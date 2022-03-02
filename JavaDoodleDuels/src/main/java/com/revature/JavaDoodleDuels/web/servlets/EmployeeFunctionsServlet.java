package com.revature.JavaDoodleDuels.web.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.JavaDoodleDuels.services.DuelerService;
import com.revature.JavaDoodleDuels.services.SkillService;
import com.revature.JavaDoodleDuels.services.UserService;

@RestController
@RequestMapping("/employeeFunctions")
public class EmployeeFunctionsServlet {
	
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
	@GetMapping("/removeUser")
	public void removeUser() {
		
	}
	
	//this will be for employees to remove user created duelers from the database
	@GetMapping("/removeDueler")
	public void removeDueler() {
		
	}
	
	//this will be so employees can make new skills
	@GetMapping("/createSkill")
	public void createSkill() {
		
	}
	
	//this will be for employees to remove skills from the database
	@GetMapping("/removeSkill")
	public void removeSkill() {
		
	}
	
	//this will be for employees to add to the dummy pool
	@GetMapping("/addDummy")
	public void addDummy() {
		
	}
	
	//this will be for employees to remove from the dummy pool
	@GetMapping("/removeDummy")
	public void removeDummy() {
		
	}
	
	

}
