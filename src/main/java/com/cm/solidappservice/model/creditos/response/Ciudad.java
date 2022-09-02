package com.cm.solidappservice.model.creditos.response;

public class Ciudad {
    
    private String idCiudad; // k_ciudad
    private String nombreCiudad; // n_ciudad   
    
	public Ciudad() {
		super();
	}

	public Ciudad(String idCiudad, String nombreCiudad) {
		super();
		this.idCiudad = idCiudad;
		this.nombreCiudad = nombreCiudad;
	}

	public String getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
    
}
