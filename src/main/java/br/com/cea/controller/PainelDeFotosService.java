package br.com.cea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cea.business.RelatorioBO;
import br.com.cea.entity.Relatorio;
import br.com.cea.repository.RelatorioRepository;
import br.com.cea.repository.SemanaCeaRepository;
import br.com.cea.vo.ProdutoVO;
import br.com.cea.vo.RelatorioVO;
import br.com.cea.vo.SemanaVO;

/**
 * Servico para testes com o controller {@link PainelDeFotosController};
 * 
 * @author Jorge Peres Guimaraes Jr.
 *
 */
@RestController
public class PainelDeFotosService {

	@Autowired
	private RelatorioRepository relatorioRepository;

	@Autowired
	private SemanaCeaRepository semanaCeaRepository;

	@Autowired
	private RelatorioBO relatorioBO;

	@RequestMapping("/r/{modeloCor}")
	public @ResponseBody RelatorioVO recuperaModelosJason2(
			@PathVariable String modeloCor) {

		LocaleContextHolder.getLocale();
		String arrayModelos[] = StringUtils
				.commaDelimitedListToStringArray(modeloCor);

		List<Relatorio> listDeRelatorio = relatorioBO
				.findOrderBySemVenda(arrayModelos);

		// Ajustes para o layout
		for (Relatorio relatorio : listDeRelatorio) {
			if (!StringUtils.isEmpty(relatorio.getListaLojas())) {
				relatorio.setListaLojas(StringUtils.replace(
						relatorio.getListaLojas(), "_", " "));
			}
		}

		return this.diviteListaEmColunasESemanas(listDeRelatorio);
	}

	public RelatorioVO diviteListaEmColunasESemanas(
			List<Relatorio> listDeRelatorio) {

		final Integer semanaAtual = semanaCeaRepository.findCeaWeekID();

		final RelatorioVO relatorioVO = new RelatorioVO();

		final SemanaVO primeiraSemana = new SemanaVO("Primeira Semana");
		
		final SemanaVO segundaSemana = new SemanaVO("Segunda Semana");
		
		final SemanaVO demaisSemanas = new SemanaVO("Demais Semanas");

		for (Relatorio relatorio : listDeRelatorio) {
			if ((semanaAtual - relatorio.getVendaPrimSemana()) == 0) {
				primeiraSemana.adicionaNovoProduto(new ProdutoVO(relatorio));
			} else if ((semanaAtual - relatorio.getVendaPrimSemana()) == 1) {
				segundaSemana.adicionaNovoProduto(new ProdutoVO(relatorio));
			} else if ((semanaAtual - relatorio.getVendaPrimSemana()) >= 2) {
				demaisSemanas.adicionaNovoProduto(new ProdutoVO(relatorio));
			}
		}
		relatorioVO.addSemana(primeiraSemana);
		relatorioVO.addSemana(segundaSemana);
		relatorioVO.addSemana(demaisSemanas);
		return relatorioVO;
	}


}