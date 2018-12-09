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
   policyIdToUpdate = null;
   processValidation = false;
   
    //Create form
   policyForm = new FormGroup({
   	  id:new FormControl('', Validators.required),
       name: new FormControl('', Validators.required),
       details: new FormControl('', Validators.required)	,
       expiryDate: new FormControl()
   });
  constructor(private policyService: PolicyService) { }

  ngOnInit() {
  
 this.getAllPolicies();
  }
  getAllPolicies() {
  console.log('hello');
        this.policyService.getAllPolicies()
	  .subscribe(
                data => this.policies = data,
                errorCode =>  this.statusCode = errorCode);   
                
                console.log(this.statusCode);
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
	  
	 this.policyService.getAllPolicies()
	      .subscribe(policies => {
			 
		   //Generate article id	 
		 
		   
		   //Create article
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
             policy.name = this.policyIdToUpdate; 		
	     this.policyService.updatePolicy(policy)
	        .subscribe(successCode => {
		     this.statusCode = successCode;
		     this.getAllPolicies();	
		     this.backToCreatePolicy();
		},
		errorCode => this.statusCode = errorCode);	  
	   }
   }
   
    loadPolicyToEdit(policyId: number) {
      this.preProcessConfigurations();
      this.policyService.getPolicyById(policyId)
	   .subscribe(policy => {
	            this.policyIdToUpdate = policy.id;   
	            this.policyForm.setValue({ id:policy.id,name:policy.name,details:policy.details,expiryDate:policy.expiryDate });
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
      this.policyIdToUpdate = null;
      this.policyForm.reset();	  
      this.processValidation = false;
   }
   

}
