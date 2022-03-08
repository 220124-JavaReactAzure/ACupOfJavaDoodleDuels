package com.revature.JavaDoodleDuels.services;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonElement;
import com.revature.JavaDoodleDuels.daos.SkillDAO;
import com.revature.JavaDoodleDuels.models.Skill;
import com.revature.JavaDoodleDuels.web.dto.AddSkillRequest;

@Service
public class SkillService {
	
	private SkillDAO skillDAO;
	
	public SkillService() {
		
	}
	
	@Autowired
	public SkillService(SkillDAO skillDAO) {
		this.skillDAO = skillDAO;
	}
	
	@Transactional
	public void registerNewSkill(AddSkillRequest addSkillRequest) {
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
			throw new PersistenceException("The skill could not be persisted");
		}
		
	}
	
	@Transactional
	public List<Skill> getAllSkills() {
		return skillDAO.findAll();
	}

	@Transactional
	public boolean isSkillNameAvailable(String skillName) {
		return skillDAO.findSkillBySkillName(skillName).isEmpty();
	}

	@Transactional
	public void removeSkillByName(String skillName) {
		skillDAO.deleteById(skillName);
	}

	@Transactional
	public Skill findSkillBySkillName(String skillName) {
		return skillDAO.findSkillBySkillName(skillName).orElse(null);
	}

	

}
