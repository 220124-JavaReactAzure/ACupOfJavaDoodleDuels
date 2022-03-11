package com.revature.JavaDoodleDuels.web.dto;

import java.util.Objects;

public class SelectDuelerRequest {
	
	private String username;
	private String duelerName;

	public SelectDuelerRequest() {
		super();
	}

	public SelectDuelerRequest(String username, String duelerName) {
		super();
		this.username = username;
		this.duelerName = duelerName;
	}

	public String getDuelerName() {
		return duelerName;
	}

	public void setDuelerName(String duelerName) {
		this.duelerName = duelerName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "SelectDuelerRequest [username=" + username + ", duelerName=" + duelerName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(duelerName, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SelectDuelerRequest other = (SelectDuelerRequest) obj;
		return Objects.equals(duelerName, other.duelerName) && Objects.equals(username, other.username);
	}



}
