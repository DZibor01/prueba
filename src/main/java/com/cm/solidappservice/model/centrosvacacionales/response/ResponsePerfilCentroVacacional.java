package com.cm.solidappservice.model.centrosvacacionales.response;

public class ResponsePerfilCentroVacacional {
	private String codigo;
	private String nombre;

	public ResponsePerfilCentroVacacional(String _codigo, String _nombre){
		this.codigo = _codigo;
		this.nombre = _nombre;
	}
	
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
}