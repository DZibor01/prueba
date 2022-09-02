package com.cm.solidappservice.model.adelantonomina.response;

public class ResponseMovimientosAdelantoDeprecated{

  private String k_transa;
  private String aanumnit;  
  private String f_solictud;
  private Integer v_solicitado;
  private Integer v_cupo;
  private String i_estado;
  private String n_error;
  private String k_tipodr;
  private String k_numdoc;
  private Integer v_valorcre;
  private String f_primcuota;
  private Integer k_flujo;
  private String i_aceptacion;  
  private String f_aceptacion;
  private String ip;

  public ResponseMovimientosAdelantoDeprecated() {}
  
  public ResponseMovimientosAdelantoDeprecated(String k_transa, String aanumnit, String f_solictud, Integer v_solicitado, 
  Integer v_cupo, String i_estado, String n_error, String k_tipodr, String k_numdoc, Integer v_valorcre, 
  String f_primcuota, Integer k_flujo, String i_aceptacion, String f_aceptacion, String ip) {	  
    this.k_transa = k_transa;
    this.aanumnit = aanumnit;
    this.f_solictud = f_solictud;
    this.v_solicitado = v_solicitado;
    this.v_cupo = v_cupo;
    this.i_estado = i_estado;
    this.n_error = n_error;
    this.k_tipodr = k_tipodr;
    this.k_numdoc = k_numdoc;
    this.v_valorcre = v_valorcre;
    this.f_primcuota = f_primcuota;
    this.k_flujo = k_flujo;
    this.i_aceptacion = i_aceptacion;
    this.f_aceptacion = f_aceptacion;
    this.ip = ip;
  }
  
  public String getK_transa() {
    return this.k_transa;
  }
  
  public void setK_transa(String k_transa) {
    this.k_transa = k_transa;
  }
  
  public String getAanumnit() {
    return this.aanumnit;
  }
  
  public void setAanumnit(String aanumnit) {
    this.aanumnit = aanumnit;
  }
  
  public String getF_solictud() {
    return this.f_solictud;
  }
  
  public void setF_solictud(String f_solictud) {
    this.f_solictud = f_solictud;
  }
  
  public Integer getV_solicitado() {
    return this.v_solicitado;
  }
  
  public void setV_solicitado(Integer v_solicitado) {
    this.v_solicitado = v_solicitado;
  }
  
  public Integer getV_cupo() {
    return this.v_cupo;
  }
  
  public void setV_cupo(Integer v_cupo) {
    this.v_cupo = v_cupo;
  }
  
  public String getI_estado() {
    return this.i_estado;
  }
  
  public void setI_estado(String i_estado) {
    this.i_estado = i_estado;
  }
  
  public String getN_error() {
    return this.n_error;
  }
  
  public void setN_error(String n_error) {
    this.n_error = n_error;
  }
  
  public String getK_tipodr() {
    return this.k_tipodr;
  }
  
  public void setK_tipodr(String k_tipodr) {
    this.k_tipodr = k_tipodr;
  }
  
  public String getK_numdoc() {
    return this.k_numdoc;
  }
  
  public void setK_numdoc(String k_numdoc) {
    this.k_numdoc = k_numdoc;
  }
  
  public Integer getV_valorcre() {
    return this.v_valorcre;
  }
  
  public void setV_valorcre(Integer v_valorcre) {
    this.v_valorcre = v_valorcre;
  }
  
  public String getF_primcuota() {
    return this.f_primcuota;
  }
  
  public void setF_primcuota(String f_primcuota) {
    this.f_primcuota = f_primcuota;
  }
  
  public Integer getK_flujo() {
    return this.k_flujo;
  }
  
  public void setK_flujo(Integer k_flujo) {
    this.k_flujo = k_flujo;
  }
  
  public String getI_aceptacion() {
    return this.i_aceptacion;
  }
  
  public void setI_aceptacion(String i_aceptacion) {
    this.i_aceptacion = i_aceptacion;
  }
  
  public String getF_aceptacion() {
    return this.f_aceptacion;
  }
  
  public void setF_aceptacion(String f_aceptacion) {
    this.f_aceptacion = f_aceptacion;
  }
  
  public String getIp() {
    return this.ip;
  }
  
  public void setIp(String ip) {
    this.ip = ip;
  }
}