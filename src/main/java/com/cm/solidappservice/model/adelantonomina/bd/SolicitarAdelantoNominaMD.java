package com.cm.solidappservice.model.adelantonomina.bd;

/*
**pk_pst_app_avance_nomina.pr_inserta_solicitud
*/
public class SolicitarAdelantoNominaMD{

  private String n_aanumnit;
  private String v_monto;
  private String f_solici;
  private String k_nroSolici;
  private String n_resultado;
  private String n_error;
  private Integer v_k_flujo;
  
  public SolicitarAdelantoNominaMD() {}
  
  public SolicitarAdelantoNominaMD(String n_aanumnit, String v_monto, String f_solici, String k_nroSolici, String n_resultado, String n_error, Integer v_k_flujo) {
    this.n_aanumnit = n_aanumnit;
    this.v_monto = v_monto;
    this.f_solici = f_solici;
    this.k_nroSolici = k_nroSolici;
    this.n_resultado = n_resultado;
    this.n_error = n_error;
    this.v_k_flujo = v_k_flujo;
  }
  
  public String getN_aanumnit() {
    return this.n_aanumnit;
  }
  
  public void setN_aanumnit(String n_aanumnit) {
    this.n_aanumnit = n_aanumnit;
  }
  
  public String getV_monto() {
    return this.v_monto;
  }
  public void setV_monto(String v_monto) {
    this.v_monto = v_monto;
  }
  
  public String getF_solici() {
    return this.f_solici;
  }
  
  public void setF_solici(String f_solici) {
    this.f_solici = f_solici;
  }

  public String getK_nroSolici() {
    return this.k_nroSolici;
  }
  
  public void setK_nroSolici(String k_nroSolici) {
    this.k_nroSolici = k_nroSolici;
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
  
  public Integer getV_k_flujo() {
    return Integer.valueOf(this.v_k_flujo);
  }
  
  public void setV_k_flujo(Integer v_k_flujo) {
    this.v_k_flujo = v_k_flujo;
  }
}
