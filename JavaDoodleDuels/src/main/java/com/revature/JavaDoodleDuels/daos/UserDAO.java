package com.revature.JavaDoodleDuels.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.JavaDoodleDuels.models.User;

@Repository
public interface UserDAO extends CrudRepository<User, String> {

	Optional<User> findUserByUsername(String username);
	Optional<User> findUserByEmail(String email);
	
	@Query("from User s where s.username = :username and s.password = :password")
	User findUserByUsernameAndPassword(String username, String password);
}
