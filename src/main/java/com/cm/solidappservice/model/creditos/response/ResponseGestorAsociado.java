package com.cm.solidappservice.model.creditos.response;

public class ResponseGestorAsociado {
    
	private String idGestor; // k_idterc
    private String cedulaGestor; // cedgestor
    private String nombreGestor; // nombgestor

    public ResponseGestorAsociado(){}

    public ResponseGestorAsociado(String idGestor, String cedulaGestor, String nombreGestor) {
		super();
		this.idGestor = idGestor;
		this.cedulaGestor = cedulaGestor;
		this.nombreGestor = nombreGestor;
	}

	public String getIdGestor() {
        return this.idGestor;
    }

    public void setIdGestor(String idGestor) {
        this.idGestor = idGestor;
    }

    public String getCedulaGestor() {
        return this.cedulaGestor;
    }

    public void setCedulaGestor(String cedulaGestor) {
        this.cedulaGestor = cedulaGestor;
    }

    public String getNombreGestor() {
        return this.nombreGestor;
    }

    public void setNombreGestor(String nombreGestor) {
        this.nombreGestor = nombreGestor;
    }
}


