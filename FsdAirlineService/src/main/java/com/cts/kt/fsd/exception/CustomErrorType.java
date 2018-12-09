package com.cts.kt.fsd.exception;

public class CustomErrorType  {

	 private String errorMessage;

	    public CustomErrorType(String errorMessage){
	        this.errorMessage = errorMessage;
	    }

	    public String getErrorMessage() {
	        return errorMessage;
	    }
}