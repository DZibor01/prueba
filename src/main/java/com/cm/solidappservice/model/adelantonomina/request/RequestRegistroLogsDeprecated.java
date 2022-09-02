package com.cm.solidappservice.model.adelantonomina.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestRegistroLogsDeprecated extends RequestAutenticacion {

  private String f_registro;
  private String n_accion;
  private String n_descr;
  
  public RequestRegistroLogsDeprecated() {}

  public RequestRegistroLogsDeprecated(String cedula, String token, String f_registro, String n_accion, String n_descr) {
    super(cedula, token);
    this.f_registro = f_registro;
    this.n_accion = n_accion;
    this.n_descr = n_descr;
  }

  public RequestRegistroLogsDeprecated(String f_registro, String n_accion, String n_descr) {
    this.f_registro = f_registro;
    this.n_accion = n_accion;
    this.n_descr = n_descr;
  }

  public String getF_registro() {
    return f_registro;
  }

  public void setF_registro(String f_registro) {
    this.f_registro = f_registro;
  }

  public String getN_accion() {
    return n_accion;
  }

  public void setN_accion(String n_accion) {
    this.n_accion = n_accion;
  }

  public String getN_descr() {
    return n_descr;
  }

  public void setN_descr(String n_descr) {
    this.n_descr = n_descr;
  }
  
}
