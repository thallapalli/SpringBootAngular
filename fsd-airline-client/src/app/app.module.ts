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
import { HttpModule } from '@angular/http';
import {AccountService} from "./services/account.service";
import { AppRoutingModule } from './/app-routing.module';
import { FormsModule } from '@angular/forms';

import {UrlPermission} from "./urlPermission/url-permission";
import { PolicyService } from './services/policy.service';
import { BookingService } from './services/booking.service';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { PoliciesComponent } from './components/policies/policies.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { BookingComponent } from './components/booking/booking.component';
import { FlightComponent } from './components/flight/flight.component';



@NgModule({
  declarations: [
    AppComponent,
    UserviewComponent,
    AdminviewComponent,
    LoginComponent,
    RegisterComponent,
    PoliciesComponent,
    NavbarComponent,
    HomeComponent,
    BookingComponent,
    FlightComponent,
   
    
  
  ],
  imports: [
    BrowserModule,
    
    FormsModule,
    AppRoutingModule,
    HttpModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
     ReactiveFormsModule,
  
    NgbModule.forRoot(),
  ],
  providers: [AuthService,AccountService,BookingService,UrlPermission,
       
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
