package com.revature.JavaDoodleDuels.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.JavaDoodleDuels.daos.DuelerDAO;

public class DuelerService {

private final DuelerDAO duelerDAO;
	
	@Autowired
	public DuelerService(DuelerDAO duelerDAO) {
		this.duelerDAO = duelerDAO;
	}
	
}
