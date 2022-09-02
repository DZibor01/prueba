package com.cm.solidappservice.model.codigoverificacion.response;

import java.util.Date;

public class ResponseCodigo {
    
    private String idCodigo; // k_codigo
    private String codigo; // n_codigo
    private Date fechaGeneracion; // f_generacion
    private Date fechaExpiracion; // f_expiracion

    public ResponseCodigo() {
    }

    public ResponseCodigo(String idCodigo, String codigo, Date fechaGeneracion, Date fechaExpiracion) {
        this.idCodigo = idCodigo;
        this.codigo = codigo;
        this.fechaGeneracion = fechaGeneracion;
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getIdCodigo() {
        return this.idCodigo;
    }

    public void setIdCodigo(String idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaGeneracion() {
        return this.fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public Date getFechaExpiracion() {
        return this.fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
