package com.revature.JavaDoodleDuels.web.dto;

import java.util.List;
import java.util.Objects;

import com.revature.JavaDoodleDuels.models.Skill;

public class DuelerResponse {
	
	private String userID;
	private List<Skill> allSkills;
	
	public DuelerResponse() {
		super();
	}
	public DuelerResponse(String userID, List<Skill> allSkills) {
		super();
		this.userID = userID;
		this.allSkills = allSkills;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public List<Skill> getAllSkills() {
		return allSkills;
	}
	public void setAllSkills(List<Skill> allSkills) {
		this.allSkills = allSkills;
	}
	@Override
	public String toString() {
		return "DuelerResponse [userID=" + userID + ", allSkills=" + allSkills + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(allSkills, userID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DuelerResponse other = (DuelerResponse) obj;
		return Objects.equals(allSkills, other.allSkills) && Objects.equals(userID, other.userID);
	}
	

}
