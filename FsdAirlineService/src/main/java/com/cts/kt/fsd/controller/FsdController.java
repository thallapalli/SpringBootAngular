package com.cts.kt.fsd.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.cts.kt.fsd.exception.CustomErrorType;
import com.cts.kt.fsd.service.CustomerService;
import com.cts.kt.fsd.service.FlightService;

@RestController
public class FsdController {
	public static final Logger logger = LoggerFactory.getLogger(FsdController.class);
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
		logger.info(" start fetchAllFlights ");
		List<Flight> listOfFlights = flightService.fetchAllFlights();
		logger.info(" end fetchAllFlights ");
		return listOfFlights;
	}

	@GetMapping("/fsd/{airline}/details")
	public Flight fetchByAirline(@PathVariable String airline) {
		logger.info(" start fetchByAirline " + airline);
		Flight flight = flightService.fetchFlightByAirline(airline);
		logger.info(" end fetchByAirline " + airline);
		return flight;
	}

	@GetMapping("/fsd/fetchallbookings")
	public Iterable<Booking> fetchAllBookings() {
		logger.info(" start fetchAllBookings ");
		Iterable<Booking> lisOfBookings = bookingRepository.findAll();
		logger.info(" end fetchAllBookings ");

		return lisOfBookings;
	}

	@GetMapping("/fsd/{bookingid}/details")
	public Optional<Booking> fetchByBookingId(@PathVariable Long id) {
		logger.info(" start fetchByBookingId " + id);

		Optional<Booking> booking = bookingRepository.findById(id);
		logger.info(" end fetchByBookingId " + id);

		return booking;
	}

	@GetMapping("/fsd/fetchallusers")
	public List<Customer> fetchAllUsers() {
		logger.info(" start fetchAllUsers ");

		List<Customer> fetchAllUsers = customerService.fetchAllUsers();
		logger.info(" end fetchAllUsers ");

		return fetchAllUsers;
	}

	@GetMapping("/fsd/{email}/details")
	public Customer fetchByEmail(@PathVariable String email) {
		logger.info(" start fetchByEmail " + email);

		Customer fsdCustomer = customerService.fetchUserByEmail(email);
		logger.info(" end fetchByEmail " + email);

		return fsdCustomer;
	}

	@RequestMapping(value = "/fsd/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody Customer customer) {
		logger.info(" start createUser");
		if (customerService.fetchUserByEmail(customer.getEmail()) != null) {
			logger.error("username Already exist " + customer.getEmail());
			return new ResponseEntity(
					new CustomErrorType("user with username " + customer.getEmail() + "already exist "),
					HttpStatus.CONFLICT);
		}
		logger.info(" exit createUser");
		return new ResponseEntity<Customer>(customerService.saveUser(customer), HttpStatus.CREATED);
	}

	// this is the login api/service
	@RequestMapping("/fsd/login")
	public Principal user(Principal principal) {
		logger.info("user logged " + principal);
		return principal;
	}

	@RequestMapping(value = "/fsd/createbooking", method = RequestMethod.POST)
	public Booking createBooking(@RequestBody Booking booking) {
		logger.info(" start createBooking ");
		Booking createdBooking = bookingRepository.save(booking);
		logger.info(" end createBooking ");
		return createdBooking;

	}

	@DeleteMapping("/fsd/{bookingid}/cancel")
	public void cancelBooking(@PathVariable Long bookingId) {
		logger.info(" start cancelBooking " + bookingId);
		bookingRepository.deleteById(bookingId);
		logger.info(" end cancelBooking " + bookingId);

	}

	@RequestMapping(value = "/fsd/createflight", method = RequestMethod.POST)
	public Flight createFlight(@RequestBody Flight flight) {
		logger.info(" start createFlight ");
		Flight createdFlight = flightService.saveFlight(flight);
		logger.info(" end createFlight ");
		return createdFlight;

	}

	@DeleteMapping("/fsd/{flightid}/delete")
	public void deleteFlight(@PathVariable Long flightId) {
		logger.info(" start deleteFlight "+flightId);
		bookingRepository.deleteById(flightId);
		logger.info(" end deleteFlight "+flightId);
		

	}

	@RequestMapping(value = "/fsd/updateflight", method = RequestMethod.PUT)
	public Flight updateFlight(@RequestBody Flight flight) {
		logger.info(" start updateFlight ");
		Flight updatedFlight = flightService.updateFlight(flight);
		logger.info(" end updateFlight ");
		
		return updatedFlight;

	}

}
