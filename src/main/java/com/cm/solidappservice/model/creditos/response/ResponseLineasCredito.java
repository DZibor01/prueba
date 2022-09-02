package com.cm.solidappservice.model.creditos.response;

public class ResponseLineasCredito {
    
    private String idLineaCredito; // k_LINEA
    private String nombreLineaCredito; // n_LINEA
    private String estado; // i_ESTADO
    private String idProductoArco;   //k_PRODUCTOARCO

    public ResponseLineasCredito(){}

    public ResponseLineasCredito(String idLineaCredito, String nombreLineaCredito, String estado, String idProductoArco){
        super();
        this.idLineaCredito = idLineaCredito;
        this.nombreLineaCredito = nombreLineaCredito;
        this.estado = estado;
        this.idProductoArco = idProductoArco;
    }

    public String getIdLineaCredito() {
        return this.idLineaCredito;
    }

    public void setIdLineaCredito(String idLineaCredito) {
        this.idLineaCredito = idLineaCredito;
    }

    public String getNombreLineaCredito() {
        return this.nombreLineaCredito;
    }

    public void setNombreLineaCredito(String nombreLineaCredito) {
        this.nombreLineaCredito = nombreLineaCredito;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdProductoArco() {
        return this.idProductoArco;
    }

    public void setIdProductoArco(String idProductoArco) {
        this.idProductoArco = idProductoArco;
    }

}
