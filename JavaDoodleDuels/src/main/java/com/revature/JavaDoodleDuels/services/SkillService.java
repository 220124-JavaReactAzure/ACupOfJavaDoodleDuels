package com.revature.JavaDoodleDuels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.revature.JavaDoodleDuels.daos.SkillDAO;
import com.revature.JavaDoodleDuels.models.Skill;

@Service
public class SkillService {
	
	private SkillDAO skillDAO;
	
	public SkillService() {
		
	}
	
	@Autowired
	public SkillService(SkillDAO skillDAO) {
		this.skillDAO = skillDAO;
	}

	public List<Skill> getAllSkills() {
		return skillDAO.findAll();
	}

}
