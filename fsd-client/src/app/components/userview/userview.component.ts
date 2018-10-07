import { Component, OnInit } from '@angular/core';
import {User} from "../../model/model.user";
import {AuthService} from "../../services/auth.service";
;
import {Router} from "@angular/router";


@Component({
  selector: 'app-userview',
  templateUrl: './userview.component.html',
  styleUrls: ['./userview.component.css']
})
export class UserviewComponent implements OnInit {

  currentUser: User;
 
 constructor(public authService: AuthService, public router: Router) {
  this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
 }
  

  ngOnInit() {
  }
logOut() {
    this.authService.logOut()
      .subscribe(
        data => {
          this.router.navigate(['/login']);
        },
        error => {
  console.log('error --------'+error);
        });
  }
}
