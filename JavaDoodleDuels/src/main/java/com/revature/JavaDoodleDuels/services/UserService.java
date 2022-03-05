package com.revature.JavaDoodleDuels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.JavaDoodleDuels.daos.UserDAO;

@Service
public class UserService {

	private UserDAO userDAO;
	
	public UserService() {
		
	}
	
	@Autowired
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
