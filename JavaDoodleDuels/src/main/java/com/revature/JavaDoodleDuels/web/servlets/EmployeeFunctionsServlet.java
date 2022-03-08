package com.revature.JavaDoodleDuels.web.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.JavaDoodleDuels.services.DuelerService;
import com.revature.JavaDoodleDuels.services.SkillService;
import com.revature.JavaDoodleDuels.services.UserService;
import com.revature.JavaDoodleDuels.web.dto.AddSkillRequest;
import com.revature.JavaDoodleDuels.web.dto.RemoveDuelerRequest;
import com.revature.JavaDoodleDuels.web.dto.RemoveDummyRequest;
import com.revature.JavaDoodleDuels.web.dto.RemoveSkillRequest;
import com.revature.JavaDoodleDuels.web.dto.RemoveUserRequest;
import com.revature.JavaDoodleDuels.web.dto.addDummyRequest;

@RestController
@RequestMapping("/employeeFunctions")
public class EmployeeFunctionsServlet {
	private final static Logger  log = LogManager.getFormatterLogger();

	
	private final UserService userService;
	private final DuelerService duelerService;
	private final SkillService skillService;
	
	@Autowired
	public EmployeeFunctionsServlet(UserService userService, DuelerService duelerService, SkillService skillService) {
		this.userService = userService;
		this.duelerService = duelerService;
		this.skillService = skillService;
	}
	
	//this will be for employees to remove users from the database
	@PostMapping("/removeUser")
	public ResponseEntity<Void> removeUser(@RequestBody RemoveUserRequest removeUserRequest) {
		if(userService.isUsernameAvailable(removeUserRequest.getUsername())) {
			log.info("invalid name provided, name doesnt exist in database...");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			userService.removeUserByUsername(removeUserRequest.getUsername());
			log.info("User removed...");
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}
	
	//this will be for employees to remove user created duelers from the database
	@PostMapping("/removeDueler")
	public ResponseEntity<Void> removeDueler(@RequestBody RemoveDuelerRequest removeDuelerRequest) {
		if(duelerService.isDuelerNameAvailable(removeDuelerRequest.getDuelerName())) {
			log.info("dueler not found...");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			duelerService.removeDuelerByName(removeDuelerRequest.getDuelerName());
			log.info("dueler found and removed");
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}
	
	//this will be so employees can make new skills
	@PostMapping("/createSkill")
	public ResponseEntity<Void> createSkill(@RequestBody AddSkillRequest addSkillRequest) {
		if(skillService.isSkillNameAvailable(addSkillRequest.getSkillName())) {
			skillService.registerNewSkill(addSkillRequest);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	//this will be for employees to remove skills from the database
	@PostMapping("/removeSkill")
	public ResponseEntity<Void> removeSkill(@RequestBody RemoveSkillRequest removeSkillRequest) {
		if(skillService.isSkillNameAvailable(removeSkillRequest.getSkillName())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			skillService.removeSkillByName(removeSkillRequest.getSkillName());
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}
	
	//this will be for employees to add to the dummy pool
	@PostMapping("/addDummy")
	public ResponseEntity<Void> addDummy(@RequestBody addDummyRequest addDummyRequest) {
		if(duelerService.isDuelerNameAvailable(addDummyRequest.getDuelerName())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			duelerService.addDummyByName(addDummyRequest.getDuelerName());
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}
	
	//this will be for employees to remove from the dummy pool
	@PostMapping("/removeDummy")
	public ResponseEntity<Void> removeDummy(@RequestBody RemoveDummyRequest removeDummyRequest) {
		if(duelerService.isDuelerNameAvailable(removeDummyRequest.getDuelerName())) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			duelerService.removeDummyByName(removeDummyRequest.getDuelerName());
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}
	
	

}
