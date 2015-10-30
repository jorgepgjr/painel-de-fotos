package br.com.cea.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cea.entity.SemanaCea;

/**
 * @author Jorge Peres Guimaraes Jr.
 *
 */
@Repository
public interface SemanaCeaRepository extends CrudRepository<SemanaCea, Integer>{
	
	@Query(value = "SELECT CeaWeekID FROM RTL_CEA_WEEK WHERE lastCEAWeekClosedFlag = 'S'", nativeQuery = true)
	Integer findCeaWeekID();

}
