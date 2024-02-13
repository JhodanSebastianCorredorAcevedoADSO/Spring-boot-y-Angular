import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./components/header/header.component";
import { LoginService } from './servicios/login/login.service';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, HeaderComponent]
})
export class AppComponent {
  title = 'sistema-registro-proyecto';

  constructor(private loginService: LoginService){}

  isAuthenticated(): boolean{
    return this.loginService.isAuthenticated();
  }
}
