package com.revature.JavaDoodleDuels.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class Dueler {
	
	@Id
	@Column(name="dueler_name")
	private String duelerName;
	
	@Column(name="account_number")
	private long accountNumer;   // used to get called by user
	
	@Column(name="dueler_image")
	private String duelerImage;   // not sure if this will work
	
	@Column
	private int strength;
	
	@Column
	private int dexterity;
	
	@Column
	private int constitution;
	
	@Column
	private int wisdom;
	
	@Column
	private int intelligence;
	
	@Column
	private int charisma;
	
	@Column(name="skill_one")
	private String skillOne;  // used to call skill table
	
	@Column(name="skill_two")
	private String skillTwo;  // used to call skill table
	
	@Column(name="skill_three")
	private String skillThree;  // used to call skill table
	
	@Column(name="is_dummy")
	private boolean isDummy; // used to create a pool of dummies to battle against, default is false

	public Dueler() {
		super();
	}
	
	public Dueler(String duelerName, long accountNumer, String duelerImage, int strength, int dexterity,
			int constitution, int wisdom, int intelligence, int charisma, String skillOne, String skillTwo,
			String skillThree, boolean isDummy) {
		super();
		this.duelerName = duelerName;
		this.accountNumer = accountNumer;
		this.duelerImage = duelerImage;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.wisdom = wisdom;
		this.intelligence = intelligence;
		this.charisma = charisma;
		this.skillOne = skillOne;
		this.skillTwo = skillTwo;
		this.skillThree = skillThree;
		this.isDummy = isDummy;
	}

	public String getDuelerName() {
		return duelerName;
	}

	public void setDuelerName(String duelerName) {
		this.duelerName = duelerName;
	}

	public long getAccountNumer() {
		return accountNumer;
	}

	public void setAccountNumer(long accountNumer) {
		this.accountNumer = accountNumer;
	}

	public String getDuelerImage() {
		return duelerImage;
	}

	public void setDuelerImage(String duelerImage) {
		this.duelerImage = duelerImage;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public String getSkillOne() {
		return skillOne;
	}

	public void setSkillOne(String skillOne) {
		this.skillOne = skillOne;
	}

	public String getSkillTwo() {
		return skillTwo;
	}

	public void setSkillTwo(String skillTwo) {
		this.skillTwo = skillTwo;
	}

	public String getSkillThree() {
		return skillThree;
	}

	public void setSkillThree(String skillThree) {
		this.skillThree = skillThree;
	}

	public boolean isDummy() {
		return isDummy;
	}

	public void setDummy(boolean isDummy) {
		this.isDummy = isDummy;
	}

	@Override
	public String toString() {
		return "Dueler [duelerName=" + duelerName + ", accountNumer=" + accountNumer + ", duelerImage=" + duelerImage
				+ ", strength=" + strength + ", dexterity=" + dexterity + ", constitution=" + constitution + ", wisdom="
				+ wisdom + ", intelligence=" + intelligence + ", charisma=" + charisma + ", skillOne=" + skillOne
				+ ", skillTwo=" + skillTwo + ", skillThree=" + skillThree + ", isDummy=" + isDummy + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumer, charisma, constitution, dexterity, duelerImage, duelerName, intelligence,
				isDummy, skillOne, skillThree, skillTwo, strength, wisdom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dueler other = (Dueler) obj;
		return accountNumer == other.accountNumer && charisma == other.charisma && constitution == other.constitution
				&& dexterity == other.dexterity && Objects.equals(duelerImage, other.duelerImage)
				&& Objects.equals(duelerName, other.duelerName) && intelligence == other.intelligence
				&& isDummy == other.isDummy && Objects.equals(skillOne, other.skillOne)
				&& Objects.equals(skillThree, other.skillThree) && Objects.equals(skillTwo, other.skillTwo)
				&& strength == other.strength && wisdom == other.wisdom;
	}

	
}
