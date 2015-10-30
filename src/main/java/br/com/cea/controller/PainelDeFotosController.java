package br.com.cea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cea.business.RelatorioBO;
import br.com.cea.entity.Relatorio;
import br.com.cea.repository.RelatorioRepository;
import br.com.cea.repository.SemanaCeaRepository;
import br.com.cea.vo.ProdutoVO;
import br.com.cea.vo.RelatorioVO;
import br.com.cea.vo.SemanaVO;

/**
 * Controller principal da tela do painel de fotos
 * 
 * @author Jorge Peres Guimaraes Jr.
 *
 */
@Controller
public class PainelDeFotosController {

	@Autowired
	private RelatorioRepository relatorioRepository;

	@Autowired
	private SemanaCeaRepository semanaCeaRepository;

	@Autowired
	private RelatorioBO relatorioBO;

	/**
	 * Controller principal do projeto. Recebe uma lista de modeloCor na URL,
	 * separada por virgulas e busca no banco as informacoes para printar na
	 * tela; Exemplo:
	 * http://localhost:8080/business-transformation-report/8066942
	 * %20-%20JEANS_BCK,8071443%20-%20OFF_WHITE,8148404%20-%20JEANS_ESC
	 * 
	 * @param modeloCor
	 *            seperados por virgula
	 * @param model
	 * @return
	 */
	@RequestMapping("/{modeloCor}")
	public ModelAndView recuperaModelosMobile(@PathVariable String modeloCor,
			ModelAndView model) {
		
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

		RelatorioVO relatorio = diviteListaEmColunasESemanas(listDeRelatorio);

		model.addObject("relatorios", relatorio);
		model.setViewName("homeResponsive");
		return model;
	}

	/**
	 * Divide a lista em um layout para caber 3 itens por linha e separa por 3 semanas CEA;
	 * Primeira Semana, Segunda Semana, e Demais Semanas
	 * 
	 * @param listDeRelatorio
	 * @return
	 */
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