import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UserviewComponent } from './components/userview/userview.component';
import { AdminviewComponent } from './components/adminview/adminview.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

import { AuthService } from "./services/auth.service";
import {HttpModule} from "@angular/http";
import {AccountService} from "./services/account.service";

import { AppRoutingModule } from './/app-routing.module';
import { FormsModule } from '@angular/forms';
import {FacebookModule} from "ngx-facebook";
import {UrlPermission} from "./urlPermission/url-permission";

import { HttpClientModule } from '@angular/common/http';
import { CarService } from './services/car.service';
import { PolicyService } from './services/policy.service';
import { CarListComponent } from './components/car-list/car-list.component';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarEditComponent } from './components/car-edit/car-edit.component';
import { PoliciesComponent } from './components/policies/policies.component';


@NgModule({
  declarations: [
    AppComponent,
    UserviewComponent,
    AdminviewComponent,
    LoginComponent,
    RegisterComponent,
    CarListComponent,
    CarEditComponent,
    PoliciesComponent,
  
    
  
  ],
  imports: [
   BrowserModule,HttpModule,FormsModule,
    AppRoutingModule,HttpClientModule,
      BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
  ],
  providers: [AuthService,AccountService,UrlPermission,CarService,],
  bootstrap: [AppComponent]
})
export class AppModule { }
