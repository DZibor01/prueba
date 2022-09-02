package com.cm.solidappservice.model.adelantonomina.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestProcesarSolicitudAdelantoDeprecated extends RequestAutenticacion {

  private Integer v_k_flujo;
  
  public RequestProcesarSolicitudAdelantoDeprecated() {}
  
  public RequestProcesarSolicitudAdelantoDeprecated(Integer v_k_flujo) {
    this.v_k_flujo = v_k_flujo;
  }
  
  public Integer getV_k_flujo() {
    return this.v_k_flujo;
  }
  
  public void setV_k_flujo(Integer v_k_flujo) {
    this.v_k_flujo = v_k_flujo;
  }

}