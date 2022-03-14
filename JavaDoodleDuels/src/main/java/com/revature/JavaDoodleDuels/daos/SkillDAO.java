package com.revature.JavaDoodleDuels.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.JavaDoodleDuels.models.Skill;

@Repository
public interface SkillDAO extends CrudRepository<Skill, String> {
	Optional<Skill> findSkillBySkillName(String skillName);
	List<Skill> findAll();
}
