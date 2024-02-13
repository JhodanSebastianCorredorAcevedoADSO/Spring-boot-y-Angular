import { Component, OnInit } from '@angular/core';
import { TipoDocumento } from '../../model/tipo-documento';
import { TipoDocumentoService } from '../../servicios/tipo-documento/tipo-documento.service';
import { CommonModule } from '@angular/common';
import { Persona } from '../../model/persona';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import Swal from 'sweetalert2';
import { ComandoPersona } from '../../comando/comando-persona';
import { PersonaService } from '../../servicios/persona/persona.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-registar-personas',
  standalone: true,
  imports: [CommonModule, HttpClientModule, FormsModule],
  templateUrl: './registrar-personas.component.html',
  styleUrl: './registrar-personas.component.css'
})
export class RegistarPersonasComponent implements OnInit {

  tipoDocumento: TipoDocumento[];

  // array de  la lista de personas
  persona: Persona = new Persona();

  comandoPersona: ComandoPersona;

  // identificados del valor que trae un idPersona
  idPersona: number;

  // identificador que trae para su edicion o regristro segun el idpersona
  titulo: string;
  
  //  copnstrcutor quemostrara la perosna iniciada y su ruta y direcionamiento
  constructor(private tipoDcoumentoService: TipoDocumentoService,
    private personaServicie: PersonaService,
    private router: Router,
    private route: ActivatedRoute) {

      // validar si la perosna ingresada ca editar ya esta registrada o y es de tipo number
    this.idPersona = Number(this.route.snapshot.paramMap.get('idPersona'));

    // validar para el cambio de mensaje de titulo de registro o edicion
    if (this.idPersona === 0) {
      this.titulo = 'Registar Persona';
    } else {
      this.titulo = 'Editar Persona ';
      // va al metodo para verificar y pasar los datos de la persona
      this.consultarPersonaPorId();
    }
  }

  //  validacion del requerimiento segun la peticion del metodo en este caso el docuemnto
  ngOnInit(): void {
    this.tipoDcoumentoService.listarTipoDocumento().subscribe(
      resp => {
        this.tipoDocumento = resp;

      }
    );
  }

  // metodo para la consulta del id sea correcto y proceder con la consulta
  consultarPersonaPorId(): void {
    this.personaServicie.consultarPorId(this.idPersona).subscribe(
      resp => {
        this.persona = resp;
      }
    )
  }

  // metodo del reguistro de una nueva persona
  registrar(): void {
    Swal.fire({
      title: "Atencion",
      text: "Esta seguro de guardar la informacion",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#2DA91C",
      cancelButtonColor: "#d33",
      confirmButtonText: "Yes"
    }).then((result) => {
      // validacion de identificacion si es registro o actualizacion por el id
      this.establecerComando();
      if (this.idPersona === 0) {
        this.insertar();
      } else {
        this.actualizar();
      }
    });
  }

  // metodo para pasar los datos de la persona en el momento de guardar la informacion
  establecerComando(): void {
    this.comandoPersona = new ComandoPersona();
    this.comandoPersona.idPersona = this.persona.idPersona;
    this.comandoPersona.idTipoDocumento = this.persona.tipoDocumento.idTipoDocumento;
    this.comandoPersona.numeroDocumento = this.persona.numeroDocumento;
    this.comandoPersona.nombre = this.persona.nombre;
    this.comandoPersona.apellido = this.persona.apellido;
    this.comandoPersona.activo = this.persona.activo;
  }

  // metodo para guardra los datos de la persona creada
  insertar(): void {
    this.personaServicie.insertar(this.comandoPersona).subscribe(
      _ => {
        Swal.fire({
          text: this.persona.nombre + ' Guardado Correctamente',
          icon: 'success',
          confirmButtonColor: "#2DA91C"
        });
        // redirecionamiento para observar una vez validado en guardado a la lista de personas
        this.router.navigate(['/listar']);
      }
    );
  }

  // metodo de actualizacion
  actualizar(): void {
    this.personaServicie.actualizar(this.comandoPersona).subscribe(
      _ => {
        Swal.fire({
          text: this.persona.nombre + ' Actualizado Correctamente',
          icon: 'success',
          confirmButtonColor: "#2DA91C"
        });
        this.router.navigate(['/listar']);
      }
    )
  }
}
