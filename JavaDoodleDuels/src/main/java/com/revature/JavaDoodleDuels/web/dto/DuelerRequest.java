package com.revature.JavaDoodleDuels.web.dto;

import java.util.Objects;


public class DuelerRequest {
	
	private String duelerName;
	private long accountNumber;   // used to get called by user
	private String duelerImage;   // not sure if this will work
	private int strength;
	private int dexterity;
	private int constitution;
	private int wisdom;
	private int intelligence;
	private int charisma;
	private int maxHealth;
	private int maxMana;
	private String skillOne;  // used to call skill table
	private String skillTwo;  // used to call skill table
	private String skillThree;  // used to call skill table
	private boolean isDummy; // used to create a pool of dummies to battle against, default is false

	public DuelerRequest() {
		super();
	}
	
	public DuelerRequest(String duelerName, long accountNumber, String duelerImage, int strength, int dexterity,
			int constitution, int wisdom, int intelligence, int charisma, int maxHealth, int maxMana, String skillOne, String skillTwo,
			String skillThree, boolean isDummy) {
		super();
		this.duelerName = duelerName;
		this.accountNumber = accountNumber;
		this.duelerImage = duelerImage;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.wisdom = wisdom;
		this.intelligence = intelligence;
		this.charisma = charisma;
		this.maxHealth = maxHealth;
		this.maxMana = maxMana;
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

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
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
		return "DuelerRequest [duelerName=" + duelerName + ", accountNumber=" + accountNumber + ", duelerImage=" + duelerImage
				+ ", strength=" + strength + ", dexterity=" + dexterity + ", constitution=" + constitution + ", wisdom="
				+ wisdom + ", intelligence=" + intelligence + ", charisma=" + charisma + ", skillOne=" + skillOne
				+ ", skillTwo=" + skillTwo + ", skillThree=" + skillThree + ", isDummy=" + isDummy + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, charisma, constitution, dexterity, duelerImage, duelerName, intelligence,
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
		DuelerRequest other = (DuelerRequest) obj;
		return accountNumber == other.accountNumber && charisma == other.charisma && constitution == other.constitution
				&& dexterity == other.dexterity && Objects.equals(duelerImage, other.duelerImage)
				&& Objects.equals(duelerName, other.duelerName) && intelligence == other.intelligence
				&& isDummy == other.isDummy && Objects.equals(skillOne, other.skillOne)
				&& Objects.equals(skillThree, other.skillThree) && Objects.equals(skillTwo, other.skillTwo)
				&& strength == other.strength && wisdom == other.wisdom;
	}



}
