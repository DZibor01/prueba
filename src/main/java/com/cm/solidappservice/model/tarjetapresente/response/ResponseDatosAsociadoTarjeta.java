package com.cm.solidappservice.model.tarjetapresente.response;

public class ResponseDatosAsociadoTarjeta {
    
    private String cedula; // v_aanumnit;
    private String pimerApellido; // n_apell1;
    private String segundoApellido; // n_apell2;
    private String primerNombre; // n_nombr1;
    private String segundoNombre; // n_nombr2;
    private String nombreCiudad; // n_ciudad;
    private String idDependencia; // k_dependencia;
    private String nombreDependencia; // n_dependencia;

    public ResponseDatosAsociadoTarjeta(){}

    public ResponseDatosAsociadoTarjeta(String cedula, String pimerApellido, String segundoApellido,
            String primerNombre, String segundoNombre, String nombreCiudad, String idDependencia, String nombreDependencia) {
        this.cedula = cedula;
        this.pimerApellido = pimerApellido;
        this.segundoApellido = segundoApellido;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.nombreCiudad = nombreCiudad;
        this.idDependencia = idDependencia;
        this.nombreDependencia = nombreDependencia;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPimerApellido() {
        return pimerApellido;
    }

    public void setPimerApellido(String pimerApellido) {
        this.pimerApellido = pimerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(String idDependencia) {
        this.idDependencia = idDependencia;
    }

    public String getNombreDependencia() {
        return nombreDependencia;
    }

    public void setNombreDependencia(String nombreDependencia) {
        this.nombreDependencia = nombreDependencia;
    }

    
    
}


