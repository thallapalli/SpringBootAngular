package com.cts.osp.kt.osp.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.osp.kt.osp.dao.UserPolicyRepository;
import com.cts.osp.kt.osp.entity.AppUser;
import com.cts.osp.kt.osp.entity.Policy;
import com.cts.osp.kt.osp.entity.UserPolicy;
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
	@Autowired
	private UserPolicyRepository userPolicyRepository;

	// request method to create a new account by a guest
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody AppUser newUser) {
		logger.info(" start createUser");
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}
		newUser.setRole("USER");
		logger.info(" exit createUser");
		return new ResponseEntity<AppUser>(userService.save(newUser), HttpStatus.CREATED);
	}

	// this is the login api/service
	@RequestMapping("/login")
	public Principal user(Principal principal) {
		logger.info("user logged " + principal);
		return principal;
	}

	

	@Secured("{USER}")
	@PutMapping("/policy/save")
	@ResponseBody
	public Policy save(@RequestBody Policy policy, HttpServletRequest request,@RequestHeader HttpHeaders headers) {
		// TODO Auto-generated method stub
		logger.info(" Save Method");
		return policyService.save(policy);
	}

	@PostMapping("/policy/update")
	@ResponseBody
	public Policy updatePolicy(@RequestBody Policy account, HttpServletRequest request,@RequestHeader HttpHeaders headers) {
		// TODO Auto-generated method stub
		logger.info(" updatePolicy");
		return policyService.save(account);
	}

	@Secured("{USER}")
	@GetMapping("/policy/{id}/details")
	public Policy findPolicyByname(@PathVariable Long id, HttpServletRequest request,@RequestHeader HttpHeaders headers) {
		// TODO Auto-generated method stub
		logger.info(" findPolicyByname");
		return policyService.findById(id);
	}

	@Secured("{USER}")
	@GetMapping("/readpolicies")
	public Iterable<Policy> readPolicies(HttpServletRequest request,@RequestHeader HttpHeaders headers) {
		// TODO Auto-generated method stub
		logger.info(" findPolicyByname");
		return policyService.findAll();
	}

	@Secured("{USER}")
	@GetMapping("/userpolicies")
	public Iterable<UserPolicy> fetchUserPolicies(HttpServletRequest request,@RequestHeader HttpHeaders headers) {
		return userPolicyRepository.findAll();

	}
	@Secured("{USER}")
	@GetMapping("/allusers")
	public List<AppUser> fetchAllusers(HttpServletRequest request,@RequestHeader HttpHeaders headers) {
		return userService.fetchAllUsers();

	}
	@GetMapping("/sayhello")
	public String sayHello() {
		return "Hello";
	}

	@Secured({ "USER" })
	@GetMapping("/saysecuredhello")
	public String saySecuredHello(HttpServletRequest request,

			@RequestHeader HttpHeaders headers) {
		return "Hello";
	}

}
