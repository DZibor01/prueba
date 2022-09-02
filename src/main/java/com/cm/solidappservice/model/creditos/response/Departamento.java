package com.cm.solidappservice.model.creditos.response;

import java.util.List;

public class Departamento {
   
    private String idDepartamento; // k_depart
    private String nombreDepartamento; // getN_depart
    private List<Ciudad> ciudades;
    
    
	public Departamento() {
		super();
	}
	
	public Departamento(String idDepartamento, String nombreDepartamento) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombreDepartamento = nombreDepartamento;
	}

	public Departamento(String idDepartamento, String nombreDepartamento, List<Ciudad> ciudades) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombreDepartamento = nombreDepartamento;
		this.ciudades = ciudades;
	}
	
	public String getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public List<Ciudad> getCiudades() {
		return ciudades;
	}
	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
    
    
    
}
