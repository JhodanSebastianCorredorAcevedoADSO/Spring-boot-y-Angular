import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../servicios/login/login.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  // importacion requerida para el manejo de sus modulos
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  constructor(public loginService: LoginService){ }


}

