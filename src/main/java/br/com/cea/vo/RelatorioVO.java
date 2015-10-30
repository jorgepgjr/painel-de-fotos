package br.com.cea.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * VO para a tela contendo produtos separados por semana
 * @author Jorge Peres Guimaraes Jr.
 *
 */
public class RelatorioVO {
	
	private List<SemanaVO> semanasVO = new ArrayList<SemanaVO>();
	
	public void addSemana(SemanaVO semanaVO){
		semanasVO.add(semanaVO);
	}

	public List<SemanaVO> getSemanasVO() {
		return semanasVO;
	}

	public void setSemanasVO(List<SemanaVO> semanasVO) {
		this.semanasVO = semanasVO;
	}

	
}