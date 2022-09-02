package com.cm.solidappservice.model.diverseinfo.bd;

/**
 * REPLYMESSAGES
 * TAB_APPMENSAJESRESP
 */
public class ReplyMessagesMD {
	
	private Integer k_mensajeresp; 
	private String n_tipomensaje;
	private String n_mensajeresp;
	
	public ReplyMessagesMD() {
	}

	public ReplyMessagesMD(Integer k_mensajeresp, String n_tipomensaje, String n_mensajeresp) {
		this.k_mensajeresp = k_mensajeresp;
		this.n_tipomensaje = n_tipomensaje;
		this.n_mensajeresp = n_mensajeresp;
	}

	public Integer getK_mensajeresp() {
		return k_mensajeresp;
	}

	public void setK_mensajeresp(Integer k_mensajeresp) {
		this.k_mensajeresp = k_mensajeresp;
	}

	public String getN_tipomensaje() {
		return n_tipomensaje;
	}

	public void setN_tipomensaje(String n_tipomensaje) {
		this.n_tipomensaje = n_tipomensaje;
	}

	public String getN_mensajeresp() {
		return n_mensajeresp;
	}

	public void setN_mensajeresp(String n_mensajeresp) {
		this.n_mensajeresp = n_mensajeresp;
	}
	
}
