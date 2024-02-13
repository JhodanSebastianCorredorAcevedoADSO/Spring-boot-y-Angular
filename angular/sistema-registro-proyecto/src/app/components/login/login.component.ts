import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Usuario } from '../../model/usuario';
import { FormsModule } from '@angular/forms';
import { LoginService } from '../../servicios/login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  usuario = new Usuario();

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {

  }

  // validacion de los campos si estan incomnpletos antes de su ingreso
  login(): void {
    if (this.usuario.username === undefined || this.usuario.password === undefined) {
      Swal.fire({
        title: "Campos Incompletos",
        text: "Complete sus datos antes de ingresar",
        icon: 'error'

      });

    } else {
      this.loginService.login(this.usuario).subscribe(
        response => {

          // y se obtiene el token del usuario una vez loguiado para su verificacion
          this.loginService.guardarUsuario(response.access_token);
          this.loginService.guardarToken(response.access_token);
          // si los campos son correctos se su acesso correspondiente
          Swal.fire({
            title: "Bienvenido",
            text: "Bienvenido " + this.usuario.username,
            icon: 'success'
          });
          //  y se redireciona una vez todo completo
          this.router.navigate(['./home']);

        }, _ => {
          Swal.fire({
            title: "Contraseña Incorrecta",
            text: "Verifique que sus datos sean correctos",
            icon: 'error'
          });
        }
      );
    }
  }
}
