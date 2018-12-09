package com.cts.kt.fsd.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.kt.fsd.entity.Flight;


public interface FlightRepository extends CrudRepository<Flight, Long> {

public Flight findByAirline(String airline);

}
