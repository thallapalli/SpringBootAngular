package com.cts.kt.fsd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.kt.fsd.dao.CustomerRepository;
import com.cts.kt.fsd.entity.Customer;

@Service
public class CustomerService implements UserDetailsService {
	public static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	CustomerRepository fsdCustomerRepository;

	public List<Customer> fetchAllUsers() {
		logger.info(" start fetchAllUsers ");
		List<Customer> listOfUsers = (List<Customer>) fsdCustomerRepository.findAll();
		
		logger.info(" end fetchAllUsers ");
		return listOfUsers;

	}

	public Customer fetchUserByEmail(String email) {
		logger.info(" start fetchUserByEmail ");
		Customer fsdCustomer = fsdCustomerRepository.findByEmail(email);
		logger.info(" end fetchUserByEmail ");
		return fsdCustomer;

	}

	public Customer saveUser(Customer fsdCustomer) {
		logger.info(" start saveUser ");
		Customer savedfsdCustomer = fsdCustomerRepository.save(fsdCustomer);
		logger.info(" end saveUser ");
		return savedfsdCustomer;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info(" start loadUserByUsername "+username);

		Customer customer = fsdCustomerRepository.findByEmail(username);
		logger.info(" end loadUserByUsername"+username);
		return customer;
	}
	
	
	

}
