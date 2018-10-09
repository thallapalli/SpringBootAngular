import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UserviewComponent } from './userview/userview.component';
import { AdminviewComponent } from './adminview/adminview.component';
import { GuardGuard } from './auth/guard.guard';



const routes: Routes = [
  { path: '', component: HomeComponent, canActivate: [GuardGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'userview', component: UserviewComponent },
  { path: 'adminview', component: AdminviewComponent },
  { path: 'register', component: RegisterComponent },




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
