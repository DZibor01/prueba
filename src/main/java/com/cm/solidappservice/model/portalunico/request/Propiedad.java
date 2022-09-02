package com.cm.solidappservice.model.portalunico.request;

public class Propiedad {
  
    private String numeroMatricula; //A_NUMMATRICULA 
    private String direccionPropiedad; //A_NUMMATRICULA
    private String idDepartamento; //K_DEPART 
    private String nombreDepartamento; //N_DEPART
    private String idCiudad; // K_CIUDAD
    private String nombreCiudad; // N_CIUDAD
    
    public Propiedad() {
    }

    public Propiedad(String numeroMatricula, String direccionPropiedad, String idDepartamento,
            String nombreDepartamento, String idCiudad, String nombreCiudad) {
        this.numeroMatricula = numeroMatricula;
        this.direccionPropiedad = direccionPropiedad;
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getDireccionPropiedad() {
        return direccionPropiedad;
    }

    public void setDireccionPropiedad(String direccionPropiedad) {
        this.direccionPropiedad = direccionPropiedad;
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
