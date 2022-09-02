package com.cm.solidappservice.model.centrosvacacionales.response;

import java.util.List;

public class ResponseCentroVacacional{
	private String codigo;
	private String nombre;
	private String direccion;
	private List<ResponsePerfilCentroVacacional> perfiles;
	
	public ResponseCentroVacacional(
			String _codigo,
			String _nombre,
			String _direccion){
		setCodigo(_codigo);
		setNombre(_nombre);
		setDireccion(_direccion);
	}
	
	public ResponseCentroVacacional(){}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<ResponsePerfilCentroVacacional> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<ResponsePerfilCentroVacacional> perfiles) {
		this.perfiles = perfiles;
	}
}