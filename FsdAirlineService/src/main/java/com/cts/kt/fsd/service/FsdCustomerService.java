package com.cts.kt.fsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.kt.fsd.dao.FsdCustomerRepository;
import com.cts.kt.fsd.entity.Customer;

@Service
public class FsdCustomerService {
	@Autowired
	FsdCustomerRepository fsdCustomerRepository;

	public List<Customer> fetchAllUsers() {
		List<Customer> listOfUsers = (List<Customer>) fsdCustomerRepository.findAll();
		return listOfUsers;

	}

	public Customer fetchUserByEmail(String email) {
		Customer fsdCustomer = fsdCustomerRepository.findByEmail(email);
		return fsdCustomer;

	}
	public Customer saveUser(Customer fsdCustomer) {
		Customer savedfsdCustomer = fsdCustomerRepository.save(fsdCustomer);
		return savedfsdCustomer;

	}
	
	

}
