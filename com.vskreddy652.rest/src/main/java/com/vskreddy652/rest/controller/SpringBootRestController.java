package com.vskreddy652.rest.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:9229/springbootwithsecurity/userlogin1
// http://localhost:9229/springbootwithsecurity/adminlogin

@RestController
public class SpringBootRestController {
	@RequestMapping("/userlogin1")
	public String userValidation1() {
		UserDetails user_details = (UserDetails)SecurityContextHolder
									.getContext()
									.getAuthentication().getPrincipal();

		return "User: Successfully logged in 1111!"+user_details.getUsername()+" "+user_details.getAuthorities();
	}

	@RequestMapping("/userlogin2")
	public String userValidation2() {
		return "User: Successfully logged in 2222!";
	}

	@RequestMapping("/adminlogin")
	public String adminValidation() {
		return "Admin: Successfully logged in!";
	}

	@RequestMapping("/sellerlogin")
	public String slrValidation() {
		return "Seller: Successfully logged in!";
	}
}