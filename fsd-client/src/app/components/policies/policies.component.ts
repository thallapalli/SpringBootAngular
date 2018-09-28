import { Component, OnInit } from '@angular/core';
import { PolicyService } from '../../services/policy.service';
import {Policy} from "../../model/policy.model";
import {Router} from "@angular/router";
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {RequestOptions, Request, RequestMethod} from '@angular/http';

@Component({
  selector: 'app-policies',
  templateUrl: './policies.component.html',
  styleUrls: ['./policies.component.css']
})
export class PoliciesComponent implements OnInit {

  policies:Policy[];
  statusCode: number;
   requestProcessing = false;
   policyNameToUpdate = null;
   processValidation = false;
   
    //Create form
   policyForm = new FormGroup({
       name: new FormControl('', Validators.required),
       details: new FormControl('', Validators.required)	
       expiryDate: new FormControl()
   });
  constructor(private policyService: PolicyService) { }

  ngOnInit() {
 this.getAllpolicies();
  }
  getAllpolicies(){
   this.policyService.getAll().subscribe(data => {
      this.policies = data;
    });
  }
  
  
  onPolicyFormSubmit() {
	  this.processValidation = true;   
	  if (this.policyForm.invalid) {
	       return; //Validation failed, exit from method.
	  }   
	  //Form is valid, now perform create or update
          this.preProcessConfigurations();
	  let policy = this.policyForm.value;
	  if (this.policyIdToUpdate === null) {  
	    //Generate policy id then create article
            this.articleService.getAllPolicies()
	      .subscribe(policies => {
			 
		
		   //Create policy
     	           this.policyService.createPolicy(policy)
			  .subscribe(successCode => {
				   this.statusCode = successCode;
				   this.getAllPolicies();	
				   this.backToCreatePolicy();
				 },
				 errorCode => this.statusCode = errorCode
			   );
		 });		
	   } else {  
   	     //Handle update article
             policy.name = this.policyNameToUpdate; 		
	     this.policyService.updatePolicy(policy)
	        .subscribe(successCode => {
		     this.statusCode = successCode;
		     this.getAllPolicies();	
		     this.backToCreatePolicy();
		},
		errorCode => this.statusCode = errorCode);	  
	   }
   }
   
    loadPolicyToEdit(policyName: string) {
      this.preProcessConfigurations();
      this.policyService.getPolicyByName(policyName)
	   .subscribe(policy => {
	            this.policyNameToUpdate = article.id;   
	            this.policyForm.setValue({ name: policy.name, details: policy.details });
	   	    this.processValidation = true;
		    this.requestProcessing = false;   
	   },
           errorCode =>  this.statusCode = errorCode);   
   }
   
    preProcessConfigurations() {
      this.statusCode = null;
      this.requestProcessing = true;   
   }
   //Go back from update to create
   backToCreatePolicy() {
      this.policyNameToUpdate = null;
      this.policyForm.reset();	  
      this.processValidation = false;
   }
   

}
