package com.revature.JavaDoodleDuels.services;

import java.util.List;
import java.util.UUID;

import javax.naming.AuthenticationException;
import javax.naming.directory.InvalidAttributesException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.JavaDoodleDuels.daos.UserDAO;
import com.revature.JavaDoodleDuels.models.User;
import com.revature.JavaDoodleDuels.web.dto.UserRequest;
import com.revature.JavaDoodleDuels.web.dto.UserResponse;

@Service
public class UserService {

	private UserDAO userDAO;

	public UserService() {

	}

	@Autowired
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public void registerNewUser(UserRequest userRequest) {

		User newUser = new User(userRequest.getUsername(), userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail(),
				userRequest.getPassword(), userRequest.getAccountType(), userRequest.getEmployeeCode(), userRequest.getCurrentDuelerName());
		newUser.setAccountNumber(UUID.randomUUID().toString());
		User persistedUser = userDAO.save(newUser);
		if (persistedUser == null) {
			throw new PersistenceException("user could not be persisted");
		}
	}
	
	@Transactional
	public void updateUser(User updateUser) {
		User persistedUser = userDAO.save(updateUser);
		if (persistedUser == null) {
			throw new PersistenceException("user could not be persisted");
		}
	}

	@Transactional
	public List<UserResponse> getAllUsers() {
		return null;
	}

	@Transactional
	public boolean isEmailAvailable(String email) {
		return !(userDAO.findUserByEmail(email).isPresent() );
	}
	
	@Transactional
	public boolean isUsernameAvailable(String username) {
		return !(userDAO.findUserByUsername(username).isPresent());
	}
	
	@Transactional
	public void removeUserByUsername(String username) {
		userDAO.deleteById(username);
	}
	
	@Transactional
	public void updateDueler(User currentUser) {
		userDAO.save(currentUser);
	}
	
	@Transactional
	public User findUserByUsername(String username) {
		return userDAO.findUserByUsername(username).orElse(null);
	}
}