package com.revature.JavaDoodleDuels.web.servlets;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.JavaDoodleDuels.services.DuelerService;
import com.revature.JavaDoodleDuels.services.SkillService;
import com.revature.JavaDoodleDuels.services.UserService;
import com.revature.JavaDoodleDuels.web.dto.DuelerRequest;

@RestController
//@RequestMapping("/createDueler")
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
	
	@GetMapping("/createDueler")
	public String duelerSkills() {
		return "Yo";
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		return gson.toJson(skillService.getAllSkills());
	}
	
	@PostMapping("/createDueler")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDueler(@RequestBody DuelerRequest duelerRequest) {
		duelerService.registerNewDueler(duelerRequest);
	}
	
//	@GetMapping("/checkDuelerName")
//	public ResponseEntity<Void> checkDuelerName(@RequestParam String duelerName){
//		return duelerService.isDuelerNameAvailable(duelerName) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.CONFLICT);
//	}
	
}
