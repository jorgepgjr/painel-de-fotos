package br.com.cea.business.repository;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.cea.AppConfig;
import br.com.cea.entity.Relatorio;
import br.com.cea.repository.RelatorioRepository;


/**
 * Teste da classe {@linkplain RelatorioRepository}
 * @author Jorge Peres Guimaraes Jr.
 *
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class RelatorioRepositoryTest {

	
	@Autowired
	public RelatorioRepository repository;
	
	/**
	 * 
	 * Testa o sort do DAO
	 */
	@Test
	@Ignore
	public void findOrderBySemVendaTest() {
		String[] modeloCor = {"8066942 - JEANS_BCK" ,"8071443 - OFF_WHITE","8148404 - JEANS_ESC","7927374 - JEANS-MD","8099584 - PRETO"};
		List<Relatorio> a = repository.findByMdlCorInOrderByVendaPrimSemanaDesc(modeloCor);
		for (Relatorio relatorio : a) {
			System.out.println(relatorio.getMdlCor() + "   "+ relatorio.getVendaPrimSemana()); 
		}
		
	}
}
