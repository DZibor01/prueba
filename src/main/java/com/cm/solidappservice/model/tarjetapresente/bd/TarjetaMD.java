package com.cm.solidappservice.model.tarjetapresente.bd;

import java.util.Date;

/*
* LINIX VISTA VIEW_APP_TJ
*/
public class TarjetaMD{
	private String aanumnit;
	private String i_estado; //( A-ACTIVO, I-INACTIVO, B-BLOQUEADO, BC-CUPO BLOQUEADO )
	private String k_numpla; //Número Bolsillo
	private String k_mnumpl; //Número tarjeta
	private String n_percol; //Nombre producto-tarjeta
	private String a_numcta; //Cuenta de ahorros
	private String a_tipodr; //Tipo de obligación
	private String a_obliga; //Número de obligación
	private Date f_movim; //Fecha de actualizacion
	private double v_cupo;
	
	public String getAanumnit() {
		return aanumnit;
	}
	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}
	public String getI_estado() {
		return i_estado;
	}
	public void setI_estado(String i_estado) {
		this.i_estado = i_estado;
	}
	public String getK_numpla() {
		return k_numpla;
	}
	public void setK_numpla(String k_numpla) {
		this.k_numpla = k_numpla;
	}
	public String getN_percol() {
		return n_percol;
	}
	public void setN_percol(String n_percol) {
		this.n_percol = n_percol;
	}
	public String getA_numcta() {
		return a_numcta;
	}
	public void setA_numcta(String a_numcta) {
		this.a_numcta = a_numcta;
	}
	public String getA_tipodr() {
		return a_tipodr;
	}
	public void setA_tipodr(String a_tipodr) {
		this.a_tipodr = a_tipodr;
	}
	public String getA_obliga() {
		return a_obliga;
	}
	public void setA_obliga(String a_obliga) {
		this.a_obliga = a_obliga;
	}
	public Date getF_movim() {
		return f_movim;
	}
	public void setF_movim(Date f_movim) {
		this.f_movim = f_movim;
	}
	public double getV_cupo() {
		return v_cupo;
	}
	public void setV_cupo(double v_cupo) {
		this.v_cupo = v_cupo;
	}
	public String getK_mnumpl() {
		return k_mnumpl;
	}
	public void setK_mnumpl(String k_mnumpl) {
		this.k_mnumpl = k_mnumpl;
	}
}