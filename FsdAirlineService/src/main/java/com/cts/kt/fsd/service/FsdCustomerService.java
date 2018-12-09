package com.cts.kt.fsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.kt.fsd.dao.FsdCustomerRepository;
import com.cts.kt.fsd.entity.FsdCustomer;

@Service
public class FsdCustomerService {
	@Autowired
	FsdCustomerRepository fsdCustomerRepository;

	public List<FsdCustomer> fetchAllUsers() {
		List<FsdCustomer> listOfUsers = (List<FsdCustomer>) fsdCustomerRepository.findAll();
		return listOfUsers;

	}

	public FsdCustomer fetchUserByEmail(String email) {
		FsdCustomer fsdCustomer = fsdCustomerRepository.findByEmail(email);
		return fsdCustomer;

	}
	public FsdCustomer saveUser(FsdCustomer fsdCustomer) {
		FsdCustomer savedfsdCustomer = fsdCustomerRepository.save(fsdCustomer);
		return savedfsdCustomer;

	}
	
	

}
