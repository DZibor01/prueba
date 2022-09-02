package com.cm.solidappservice.model.creditos.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestListCreditosRadicadosDeprecated extends RequestAutenticacion {

  private String k_solicitud;
  private String k_linea;
  private String i_formaentrega;
  private String f_solicitud;
  private int v_solicitado;
  
  public String getK_solicitud() {
    return this.k_solicitud;
  }
  
  public void setK_solicitud(String k_solicitud) {
    this.k_solicitud = k_solicitud;
  }
  
  public String getK_linea() {
    return this.k_linea;
  }
  
  public void setK_linea(String k_linea) {
    this.k_linea = k_linea;
  }
  
  public String getI_formaentrega() {
    return this.i_formaentrega;
  }
  
  public void setI_formaentrega(String i_formaentrega) {
    this.i_formaentrega = i_formaentrega;
  }
  
  public String getF_solicitud() {
    return this.f_solicitud;
  }
  
  public void setF_solicitud(String f_solicitud) {
    this.f_solicitud = f_solicitud;
  }
  
  public int getV_solicitado() {
    return this.v_solicitado;
  }
  
  public void setV_solicitado(int v_solicitado) {
    this.v_solicitado = v_solicitado;
  }
}
