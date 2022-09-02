package com.cm.solidappservice.model.transferencias.bd;

import java.util.Date;

/**
 * TAB_APPSOLITRASL
 */
public class TransferenciaMD {

	private String id_dispositivo;
	private String aanumnit_o;      
	private String a_numdoc;        
	private double v_valor;         
	private long k_idterc;        
	private long k_idterc_tit;    
	private String n_numcta;        
	private Date f_solici;
	private String k_ano_mov;
	private String k_sucurs_mov;
	private String k_tipdoc_mov;
	private String k_numdoc_mov;
	private String n_observ;
	
	public TransferenciaMD() {
	}

	public TransferenciaMD(String id_dispositivo, String aanumnit_o, String a_numdoc, double v_valor, long k_idterc,
			long k_idterc_tit, String n_numcta, Date f_solici, String k_ano_mov, String k_sucurs_mov,
			String k_tipdoc_mov, String k_numdoc_mov, String n_observ) {
		this.id_dispositivo = id_dispositivo;
		this.aanumnit_o = aanumnit_o;
		this.a_numdoc = a_numdoc;
		this.v_valor = v_valor;
		this.k_idterc = k_idterc;
		this.k_idterc_tit = k_idterc_tit;
		this.n_numcta = n_numcta;
		this.f_solici = f_solici;
		this.k_ano_mov = k_ano_mov;
		this.k_sucurs_mov = k_sucurs_mov;
		this.k_tipdoc_mov = k_tipdoc_mov;
		this.k_numdoc_mov = k_numdoc_mov;
		this.n_observ = n_observ;
	}

	public String getId_dispositivo() {
		return id_dispositivo;
	}

	public void setId_dispositivo(String id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}

	public String getAanumnit_o() {
		return aanumnit_o;
	}

	public void setAanumnit_o(String aanumnit_o) {
		this.aanumnit_o = aanumnit_o;
	}

	public String getA_numdoc() {
		return a_numdoc;
	}

	public void setA_numdoc(String a_numdoc) {
		this.a_numdoc = a_numdoc;
	}

	public double getV_valor() {
		return v_valor;
	}

	public void setV_valor(double v_valor) {
		this.v_valor = v_valor;
	}

	public long getK_idterc() {
		return k_idterc;
	}

	public void setK_idterc(long k_idterc) {
		this.k_idterc = k_idterc;
	}

	public long getK_idterc_tit() {
		return k_idterc_tit;
	}

	public void setK_idterc_tit(long k_idterc_tit) {
		this.k_idterc_tit = k_idterc_tit;
	}

	public String getN_numcta() {
		return n_numcta;
	}

	public void setN_numcta(String n_numcta) {
		this.n_numcta = n_numcta;
	}

	public Date getF_solici() {
		return f_solici;
	}

	public void setF_solici(Date f_solici) {
		this.f_solici = f_solici;
	}

	public String getK_ano_mov() {
		return k_ano_mov;
	}

	public void setK_ano_mov(String k_ano_mov) {
		this.k_ano_mov = k_ano_mov;
	}

	public String getK_sucurs_mov() {
		return k_sucurs_mov;
	}

	public void setK_sucurs_mov(String k_sucurs_mov) {
		this.k_sucurs_mov = k_sucurs_mov;
	}

	public String getK_tipdoc_mov() {
		return k_tipdoc_mov;
	}

	public void setK_tipdoc_mov(String k_tipdoc_mov) {
		this.k_tipdoc_mov = k_tipdoc_mov;
	}

	public String getK_numdoc_mov() {
		return k_numdoc_mov;
	}

	public void setK_numdoc_mov(String k_numdoc_mov) {
		this.k_numdoc_mov = k_numdoc_mov;
	}

	public String getN_observ() {
		return n_observ;
	}

	public void setN_observ(String n_observ) {
		this.n_observ = n_observ;
	}

	

}
