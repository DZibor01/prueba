package com.cm.solidappservice.model.creditos.response;

import java.util.List;

public class Pais {

	 private String idPais; //k_pais
	 private String nombrePais; //n_pais
	 private List<Departamento> departamentos;
	 
	public Pais() {
		super();
	}

	public Pais(String idPais, String nombrePais) {
		super();
		this.idPais = idPais;
		this.nombrePais = nombrePais;
	}

	public Pais(String idPais, String nombrePais, List<Departamento> departamentos) {
		super();
		this.idPais = idPais;
		this.nombrePais = nombrePais;
		this.departamentos = departamentos;
	}
	
	public String getIdPais() {
		return idPais;
	}
	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	 
	 
}
