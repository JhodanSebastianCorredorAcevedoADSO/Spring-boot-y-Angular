import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../../servicios/persona/persona.service';
import { Persona } from '../../model/persona';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-personas',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './listar-personas.component.html',
  styleUrl: './listar-personas.component.css'
})
export class ListarPersonasComponent implements OnInit {

  // array con la lista de personas enlistadas
  personas: Persona[];

  constructor(private personaService: PersonaService, public router: Router) { }

  ngOnInit(): void {
    
    // Validacion de el frm de los enlistados en caso de que eno exista ninguna persona
    this.personaService.listarPersonas().subscribe(
      resp => {
        
        this.personas = resp;

        // validar sin existe algun ingreso sino muestre le mensaje
        if (this.personas.length === 0) {
          Swal.fire('No existen regristros en el sistema');
        }
      }
    );
  }


  // metodo de eliminacion de una perosna enlistada
  eliminar(persona: Persona): void{
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: "btn btn-success",
        cancelButton: "btn btn-danger"
      },
      buttonsStyling: false
    });
    // confirmacion antes de la eliminacion
    swalWithBootstrapButtons.fire({
      title: "Estas Seguro",
      text: "Si aceptas eliminaras a la persona del registro",
      icon: "warning",
      showCancelButton: true,
      confirmButtonText: "Yes, delete!",
      cancelButtonText: "No, cancel!",
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        // eliminacion de la lista a la persona por el id
        this.personaService.eliminar(persona.idPersona).subscribe(
          _ =>{
            this.personas = this.personas.filter(p => p !== persona)
          }
        ) 
        // muestra de mensaje en caso de la eliminacion sea efectiva
        swalWithBootstrapButtons.fire({
          title: "Atencion!",
          text: 'Persona eliminada ' + "" + (persona.nombre), 
          icon: "success"
        });
      }
    });
  }

  // redirecionamiento de la ruta luego de elijir dar la edicion a una persona
  editarPersona(persona: Persona): void{
    this.router.navigate([`/editar/${persona.idPersona}`]);
  }

  
}
