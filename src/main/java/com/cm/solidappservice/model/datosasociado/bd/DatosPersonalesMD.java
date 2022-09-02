package com.cm.solidappservice.model.datosasociado.bd;

/*
**PK_APP_SOLITUDCREDITO.PR_DatosPersonalesMDASOCIADO
*/
public class DatosPersonalesMD {

  private String v_aanumnit;
  private String n_apell1;
  private String n_apell2;
  private String n_nombr1;
  private String n_nombr2;
  private String d_email;
  private String t_fijo;
  private String t_celular;
  private String n_direccion;
  private String n_barrio;
  private String n_ciudad;
  private String k_ciudad;
  private String k_depart;
  private String n_estciv;
  private int v_sueldo;
  private String f_antigu;
  private String k_dependencia;
  private String n_dependencia;
  private String k_regional;
  private String n_regional;
  private String n_cargo;
  private String i_tipnom;

  public DatosPersonalesMD() {}
  
  public DatosPersonalesMD(String v_aanumnit) {
    super();
    this.v_aanumnit = v_aanumnit;
  }

  public DatosPersonalesMD(String v_aanumnit, String n_apell1, String n_apell2, String n_nombr1, 
      String n_nombr2, String d_email, String t_fijo, String t_celular, String n_direccion, String n_barrio, 
      String n_ciudad, String k_ciudad, String k_depart, String n_estciv, int v_sueldo, String f_antigu, 
      String k_dependencia, String n_dependencia, String k_regional, String n_regional, String n_cargo, String i_tipnom) {
      this.v_aanumnit = v_aanumnit;
      this.n_apell1 = n_apell1;
      this.n_apell2 = n_apell2;
      this.n_nombr1 = n_nombr1;
      this.n_nombr2 = n_nombr2;
      this.d_email = d_email;
      this.t_fijo = t_fijo;
      this.t_celular = t_celular;
      this.n_direccion = n_direccion;
      this.n_barrio = n_barrio;
      this.n_ciudad = n_ciudad;
      this.k_ciudad = k_ciudad;
      this.k_depart = k_depart;
      this.n_estciv = n_estciv;
      this.v_sueldo = v_sueldo;
      this.f_antigu = f_antigu;
      this.k_dependencia = k_dependencia;
      this.n_dependencia = n_dependencia;
      this.k_regional = k_regional;
      this.n_regional = n_regional;
      this.n_cargo = n_cargo;
      this.i_tipnom = i_tipnom;
  }


  public String getV_aanumnit() {
    return this.v_aanumnit;
  }

  public void setV_aanumnit(String v_aanumnit) {
    this.v_aanumnit = v_aanumnit;
  }

  public String getN_apell1() {
    return this.n_apell1;
  }

  public void setN_apell1(String n_apell1) {
    this.n_apell1 = n_apell1;
  }

  public String getN_apell2() {
    return this.n_apell2;
  }

  public void setN_apell2(String n_apell2) {
    this.n_apell2 = n_apell2;
  }

  public String getN_nombr1() {
    return this.n_nombr1;
  }

  public void setN_nombr1(String n_nombr1) {
    this.n_nombr1 = n_nombr1;
  }

  public String getN_nombr2() {
    return this.n_nombr2;
  }

  public void setN_nombr2(String n_nombr2) {
    this.n_nombr2 = n_nombr2;
  }

  public String getD_email() {
    return this.d_email;
  }

  public void setD_email(String d_email) {
    this.d_email = d_email;
  }

  public String getT_fijo() {
    return this.t_fijo;
  }

  public void setT_fijo(String t_fijo) {
    this.t_fijo = t_fijo;
  }

  public String getT_celular() {
    return this.t_celular;
  }

  public void setT_celular(String t_celular) {
    this.t_celular = t_celular;
  }

  public String getN_direccion() {
    return this.n_direccion;
  }

  public void setN_direccion(String n_direccion) {
    this.n_direccion = n_direccion;
  }

  public String getN_barrio() {
    return this.n_barrio;
  }

  public void setN_barrio(String n_barrio) {
    this.n_barrio = n_barrio;
  }

  public String getN_ciudad() {
    return this.n_ciudad;
  }

  public void setN_ciudad(String n_ciudad) {
    this.n_ciudad = n_ciudad;
  }

  public String getK_ciudad() {
    return this.k_ciudad;
  }

  public void setK_ciudad(String k_ciudad) {
    this.k_ciudad = k_ciudad;
  }

  public String getK_depart() {
    return this.k_depart;
  }

  public void setK_depart(String k_depart) {
    this.k_depart = k_depart;
  }

  public String getN_estciv() {
    return this.n_estciv;
  }

  public void setN_estciv(String n_estciv) {
    this.n_estciv = n_estciv;
  }

  public int getV_sueldo() {
    return this.v_sueldo;
  }

  public void setV_sueldo(int v_sueldo) {
    this.v_sueldo = v_sueldo;
  }

  public String getF_antigu() {
    return this.f_antigu;
  }

  public void setF_antigu(String f_antigu) {
    this.f_antigu = f_antigu;
  }

  public String getK_dependencia() {
    return this.k_dependencia;
  }

  public void setK_dependencia(String k_dependencia) {
    this.k_dependencia = k_dependencia;
  }

  public String getN_dependencia() {
    return this.n_dependencia;
  }

  public void setN_dependencia(String n_dependencia) {
    this.n_dependencia = n_dependencia;
  }

  public String getK_regional() {
    return this.k_regional;
  }

  public void setK_regional(String k_regional) {
    this.k_regional = k_regional;
  }

  public String getN_regional() {
    return this.n_regional;
  }

  public void setN_regional(String n_regional) {
    this.n_regional = n_regional;
  }

  public String getN_cargo() {
    return this.n_cargo;
  }

  public void setN_cargo(String n_cargo) {
    this.n_cargo = n_cargo;
  }

  public String getI_tipnom() {
    return this.i_tipnom;
  }

  public void setI_tipnom(String i_tipnom) {
    this.i_tipnom = i_tipnom;
  }
    
}