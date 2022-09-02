package com.cm.solidappservice.model.adelantonomina.response;

public class ResponseEstadoAdelantoDeprecated {
	
	private String k_parame;
	private String v_alfabe;

	public ResponseEstadoAdelantoDeprecated() {
	}

	public ResponseEstadoAdelantoDeprecated(String k_parame, String v_alfabe) {
		this.k_parame = k_parame;
		this.v_alfabe = v_alfabe;
	}

	public String getK_parame() {
		return k_parame;
	}

	public void setK_parame(String k_parame) {
		this.k_parame = k_parame;
	}

	public String getV_alfabe() {
		return v_alfabe;
	}

	public void setV_alfabe(String v_alfabe) {
		this.v_alfabe = v_alfabe;
	}
}