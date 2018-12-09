package com.cts.kt.fsd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.kt.fsd.dao.FlightRepository;
import com.cts.kt.fsd.entity.Flight;
import com.cts.kt.fsd.security.WebConfig;

@Service
public class FlightService {
	public static final Logger logger = LoggerFactory.getLogger(FlightService.class);

	@Autowired
	FlightRepository flightRepository;

	public List<Flight> fetchAllFlights() {
		logger.info(" start fetchAllFlights ");
		List<Flight> listOfFlights = (List<Flight>) flightRepository.findAll();
		logger.info(" end fetchAllFlights ");
		return listOfFlights;

	}

	public Flight fetchFlightByAirline(String airline) {
		logger.info(" start fetchFlightByAirline ");
		Flight flight = flightRepository.findByAirline(airline);
		logger.info(" end fetchFlightByAirline ");
		
		return flight;

	}

	public Flight saveFlight(Flight flight) {
		
		
		return flightRepository.save(flight);

	}

	public void deleteFlight(Flight flight) {
		flightRepository.delete(flight);

	}

	public Flight updateFlight(Flight flight) {
		Flight savedflight = flightRepository.save(flight);
		return savedflight;

	}

}
