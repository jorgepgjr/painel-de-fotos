package br.com.cea.business;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.cea.entity.Relatorio;
import br.com.cea.repository.RelatorioRepository;
import br.com.cea.repository.SemanaCeaRepository;


/**
 * Teste da classe BO
 * @author Jorge Peres Guimaraes Jr.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RelatorioBOTest {

	@InjectMocks
	public RelatorioBO relatorioBO;

	@Mock
	public RelatorioRepository repository;
	
	@Mock
	private SemanaCeaRepository semanaCeaRepository;

	List<Relatorio> relatorioList;
	
	
	@Before
	public void criaLista(){
		relatorioList = new ArrayList<Relatorio>();		
		
		relatorioList.add(criaRelatorio(1.0, "3", 201520, 3.0));
		relatorioList.add(criaRelatorio(1.0, "4", 201520, 4.0));
		
		relatorioList.add(criaRelatorio(1.0, "6", 201520, 1.0));
		relatorioList.add(criaRelatorio(1.0, "5", 201520, 5.0));
		
		relatorioList.add(criaRelatorio(1.0, "2", 201520, 5.0));
		relatorioList.add(criaRelatorio(1.0, "1", 201520, 6.0));
	}
	
	/**
	 * Testa o sort do BO
	 */
	@Test
	public void findOrderBySemVendaTest() {		
		when(repository.findByMdlCorInOrderByVendaPrimSemanaDesc(any(String[].class))).thenReturn(relatorioList);
		when(semanaCeaRepository.findCeaWeekID()).thenReturn(201523);
		List<Relatorio> retornoList = relatorioBO.findOrderBySemVenda(new String[0]);
		Assert.assertTrue("1".equals(retornoList.get(0).getMdlCor()));
		Assert.assertTrue("6".equals(retornoList.get(5).getMdlCor()));
	}
	
	private Relatorio criaRelatorio(Double total3, String modeloCor, Integer vendaPrimSemana, Double roS3WAmt) {
		final Relatorio relatorio = new Relatorio();
		relatorio.setVendaPrimSemana(vendaPrimSemana);
		relatorio.setSellThrough3WTotal(total3);
		relatorio.setMdlCor(modeloCor);
		relatorio.setRoS3WAmt(roS3WAmt);
		return relatorio;
	}
}
