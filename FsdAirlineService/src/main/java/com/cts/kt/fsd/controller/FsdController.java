package com.cts.kt.fsd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.kt.fsd.dao.BookingRepository;
import com.cts.kt.fsd.entity.Booking;
import com.cts.kt.fsd.entity.Customer;
import com.cts.kt.fsd.entity.Flight;

import com.cts.kt.fsd.service.CustomerService;
import com.cts.kt.fsd.service.FlightService;

@RestController
public class FsdController {
	@Autowired
	CustomerService customerService;
	@Autowired
	FlightService flightService;
	@Autowired
	BookingRepository bookingRepository;
	
	
	
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
	
	@GetMapping("/fsd/fetchallbookings")
	public Iterable<Booking>  fetchAllBookings() {
		 Iterable<Booking> lisOfBookings = bookingRepository.findAll();
		return lisOfBookings;
	}

	@GetMapping("/fsd/{bookingid}/details")
	public Optional<Booking> fetchByBookingId(@PathVariable Long id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		return booking;
	}

	@GetMapping("/fsd/fetchallusers")
	public List<Customer> fetchAllUsers() {
		List<Customer> fetchAllUsers = customerService.fetchAllUsers();
		return fetchAllUsers;
	}

	@GetMapping("/fsd/{email}/details")
	public Customer fetchByEmail(@PathVariable String email) {
		Customer fsdCustomer = customerService.fetchUserByEmail(email);
		return fsdCustomer;
	}

	@RequestMapping(value = "/fsd/register", method = RequestMethod.POST)
	public Customer saveUser(@RequestBody Customer fsdCustomer) {
		Customer fsdCustomer2 = customerService.saveUser(fsdCustomer);
		return fsdCustomer2;
	}
	@RequestMapping(value = "/fsd/createbooking", method = RequestMethod.POST)
	public Booking createBooking(@RequestBody Booking booking) {
		Booking createdBooking = bookingRepository.save(booking);
		return createdBooking;

	}

	@DeleteMapping("/fsd/{bookingid}/cancel")
	public void cancelBooking(@PathVariable Long bookingId) {
		bookingRepository.deleteById(bookingId);

	}
	
	
	
	
	@RequestMapping(value = "/fsd/createflight", method = RequestMethod.POST)
	public Flight createFlight(@RequestBody Flight flight) {
		Flight createdFlight = flightService.saveFlight(flight);
		return createdFlight;

	}

	@DeleteMapping("/fsd/{flightid}/delete")
	public void deleteFlight(@PathVariable Long flightId) {
		bookingRepository.deleteById(flightId);

	}
	@RequestMapping(value = "/fsd/updateflight", method = RequestMethod.PUT)
	public Flight updateFlight(@RequestBody Flight flight) {
		Flight updatedFlight = flightService.updateFlight(flight);
		return updatedFlight;

	}
	
}
