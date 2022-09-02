package com.cm.solidappservice.model.creditos.request;

public class ReferenciaCredito {
    
	String idReferencia; //k_referencia
	String nombreReferencia; //n_nombreape
	String telefonoCelular; //t_tercel
	String telefonoFijo; //t_telfijo
	String email; //d_email
	String direccion; //d_direc
	String nombreCiudad; //n_ciudad
	String idCiudad; //k_ciudad
	String idDepartamento; //k_depart
	String parentesco; //parentesco	
	public ReferenciaCredito() {}
	
	public ReferenciaCredito(String idReferencia, String nombreReferencia,
			String telefonoCelular, String telefonoFijo, String email, String direccion, String nombreCiudad, String idCiudad,
			String idDepartamento, String parentesco) {
		super();
		this.idReferencia = idReferencia;
		this.nombreReferencia = nombreReferencia;
		this.telefonoCelular = telefonoCelular;
		this.telefonoFijo = telefonoFijo;
		this.email = email;
		this.direccion = direccion;
		this.nombreCiudad = nombreCiudad;
		this.idCiudad = idCiudad;
		this.idDepartamento = idDepartamento;
		this.parentesco = parentesco;
	}
	
	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public String getIdReferencia() {
		return idReferencia;
	}
	public void setIdReferencia(String idReferencia) {
		this.idReferencia = idReferencia;
	}
	public String getNombreReferencia() {
		return nombreReferencia;
	}
	public void setNombreReferencia(String nombreReferencia) {
		this.nombreReferencia = nombreReferencia;
	}
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	public String getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
}
