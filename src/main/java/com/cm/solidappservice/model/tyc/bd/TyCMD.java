package com.cm.solidappservice.model.tyc.bd;

import java.sql.Date;

/*
**TAB_APPTERMYCOND
*/
public class TyCMD {
	
	private Integer k_termycond;
	private String n_termycond;
	private Date f_modificacion;
	private String i_estado;
	
	public Integer getK_termycond() {
		return k_termycond;
	}
	public void setK_termycond(Integer k_termycond) {
		this.k_termycond = k_termycond;
	}

	public String getN_termycond() {
		return n_termycond;
	}
	public void setN_termycond(String n_termycond) {
		this.n_termycond = n_termycond;
	}

	public Date getF_modificacion() {
		return f_modificacion;
	}
	public void setF_modificacion(Date f_modificacion) {
		this.f_modificacion = f_modificacion;
	}

	public String getI_estado() {
		return i_estado;
	}
	public void setI_estado(String i_estado) {
		this.i_estado = i_estado;
	}
}