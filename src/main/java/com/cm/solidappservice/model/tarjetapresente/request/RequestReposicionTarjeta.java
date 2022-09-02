package com.cm.solidappservice.model.tarjetapresente.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestReposicionTarjeta extends RequestAutenticacion {

    private String primerNombre; // n_nombr1
    private String segundoNombre; // n_nombr2
    private String primerApellido; // n_apell1
    private String segundoApellido; // n_apell2
    private String email; // d_email
    private String telefonoCelular; // t_telcel
    private String nombreCiudad; // n_ciudad
    private String codigoDependencia; // k_coddependencia
    private String nombreDependencia; // n_dependencia
    private String dependenciaModificada; // i_depmodificada
    private String numeroPlastico; // n_numplastico
    private String idCentralCostos; // k_ccostos
    private String encargado; // i_estpla
    private String tipoTransaccion; // k_tipotransa
    private String fechaSolicitud; //f_solicitud

    public RequestReposicionTarjeta() {
    }

    public RequestReposicionTarjeta(String primerNombre, String segundoNombre, String primerApellido,
            String segundoApellido, String email, String telefonoCelular, String nombreCiudad, String codigoDependencia,
            String nombreDependencia, String dependenciaModificada, String numeroPlastico, String idCentralCostos,
            String encargado, String tipoTransaccion, String fechaSolicitud) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.email = email;
        this.telefonoCelular = telefonoCelular;
        this.nombreCiudad = nombreCiudad;
        this.codigoDependencia = codigoDependencia;
        this.nombreDependencia = nombreDependencia;
        this.dependenciaModificada = dependenciaModificada;
        this.numeroPlastico = numeroPlastico;
        this.idCentralCostos = idCentralCostos;
        this.encargado = encargado;
        this.tipoTransaccion = tipoTransaccion;
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getPrimerNombre() {
        return this.primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return this.segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonoCelular() {
        return this.telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getNombreCiudad() {
        return this.nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getCodigoDependencia() {
        return this.codigoDependencia;
    }

    public void setCodigoDependencia(String codigoDependencia) {
        this.codigoDependencia = codigoDependencia;
    }

    public String getNombreDependencia() {
        return this.nombreDependencia;
    }

    public void setNombreDependencia(String nombreDependencia) {
        this.nombreDependencia = nombreDependencia;
    }

    public String getDependenciaModificada() {
        return this.dependenciaModificada;
    }

    public void setDependenciaModificada(String dependenciaModificada) {
        this.dependenciaModificada = dependenciaModificada;
    }

    public String getNumeroPlastico() {
        return this.numeroPlastico;
    }

    public void setNumeroPlastico(String numeroPlastico) {
        this.numeroPlastico = numeroPlastico;
    }

    public String getIdCentralCostos() {
        return this.idCentralCostos;
    }

    public void setIdCentralCostos(String idCentralCostos) {
        this.idCentralCostos = idCentralCostos;
    }

    public String getEncargado() {
        return this.encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getTipoTransaccion() {
        return this.tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getFechaSolicitud() {
        return this.fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
        
}
