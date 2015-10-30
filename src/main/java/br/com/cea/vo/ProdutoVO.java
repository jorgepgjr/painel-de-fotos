package br.com.cea.vo;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

import br.com.cea.entity.Relatorio;



/**
 * VO para a tela contendo as formatações dos campos 
 * @author Jorge Peres Guimaraes Jr.
 *
 */
public class ProdutoVO {

	private String mdlCor;
	
	private String itemImgURL;

	private String precoOriginalAmt;

	private String omuPerc;

	private String fase;

	private String listaLojas;

	private Integer lojasContabilizadas;

	private Integer investimento_Pecas;

	private Integer vendaPrimSemana;
	
	private Long venda1WQt;
	
	private String sellThrough1WTotal;
	
	private Long venda2WQt;
	
	private String sellThrough2WTotal;
	
	private Long venda3WQt;
	
	private String sellThrough3WTotal;
		
	private Long vendaTotalQt;
	
	private String roS3WQt;
	
	private String roS3WAmt;
	
	

	/**
	 * Recebe a entidade {@link Relatorio} e constroi o VO com os campos formatados
	 * @param relatorio
	 */
	public ProdutoVO(Relatorio relatorio) {
		super();		
		DecimalFormat numberFormat = new DecimalFormat("###0.00");
		numberFormat.setCurrency(Currency.getInstance(new Locale("pt","BR")));

		this.mdlCor = relatorio.getMdlCor();
		this.itemImgURL = relatorio.getItemImgURL();
		this.precoOriginalAmt = numberFormat.format(relatorio.getPrecoOriginalAmt());
		this.omuPerc = numberFormat.format(relatorio.getOmuPerc());
		this.fase = relatorio.getFase();
		this.listaLojas = relatorio.getListaLojas();
		this.lojasContabilizadas = relatorio.getLojasContabilizadas();
		this.investimento_Pecas = relatorio.getInvestimento_Pecas();
		this.vendaPrimSemana = relatorio.getVendaPrimSemana();
		this.venda1WQt = relatorio.getVenda1WQt();
		this.sellThrough1WTotal = numberFormat.format(relatorio.getSellThrough1WTotal());
		this.venda2WQt = relatorio.getVenda2WQt();
		this.sellThrough2WTotal = numberFormat.format(relatorio.getSellThrough2WTotal());
		this.venda3WQt = relatorio.getVenda3WQt();
		this.sellThrough3WTotal = numberFormat.format(relatorio.getSellThrough3WTotal());
		this.vendaTotalQt = relatorio.getVendaTotalQt();
		this.roS3WQt = numberFormat.format(relatorio.getRoS3WQt());
		this.roS3WAmt = numberFormat.format(relatorio.getRoS3WAmt());
	}

	public String getMdlCor() {
		return mdlCor;
	}

	public void setMdlCor(String mdlCor) {
		this.mdlCor = mdlCor;
	}

	public String getItemImgURL() {
		return itemImgURL;
	}

	public void setItemImgURL(String itemImgURL) {
		this.itemImgURL = itemImgURL;
	}

	public String getPrecoOriginalAmt() {
		return precoOriginalAmt;
	}

	public void setPrecoOriginalAmt(String precoOriginalAmt) {
		this.precoOriginalAmt = precoOriginalAmt;
	}

	public String getOmuPerc() {
		return omuPerc;
	}

	public void setOmuPerc(String omuPerc) {
		this.omuPerc = omuPerc;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public String getListaLojas() {
		return listaLojas;
	}

	public void setListaLojas(String listaLojas) {
		this.listaLojas = listaLojas;
	}

	public Integer getLojasContabilizadas() {
		return lojasContabilizadas;
	}

	public void setLojasContabilizadas(Integer lojasContabilizadas) {
		this.lojasContabilizadas = lojasContabilizadas;
	}

	public Integer getInvestimento_Pecas() {
		return investimento_Pecas;
	}

	public void setInvestimento_Pecas(Integer investimento_Pecas) {
		this.investimento_Pecas = investimento_Pecas;
	}

	public Integer getVendaPrimSemana() {
		return vendaPrimSemana;
	}

	public void setVendaPrimSemana(Integer vendaPrimSemana) {
		this.vendaPrimSemana = vendaPrimSemana;
	}

	public Long getVenda1WQt() {
		return venda1WQt;
	}

	public void setVenda1WQt(Long venda1wQt) {
		venda1WQt = venda1wQt;
	}

	public String getSellThrough1WTotal() {
		return sellThrough1WTotal;
	}

	public void setSellThrough1WTotal(String sellThrough1WTotal) {
		this.sellThrough1WTotal = sellThrough1WTotal;
	}

	public Long getVenda2WQt() {
		return venda2WQt;
	}

	public void setVenda2WQt(Long venda2wQt) {
		venda2WQt = venda2wQt;
	}

	public String getSellThrough2WTotal() {
		return sellThrough2WTotal;
	}

	public void setSellThrough2WTotal(String sellThrough2WTotal) {
		this.sellThrough2WTotal = sellThrough2WTotal;
	}

	public Long getVenda3WQt() {
		return venda3WQt;
	}

	public void setVenda3WQt(Long venda3wQt) {
		venda3WQt = venda3wQt;
	}

	public String getSellThrough3WTotal() {
		return sellThrough3WTotal;
	}

	public void setSellThrough3WTotal(String sellThrough3WTotal) {
		this.sellThrough3WTotal = sellThrough3WTotal;
	}

	public Long getVendaTotalQt() {
		return vendaTotalQt;
	}

	public void setVendaTotalQt(Long vendaTotalQt) {
		this.vendaTotalQt = vendaTotalQt;
	}

	public String getRoS3WQt() {
		return roS3WQt;
	}

	public void setRoS3WQt(String roS3WQt) {
		this.roS3WQt = roS3WQt;
	}

	public String getRoS3WAmt() {
		return roS3WAmt;
	}

	public void setRoS3WAmt(String roS3WAmt) {
		this.roS3WAmt = roS3WAmt;
	}
}
	
