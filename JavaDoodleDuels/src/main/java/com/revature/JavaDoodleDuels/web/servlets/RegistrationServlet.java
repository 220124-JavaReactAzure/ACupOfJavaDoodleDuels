package com.revature.JavaDoodleDuels.web.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.JavaDoodleDuels.services.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationServlet {

	private final UserService userService;
	
	@Autowired
	public RegistrationServlet (UserService userService) {
		this.userService = userService;
	}
	
	
	//main user registration page
	@GetMapping
	public void registration() {
		
	}
	
	//employee registration page --- this will not have a button to take you here, manual link to page only
	@GetMapping("/employee")
	public void employeeRegistration() {
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String username = req.getParameter("username");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		
		try {
			
			boolean wasRegistered = userService
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
