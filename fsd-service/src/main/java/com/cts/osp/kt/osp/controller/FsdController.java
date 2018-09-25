package com.cts.osp.kt.osp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fsd")
public class FsdController {
	@GetMapping("/sayhello")
	public String greetMe() {
		return "Hello Welcome to Springboot";
		
	}

}
