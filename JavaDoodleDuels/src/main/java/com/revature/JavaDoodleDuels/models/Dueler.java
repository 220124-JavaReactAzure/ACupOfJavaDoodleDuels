package com.revature.JavaDoodleDuels.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dueler_info")
public class Dueler implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6483224865362138449L;

	@Id
	@Column(name="dueler_name")
	private String duelerName;
	
	@Column(name="account_number")
	private String accountNumber;   // used to get called by user
	
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
	
	@Column(name="max_health")
	private int maxHealth;
	
	@Column(name="max_mana")
	private int maxMana;
	
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
	
	public Dueler(String duelerName, String accountNumber, String duelerImage, int strength, int dexterity,
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
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
		return "Dueler [duelerName=" + duelerName + ", accountNumber=" + accountNumber + ", duelerImage=" + duelerImage
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
		Dueler other = (Dueler) obj;
		return accountNumber == other.accountNumber && charisma == other.charisma && constitution == other.constitution
				&& dexterity == other.dexterity && Objects.equals(duelerImage, other.duelerImage)
				&& Objects.equals(duelerName, other.duelerName) && intelligence == other.intelligence
				&& isDummy == other.isDummy && Objects.equals(skillOne, other.skillOne)
				&& Objects.equals(skillThree, other.skillThree) && Objects.equals(skillTwo, other.skillTwo)
				&& strength == other.strength && wisdom == other.wisdom;
	}

	
}
