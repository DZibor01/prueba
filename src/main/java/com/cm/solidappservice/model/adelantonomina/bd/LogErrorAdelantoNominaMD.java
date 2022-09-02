package com.cm.solidappservice.model.adelantonomina.bd;

import com.cm.solidappservice.model.base.RequestAutenticacion;

/*
**TAB_APPLOGADELANTON
*/
public class LogErrorAdelantoNominaMD extends RequestAutenticacion {

  private String k_log;
  private String aanumnit;
  private String f_registro;
  private String n_accion;
  private String n_descr;
  
  public LogErrorAdelantoNominaMD() {}
  
  public LogErrorAdelantoNominaMD(String k_log, String aanumnit, String f_registro, String n_accion, String n_descr) {
    this.k_log = k_log;
    this.aanumnit = aanumnit;
    this.f_registro = f_registro;
    this.n_accion = n_accion;
    this.n_descr = n_descr;
  }
  
  public String getK_log() {
    return this.k_log;
  }
  
  public void setK_log(String k_log) {
    this.k_log = k_log;
  }
  
  public String getAanumnit() {
    return this.aanumnit;
  }
  
  public void setAanumnit(String aanumnit) {
    this.aanumnit = aanumnit;
  }
  
  public String getF_registro() {
    return this.f_registro;
  }
  
  public void setF_registro(String f_registro) {
    this.f_registro = f_registro;
  }
  
  public String getN_accion() {
    return this.n_accion;
  }
  
  public void setN_accion(String n_accion) {
    this.n_accion = n_accion;
  }
  
  public String getN_descr() {
    return this.n_descr;
  }
  
  public void setN_descr(String n_descr) {
    this.n_descr = n_descr;
  }
}
