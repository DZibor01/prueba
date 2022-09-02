package com.cm.solidappservice.model.portalunico.response;

public class ResponseSolicitarCeriticado {
  
    private String idTransaccion;
    private String resultadoTransaccion;
    private String mensajeError;

    public ResponseSolicitarCeriticado() {
    }

    public ResponseSolicitarCeriticado(String idTransaccion, String resultadoTransaccion, String mensajeError) {
        this.idTransaccion = idTransaccion;
        this.resultadoTransaccion = resultadoTransaccion;
        this.mensajeError = mensajeError;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getResultadoTransaccion() {
        return resultadoTransaccion;
    }

    public void setResultadoTransaccion(String resultadoTransaccion) {
        this.resultadoTransaccion = resultadoTransaccion;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
    
    

}
