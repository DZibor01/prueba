package com.cm.solidappservice.model.portalunico.request;

import java.util.List;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestSolicitarCertificado extends RequestAutenticacion{
 
    private String nombreCompleto; //N_NOMBRE
    private String correoElectronico; //D_EMAIL
    private String telefonoCelular; //T_TELCEL 
    private String fechaSolicitud; //F_SOLICITUD 
    private Integer valorTotal; //V_VALORTOTAL 
    private String numeroProductoDebitable; //A_NUMDOC
    private boolean esPagoACredito;
    private List<Propiedad> propiedades; 

    public RequestSolicitarCertificado() {
    }

    public RequestSolicitarCertificado(String nombreCompleto, String correoElectronico, String telefonoCelular, 
            String fechaSolicitud, Integer valorTotal, String numeroProductoDebitable, boolean esPagoACredito,
            List<Propiedad> propiedades) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.telefonoCelular = telefonoCelular;
        this.fechaSolicitud = fechaSolicitud;
        this.valorTotal = valorTotal;
        this.numeroProductoDebitable = numeroProductoDebitable;
        this.esPagoACredito = esPagoACredito;
        this.propiedades = propiedades;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNumeroProductoDebitable() {
        return numeroProductoDebitable;
    }

    public void setNumeroProductoDebitable(String numeroProductoDebitable) {
        this.numeroProductoDebitable = numeroProductoDebitable;
    }
    
    public boolean isEsPagoACredito() {
        return esPagoACredito;
    }

    public void setEsPagoACredito(boolean esPagoACredito) {
        this.esPagoACredito = esPagoACredito;
    }

    public List<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

}
