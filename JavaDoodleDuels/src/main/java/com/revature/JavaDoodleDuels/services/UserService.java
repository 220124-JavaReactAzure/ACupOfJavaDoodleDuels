package com.revature.JavaDoodleDuels.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.JavaDoodleDuels.daos.UserDAO;
import com.revature.JavaDoodleDuels.models.User;

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

<<<<<<< HEAD
		User newUser = new User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail(),
				userRequest.getUsername(), userRequest.getPassword());

		boolean usernameAvailable = userDAO.findUserByUsername(newUser.getUsername()).isPresent();
		boolean emailAvailable = userDAO.findUserByEmail(newUser.getEmail()).isPresent();

		if (!usernameAvailable || !emailAvailable) {
			if (emailAvailable) {
				throw new ResourcePersistenceException("The provided username was already taken in the database");
			} else if (usernameAvailable) {
				throw new ResourcePersistenceException("The provided email was already taken in the database");
			}
		}
=======
		User newUser = new User(userRequest.getUsername(), userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail(),
				userRequest.getPassword(), userRequest.getAccountType(), userRequest.getEmployeeCode(), userRequest.getCurrentDuelerName());
		newUser.setAccountNumber(UUID.randomUUID().toString());
		User persistedUser = userDAO.save(newUser);
>>>>>>> 33209367e97eacbe08db940f09ecd29f4d82c1c5
		if (persistedUser == null) {
			throw new ResourcePersistenceException("user could not be persisted");
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
<<<<<<< HEAD
	public User authenticatedUser(String username, String password) {
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("") {
			throw new InvalidRequestException("Either username or password is invalid. Please try again.");
		}
		
		User authenticatedUser = userDAO.findUserByUsernameAndPassword(username, password);
		
		if(authenticatedUser == null) {
			throw new AuthenticationException("Unauthenticated user, info provided not found in database");
		}
		return authenticatedUser;
		}
	@Transactional
	public void updateUser(UpdateUserRequest updateUserRequest) {
		try {
			
			User original = userDAO.findById(updateUserRequest.getUserUsername()).orElseThrow(ResourceNotFoundException::new);
			
			Predicate<String> notNullorEmpty = str -> str != null && !str.equals("");
			
			if(notNullorEmpty.test(updateUserRequest.getFirstName())) {
				original.setFirstName(updateUserRequest.getFirstName());
			} else if(notNullorEmpty.test(updateUserRequest.getLastName())) {
				original.setLastName(updateUserRequest.getLastName());
			} else if(notNullorEmpty.test(updateUserRequest.getEmail())) {
				if(userDAO.findUserByEmail(updateUserRequest.getEmail()).isPresent()) {
					throw new ResourcePersistenceException("The provided email is already in use");
				}
				original.setEmail(updateUserRequest.getEmail());
			} else if(notNullorEmpty.test(updateUserRequest.getPassword())) {
				original.setPassword(updateUserRequest.getPassword());
			}
			
		} catch (ResourcePersistenceException e) {
			throw e;
		} catch (Exception e) {
			throw new ResourcePersistenceException("Could not update user to due our exception checking");
		}
	}
	
	@Transactional
=======
>>>>>>> 33209367e97eacbe08db940f09ecd29f4d82c1c5
	public boolean isEmailAvailable(String email) {
		return userDAO.findUserByEmail(email).isEmpty();
	}
	
	@Transactional
	public boolean isUsernameAvailable(String username) {
		return userDAO.findUserByUsername(username).isEmpty();
	}
<<<<<<< HEAD
=======
	
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
>>>>>>> 33209367e97eacbe08db940f09ecd29f4d82c1c5
}