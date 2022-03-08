package com.revature.JavaDoodleDuels.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.JavaDoodleDuels.models.Dueler;

@Repository
public interface DuelerDAO extends CrudRepository<Dueler, String> {

	Optional<Dueler> findDuelerByDuelerName(String duelerName);
	
	@Query(nativeQuery=true, value="SELECT TOP 5 * FROM dueler_info ORDER BY NEWID()")
	List<Dueler> findFiveRandomDuelers();
	
	@Query(nativeQuery=true, value="SELECT * FROM dueler_info s WHERE s.account_number = :accountNumber")
	List<Dueler> findDuelerByAccountNumber(String accountNumber);
	
	@Query(nativeQuery=true, value="SELECT TOP 1 * FROM dueler_info s WHERE s.is_dummy = 1 ORDER BY NEWID()")
	Dueler findRandomDummy();
}