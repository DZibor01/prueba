package com.cm.solidappservice.model.codigoverificacion.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestValidarCodigo extends RequestAutenticacion{
    
    private String idCodigoEnviado;
    private String codigoIngresado;

    public RequestValidarCodigo() {
    }

    public RequestValidarCodigo(String idCodigoEnviado, String codigoIngresado) {
        this.idCodigoEnviado = idCodigoEnviado;
        this.codigoIngresado = codigoIngresado;
    }

    public String getIdCodigoEnviado() {
        return this.idCodigoEnviado;
    }

    public void setIdCodigoEnviado(String idCodigoEnviado) {
        this.idCodigoEnviado = idCodigoEnviado;
    }

    public String getCodigoIngresado() {
        return this.codigoIngresado;
    }

    public void setCodigoIngresado(String codigoIngresado) {
        this.codigoIngresado = codigoIngresado;
    }

}
