package com.revature.JavaDoodleDuels.daos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.revature.JavaDoodleDuels.models.User;

public interface UserDAO extends CrudRepository<User, String> {

	Optional<User> findUserbyUsername(String username);
	Optional<User> findUserbyEmail(String email);
}
