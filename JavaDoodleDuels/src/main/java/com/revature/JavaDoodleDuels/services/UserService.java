package com.revature.JavaDoodleDuels.services;

import java.util.List;

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
	public boolean registerNewUser(UserRequest userRequest) {

		User newUser = new User(userRequest.getUsername(), userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail(),
				userRequest.getPassword(), userRequest.getAccountType(), userRequest.getEmployeeCode(), userRequest.getCurrentDuelerName());

		boolean usernameAvailable = userDAO.findUserByUsername(newUser.getUsername()).isPresent();
		boolean emailAvailable = userDAO.findUserByEmail(newUser.getEmail()).isPresent();

		if (!usernameAvailable || !emailAvailable) {
			if (emailAvailable) {
				throw new PersistenceException("The provided username was already taken in the database");
			} else if (usernameAvailable) {
				throw new PersistenceException("The provided email was already taken in the database");
			}
		}
		User persistedUser = userDAO.save(newUser);
		if (persistedUser == null) {
			throw new PersistenceException("user could not be persisted");
		}
		return true;

	}

	@Transactional
	public List<UserResponse> getAllUsers() {
		return null;
	}

	@Transactional
	public User authenticatedUser(String username, String password) throws InvalidAttributesException, AuthenticationException {
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			throw new InvalidAttributesException("Either username or password is invalid. Please try again.");
		}
		
		User authenticatedUser = userDAO.findUserByUsernameAndPassword(username, password);
		
		if(authenticatedUser == null) {
			throw new AuthenticationException("Unauthenticated user, info provided not found in database");
		}
		return authenticatedUser;
		}
//	@Transactional
//	public void updateUser(UpdateUserRequest updateUserRequest) {
//		try {
//			
//			User original = userDAO.findById(updateUserRequest.getUserUsername()).orElseThrow(ResourceNotFoundException::new);
//			
//			Predicate<String> notNullorEmpty = str -> str != null && !str.equals("");
//			
//			if(notNullorEmpty.test(updateUserRequest.getFirstName())) {
//				original.setFirstName(updateUserRequest.getFirstName());
//			} else if(notNullorEmpty.test(updateUserRequest.getLastName())) {
//				original.setLastName(updateUserRequest.getLastName());
//			} else if(notNullorEmpty.test(updateUserRequest.getEmail())) {
//				if(userDAO.findUserByEmail(updateUserRequest.getEmail()).isPresent()) {
//					throw new ResourcePersistenceException("The provided email is already in use");
//				}
//				original.setEmail(updateUserRequest.getEmail());
//			} else if(notNullorEmpty.test(updateUserRequest.getPassword())) {
//				original.setPassword(updateUserRequest.getPassword());
//			}
//			
//		} catch (ResourcePersistenceException e) {
//			throw e;
//		} catch (Exception e) {
//			throw new ResourcePersistenceException("Could not update user to due our exception checking");
//		}
//	}
	
	@Transactional
	public boolean isEmailAvailable(String email) {
		return userDAO.findUserByEmail(email).isEmpty();
	}
	
	@Transactional
	public boolean isUsernameAvailable(String username) {
		return userDAO.findUserByUsername(username).isEmpty();
	}
	
	@Transactional
	public void removeUserByUsername(String username) {
		// TODO Auto-generated method stub
		userDAO.deleteById(username);
	}
}