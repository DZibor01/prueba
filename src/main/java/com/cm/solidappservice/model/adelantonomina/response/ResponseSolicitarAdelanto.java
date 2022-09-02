package com.cm.solidappservice.model.adelantonomina.response;

public class ResponseSolicitarAdelanto {

    private String valorFinalSolicitado; // v_monto
    private String fechaSolicitud; // f_solici
    private Integer idFlujo; // v_k_flujo
    private String resultadoSolicitud; // n_resultado
    private String error; // n_error

    public ResponseSolicitarAdelanto(){}

    public ResponseSolicitarAdelanto(String valorFinalSolicitado, String fechaSolicitud, Integer idFlujo,
			String resultadoSolicitud, String error) {
		super();
		this.valorFinalSolicitado = valorFinalSolicitado;
		this.fechaSolicitud = fechaSolicitud;
		this.idFlujo = idFlujo;
		this.resultadoSolicitud = resultadoSolicitud;
		this.error = error;
	}

	public String getvalorFinalSolicitado() {
        return this.valorFinalSolicitado;
    }

    public void setvalorFinalSolicitado(String valorFinalSolicitado) {
        this.valorFinalSolicitado = valorFinalSolicitado;
    }

    public String getFechaSolicitud() {
        return this.fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Integer getIdFlujo() {
        return this.idFlujo;
    }

    public void setIdFlujo(Integer idFlujo) {
        this.idFlujo = idFlujo;
    }

    public String getResultadoSolicitud() {
        return this.resultadoSolicitud;
    }

    public void setResultadoSolicitud(String resultadoSolicitud) {
        this.resultadoSolicitud = resultadoSolicitud;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
}
