package com.revature.JavaDoodleDuels.web.servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.JavaDoodleDuels.models.Dueler;
import com.revature.JavaDoodleDuels.models.Skill;
import com.revature.JavaDoodleDuels.models.User;
import com.revature.JavaDoodleDuels.services.DuelerService;
import com.revature.JavaDoodleDuels.services.SkillService;
import com.revature.JavaDoodleDuels.services.UserService;
import com.revature.JavaDoodleDuels.web.dto.FighterResponse;

@RestController

public class FightDummyServlet {

	private final UserService userService;
	private final DuelerService duelerService;
	private final SkillService skillService;

	@Autowired
	public FightDummyServlet(UserService userService, DuelerService duelerService, SkillService skillService) {
		this.userService = userService;
		this.duelerService = duelerService;
		this.skillService = skillService;
	}

	@GetMapping("/fighter1")
	public String yourFighter(HttpSession httpSession) {
		User currentUser = (User) httpSession.getAttribute("authUser");
		Dueler currentDueler = duelerService.findDuelerByName(currentUser.getCurrentDuelerName());
		Skill skillOne = skillService.findSkillBySkillName(currentDueler.getSkillOne());
		Skill skillTwo = skillService.findSkillBySkillName(currentDueler.getSkillTwo());
		Skill skillThree = skillService.findSkillBySkillName(currentDueler.getSkillThree());
		FighterResponse fighterResponse = new FighterResponse(currentDueler, skillOne, skillTwo, skillThree);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(fighterResponse);
	}
	
	@GetMapping("/fighter2")
	public String dummy() {
		Dueler currentDueler = duelerService.findRandomDummy();
		Skill skillOne = skillService.findSkillBySkillName(currentDueler.getSkillOne());
		Skill skillTwo = skillService.findSkillBySkillName(currentDueler.getSkillTwo());
		Skill skillThree = skillService.findSkillBySkillName(currentDueler.getSkillThree());
		FighterResponse fighterResponse = new FighterResponse(currentDueler, skillOne, skillTwo, skillThree);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(fighterResponse);
	}

}
