package com.revature.JavaDoodleDuels.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.JavaDoodleDuels.daos.SkillDAO;

public class SkillService {
	
	private final SkillDAO skillDAO;
	
	@Autowired
	public SkillService(SkillDAO skillDAO) {
		this.skillDAO = skillDAO;
	}

}
