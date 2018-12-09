package com.cts.kt.fsd.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the FLIGHT database table.
 * 
 */
@Entity
@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
public class Flight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FLIGHT_ID")
	private long flightId;

	private String airline;

	@Column(name="ARRIVAL_TIME")
	private String arrivalTime;

	@Column(name="DEAPRTURE_TIME")
	private String deaprtureTime;

	@Column(name="DEPARTURE_DATE")
	private Timestamp departureDate;

	@Column(name="NUM_OF_PASSENGERS")
	private BigDecimal numOfPassengers;

	private BigDecimal price;
	 

	public Flight() {
	}

	public long getFlightId() {
		return this.flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getAirline() {
		return this.airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDeaprtureTime() {
		return this.deaprtureTime;
	}

	public void setDeaprtureTime(String deaprtureTime) {
		this.deaprtureTime = deaprtureTime;
	}

	public Timestamp getDepartureDate() {
		return this.departureDate;
	}

	public void setDepartureDate(Timestamp departureDate) {
		this.departureDate = departureDate;
	}

	public BigDecimal getNumOfPassengers() {
		return this.numOfPassengers;
	}

	public void setNumOfPassengers(BigDecimal numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}