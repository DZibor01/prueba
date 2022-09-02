package com.cm.solidappservice.model.dispositivo.response;

public class ResponseValidarDispositivoRegistrado {

    private String dispositivoRegistrado;
    private String idRegistroDispositivo;

    public ResponseValidarDispositivoRegistrado() {
    }

    public ResponseValidarDispositivoRegistrado(String dispositivoRegistrado, String idRegistroDispositivo) {
        this.dispositivoRegistrado = dispositivoRegistrado;
        this.idRegistroDispositivo = idRegistroDispositivo;
    }
    
    public String getDispositivoRegistrado() {
        return dispositivoRegistrado;
    }
    public void setDispositivoRegistrado(String dispositivoRegistrado) {
        this.dispositivoRegistrado = dispositivoRegistrado;
    }
    public String getIdRegistroDispositivo() {
        return idRegistroDispositivo;
    }
    public void setIdRegistroDispositivo(String idRegistroDispositivo) {
        this.idRegistroDispositivo = idRegistroDispositivo;
    }

    
    
}
