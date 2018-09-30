package com.cts.osp.kt.osp;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FsdServiceApplication {
	Logger logger = LoggerFactory.getLogger(FsdServiceApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(FsdServiceApplication.class, args);
	}
}
