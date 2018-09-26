import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserviewComponent } from './components/userview/userview.component';
import { AdminviewComponent } from './components/adminview/adminview.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';


const routes: Routes = [
  { path: 'userview', component: UserviewComponent },
  { path: 'adminview', component: AdminviewComponent },
  { path: 'login', component: LoginComponent  },
   { path: 'register', component: RegisterComponent  },
   { path: '**', redirectTo: '/login' }
  
];

@NgModule({
  imports: [
  
    RouterModule.forRoot(routes)
  ],
    exports: [ RouterModule ],
  
})
export class AppRoutingModule { }



