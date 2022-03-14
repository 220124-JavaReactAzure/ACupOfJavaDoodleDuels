package com.revature.JavaDoodleDuels.web.dto;

import java.util.Objects;

public class RemoveSkillRequest {

	private String skillName;

	public RemoveSkillRequest() {
		super();
	}

	public RemoveSkillRequest(String skillName) {
		super();
		this.skillName = skillName;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "RemoveSkillRequest [skillName=" + skillName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(skillName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemoveSkillRequest other = (RemoveSkillRequest) obj;
		return Objects.equals(skillName, other.skillName);
	}
	
}
