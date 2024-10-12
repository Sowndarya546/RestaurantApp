package com.restaurant.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "RestaurantGreeting")
public interface ServiceProxy {

	@GetMapping("/welcome")
	public String greeting();
}
