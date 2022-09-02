package com.cm.solidappservice.model.agencias.response;

import java.util.List;

public class ResponseObtenerAgencias {
    
    private String latitud; // n_latitu
    private String longitud; // n_longit
    private String nombreSucursal; // n_sucurs
    private String codigoSucursal; // i_tippage Tipo de sucursal
    private String idSucursal; // k_sucurs Codigo de sucursal
    private String direccionSucursal; // d_sucurs Dirección sucursal
    private String nombreDepartamento; // n_depart Nombre departamento
    private String nombreCiudad; // n_ciudad Nombre de la ciudad
    private String tipoSucursal; // t_sucurs Telefono sucursal
    private List<ContactoAgencia> contactos;

    public ResponseObtenerAgencias(){}    
    
    public ResponseObtenerAgencias(String latitud, String longitud, String nombreSucursal, String codigoSucursal,
			String idSucursal, String direccionSucursal, String nombreDepartamento, String nombreCiudad,
			String tipoSucursal, List<ContactoAgencia> contactos) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombreSucursal = nombreSucursal;
		this.codigoSucursal = codigoSucursal;
		this.idSucursal = idSucursal;
		this.direccionSucursal = direccionSucursal;
		this.nombreDepartamento = nombreDepartamento;
		this.nombreCiudad = nombreCiudad;
		this.tipoSucursal = tipoSucursal;
		this.contactos = contactos;
	}



	public String getLatitud() {
        return this.latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return this.longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getNombreSucursal() {
        return this.nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getCodigoSucursal() {
        return this.codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getIdSucursal() {
        return this.idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDireccionSucursal() {
        return this.direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }

    public String getNombreDepartamento() {
        return this.nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNombreCiudad() {
        return this.nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getTipoSucursal() {
        return this.tipoSucursal;
    }

    public void setTipoSucursal(String tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }

    public List<ContactoAgencia> getContactos() {
        return this.contactos;
    }

    public void setContactos(List<ContactoAgencia> contactos) {
        this.contactos = contactos;
    }
	
}
