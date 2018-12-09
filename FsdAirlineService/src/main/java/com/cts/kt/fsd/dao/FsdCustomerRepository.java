package com.cts.kt.fsd.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.kt.fsd.entity.Customer;

public interface FsdCustomerRepository extends CrudRepository<Customer, Long> {

public Customer findByEmail(String email);
}
