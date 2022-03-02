package com.revature.JavaDoodleDuels.daos;

import org.springframework.data.repository.CrudRepository;

import com.revature.JavaDoodleDuels.models.Dueler;

public interface DuelerDAO extends CrudRepository<Dueler, String> {

}
