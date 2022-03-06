package com.revature.JavaDoodleDuels.web.servlets;

import javax.naming.AuthenticationException;
import javax.naming.directory.InvalidAttributesException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.JavaDoodleDuels.models.User;
import com.revature.JavaDoodleDuels.services.UserService;
import com.revature.JavaDoodleDuels.web.dto.LoginCredentials;

@RestController
public class HomePageServlet {

	private final UserService userService;
	
	@Autowired
	public HomePageServlet(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping
	public void home() {
		//login
		//registration
	}
	
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void login(@RequestBody LoginCredentials loginCredentials, HttpSession httpSession) throws AuthenticationException, InvalidAttributesException {
		User authUser = userService.authenticatedUser(loginCredentials.getUsername(), loginCredentials.getPassword());
		httpSession.setAttribute("authUser", authUser);
	}
	

	@DeleteMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
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
