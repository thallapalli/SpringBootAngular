import { Component, OnInit } from '@angular/core';
import {User} from "../../model/model.user";
import {AuthService} from "../../services/auth.service";
import { Policy } from "../../model/policy.model";
import { Router } from "@angular/router";
import { PolicyService } from '../../services/policy.service';

import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {RequestOptions, Request, RequestMethod} from '@angular/http';


@Component({
  selector: 'app-userview',
  templateUrl: './userview.component.html',
  styleUrls: ['./userview.component.css']
})
export class UserviewComponent implements OnInit {

  currentUser: User;
  policies: Policy[];
   policyForm = new FormGroup({
   	  id:new FormControl('', Validators.required),
       name: new FormControl('', Validators.required),
       details: new FormControl('', Validators.required)	,
       expiryDate: new FormControl()
   });
 
  constructor(public authService: AuthService, public router: Router, private policyService: PolicyService) {
  this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
 }
  

  ngOnInit() {
  

  this.getAllPolicies();
  }
getAllPolicies() {
  console.log('hello');
  this.policyService.getAllPolicies()
    .subscribe(
      data => this.policies = data,
      errorCode => this.statusCode = errorCode);

  console.log(this.statusCode);
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
