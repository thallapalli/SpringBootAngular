package com.cts.osp.kt.osp.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.osp.kt.osp.controller.FsdController;
import com.cts.osp.kt.osp.dao.UserRepository;
import com.cts.osp.kt.osp.entity.AppUser;





@Service
public class UserService {
	public static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;
	public AppUser save(AppUser user) {
		logger.info(" start save");
		//add business logic 
		//full name is first name+lastname
		user.setFullName(user.getFirstName().concat(" ").concat(user.getLastName()));
		//username is firstnameDDMM
	
		Calendar cal = Calendar.getInstance();
		cal.setTime(user.getDob());
		
		LocalDate localDate = user.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year  = localDate.getYear();
		int month = localDate.getMonthValue();
		int day   = localDate.getDayOfMonth();
		user.setUsername(user.getFirstName()+month+day);
		logger.info(" end save");
		return userRepository.saveAndFlush(user);
	}

	public AppUser update(AppUser user) {
		return userRepository.save(user);
	}

	public AppUser find(String userName) {
		return userRepository.findByUsername(userName);
	}

	public AppUser find(Long id) {
		return userRepository.findOne(id);
	}
	public List<AppUser> fetchAllUsers(){
		return userRepository.findAll();
	}
}
