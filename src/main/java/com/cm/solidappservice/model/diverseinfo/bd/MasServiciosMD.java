package com.cm.solidappservice.model.diverseinfo.bd;
/*
 **TAB_APPSERVICIOS
 */
public class MasServiciosMD {

  private Integer k_servicio;
  private String n_servicio;
  private String n_url_icono;
  private String n_url_enlace;
  private String i_estado;
  private Integer q_orden;
  
  public MasServiciosMD() {}
  
  public MasServiciosMD(Integer k_servicio, String n_servicio, String n_url_icono, String n_url_enlace, String i_estado, Integer q_orden) {
    this.k_servicio = k_servicio;
    this.n_servicio = n_servicio;
    this.n_url_icono = n_url_icono;
    this.n_url_enlace = n_url_enlace;
    this.i_estado = i_estado;
    this.q_orden = q_orden;
  }
  
  public Integer getK_servicio() {
    return this.k_servicio;
  }
  
  public void setK_servicio(Integer k_servicio) {
    this.k_servicio = k_servicio;
  }
  
  public String getN_servicio() {
    return this.n_servicio;
  }
  
  public void setN_servicio(String n_servicio) {
    this.n_servicio = n_servicio;
  }
  
  public String getN_url_icono() {
    return this.n_url_icono;
  }
  
  public void setN_url_icono(String n_url_icono) {
    this.n_url_icono = n_url_icono;
  }
  
  public String getN_url_enlace() {
    return this.n_url_enlace;
  }
  
  public void setN_url_enlace(String n_url_enlace) {
    this.n_url_enlace = n_url_enlace;
  }
  
  public String getI_estado() {
    return this.i_estado;
  }
  
  public void setI_estado(String i_estado) {
    this.i_estado = i_estado;
  }

  public Integer getQ_orden() {
    return this.q_orden;
  }
  
  public void setQ_orden(Integer q_orden) {
    this.q_orden = q_orden;
  }

}