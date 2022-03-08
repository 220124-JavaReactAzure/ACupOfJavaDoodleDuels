package com.revature.JavaDoodleDuels.web.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.JavaDoodleDuels.models.User;
import com.revature.JavaDoodleDuels.services.UserService;
import com.revature.JavaDoodleDuels.web.dto.UserRequest;

@RestController
public class RegistrationServlet {

	private final UserService userService;
	
	@Autowired
	public RegistrationServlet (UserService userService) {
		this.userService = userService;
	}
	
	
	//main user registration page
	@PostMapping("/registration")
	public ResponseEntity<Void> registration(@RequestBody UserRequest userRequest) {
		if(userService.isUsernameAvailable(userRequest.getUsername())) {
			if(userService.isEmailAvailable(userRequest.getEmail())) {
				userService.registerNewUser(userRequest);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	//employee registration page --- this will not have a button to take you here, manual link to page only
	@PostMapping("/registration/employee")
	public ResponseEntity<Void> employeeRegistration(@RequestBody UserRequest userRequest) {
		if(userService.isUsernameAvailable(userRequest.getUsername())) {
			if(userService.isEmailAvailable(userRequest.getEmail())) {
				userService.registerNewUser(userRequest);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/updateUser")
	public String updateUser(HttpSession httpSession){
		User currentUser = (User) httpSession.getAttribute("authUser");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(currentUser);
	}
	
	@PostMapping("/updateUser")
	public ResponseEntity<Void> updateUser(@RequestBody UserRequest userRequest, HttpSession httpSession){
		User currentUser = (User) httpSession.getAttribute("authUser");
		if(currentUser.getUsername().equals(userRequest.getUsername()) || userService.isUsernameAvailable(userRequest.getUsername())) {
			if(currentUser.getEmail().equals(userRequest.getEmail()) || userService.isEmailAvailable(userRequest.getEmail())) {
				
				User updateUser = new User(userRequest.getUsername(), userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail(),
						userRequest.getPassword(), userRequest.getAccountType(), userRequest.getEmployeeCode(), userRequest.getCurrentDuelerName());
				updateUser.setAccountNumber(currentUser.getAccountNumber());
				userService.updateUser(updateUser);
				httpSession.setAttribute("authUser", updateUser);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
