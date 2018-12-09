package com.cts.kt.fsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.kt.fsd.dao.FlightRepository;
import com.cts.kt.fsd.entity.Flight;

@Service
public class FlightService {
	@Autowired
	FlightRepository flightRepository;

	public List<Flight> fetchAllFlights() {
		List<Flight> listOfFlights = (List<Flight>) flightRepository.findAll();
		return listOfFlights;

	}

	public Flight fetchFlightByAirline(String airline) {
		Flight flight = flightRepository.findByAirline(airline);
		return flight;

	}

}
