package com.cm.solidappservice.model.adelantonomina.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestSolicitarAdelantoDeprecated extends RequestAutenticacion {

  private String v_monto;
  private String f_solici;
  private String k_nroSolici;
  
  public RequestSolicitarAdelantoDeprecated() {}

  public RequestSolicitarAdelantoDeprecated(String v_monto, String f_solici, String k_nroSolici) {
    this.v_monto = v_monto;
    this.f_solici = f_solici;
    this.k_nroSolici = k_nroSolici;
  }

  public String getV_monto() {
    return v_monto;
  }

  public void setV_monto(String v_monto) {
    this.v_monto = v_monto;
  }

  public String getF_solici() {
    return f_solici;
  }

  public void setF_solici(String f_solici) {
    this.f_solici = f_solici;
  }

  public String getK_nroSolici() {
    return k_nroSolici;
  }

  public void setK_nroSolici(String k_nroSolici) {
    this.k_nroSolici = k_nroSolici;
  }
  
  
  
}
