package com.in28minutes.springbootwebapp.firstwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String goToLoginPage() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String goToWelcomePage(@RequestParam String name,
			                      @RequestParam String password,
			                      ModelMap map) {
		
		System.out.println("in WelcomwPage method");
		map.put("name",name);
		
		return "welcome";
	}
}
