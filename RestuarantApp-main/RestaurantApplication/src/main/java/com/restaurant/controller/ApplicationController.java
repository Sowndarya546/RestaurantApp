package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.proxy.ServiceProxy;


@RestController
public class ApplicationController {

	@Autowired
	private ServiceProxy serviceProxy;
	
	@GetMapping("/greet")
	public String retreiveInfo( ) {
		
		return serviceProxy.greeting();
		
	}
	
	@GetMapping("/welcomeFallBack")
	public String fallback(Exception e) {
		//@ComponentScan({"com.*"})

		return "Sorry Service is unavailable";
	}
	
}
