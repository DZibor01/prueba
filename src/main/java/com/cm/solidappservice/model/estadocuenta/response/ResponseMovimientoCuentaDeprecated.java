package com.cm.solidappservice.model.estadocuenta.response;

import java.util.Date;

public class ResponseMovimientoCuentaDeprecated {

	private String a_tipodr;
	private String a_numdoc;
	private Date f_movimi;
	private String k_numdoc;
	private String n_tipdoc;
	private long v_valor;
	private String aanumnit;
	
	public ResponseMovimientoCuentaDeprecated() {}
	
	public ResponseMovimientoCuentaDeprecated(String a_tipodr, String a_numdoc, Date f_movimi,
			String k_numdoc, String n_tipdoc, long v_valor) {
		super();
		this.a_tipodr = a_tipodr;
		this.a_numdoc = a_numdoc;
		this.f_movimi = f_movimi;
		this.k_numdoc = k_numdoc;
		this.n_tipdoc = n_tipdoc;
		this.v_valor = v_valor;
	}
	
	public String getA_tipodr() {
		return a_tipodr;
	}
	public String getA_numdoc() {
		return a_numdoc;
	}
	public Date getF_movimi() {
		return f_movimi;
	}
	public String getK_numdoc() {
		return k_numdoc;
	}
	public String getN_tipdoc() {
		return n_tipdoc;
	}
	public long getV_valor() {
		return v_valor;
	}
	public void setA_tipodr(String a_tipodr) {
		this.a_tipodr = a_tipodr;
	}
	public void setA_numdoc(String a_numdoc) {
		this.a_numdoc = a_numdoc;
	}
	public void setF_movimi(Date f_movimi) {
		this.f_movimi = f_movimi;
	}
	public void setK_numdoc(String k_numdoc) {
		this.k_numdoc = k_numdoc;
	}
	public void setN_tipdoc(String n_tipdoc) {
		this.n_tipdoc = n_tipdoc;
	}
	public void setV_valor(long v_valor) {
		this.v_valor = v_valor;
	}

	public String getAanumnit() {
		return aanumnit;
	}

	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}
	
	
}
