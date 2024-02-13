
// importtaciones de utilidad
import { Routes } from '@angular/router';
import { ListarPersonasComponent } from './components/listar-personas/listar-personas.component';
import { HomeComponent } from './components/home/home.component';
import { RegistarPersonasComponent } from './components/registar-personas/registrar-personas.component';
import { LoginComponent } from './components/login/login.component';

export const routes: Routes = [
    // rutas designadas para cada uno de las pantallas junto con sus componentes que adquieren
    { path: 'editar/:idPersona' , component: RegistarPersonasComponent},
    { path: 'crear' , component: RegistarPersonasComponent},
    { path: 'listar', component: ListarPersonasComponent},
    { path: 'home' , component: HomeComponent},
    { path: 'login', component: LoginComponent},
    { path: '**' , pathMatch: 'full' , redirectTo: 'login'}
];
