package com.cm.solidappservice.model.creditos.response;

public class ResponseCreditosRadicadosDeprecated{

	private String k_solicitud;
	private String k_linea;
	private Integer v_solicitado;
	private String f_solicitud;
	private String i_formaentrega;

	public ResponseCreditosRadicadosDeprecated() {}

	public ResponseCreditosRadicadosDeprecated(String k_solicitud, String k_linea, Integer v_solicitado, String f_solicitud,
			String i_formaentrega) {
		this.k_solicitud = k_solicitud;
		this.k_linea = k_linea;
		this.v_solicitado = v_solicitado;
		this.f_solicitud = f_solicitud;
		this.i_formaentrega = i_formaentrega;
	}

	public String getK_solicitud() {
		return k_solicitud;
	}

	public void setK_solicitud(String k_solicitud) {
		this.k_solicitud = k_solicitud;
	}

	public String getK_linea() {
		return k_linea;
	}

	public void setK_linea(String k_linea) {
		this.k_linea = k_linea;
	}

	public Integer getV_solicitado() {
		return v_solicitado;
	}

	public void setV_solicitado(Integer v_solicitado) {
		this.v_solicitado = v_solicitado;
	}

	public String getF_solicitud() {
		return f_solicitud;
	}

	public void setF_solicitud(String f_solicitud) {
		this.f_solicitud = f_solicitud;
	}

	public String getI_formaentrega() {
		return i_formaentrega;
	}

	public void setI_formaentrega(String i_formaentrega) {
		this.i_formaentrega = i_formaentrega;
	}

	
	
}
