package com.cts.kt.fsd.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the BOOKING database table.
 * 
 */
@Entity
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BOOKING_ID")
	private long bookingId;

	//uni-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Customer customer;

	//uni-directional many-to-one association to Flight
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FLIGHT_ID")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Flight flight;

	public Booking() {
	}

	public long getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Flight getFlight() {
		return this.flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}