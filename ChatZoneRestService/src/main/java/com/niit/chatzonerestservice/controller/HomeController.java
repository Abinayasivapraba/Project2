package com.niit.chatzonerestservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
	@GetMapping("/hello")
	public  String sayHello()
	{
		return "Testing my rest controller";
	}

}
