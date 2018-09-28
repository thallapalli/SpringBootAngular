import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserviewComponent } from './components/userview/userview.component';
import { AdminviewComponent } from './components/adminview/adminview.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import {UrlPermission} from "./urlPermission/url-permission";
import {CarListComponent} from "./components/car-list/car-list.component";
import { CarEditComponent } from './components/car-edit/car-edit.component';


const routes: Routes = [
  { path: 'userview', component: UserviewComponent, canActivate: [UrlPermission] },
  { path: 'adminview', component: AdminviewComponent ,canActivate: [UrlPermission] },
  { path: 'cars', component: CarListComponent},
  {
    path: 'car-add',
    component: CarEditComponent
  },
  {
    path: 'car-edit/:id',
    component: CarEditComponent
  },
  
  { path: 'login', component: LoginComponent  },
   { path: 'register', component: RegisterComponent, canActivate: [UrlPermission]  },
   { path: '**', redirectTo: '/login' }
  
];

@NgModule({
  imports: [
  
    RouterModule.forRoot(routes)
  ],
    exports: [ RouterModule ],
  
})
export class AppRoutingModule { }



