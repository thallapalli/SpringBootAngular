package com.cts.osp.kt.osp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.osp.kt.osp.entity.AppUser;
import com.cts.osp.kt.osp.security.WebConfig;



@Service
public class AppUserDetailsService implements  UserDetailsService{
	public static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

	
	@Autowired
	UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info(" start loadUserByUsername");
		
		AppUser user = userService.find(username);
		logger.info(" end loadUserByUsername");
		return  user;
	}

}
