package com.revature.JavaDoodleDuels.dto;

import java.util.Objects;

import com.revature.JavaDoodleDuels.models.User;

public class UserResponse {

	private String username;

	public UserResponse(User user) {
		this.username = user.getUsername();
	}

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserResponse [username=" + username + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserResponse other = (UserResponse) obj;
		return Objects.equals(username, other.username);
	}

}
