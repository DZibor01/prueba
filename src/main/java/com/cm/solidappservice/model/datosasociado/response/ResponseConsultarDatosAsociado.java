package com.cm.solidappservice.model.datosasociado.response;

public class ResponseConsultarDatosAsociado {
    
    private String cedula; // anumnit
    private String nombreCompleto; // nombre1
    private String direccion; // direccion
    private String celular; // celular
    private String email; // email
    private String barrio; // barrio
    private String idCiudad; // codCiudad
    private String nombreCiudad; // nomCiudad
    private String idDepartamento; // codDepart
    private String nombreDepartamento; // nomDepart
    private String idPais; // codPais
    private String nombrePais; // nomPais
    
    public ResponseConsultarDatosAsociado() {
		super();
	}

	public ResponseConsultarDatosAsociado(String cedula, String nombreCompleto, String direccion, String celular, 
        String email, String barrio, String idCiudad, String nombreCiudad, String idDepartamento, String nombreDepartamento, 
        String idPais, String nombrePais) {
		super();
		this.cedula = cedula;
		this.nombreCompleto = nombreCompleto;
		this.direccion = direccion;
		this.celular = celular;
		this.email = email;
		this.barrio = barrio;
		this.idCiudad = idCiudad;
		this.nombreCiudad = nombreCiudad;
		this.idDepartamento = idDepartamento;
		this.nombreDepartamento = nombreDepartamento;
		this.idPais = idPais;
		this.nombrePais = nombrePais;
	}

	public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBarrio() {
        return this.barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getIdCiudad() {
        return this.idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return this.nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getIdDepartamento() {
        return this.idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return this.nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getIdPais() {
        return this.idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return this.nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

}
