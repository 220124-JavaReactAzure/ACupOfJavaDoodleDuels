package com.revature.JavaDoodleDuels.web.servlets;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.JavaDoodleDuels.services.DuelerService;
import com.revature.JavaDoodleDuels.services.SkillService;
import com.revature.JavaDoodleDuels.services.UserService;

@RestController

@RequestMapping("/fightDummy")
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

	@GetMapping
	public String fightDummy() {
		return "fightDummy";
	}
	

}
