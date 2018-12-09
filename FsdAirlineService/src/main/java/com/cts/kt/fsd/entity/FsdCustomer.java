package com.cts.kt.fsd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FSD_CUSTOMER", schema="FSD1")
public class FsdCustomer {
	@Id
	@GeneratedValue
	public long customerId;
	public String email;
	public String password;

	public FsdCustomer() {

	}

	public FsdCustomer(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
