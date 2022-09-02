package com.cm.solidappservice.model.diverseinfo.bd;

/**
 * TAB_APPMENSAJES
 */
public class MensajesBannerMD {

	private int k_idmens; // 10
	private String n_mensaje; // 250

	public MensajesBannerMD() {
	}

	public MensajesBannerMD(int k_idmens, String n_mensaje) {
		super();
		this.k_idmens = k_idmens;
		this.n_mensaje = n_mensaje;
	}

	public int getK_idmens() {
		return k_idmens;
	}

	public String getN_mensaje() {
		return n_mensaje;
	}

	public void setK_idmens(int k_idmens) {
		this.k_idmens = k_idmens;
	}

	public void setN_mensaje(String n_mensaje) {
		this.n_mensaje = n_mensaje;
	}

}
