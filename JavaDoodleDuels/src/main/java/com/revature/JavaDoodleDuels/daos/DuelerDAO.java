package com.revature.JavaDoodleDuels.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.JavaDoodleDuels.models.Dueler;

@Repository
public interface DuelerDAO extends CrudRepository<Dueler, String> {

}
