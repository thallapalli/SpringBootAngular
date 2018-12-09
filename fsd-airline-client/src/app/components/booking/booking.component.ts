import { Component, OnInit } from '@angular/core';
import { BookingService } from '../../services/booking.service';
import {Booking} from "../../model/booking";
import {Router} from "@angular/router";
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {RequestOptions, Request, RequestMethod} from '@angular/http';
@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  bookings:Booking[];
   statusCode: number;
   requestProcessing = false;
   policyIdToUpdate = null;
   processValidation = false;
   
    //Create form
   bookingForm = new FormGroup({
   	   bookingId:new FormControl('', Validators.required),
       numOfPassengers: new FormControl('', Validators.required),
       totalCost: new FormControl('', Validators.required)	
       
   });
  constructor(private bookingService: BookingService) { }

  ngOnInit() {
  
 this.getAllBookings();
  }
  getAllBookings() {
        this.bookingService.getAllBookings()
	  .subscribe(
                data => this.bookings = data,
                errorCode =>  this.statusCode = errorCode);   
                
                console.log(this.statusCode);
   }
  
  onBookingFormSubmit() {
	  this.processValidation = true;   
	  if (this.bookingForm.invalid) {
	       return; //Validation failed, exit from method.
	  }   
	  //Form is valid, now perform create or update
          this.preProcessConfigurations();
	  let booking = this.bookingForm.value;
	  if (this.bookingIdToUpdate === null) { 
	  
	 this.bookingService.getAllBookings()
	      .subscribe(bookings => {
		
     	           this.bookingService.createBooking(booking)
			  .subscribe(successCode => {
				   this.statusCode = successCode;
				   this.getAllBookings();	
				   this.backToCreateBooking();
				 },
				 errorCode => this.statusCode = errorCode
			   );
		 });		
	  
	  
	   } else {  
   	     //Handle update article
             booking.name = this.bookingIdToUpdate; 		
	     this.bookingService.updateBooking(booking)
	        .subscribe(successCode => {
		     this.statusCode = successCode;
		     this.getAllBookings();	
		     this.backToCreateBooking();
		},
		errorCode => this.statusCode = errorCode);	  
	   }
   }
   
    loadBookingToEdit(bookingId: number) {
      this.preProcessConfigurations();
      this.bookingService.getBookingById(bookingId)
	   .subscribe(booking => {
	            this.bookingIdToUpdate = policy.id;   
	            this.bookingForm.setValue({ bookingId:policy.bookingId,numOfPassengers:policy.numOfPassengers,totalCost:policy.totalCost });
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
   backToCreateBooking() {
      this.bookingIdToUpdate = null;
      this.bookingForm.reset();	  
      this.processValidation = false;
   }
   

}
