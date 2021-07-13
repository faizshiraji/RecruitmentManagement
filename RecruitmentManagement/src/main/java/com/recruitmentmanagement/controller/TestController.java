package com.recruitmentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/userhome")
	public String headerhori() {
		
		return "horizontal-menu";
	}
	
	@GetMapping("/landing")
	public String landing() {
		
		return "landing-page";
	}
	
	@GetMapping("/order")
	public String order() {
		
		return "orders";
	}
	

}
