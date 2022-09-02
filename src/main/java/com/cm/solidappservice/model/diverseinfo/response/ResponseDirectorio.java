package com.cm.solidappservice.model.diverseinfo.response;

public class ResponseDirectorio {

	private String nombreContacto;//n_nombre
	private String telefonoContacto; //n_telefono
	private String telefonoUsuario; //n_teleusu
	private int ordn; //i_orden
	
	public ResponseDirectorio() {
	}

	public ResponseDirectorio(String nombreContacto, String telefonoContacto, String telefonoUsuario, int ordn) {
		this.nombreContacto = nombreContacto;
		this.telefonoContacto = telefonoContacto;
		this.telefonoUsuario = telefonoUsuario;
		this.ordn = ordn;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public int getOrdn() {
		return ordn;
	}

	public void setOrdn(int ordn) {
		this.ordn = ordn;
	}

	
	
	
}
