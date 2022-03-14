package com.revature.JavaDoodleDuels;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.JavaDoodleDuels.daos.UserDAO;
import com.revature.JavaDoodleDuels.models.User;
import com.revature.JavaDoodleDuels.services.UserService;
import com.revature.JavaDoodleDuels.web.dto.UserRequest;

@SpringBootTest
class JavaDoodleDuelsApplicationTests {
	
	UserService sut;
	UserDAO mockUserDAO;
	
	@Before
	public void testPrep() {
		mockUserDAO = mock(UserDAO.class);
		sut = new UserService(mockUserDAO);
	}
	
	@Test
	public void test_isUserValid_returnsTrue_givenValidUser() {
		
		// Arrange
		UserRequest validUser = new UserRequest();
		
		// Act
		boolean actualResult = sut.isUserValid(validUser);
		
		// Assert
		Assert.assertTrue(actualResult);
		
	}
	
	@Test
	public void test_isUserValid_returnsFalse_givenUserWithFirstName() {
		
		// Arrange
		UserRequest invalidScientist1 = new UserRequest("","valid","valid","valid","valid");
		UserRequest invalidScientist2 = new UserRequest(null,"valid","valid","valid","valid");
		UserRequest invalidUser3 = new UserRequest(" ","valid","valid","valid","valid");
		
		
		//Act
		boolean actualResult1 = sut.isUserValid(invalidUser1);
		boolean actualResult2 = sut.isUserValid(invalidUser2);
		boolean actualResult3 = sut.isUserValid(invalidUser3);
		
		//Assert - everything you assert must pass the condition
		Assert.assertFalse(actualResult1);
		Assert.assertFalse(actualResult2);
		Assert.assertFalse(actualResult3);
		
	}
	
	//TODO: Figure out implementation MOCK IT!!!!!!!
	@Test
	public void test_registerUser_returnsTrue_givenValidUser() {
		// Arrange
		UserRequest validUser = new UserRequest("valid","valid","valid","valid","valid");
		User user = new User(validUser.getFirstName(),validUser.getLastName(), validUser.getEmail(), validUser.getUsername(), validUser.getPassword());
		when(mockUserDAO.findByUsername(validUser.getUsername())).thenReturn(null);
		when(mockUserDAO.findByEmail(validUser.getEmail())).thenReturn(null);
		when(mockUserDAO.create(user)).thenReturn(user);
		
		// Act
		boolean actualResult = sut.registerNewUser(validUser);
		
		// Assert
		Assert.assertNotNull(actualResult);
		verify(mockUserDAO, times(1)).create(user);
	}

	@Test(expected = InvalidRequestException.class)
	public void test_registerUser_throwsInvalidRequestException_givenInvalidUser() {
		sut.registerNewUser(null);
	}
	
	@Test(expected = ResourcePersistenceException.class)
	public void test_registerUser_throwsResourcePersistenceException_givenUserWithTakenUsername() {
		
		// Arrange
		UserRequest usernameTakenUser = new UserRequest("valid","valid","valid","valid","valid");
		User user = new User(usernameTakenUser.getFirstName(),usernameTakenUser.getLastName(), usernameTakenUser.getEmail(), usernameTakenUser.getUsername(), usernameTakenUser.getPassword());
		when(mockUserDAO.findUserByUsername(usernameTakenUser.getUsername())).thenReturn(user);
		when(mockUserDAO.findUserByEmail(usernameTakenUser.getEmail())).thenReturn(null);

		
		// Act
		try {
			sut.registerNewUser(usernameTakenUser);
		} finally {
			// Assert
			verify(mockUserDAO, times(0)).create(user);
		}
	}
		
		@Test(expected = ResourcePersistenceException.class)
		public void test_registerUser_throwsResourcePersistenceException_givenUserWithTakenEmail() {
			
			// Arrange
			UserRequest emailTakenUser = new UserRequest("valid","valid","valid","valid","valid","valid","valid","valid");
			User user = new User(emailTakenUser.getFirstName(),emailTakenUser.getLastName(), emailTakenUser.getEmail(), emailTakenUser.getUsername(), emailTakenUser.getPassword());
			when(mockUserDAO.findUserByUsername(emailTakenUser.getUsername())).thenReturn(null);
			when(mockUserDAO.findUserByEmail(emailTakenUser.getEmail())).thenReturn(user);
			
			// Act
			try {
				sut.registerNewUser(emailTakenUser);
			} finally {
				// Assert
				verify(mockUserDAO, times(0)).create(user);
			}
		
		
	}
}