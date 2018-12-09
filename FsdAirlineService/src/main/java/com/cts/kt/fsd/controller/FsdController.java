package com.cts.kt.fsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.kt.fsd.entity.Flight;
import com.cts.kt.fsd.entity.Customer;
import com.cts.kt.fsd.service.FlightService;
import com.cts.kt.fsd.service.FsdCustomerService;

@RestController
public class FsdController {
	@Autowired
	FsdCustomerService fsdCustomerService;
	@Autowired
	FlightService flightService;

	@GetMapping("/fsd/sayhello")
	public String sayHello() {
		return "Hello";
	}

	@GetMapping("/fsd/fetchallflights")
	public List<Flight> fetchAllFlights() {
		List<Flight> listOfFlights = flightService.fetchAllFlights();
		return listOfFlights;
	}

	@GetMapping("/fsd/{airline}/details")
	public Flight fetchByAirline(@PathVariable String airline) {
		Flight flight = flightService.fetchFlightByAirline(airline);
		return flight;
	}

	@GetMapping("/fsd/fetchallusers")
	public List<Customer> fetchAllUsers() {
		List<Customer> fetchAllUsers = fsdCustomerService.fetchAllUsers();
		return fetchAllUsers;
	}

	@GetMapping("/fsd/{email}/details")
	public Customer fetchByEmail(@PathVariable String email) {
		Customer fsdCustomer = fsdCustomerService.fetchUserByEmail(email);
		return fsdCustomer;
	}

	@RequestMapping(value = "/fsd/register", method = RequestMethod.POST)
	public Customer saveUser(@RequestBody Customer fsdCustomer) {
		Customer fsdCustomer2 = fsdCustomerService.saveUser(fsdCustomer);
		return fsdCustomer2;
	}
}
