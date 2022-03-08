package com.revature.JavaDoodleDuels.web.servlets;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.JavaDoodleDuels.models.Dueler;
import com.revature.JavaDoodleDuels.models.Skill;
import com.revature.JavaDoodleDuels.models.User;
import com.revature.JavaDoodleDuels.services.DuelerService;
import com.revature.JavaDoodleDuels.services.SkillService;
import com.revature.JavaDoodleDuels.services.UserService;
import com.revature.JavaDoodleDuels.web.dto.DuelerRequest;
import com.revature.JavaDoodleDuels.web.dto.DuelerResponse;
import com.revature.JavaDoodleDuels.web.dto.SelectDuelerRequest;

@RestController
public class CreateDuelerServlet {
	private final static Logger  log = LogManager.getFormatterLogger();


	private final UserService userService;
	private final DuelerService duelerService;
	private final SkillService skillService;
	
	@Autowired
	public CreateDuelerServlet(UserService userService, DuelerService duelerService, SkillService skillService) {
		this.userService = userService;
		this.duelerService = duelerService;
		this.skillService = skillService;
	}
	
	@GetMapping("/createDueler")
	public String duelerSkills(HttpSession httpSession) {
		User currentUser = (User) httpSession.getAttribute("authUser");
		List<Skill> allSkills = skillService.getAllSkills();
		DuelerResponse duelerResponse = new DuelerResponse(currentUser.getAccountNumber(), allSkills);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(duelerResponse);
	}
	
	@PostMapping("/createDueler")
<<<<<<< HEAD
	@ResponseStatus(HttpStatus.CREATED)
	public void createDueler(@RequestBody DuelerRequest duelerRequest) {
		duelerService.registerNewDueler(duelerRequest);
		log.info("Dueler servlet started...");
=======
	public ResponseEntity<Void> createDueler(@RequestBody DuelerRequest duelerRequest) {
		if(duelerService.isDuelerNameAvailable(duelerRequest.getDuelerName())) {
			duelerService.registerNewDueler(duelerRequest);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
>>>>>>> 33209367e97eacbe08db940f09ecd29f4d82c1c5
	}
	
	@GetMapping("/viewDuelers")
	public String viewDuelers(HttpSession httpSession) {
		User currentUser = (User) httpSession.getAttribute("authUser");
		List<Dueler> yourDuelers = duelerService.getDuelerByAccountNumber(currentUser.getAccountNumber());
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(yourDuelers);
	}
	
	@PostMapping("/viewDuelers")
	public ResponseEntity<Void> selectDueler(@RequestBody SelectDuelerRequest selectDuelerRequest, HttpSession httpSession){
		User currentUser = (User) httpSession.getAttribute("authUser");
		currentUser.setCurrentDuelerName(selectDuelerRequest.getDuelerName());
		userService.updateDueler(currentUser);
		httpSession.setAttribute("authUser", currentUser);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
