package com.cm.solidappservice.model.creditos.response;

public class ResponseParentescos {
    
    private String idParentesco; // rv_abbreviation
    private String nombreParentesco; // rv_meaning

    public ResponseParentescos() {
		super();
	}

	public ResponseParentescos(String idParentesco, String nombreParentesco) {
		super();
		this.idParentesco = idParentesco;
		this.nombreParentesco = nombreParentesco;
	}

	public String getIdParentesco() {
        return this.idParentesco;
    }

    public void setIdParentesco(String idParentesco) {
        this.idParentesco = idParentesco;
    }

    public String getNombreParentesco() {
        return this.nombreParentesco;
    }

    public void setNombreParentesco(String nombreParentesco) {
        this.nombreParentesco = nombreParentesco;
    }

}
