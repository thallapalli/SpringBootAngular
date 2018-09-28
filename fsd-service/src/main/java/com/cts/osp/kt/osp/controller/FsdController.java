package com.cts.osp.kt.osp.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.osp.kt.osp.entity.AppUser;
import com.cts.osp.kt.osp.entity.Policy;
import com.cts.osp.kt.osp.exception.CustomErrorType;
import com.cts.osp.kt.osp.service.PolicyService;
import com.cts.osp.kt.osp.service.UserService;



@RestController
@RequestMapping("/fsd")
public class FsdController {
	public static final Logger logger = LoggerFactory.getLogger(FsdController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private PolicyService policyService;

	// request method to create a new account by a guest
	@SuppressWarnings("unchecked")
	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody AppUser newUser) {
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}
		newUser.setRole("USER");
		
		return new ResponseEntity<AppUser>(userService.save(newUser), HttpStatus.CREATED);
	}

	// this is the login api/service
	@CrossOrigin
	@RequestMapping("/login")
	public Principal user(Principal principal) {
		logger.info("user logged "+principal);
		return principal;
	}
	@CrossOrigin
	@GetMapping("/sayhello")
	public String greetMe() {
		return "Hello Welcome to Springboot";
		
	}
	@CrossOrigin
	@PutMapping("/policy/save")
	public Policy save(@RequestBody Policy policy) {
		// TODO Auto-generated method stub
		return policyService.save(policy);
	}
	@CrossOrigin
	@PostMapping("/policy/update")
	public Policy updatePolicy(@RequestBody Policy account) {
		// TODO Auto-generated method stub
		return policyService.save(account);
	}
	@CrossOrigin
	@GetMapping("/policy/{name}/details")
	public Policy findPolicyByname(@PathVariable String name) {
		// TODO Auto-generated method stub
		return policyService.findByname("test");
	}
	@CrossOrigin
	@GetMapping("/readpolicies")
	public Iterable<Policy> readPolicies() {
		// TODO Auto-generated method stub
		return policyService.findAll();
	}

	
	

}
