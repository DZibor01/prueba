package com.cm.solidappservice.model.dispositivo.response;

public class ResponseRegistrarDispositivo {
    
    private String idRegistroDispositivo;

    public ResponseRegistrarDispositivo() {
    }

    public ResponseRegistrarDispositivo(String idRegistroDispositivo) {
        this.idRegistroDispositivo = idRegistroDispositivo;
    }

    public String getIdRegistroDispositivo() {
        return this.idRegistroDispositivo;
    }

    public void setIdRegistroDispositivo(String idRegistroDispositivo) {
        this.idRegistroDispositivo = idRegistroDispositivo;
    }
}
