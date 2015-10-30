package br.com.cea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;


/**
 * Entidade da tabela TWB_FT_PICTURE_PANEL;
 * @author Jorge Peres Guimaraes Jr.
 *
 */
@Entity
@Table(name = "TWB_FT_PICTURE_PANEL")
public class Relatorio {

	@Id
	@Column(name = "MDLCOR")
	private String mdlCor;
	
	@Column(name = "ItemImgURL")
	private String itemImgURL;

	@Column(name = "PRECOORIGINALAMT")
	private Double precoOriginalAmt;

	@Column(name = "OMUPERC")
	private Double omuPerc;

	@Column(name = "FASE")
	private String fase;

	@Column(name = "LISTALOJAS")
	private String listaLojas;

	@Column(name = "LOJASCONTABILIZADAS")
	private Integer lojasContabilizadas;

	@Column(name = "INVESTIMENTO_PECAS")
	private Integer investimento_Pecas;

	@Column(name = "VENDAPRIMSEMANA")
	private Integer vendaPrimSemana;
	
	@Column(name = "VENDA1WQT")
	private Long venda1WQt;
	
	@Column(name = "SELLTHROUGH1WTOTAL")
	@NumberFormat(pattern="###.###,00")
	private Double sellThrough1WTotal;
	
	@Column(name = "VENDA2WQT")
	private Long venda2WQt;
	
	@Column(name = "SELLTHROUGH2WTOTAL")
	@NumberFormat(pattern="###.###,00")
	private Double sellThrough2WTotal;
	
	@Column(name = "VENDA3WQT")
	private Long venda3WQt;
	
	@Column(name = "SELLTHROUGH3WTOTAL")
	@NumberFormat(pattern="###.###,00")
	private Double sellThrough3WTotal;
		
	@Column(name = "VENDATOTALQT")
	private Long vendaTotalQt;
	
	@Column(name = "ROS3WQT")
	private Double roS3WQt;
	
	@Column(name = "ROS3WAMT")
	private Double roS3WAmt;

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Modelo Cor: "+ this.mdlCor);
		sb.append(" precoOriginalAmt: "+ this.precoOriginalAmt);
		sb.append(" fase: "+ this.fase);
		return super.toString();
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

	public Double getPrecoOriginalAmt() {
		return precoOriginalAmt;
	}

	public void setPrecoOriginalAmt(Double precoOriginalAmt) {
		this.precoOriginalAmt = precoOriginalAmt;
	}

	public Double getOmuPerc() {
		return omuPerc;
	}

	public void setOmuPerc(Double omuPerc) {
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

	public Double getSellThrough1WTotal() {
		return sellThrough1WTotal;
	}

	public void setSellThrough1WTotal(Double sellThrough1WTotal) {
		this.sellThrough1WTotal = sellThrough1WTotal;
	}

	public Long getVenda2WQt() {
		return venda2WQt;
	}

	public void setVenda2WQt(Long venda2wQt) {
		venda2WQt = venda2wQt;
	}

	public Double getSellThrough2WTotal() {
		return sellThrough2WTotal;
	}

	public void setSellThrough2WTotal(Double sellThrough2WTotal) {
		this.sellThrough2WTotal = sellThrough2WTotal;
	}

	public Long getVenda3WQt() {
		return venda3WQt;
	}

	public void setVenda3WQt(Long venda3wQt) {
		venda3WQt = venda3wQt;
	}

	public Double getSellThrough3WTotal() {
		return sellThrough3WTotal;
	}

	public void setSellThrough3WTotal(Double sellThrough3WTotal) {
		this.sellThrough3WTotal = sellThrough3WTotal;
	}

	public Long getVendaTotalQt() {
		return vendaTotalQt;
	}

	public void setVendaTotalQt(Long vendaTotalQt) {
		this.vendaTotalQt = vendaTotalQt;
	}

	public Double getRoS3WQt() {
		return roS3WQt;
	}

	public void setRoS3WQt(Double roS3WQt) {
		this.roS3WQt = roS3WQt;
	}

	public Double getRoS3WAmt() {
		return roS3WAmt;
	}

	public void setRoS3WAmt(Double roS3WAmt) {
		this.roS3WAmt = roS3WAmt;
	}

	}
