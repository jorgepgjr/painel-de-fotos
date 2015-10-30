package br.com.cea.business;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cea.entity.Relatorio;
import br.com.cea.repository.RelatorioRepository;
import br.com.cea.repository.SemanaCeaRepository;

@Component
public class RelatorioBO {

	@Autowired
	private RelatorioRepository relatorioRepository;
	
	@Autowired
	private SemanaCeaRepository semanaCeaRepository;

	/**
	 * Recupera na base todos os relatorios por modeloCor e ordena pelos
	 * seguintes criterios: <li>Por semanas de venda</li> <li>Do maior para o
	 * menor Sell Through (Acum.)</li>
	 * 
	 * @param arrayModelos
	 * @return
	 */
	public List<Relatorio> findOrderBySemVenda(String[] arrayModelos) {

		List<Relatorio> relatorios = relatorioRepository
				.findByMdlCorInOrderByVendaPrimSemanaDesc(arrayModelos);

		
		final Integer semanaAtual = semanaCeaRepository.findCeaWeekID();

		//TODO: Ajustar esse sort para contemplar tambem a mudanca de ano comercial
		Collections.sort(relatorios, new Comparator<Relatorio>() {

			@Override
			public int compare(Relatorio o1, Relatorio o2) {

				int semanaDoProdutoO1 = (semanaAtual - o1.getVendaPrimSemana()) + 1;
				int semanaDoProdutoO2 = (semanaAtual - o2.getVendaPrimSemana()) + 1;

				// Se os dois prodtuos estao na terceira "ou mais" semanas de
				// venda
				if (semanaDoProdutoO1 >= 3 && semanaDoProdutoO2 >= 3) {
					return (o1.getRoS3WAmt() < o2.getRoS3WAmt() ? 1 : (o1
							.getRoS3WAmt() == o2.getRoS3WAmt() ? 0 : -1));
					// Se os dois produtos estão na mesma semana de vendas
				} else if (semanaDoProdutoO1 == semanaDoProdutoO2) {
					return (o1.getSellThrough3WTotal() < o2
							.getSellThrough3WTotal() ? 1 : (o1
							.getSellThrough3WTotal() == o2
							.getSellThrough3WTotal() ? 0 : -1));
				} else {
					// Se os produtos estao em semanas diferentes
					return (semanaDoProdutoO1 < semanaDoProdutoO2 ? -1
							: (semanaDoProdutoO1 == semanaDoProdutoO2 ? 0 : 1));
				}

			}
		});

		return relatorios;
	}
}
