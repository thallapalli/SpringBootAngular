import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserviewComponent } from './components/userview/userview.component';
import { AdminviewComponent } from './components/adminview/adminview.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import {UrlPermission} from "./urlPermission/url-permission";
import {CarListComponent} from "./components/car-list/car-list.component";
import { PoliciesComponent } from './components/policies/policies.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';




const routes: Routes = [
  { path: 'userview', component: UserviewComponent, canActivate: [UrlPermission] },
  { path: 'adminview', component: AdminviewComponent ,canActivate: [UrlPermission] },
  { path: 'cars', component: CarListComponent,canActivate: [UrlPermission]},
  { path: 'policies', component: PoliciesComponent,canActivate: [UrlPermission]},
 
  {
path: '',
component: HomeComponent,canActivate: [UrlPermission]
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



