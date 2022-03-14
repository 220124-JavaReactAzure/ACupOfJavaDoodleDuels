package com.revature.JavaDoodleDuels.web.dto;

import java.util.Objects;

public class RemoveUserRequest {

	private String Username;

	public RemoveUserRequest() {
		super();
	}

	public RemoveUserRequest(String username) {
		super();
		Username = username;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	@Override
	public String toString() {
		return "RemoveUserRequest [Username=" + Username + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemoveUserRequest other = (RemoveUserRequest) obj;
		return Objects.equals(Username, other.Username);
	}
	
}
