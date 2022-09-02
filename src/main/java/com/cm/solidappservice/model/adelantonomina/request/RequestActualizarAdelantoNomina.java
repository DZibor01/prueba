package com.cm.solidappservice.model.adelantonomina.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestActualizarAdelantoNomina extends RequestAutenticacion{

  private Integer k_flujo;
  private String i_estado;
  private String n_error;
  private String k_tipodr;
  private String k_numdoc;
  private String f_primcuota;

  public RequestActualizarAdelantoNomina() {}

  public RequestActualizarAdelantoNomina(Integer k_flujo, String i_estado, String n_error, String k_tipodr,
      String k_numdoc, String f_primcuota) {
    this.k_flujo = k_flujo;
    this.i_estado = i_estado;
    this.n_error = n_error;
    this.k_tipodr = k_tipodr;
    this.k_numdoc = k_numdoc;
    this.f_primcuota = f_primcuota;
  }

  public Integer getK_flujo() {
    return k_flujo;
  }

  public void setK_flujo(Integer k_flujo) {
    this.k_flujo = k_flujo;
  }

  public String getI_estado() {
    return i_estado;
  }

  public void setI_estado(String i_estado) {
    this.i_estado = i_estado;
  }

  public String getN_error() {
    return n_error;
  }

  public void setN_error(String n_error) {
    this.n_error = n_error;
  }

  public String getK_tipodr() {
    return k_tipodr;
  }

  public void setK_tipodr(String k_tipodr) {
    this.k_tipodr = k_tipodr;
  }

  public String getK_numdoc() {
    return k_numdoc;
  }

  public void setK_numdoc(String k_numdoc) {
    this.k_numdoc = k_numdoc;
  }

  public String getF_primcuota() {
    return f_primcuota;
  }

  public void setF_primcuota(String f_primcuota) {
    this.f_primcuota = f_primcuota;
  }
  
  
  
}