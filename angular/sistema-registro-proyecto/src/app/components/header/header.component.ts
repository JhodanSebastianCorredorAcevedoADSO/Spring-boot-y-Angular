import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { LoginService } from '../../servicios/login/login.service';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{

  // Ejecutamos el login junto con su ruta especifica 
  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {
    
  }

  // metodo para el cierre de sesion 
  logout(): void{
    // esta sesion cierrela
    this.loginService.logout();
    Swal.fire('Has cerrado la sesion');
    // redirecionamiento a al login luego del cierre de sesion
    this.router.navigate(['/login']);
  }

  // metodo para validar la autenticacion en el momento de ingreso de login
  isAuthenticated(): boolean{
    return this.loginService.isAuthenticated();
  }

}
