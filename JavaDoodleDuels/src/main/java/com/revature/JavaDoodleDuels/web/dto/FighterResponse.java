package com.revature.JavaDoodleDuels.web.dto;

import java.util.Objects;

import com.revature.JavaDoodleDuels.models.Dueler;
import com.revature.JavaDoodleDuels.models.Skill;

public class FighterResponse {

	private Dueler dueler;
	private Skill skillOne;
	private Skill skillTwo;
	private Skill skillThree;
	
	public FighterResponse() {
		super();
	}
	
	public FighterResponse(Dueler dueler, Skill skillOne, Skill skillTwo, Skill skillThree) {
		super();
		this.dueler = dueler;
		this.skillOne = skillOne;
		this.skillTwo = skillTwo;
		this.skillThree = skillThree;
	}

	public Dueler getDueler() {
		return dueler;
	}

	public void setDueler(Dueler dueler) {
		this.dueler = dueler;
	}

	public Skill getSkillOne() {
		return skillOne;
	}

	public void setSkillOne(Skill skillOne) {
		this.skillOne = skillOne;
	}

	public Skill getSkillTwo() {
		return skillTwo;
	}

	public void setSkillTwo(Skill skillTwo) {
		this.skillTwo = skillTwo;
	}

	public Skill getSkillThree() {
		return skillThree;
	}

	public void setSkillThree(Skill skillThree) {
		this.skillThree = skillThree;
	}

	@Override
	public String toString() {
		return "FighterResponse [dueler=" + dueler + ", skillOne=" + skillOne + ", skillTwo=" + skillTwo
				+ ", skillThree=" + skillThree + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dueler, skillOne, skillThree, skillTwo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FighterResponse other = (FighterResponse) obj;
		return Objects.equals(dueler, other.dueler) && Objects.equals(skillOne, other.skillOne)
				&& Objects.equals(skillThree, other.skillThree) && Objects.equals(skillTwo, other.skillTwo);
	}

	
}
