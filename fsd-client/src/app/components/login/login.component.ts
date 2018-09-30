import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {User} from "../../model/model.user";
import {Router} from "@angular/router";
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {RequestOptions, Request, RequestMethod} from '@angular/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
	user:User;
   errorMessage:string;
   processValidation = false;
   
   loginForm = new FormGroup({
   	  username:new FormControl('', Validators.required),
       password: new FormControl('', Validators.required)
      
   });
  constructor(private authService :AuthService, private router: Router) { }
 


  ngOnInit() {
  }

   onloginFormSubmit(){
   console.log('Here');
   let user = this.loginForm.value;
   console.log(user);
    this.authService.logIn(user)
      .subscribe(data=>{
        this.router.navigate(['/userview']);
        },err=>{
        this.errorMessage="error :  Username or password is incorrect";
        }
      )
  }
}
