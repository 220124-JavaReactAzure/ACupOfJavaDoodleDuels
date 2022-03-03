package com.revature.JavaDoodleDuels.web.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.JavaDoodleDuels.services.DuelerService;
import com.revature.JavaDoodleDuels.services.SkillService;
import com.revature.JavaDoodleDuels.services.UserService;

@RestController
@RequestMapping("/createDueler")
public class CreateDuelerServlet {

	private final UserService userService;
	private final DuelerService duelerService;
	private final SkillService skillService;
	
	@Autowired
	public CreateDuelerServlet(UserService userService, DuelerService duelerService, SkillService skillService) {
		this.userService = userService;
		this.duelerService = duelerService;
		this.skillService = skillService;
	}
	
}
