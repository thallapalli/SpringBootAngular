package com.cts.kt.fsd;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.kt.fsd.entity.Customer;
import com.cts.kt.fsd.entity.Flight;
import com.cts.kt.fsd.service.CustomerService;
import com.cts.kt.fsd.service.FlightService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FsdAirlineServiceApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	CustomerService customerrService;
	
	@Autowired
	FlightService flightService;
	//Success scenario
	
	
	@Test
	public void testRegister() {
		
		Customer customer=new Customer();
		customer.setEmail("kt4@kt.com");
		customer.setPassword("welcome1");
		Customer policy = customerrService.saveUser(customer);
		Assert.assertEquals("kt4@kt.com", policy.getEmail());
	}
	
	@Test
	public void testfetchAllFlights() {
		//negetive case ,unique validation on email
		
		List<Flight> fetchAllFlights = flightService.fetchAllFlights();
		Assert.assertEquals(4, fetchAllFlights.size());
	}
	
	@Test
	public void testUniqueRegister() {
		//negetive case ,unique validation on email
		Customer customer=new Customer();
		customer.setEmail("kt4@kt.com");
		customer.setPassword("welcome1");
		Customer policy = customerrService.saveUser(customer);
		Assert.assertNotSame("kt4@kt.com", policy.getEmail());
	}
	
	

}
