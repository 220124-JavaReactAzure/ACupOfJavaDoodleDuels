package com.revature.JavaDoodleDuels.web.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.JavaDoodleDuels.services.UserService;

@RestController
@RequestMapping("/")
public class HomePageServlet {

	private final UserService userService;
	
	@Autowired
	public HomePageServlet(UserService userService) {
		this.userService = userService;
	}
	
	//login page
	@GetMapping
	public void home() {
		//login
		//registration
	}
	
	@PostMapping
	public void login() {
		
	}
	
	//home page for regular user after login
	@GetMapping("/userHome")
	public void userHome() {
		//dueler creation
		//account info
		//training mode
		//select or view duelers
	}
	
	
	
	//home page for employees after login
	@GetMapping("/employeeHome")
	public void employeeHome() {
		//dueler creation
		//account info
		//training mode
		//select or view duelers
		//remove user
		//remove dueler
		//add skill
		//remove skill
		//add dummy
		//remove dummy
	}
}
