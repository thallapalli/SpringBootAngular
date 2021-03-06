import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {User} from "../../model/model.user";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {
  user: User=new User();
  errorMessage:string;
  constructor(private authService :AuthService, private router: Router) { }



  ngOnInit() {
  }

  login(){
    this.authService.logIn(this.user)
      .subscribe(data=>{
        this.router.navigate(['/userview']);
        },err=>{
        this.errorMessage="error :  Username or password is incorrect";
        }
      )
  }
}