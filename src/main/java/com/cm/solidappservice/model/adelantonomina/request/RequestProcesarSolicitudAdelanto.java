package com.cm.solidappservice.model.adelantonomina.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestProcesarSolicitudAdelanto extends RequestAutenticacion{

    private Integer idFlujo; // getV_k_flujo

    public RequestProcesarSolicitudAdelanto(){}

    public RequestProcesarSolicitudAdelanto(Integer idFlujo){
        super();
        this.idFlujo = idFlujo;
    }

    public Integer getIdFlujo() {
        return this.idFlujo;
    }

    public void setIdFlujo(Integer idFlujo) {
        this.idFlujo = idFlujo;
    }
    
}
