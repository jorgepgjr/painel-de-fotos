package br.com.cea.business.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.cea.AppConfig;
import br.com.cea.repository.SemanaCeaRepository;


/**
 * Teste da classe Repository da SemanaCea
 * @author Jorge Peres Guimaraes Jr.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={AppConfig.class})
@WebAppConfiguration
public class SemanaCeaRepositoryTest {

	
	@Autowired
	public SemanaCeaRepository repository;
	
	/**
	 * 
	 * Testa o sort do DAO
	 */
	@Test
	public void findOrderBySemVendaTest() {
		 Integer a = repository.findCeaWeekID();
		System.out.println(a);
	}
}
