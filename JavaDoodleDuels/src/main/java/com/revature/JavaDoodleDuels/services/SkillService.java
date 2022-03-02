package com.revature.JavaDoodleDuels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.JavaDoodleDuels.daos.SkillDAO;

@Service
public class SkillService {
	
	private final SkillDAO skillDAO;
	
	@Autowired
	public SkillService(SkillDAO skillDAO) {
		this.skillDAO = skillDAO;
	}

}
