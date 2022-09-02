package com.cm.solidappservice.model.creditos.response;

public class ResponseSolicitudCredito {
    
    private String idRadicado;
    private String creditoRadicado;
    private String datosCredito;
    private String referenciasCredito;

    public ResponseSolicitudCredito() {
		super();
	}

	public ResponseSolicitudCredito(String idRadicado, String creditoRadicado, String datosCredito,
			String referenciasCredito) {
		super();
		this.idRadicado = idRadicado;
		this.creditoRadicado = creditoRadicado;
		this.datosCredito = datosCredito;
		this.referenciasCredito = referenciasCredito;
	}

	public String getIdRadicado() {
        return this.idRadicado;
    }

    public void setIdRadicado(String idRadicado) {
        this.idRadicado = idRadicado;
    }

    public String getCreditoRadicado() {
        return this.creditoRadicado;
    }

    public void setCreditoRadicado(String creditoRadicado) {
        this.creditoRadicado = creditoRadicado;
    }

    public String getDatosCredito() {
        return this.datosCredito;
    }

    public void setDatosCredito(String datosCredito) {
        this.datosCredito = datosCredito;
    }

    public String getReferenciasCredito() {
        return this.referenciasCredito;
    }

    public void setReferenciasCredito(String referenciasCredito) {
        this.referenciasCredito = referenciasCredito;
    }


}
