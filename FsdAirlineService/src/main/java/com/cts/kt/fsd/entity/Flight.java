package com.cts.kt.fsd.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "FLIGHT", schema = "FSD1")

public class Flight {
	@Id
	@GeneratedValue
	private Long flightId;
	private String airline;
	private Date departureDate;
	private String deaprtureTime;
	private String arrivalTime;
	private int numOfPassengers;
	private Long price;
	@Transient
	private Long totalCost;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDeaprtureTime() {
		return deaprtureTime;
	}

	public void setDeaprtureTime(String deaprtureTime) {
		this.deaprtureTime = deaprtureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getNumOfPassengers() {
		return numOfPassengers;
	}

	public void setNumOfPassengers(int numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	@Transient
	public long getTotalCost() {
		return this.price * this.numOfPassengers;
	}

}
