package br.com.cea.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cea.entity.Relatorio;

/**
 * Repositorio (DAO) de acesso a entidade de {@link Relatorio}
 * @author Jorge Peres Guimaraes Jr.
 *
 */
@Repository
public interface RelatorioRepository extends CrudRepository<Relatorio, String>{
	
	List<Relatorio> findByMdlCorInOrderByVendaPrimSemanaDesc(String[] mdlCor);

}
