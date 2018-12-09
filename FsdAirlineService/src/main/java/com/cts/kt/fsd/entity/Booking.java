package com.cts.kt.fsd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING", schema = "FSD1")
public class Booking {
	@Id
	@GeneratedValue
	private Long bookingId;
	public long customerId;
	private Long flightId;
	

}
