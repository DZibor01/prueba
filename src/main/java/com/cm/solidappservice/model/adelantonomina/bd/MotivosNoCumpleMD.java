package com.cm.solidappservice.model.adelantonomina.bd;

import java.sql.Date;
/*
**TAB_ADNREQUISITOS
*/
public class MotivosNoCumpleMD{

  private String k_aanumnit;
  private String n_requisito;
  private String n_cumple;
  private String n_observacion;
  private String k_identificador;
  private Date f_evaluacion;
  
  public MotivosNoCumpleMD() {}
  
  public MotivosNoCumpleMD(String k_aanumnit, String n_requisito, String n_cumple, String n_observacion, 
  String k_identificador, Date f_evaluacion) {

    this.k_aanumnit = k_aanumnit;
    this.n_requisito = n_requisito;
    this.n_cumple = n_cumple;
    this.n_observacion = n_observacion;
    this.k_identificador = k_identificador;
    this.f_evaluacion = f_evaluacion;
  }
  
  public String getK_aannumnit() {
    return this.k_aanumnit;
  }
  
  public void setK_annumnit(String k_aanumnit) {
    this.k_aanumnit = k_aanumnit;
  }
  
  public String getN_requisito() {
    return this.n_requisito;
  }
  
  public void setN_requisito(String n_requisito) {
    this.n_requisito = n_requisito;
  }
  
  public String getN_cumple() {
    return this.n_cumple;
  }
  
  public void setN_cumple(String n_cumple) {
    this.n_cumple = n_cumple;
  }
  
  public String getN_observacion() {
    return this.n_observacion;
  }
  
  public void setN_observacion(String n_observacion) {
    this.n_observacion = n_observacion;
  }
  
  public String getK_identificador() {
    return this.k_identificador;
  }
  
  public void setK_identificador(String k_identificador) {
    this.k_identificador = k_identificador;
  }
  
  public Date getF_evaluacion() {
    return this.f_evaluacion;
  }
  
  public void setF_evaluacion(Date f_evaluacion) {
    this.f_evaluacion = f_evaluacion;
  }
}