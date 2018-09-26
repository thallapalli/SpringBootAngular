package com.cts.osp.kt.osp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.osp.kt.osp.dao.UserRepository;
import com.cts.osp.kt.osp.entity.AppUser;





@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public AppUser save(AppUser user) {
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
}
