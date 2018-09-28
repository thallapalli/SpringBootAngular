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


@NgModule({
  declarations: [
    AppComponent,
    UserviewComponent,
    AdminviewComponent,
    LoginComponent,
    RegisterComponent,
    
  
  ],
  imports: [
   BrowserModule,HttpModule,FormsModule,
    AppRoutingModule,HttpClientModule,
  ],
  providers: [AuthService,AccountService,UrlPermission,],
  bootstrap: [AppComponent]
})
export class AppModule { }
