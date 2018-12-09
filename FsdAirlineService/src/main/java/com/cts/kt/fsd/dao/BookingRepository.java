package com.cts.kt.fsd.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.kt.fsd.entity.Booking;


public interface BookingRepository extends CrudRepository<Booking, Long> {

}
