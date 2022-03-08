package com.revature.JavaDoodleDuels.services;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.JavaDoodleDuels.daos.DuelerDAO;
import com.revature.JavaDoodleDuels.models.Dueler;
import com.revature.JavaDoodleDuels.web.dto.DuelerRequest;

@Service
public class DuelerService {
	private DuelerDAO duelerDAO;
	
	public DuelerService() {
		
	}
	
	@Autowired
	public DuelerService(DuelerDAO duelerDAO) {
		this.duelerDAO = duelerDAO;
	}
	
	@Transactional
	public void registerNewDueler(DuelerRequest duelerRequest) {
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
			throw new PersistenceException("The dueler could not be persisted");
		}
		
	}

	@Transactional
	public boolean isDuelerNameAvailable(String duelerName) {
		return !(duelerDAO.findDuelerByDuelerName(duelerName).isPresent());
	}
	
	@Transactional
	public Dueler findDuelerByName(String duelerName) {
		return duelerDAO.findDuelerByDuelerName(duelerName).orElse(null);
	}

	@Transactional
	public void removeDuelerByName(String duelerName) {
		duelerDAO.deleteById(duelerName);
	}

	@Transactional
	public void addDummyByName(String duelerName) {
		Dueler newDummy = duelerDAO.findDuelerByDuelerName(duelerName).orElse(null);
		newDummy.setDummy(true);
		duelerDAO.save(newDummy);
	}

	@Transactional
	public void removeDummyByName(String duelerName) {
		Dueler newDummy = duelerDAO.findDuelerByDuelerName(duelerName).orElse(null);
		newDummy.setDummy(false);
		duelerDAO.save(newDummy);
	}

	@Transactional
	public List<Dueler> findFiveRandomDuelers() {
		return duelerDAO.findFiveRandomDuelers();
	}

	@Transactional
	public List<Dueler> getDuelerByAccountNumber(String accountNum) {
		return duelerDAO.findDuelerByAccountNumber(accountNum);
		
	}

	@Transactional
	public Dueler findRandomDummy() {
		return duelerDAO.findRandomDummy();
	}
	
	

	
	
}
