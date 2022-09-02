package com.cm.solidappservice.model.estadocuenta.bd;

import java.util.Date;

/**
 * TABLA TAB_APPMVTO *
 */
public class MovimientoMD {

	private String a_tipodr;
	private String a_numdoc;
	private Date f_movimi;
	private String k_numdoc;
	private String n_tipdoc;
	private long v_valor;
	private String aanumnit;

	//Variables para ejecucion de paquetes de movimientos por cuenta
	private String v_aanumnit; // Cédula del cliente variable para ejecutar paquetes
	private Integer k_tipcuent;
	private String v_tipodr;
	private String v_numdoc;

		
	public MovimientoMD() {}

	public MovimientoMD(String v_aanumnit, Integer k_tipcuent, String v_tipodr, String v_numdoc) {
		super();
		this.v_aanumnit = v_aanumnit;
		this.aanumnit = v_aanumnit;
		this.k_tipcuent = k_tipcuent;
		this.v_tipodr = v_tipodr;
		this.a_tipodr = v_tipodr;
		this.v_numdoc = v_numdoc;
		this.a_numdoc = v_numdoc;
	}

	public String getA_tipodr() {
		return this.a_tipodr;
	}

	public void setA_tipodr(String a_tipodr) {
		this.a_tipodr = a_tipodr;
	}

	public String getA_numdoc() {
		return this.a_numdoc;
	}

	public void setA_numdoc(String a_numdoc) {
		this.a_numdoc = a_numdoc;
	}

	public Date getF_movimi() {
		return this.f_movimi;
	}

	public void setF_movimi(Date f_movimi) {
		this.f_movimi = f_movimi;
	}

	public String getK_numdoc() {
		return this.k_numdoc;
	}

	public void setK_numdoc(String k_numdoc) {
		this.k_numdoc = k_numdoc;
	}

	public String getN_tipdoc() {
		return this.n_tipdoc;
	}

	public void setN_tipdoc(String n_tipdoc) {
		this.n_tipdoc = n_tipdoc;
	}

	public long getV_valor() {
		return this.v_valor;
	}

	public void setV_valor(long v_valor) {
		this.v_valor = v_valor;
	}

	public String getAanumnit() {
		return this.aanumnit;
	}

	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}

	
	public String getV_aanumnit() {
		return this.v_aanumnit;
	}

	public void setV_aanumnit(String v_aanumnit) {
		this.v_aanumnit = v_aanumnit;
	}

	public Integer getK_tipcuent() {
		return this.k_tipcuent;
	}

	public void setK_tipcuent(Integer k_tipcuent) {
		this.k_tipcuent = k_tipcuent;
	}

	public String getV_tipodr() {
		return this.v_tipodr;
	}

	public void setV_tipodr(String v_tipodr) {
		this.v_tipodr = v_tipodr;
	}

	public String getV_numdoc() {
		return this.v_numdoc;
	}

	public void setV_numdoc(String v_numdoc) {
		this.v_numdoc = v_numdoc;
	}
	
}
