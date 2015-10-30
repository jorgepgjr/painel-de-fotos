package br.com.cea.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * VO de cada semana, com nome e uma matriz de {@link ProdutoVO}
 * @author Jorge Peres Guimaraes Jr.
 *
 */
public class SemanaVO {
	
	private String nomeSemana;
	private List<List<ProdutoVO>> semana = new ArrayList<List<ProdutoVO>>();
	
	public SemanaVO(String nomeSemana) {
		super();
		this.nomeSemana = nomeSemana;
		this.semana.add(new ArrayList<ProdutoVO>());
	}

	/**
	 * Methodo que auxilia a criacao de itens nas semanas, garantindo que cada a lista so teremos no maximo 3 itens por lista;
	 * Criando assim uma matriz de produtos
	 * Exemplo:
	 * { 1 , 2 , 3}
	 * { 4 , 5 , 6}
	 * @param produtoVO
	 */
	public void adicionaNovoProduto(ProdutoVO produtoVO){
		
		if(semana.get(semana.size() -1) == null){
			semana.set(semana.size() -1, new ArrayList<ProdutoVO>());
		}
		
		if (semana.get(semana.size() -1).size() >= 3){
			semana.add(new ArrayList<ProdutoVO>());
		}
		semana.get(semana.size() -1).add(produtoVO);

	}

	public String getNomeSemana() {
		return nomeSemana;
	}
	public void setNomeSemana(String nomeSemana) {
		this.nomeSemana = nomeSemana;
	}

	public List<List<ProdutoVO>> getSemana() {
		return semana;
	}

	public void setSemana(List<List<ProdutoVO>> semana) {
		this.semana = semana;
	}
		
}