package com.cm.solidappservice.model.adelantonomina.response;

public class ResponseEstadoAdelanto {
    
    private String estado; //v_alfabe k_parame = 3
    private String[] dependenciasActivas; // k_parame = 5

    public ResponseEstadoAdelanto(){}

    public ResponseEstadoAdelanto(String estado, String[] dependenciasActivas){
        super();
        this.estado = estado;
        this.dependenciasActivas = dependenciasActivas;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String[] getDependenciasActivas() {
        return this.dependenciasActivas;
    }

    public void setDependenciasActivas(String[] dependenciasActivas) {
        this.dependenciasActivas = dependenciasActivas;
    }

}
