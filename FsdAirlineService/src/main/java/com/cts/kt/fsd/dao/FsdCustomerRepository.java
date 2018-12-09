package com.cts.kt.fsd.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.kt.fsd.entity.FsdCustomer;

public interface FsdCustomerRepository extends CrudRepository<FsdCustomer, Long> {

public FsdCustomer findByEmail(String email);
}
