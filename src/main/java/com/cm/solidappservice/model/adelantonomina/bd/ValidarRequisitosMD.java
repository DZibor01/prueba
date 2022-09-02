package com.cm.solidappservice.model.adelantonomina.bd;

import java.util.Date;

/*
** pk_pst_evaluarequisito_avance.pr_almacenayevalua_requistos
*/
public class ValidarRequisitosMD {

  private String k_supreq;
  private String n_aanumnit;
  private String k_modali;
  private Date f_corte;
  private String k_identificador;
  private String CUMPLE;
  
  public ValidarRequisitosMD() {}
  
  public ValidarRequisitosMD(String k_supreq, String n_aanumnit, String k_modali, 
  Date f_corte, String k_identificador, String CUMPLE) {
	  
    this.k_supreq = k_supreq;
    this.n_aanumnit = n_aanumnit;
    this.k_modali = k_modali;
    this.f_corte = f_corte;
    this.k_identificador = k_identificador;
    this.CUMPLE = CUMPLE;
  }
  
  public String getK_supreq() {
    return this.k_supreq;
  }
  
  public void setK_supreq(String k_supreq) {
    this.k_supreq = k_supreq;
  }
  
  public String getN_aanumnit() {
    return this.n_aanumnit;
  }
  
  public void setN_aanumnit(String n_aanumnit) {
    this.n_aanumnit = n_aanumnit;
  }
  
  public String getK_modali() {
    return this.k_modali;
  }
  
  public void setK_modali(String k_modali) {
    this.k_modali = k_modali;
  }
  
  public Date getF_corte() {
    return this.f_corte;
  }
  
  public void setF_corte(Date f_corte) {
    this.f_corte = f_corte;
  }
  
  public String getK_identificador() {
    return this.k_identificador;
  }
  
  public void setK_identificador(String k_identificador) {
    this.k_identificador = k_identificador;
  }
  
  public String getCumple() {
    return this.CUMPLE;
  }
  
  public void setCumple(String CUMPLE) {
    this.CUMPLE = CUMPLE;
  }
}