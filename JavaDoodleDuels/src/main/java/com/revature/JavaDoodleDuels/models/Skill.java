package com.revature.JavaDoodleDuels.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skills")
public class Skill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6302328805745579720L;

	@Id
	@Column(name="skill_name", nullable = false)
	private String skillName; // {{Fireball}} = 6 + ( 1 * int > 12 )
	
	@Column(nullable = false)
	private int damage;  // Fireball = {{6}} + ( 1 * int > 12 )
	
	@Column(name="damage_stat_type", nullable = false)
	private String damageStatType;  // Fireball = 6 + ( 1 * {{int}} > 12 )
	
	@Column(name="scaled_damage", nullable = false)
	private int scaledDamage;  // Fireball = 6 + ( {{1}} * int > 12 )
	
	@Column(name="scaling_requirment", nullable = false)
	private int scalingRequirement;     // Fireball = 6 + ( 1 * int > {{12}} )	
	
	@Column(nullable = false)
	private String description;
	
	@Column(name="healing")
	private int healing;
	
	@Column(name="mana_cost")
	private int manaCost;

	public Skill() {
		super();
	}

	public Skill(String skillName, int damage, String damageStatType, int scaledDamage, int scalingRequirement,
			String description, int healing, int manaCost) {
		super();
		this.skillName = skillName;
		this.damage = damage;
		this.damageStatType = damageStatType;
		this.scaledDamage = scaledDamage;
		this.scalingRequirement = scalingRequirement;
		this.description = description;
		this.healing = healing;
		this.manaCost = manaCost;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getDamageStatType() {
		return damageStatType;
	}

	public void setDamageStatType(String damageStatType) {
		this.damageStatType = damageStatType;
	}

	public int getScaledDamage() {
		return scaledDamage;
	}

	public void setScaledDamage(int scaledDamage) {
		this.scaledDamage = scaledDamage;
	}

	public int getScalingRequirement() {
		return scalingRequirement;
	}

	public void setScalingRequirement(int scalingRequirement) {
		this.scalingRequirement = scalingRequirement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHealing() {
		return healing;
	}

	public void setHealing(int healing) {
		this.healing = healing;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}

	@Override
	public String toString() {
		return "Skill [skillName=" + skillName + ", damage=" + damage + ", damageStatType=" + damageStatType
				+ ", scaledDamage=" + scaledDamage + ", scalingRequirement=" + scalingRequirement + ", description="
				+ description + ", isHealing=" + healing + ", manaCost=" + manaCost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(damage, damageStatType, description, healing, manaCost, scaledDamage, scalingRequirement,
				skillName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return damage == other.damage && Objects.equals(damageStatType, other.damageStatType)
				&& Objects.equals(description, other.description) && healing == other.healing
				&& manaCost == other.manaCost && scaledDamage == other.scaledDamage
				&& scalingRequirement == other.scalingRequirement && Objects.equals(skillName, other.skillName);
	}

	
}