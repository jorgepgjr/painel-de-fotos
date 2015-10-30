package br.com.cea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade da tabela TWB_FT_PICTURE_PANEL;
 * 
 * @author Jorge Peres Guimaraes Jr.
 *
 */
@Entity
@Table(name = "RTL_CEA_WEEK")
public class SemanaCea {

	@Id
	@Column(name = "DT_CVL")
	private Integer ceaWeekID;
	
	@Column(name = "LASTCEAWEEKCLOSEDFLAG")
	private char lastCEAWeekClosedFlag;

	public Integer getCEAWeekID() {
		return ceaWeekID;
	}

	public void setCEAWeekID(Integer cEAWeekID) {
		ceaWeekID = cEAWeekID;
	}

	public char getLastCEAWeekClosedFlag() {
		return lastCEAWeekClosedFlag;
	}

	public void setLastCEAWeekClosedFlag(char lastCEAWeekClosedFlag) {
		this.lastCEAWeekClosedFlag = lastCEAWeekClosedFlag;
	}
	
}
