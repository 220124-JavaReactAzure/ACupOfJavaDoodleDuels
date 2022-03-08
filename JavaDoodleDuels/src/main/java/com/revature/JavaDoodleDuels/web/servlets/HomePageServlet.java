package com.revature.JavaDoodleDuels.web.servlets;

import java.util.List;

import javax.naming.AuthenticationException;
import javax.naming.directory.InvalidAttributesException;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.JavaDoodleDuels.models.Dueler;
import com.revature.JavaDoodleDuels.models.Skill;
import com.revature.JavaDoodleDuels.models.User;
import com.revature.JavaDoodleDuels.services.DuelerService;
import com.revature.JavaDoodleDuels.services.UserService;
import com.revature.JavaDoodleDuels.web.dto.DuelerResponse;
import com.revature.JavaDoodleDuels.web.dto.HomePageResponse;
import com.revature.JavaDoodleDuels.web.dto.LoginCredentials;

@RestController
public class HomePageServlet {
	private final static Logger  log = LogManager.getFormatterLogger();


	private final UserService userService;
	private final DuelerService duelerService;
	
	@Autowired
	public HomePageServlet(UserService userService, DuelerService duelerService) {
		this.userService = userService;
		this.duelerService = duelerService;
	}
	
	
	@PostMapping("/login")
<<<<<<< HEAD
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void login(@RequestBody LoginCredentials loginCredentials, HttpSession httpSession) throws AuthenticationException, InvalidAttributesException {
		User authUser = userService.authenticatedUser(loginCredentials.getUsername(), loginCredentials.getPassword());
		httpSession.setAttribute("authUser", authUser);
		log.info("logging in ...");
=======
	public ResponseEntity<Void> login(@RequestBody LoginCredentials loginCredentials, HttpSession httpSession) throws AuthenticationException, InvalidAttributesException {
		if(!(userService.isUsernameAvailable(loginCredentials.getUsername()))){
			User authUser = userService.findUserByUsername(loginCredentials.getUsername());
			if(authUser.getPassword().equals(loginCredentials.getPassword())) {
				httpSession.setAttribute("authUser", authUser);
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
>>>>>>> 33209367e97eacbe08db940f09ecd29f4d82c1c5
	}
	

	@DeleteMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
		log.info("logging out...session invalid");
	}
	
	
	@GetMapping("/imageCarousel")
	public String imageCarousel() {
		List<Dueler> randomDuelers = duelerService.findFiveRandomDuelers();
		HomePageResponse homePageResponse = new HomePageResponse(randomDuelers);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(homePageResponse);
	}
	
}
