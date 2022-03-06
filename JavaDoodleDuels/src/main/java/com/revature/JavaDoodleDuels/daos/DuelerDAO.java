package com.revature.JavaDoodleDuels.daos;

import java.util.List;
import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.JavaDoodleDuels.models.Dueler;

@Repository
public interface DuelerDAO extends CrudRepository<Dueler, String> {

	Optional<Dueler> findDuelerByDuelerName(String duelerName);

}
