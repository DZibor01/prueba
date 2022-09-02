package com.cm.solidappservice.model.mensajesinbox.bd;
/**
 * Tabla TAB_APPNOTIFICA
 */
public class MensajesInboxMD{
	
	private long k_proces;
	private String i_leido;
	private String aanumnit;
	private String f_inicio;
	private String f_final;
	private String n_mensaj;
	private String n_tipo;
	private int q_orden;
	
	public MensajesInboxMD() {
	}

	public MensajesInboxMD(String aanumnit, String f_inicio, String f_final, String n_mensaj) {
		this.aanumnit = aanumnit;
		this.f_inicio = f_inicio;
		this.f_final = f_final;
		this.n_mensaj = n_mensaj;
	}

	public long getK_proces() {
		return k_proces;
	}

	public void setK_proces(long k_proces) {
		this.k_proces = k_proces;
	}

	public String getI_leido() {
		return i_leido;
	}

	public void setI_leido(String i_leido) {
		this.i_leido = i_leido;
	}

	public String getAanumnit() {
		return aanumnit;
	}

	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}

	public String getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(String f_inicio) {
		this.f_inicio = f_inicio;
	}

	public String getF_final() {
		return f_final;
	}

	public void setF_final(String f_final) {
		this.f_final = f_final;
	}

	public String getN_mensaj() {
		return n_mensaj;
	}

	public void setN_mensaj(String n_mensaj) {
		this.n_mensaj = n_mensaj;
	}

	public String getN_tipo() {
		return n_tipo;
	}

	public void setN_tipo(String n_tipo) {
		this.n_tipo = n_tipo;
	}

	public int getQ_orden() {
		return q_orden;
	}

	public void setQ_orden(int q_orden) {
		this.q_orden = q_orden;
	}

}