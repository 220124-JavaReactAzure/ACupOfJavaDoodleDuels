package com.revature.JavaDoodleDuels.daos;

import org.springframework.data.repository.CrudRepository;

import com.revature.JavaDoodleDuels.models.Skill;

public interface SkillDAO extends CrudRepository<Skill, String> {

}
