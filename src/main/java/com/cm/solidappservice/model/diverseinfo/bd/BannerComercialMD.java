package com.cm.solidappservice.model.diverseinfo.bd;

/*
**TAB_APPBANNERS
*/
public class BannerComercialMD {

  private Integer k_banner;
  private String n_banner;
  private String n_url_imagen;
  private String n_url_enlace;
  private String i_estado;
  private String i_estadoportal;
  private String i_autenticportal;
  
  public BannerComercialMD() {}
  
  public BannerComercialMD(Integer k_banner, String n_banner, String n_url_imagen, String n_url_enlace, String i_estado, String i_estadoportal, String i_autenticportal) {
    this.k_banner = k_banner;
    this.n_banner = n_banner;
    this.n_url_imagen = n_url_imagen;
    this.n_url_enlace = n_url_enlace;
    this.i_estado = i_estado;
    this.i_estadoportal = i_estadoportal;
    this.i_autenticportal = i_autenticportal;
  }
  
  public Integer getK_banner() {
    return this.k_banner;
  }
  
  public void setK_banner(Integer k_banner) {
    this.k_banner = k_banner;
  }
  
  public String getN_banner() {
    return this.n_banner;
  }
  
  public void setN_banner(String n_banner) {
    this.n_banner = n_banner;
  }
  
  public String getN_url_imagen() {
    return this.n_url_imagen;
  }
  
  public void setN_url_imagen(String n_url_imagen) {
    this.n_url_imagen = n_url_imagen;
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

  public String getI_estadoportal() {
    return this.i_estadoportal;
  }
  
  public void setI_estadoportal(String i_estadoportal) {
    this.i_estadoportal = i_estadoportal;
  }
  
  public String getI_autenticportal() {
    return i_autenticportal;
  }

  public void setI_autenticportal(String i_autenticportal) {
    this.i_autenticportal = i_autenticportal;
  }
}