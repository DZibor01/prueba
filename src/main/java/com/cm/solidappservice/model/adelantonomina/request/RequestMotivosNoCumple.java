package com.cm.solidappservice.model.adelantonomina.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestMotivosNoCumple extends RequestAutenticacion {

  private String n_requisito;
  private String k_identificador;
  
  public RequestMotivosNoCumple() {}

  public RequestMotivosNoCumple(String n_requisito, String k_identificador) {
    this.n_requisito = n_requisito;
    this.k_identificador = k_identificador;
  }

  public String getN_requisito() {
    return n_requisito;
  }

  public void setN_requisito(String n_requisito) {
    this.n_requisito = n_requisito;
  }

  public String getK_identificador() {
    return k_identificador;
  }

  public void setK_identificador(String k_identificador) {
    this.k_identificador = k_identificador;
  }

}