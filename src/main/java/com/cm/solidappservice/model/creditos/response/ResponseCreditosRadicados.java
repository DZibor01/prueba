package com.cm.solidappservice.model.creditos.response;

public class ResponseCreditosRadicados {
    
    private String idRadicado; //k_solicitud
    private String idLineaCredito; //k_linea
    private String formaEntrega; //i_formaentrega
    private String fechaSolicitud; //f_solicitud
    private Integer valorSolicitado; //v_solicitado
    
	public ResponseCreditosRadicados() {
		super();
	}

	public ResponseCreditosRadicados(String idRadicado, String idLineaCredito, String formaEntrega,
			String fechaSolicitud, Integer valorSolicitado) {
		super();
		this.idRadicado = idRadicado;
		this.idLineaCredito = idLineaCredito;
		this.formaEntrega = formaEntrega;
		this.fechaSolicitud = fechaSolicitud;
		this.valorSolicitado = valorSolicitado;
	}

	public String getIdRadicado() {
		return idRadicado;
	}

	public void setIdRadicado(String idRadicado) {
		this.idRadicado = idRadicado;
	}

	public String getIdLineaCredito() {
		return idLineaCredito;
	}

	public void setIdLineaCredito(String idLineaCredito) {
		this.idLineaCredito = idLineaCredito;
	}

	public String getFormaEntrega() {
		return formaEntrega;
	}

	public void setFormaEntrega(String formaEntrega) {
		this.formaEntrega = formaEntrega;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Integer getValorSolicitado() {
		return valorSolicitado;
	}

	public void setValorSolicitado(Integer valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}

}
