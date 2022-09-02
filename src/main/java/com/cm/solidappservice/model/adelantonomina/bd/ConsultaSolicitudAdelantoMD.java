package com.cm.solidappservice.model.adelantonomina.bd;

import java.sql.Date;

/*
**LINIX.pk_pst_app_avance_nomina.pr_consulta_solicitud
*/
public class ConsultaSolicitudAdelantoMD{

  private Integer v_k_flujo;
  private String a_numnit;
  private Date f_solici;
  private Integer v_solici;
  private Integer k_ano;
  private String k_sucurs;
  private String k_tipdoc;
  private Date f_primera;
  private String k_numdoc;
  private String a_tipodr;
  private String a_obliga;
  private String n_resultado;
  private String n_error;
  
  public ConsultaSolicitudAdelantoMD() {}
  
  public ConsultaSolicitudAdelantoMD(Integer v_k_flujo, String a_numnit, Date f_solici, Integer v_solici, Integer k_ano, String k_sucurs, String k_tipdoc, Date f_primera, String k_numdoc, String a_tipodr, String a_obliga, String n_resultado, String n_error) {
    this.v_k_flujo = v_k_flujo;
    this.a_numnit = a_numnit;
    this.f_solici = f_solici;
    this.v_solici = v_solici;
    this.k_ano = k_ano;
    this.k_sucurs = k_sucurs;
    this.k_tipdoc = k_tipdoc;
    this.f_primera = f_primera;
    this.k_numdoc = k_numdoc;
    this.a_tipodr = a_tipodr;
    this.a_obliga = a_obliga;
    this.n_resultado = n_resultado;
    this.n_error = n_error;
  }
  
  public Integer getV_k_flujo() {
    return this.v_k_flujo;
  }
  
  public void setV_k_flujo(Integer v_k_flujo) {
    this.v_k_flujo = v_k_flujo;
  }
  
  public String getA_numnit() {
    return this.a_numnit;
  }
  
  public void setA_numnit(String a_numnit) {
    this.a_numnit = a_numnit;
  }
  
  public Date getF_solici() {
    return this.f_solici;
  }
  
  public void setF_solici(Date f_solici) {
    this.f_solici = f_solici;
  }
  
  public Integer getV_solici() {
    return this.v_solici;
  }
  
  public void setV_solici(Integer v_solici) {
    this.v_solici = v_solici;
  }
  
  public Integer getK_ano() {
    return this.k_ano;
  }
  
  public void setK_ano(Integer k_ano) {
    this.k_ano = k_ano;
  }
  
  public String getK_sucurs() {
    return this.k_sucurs;
  }
  
  public void setK_sucurs(String k_sucurs) {
    this.k_sucurs = k_sucurs;
  }
  
  public String getK_tipdoc() {
    return this.k_tipdoc;
  }
  
  public void setK_tipdoc(String k_tipdoc) {
    this.k_tipdoc = k_tipdoc;
  }
  
  public Date getF_primera() {
    return this.f_primera;
  }
  
  public void setF_primera(Date f_primera) {
    this.f_primera = f_primera;
  }
  
  public String getK_numdoc() {
    return this.k_numdoc;
  }
  
  public void setK_numdoc(String k_numdoc) {
    this.k_numdoc = k_numdoc;
  }
  
  public String getA_tipodr() {
    return this.a_tipodr;
  }
  
  public void setA_tipodr(String a_tipodr) {
    this.a_tipodr = a_tipodr;
  }
  
  public String getA_obliga() {
    return this.a_obliga;
  }
  
  public void setA_obliga(String a_obliga) {
    this.a_obliga = a_obliga;
  }
  
  public String getN_resultado() {
    return this.n_resultado;
  }
  
  public void setN_resultado(String n_resultado) {
    this.n_resultado = n_resultado;
  }
  
  public String getN_error() {
    return this.n_error;
  }
  
  public void setN_error(String n_error) {
    this.n_error = n_error;
  }
}