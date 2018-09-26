import { Component, OnInit } from '@angular/core';
import {PolicyService} from "../../services/policy.service";
import {Policy} from "../model/policy.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-viewpolicy',
  templateUrl: './viewpolicy.component.html',
  styleUrls: ['./viewpolicy.component.css']
})
export class ViewpolicyComponent implements OnInit {

  policy: Policy[];

  constructor(private router: Router,private policyService: PolicyService) { }

  ngOnInit() {
   this.policyService.getPolicy()
      .subscribe( data => {
        this.users = data;
      });
  
  }

}
