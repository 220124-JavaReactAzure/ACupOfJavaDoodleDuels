package com.revature.JavaDoodleDuels.services;

import javax.persistence.PersistenceException;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.JavaDoodleDuels.daos.DuelerDAO;
import com.revature.JavaDoodleDuels.models.Dueler;
import com.revature.JavaDoodleDuels.web.dto.DuelerRequest;

@Service
public class DuelerService {
	private DuelerDAO duelerDAO;
	
	private final static Logger  log = LogManager.getFormatterLogger();

	
	public DuelerService() {
		
	}
	
	@Autowired
	public DuelerService(DuelerDAO duelerDAO) {
		this.duelerDAO = duelerDAO;
	}
	
	@Transactional
	public void registerNewDueler(DuelerRequest duelerRequest) {
		log.info("Creating a new Dueler...");
		Dueler newDueler = new Dueler(
				duelerRequest.getDuelerName(),
				duelerRequest.getAccountNumber(),
				duelerRequest.getDuelerImage(),
				duelerRequest.getStrength(),
				duelerRequest.getDexterity(),
				duelerRequest.getConstitution(),
				duelerRequest.getWisdom(),
				duelerRequest.getIntelligence(),
				duelerRequest.getCharisma(),
				duelerRequest.getMaxHealth(),
				duelerRequest.getMaxMana(),
				duelerRequest.getSkillOne(),
				duelerRequest.getSkillTwo(),
				duelerRequest.getSkillThree(),
				duelerRequest.isDummy()
				);
		
		Dueler persistedDueler = duelerDAO.save(newDueler);
		
		if(persistedDueler == null) {
			log.info("Failure to create Dueler...");
			log.error("application failed to create new user, posibly failed to connect to database");
			throw new PersistenceException("The dueler could not be persisted");
		}
		log.info("Success, dueler added...");
		
	}

	@Transactional
	public boolean isDuelerNameAvailable(String duelerName) {
		log.info("Checking is dueler is available....");
		return duelerDAO.findDuelerByDuelerName(duelerName).isEmpty();
	}

	@Transactional
	public void removeDuelerByName(String duelerName) {
		log.info("Removing dueler...");
		duelerDAO.deleteById(duelerName);
	}

	@Transactional
	public void addDummyByName(String duelerName) {
		Dueler newDummy = duelerDAO.findDuelerByDuelerName(duelerName).orElse(null);
		newDummy.setDummy(true);
		duelerDAO.save(newDummy);
		log.info("dummy dueler created...");
	}

	public void removeDummyByName(String duelerName) {
		Dueler newDummy = duelerDAO.findDuelerByDuelerName(duelerName).orElse(null);
		newDummy.setDummy(false);
		duelerDAO.save(newDummy);
		log.info("Dummy removed using name token...");
	}
	

	
	
}
