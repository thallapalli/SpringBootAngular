import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { UserviewComponent } from './components/userview/userview.component';
import { AdminviewComponent } from './components/adminview/adminview.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

import { AuthService } from "./services/auth.service";
import {HttpModule} from "@angular/http";
import {AccountService} from "./services/account.service";
import {CustomInterceptorService} from "./services/custom-interceptor.service";
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';

import { AppRoutingModule } from './/app-routing.module';
import { FormsModule } from '@angular/forms';
import {FacebookModule} from "ngx-facebook";
import {UrlPermission} from "./urlPermission/url-permission";

import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpClientModule,
  HttpInterceptor
} from '@angular/common/http';
import { CarService } from './services/car.service';
import { PolicyService } from './services/policy.service';
import { CarListComponent } from './components/car-list/car-list.component';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CarEditComponent } from './components/car-edit/car-edit.component';
import { PoliciesComponent } from './components/policies/policies.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';



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
    NavbarComponent,
    HomeComponent,
   
    
  
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
     ReactiveFormsModule,
  
    NgbModule.forRoot(),
  ],
  providers: [AuthService,AccountService,UrlPermission,CarService, 
  {
      provide: HTTP_INTERCEPTORS,
      useClass: CustomInterceptorService,
      multi: true
    }
       
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
