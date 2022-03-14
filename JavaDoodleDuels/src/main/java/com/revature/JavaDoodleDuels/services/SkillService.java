package com.revature.JavaDoodleDuels.services;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonElement;
import com.revature.JavaDoodleDuels.daos.SkillDAO;
import com.revature.JavaDoodleDuels.models.Skill;
import com.revature.JavaDoodleDuels.web.dto.AddSkillRequest;

@Service
public class SkillService {
	
	private final static Logger  log = LogManager.getFormatterLogger();

	
	private SkillDAO skillDAO;
	
	public SkillService() {
		
	}
	
	@Autowired
	public SkillService(SkillDAO skillDAO) {
		this.skillDAO = skillDAO;
	}
	
	@Transactional
	public void registerNewSkill(AddSkillRequest addSkillRequest) {
		log.info("Registering a new skill...");
		Skill newSkill = new Skill(
				addSkillRequest.getSkillName(),
				addSkillRequest.getDamage(),
				addSkillRequest.getDamageStatType(),
				addSkillRequest.getScaledDamage(),
				addSkillRequest.getScalingRequirement(),
				addSkillRequest.getDescription(),
				addSkillRequest.getHealing(),
				addSkillRequest.getManaCost()
				);
		Skill persistedSkill = skillDAO.save(newSkill);
		
		if(persistedSkill == null) {
			log.error("Could not create new skill, problem persisting to database...");
			throw new PersistenceException("The skill could not be persisted");
		}
		log.info("new skill created...");
		
	}
	
	@Transactional
	public List<Skill> getAllSkills() {
		return skillDAO.findAll();
	}

	@Transactional
	public boolean isSkillNameAvailable(String skillName) {
		return !(skillDAO.findSkillBySkillName(skillName).isPresent());
	}

	@Transactional
	public void removeSkillByName(String skillName) {
		skillDAO.deleteById(skillName);
		log.info("skill"+skillName+" removed...");
	}

	@Transactional
	public Skill findSkillBySkillName(String skillName) {
		return skillDAO.findSkillBySkillName(skillName).orElse(null);
	}

	

}
