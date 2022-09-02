package com.cm.solidappservice.model.creditos.response;

public class ResponseUbicacionesDeprecated {

	private String k_ciudad;
  private String n_ciudad;
  private String k_depart;
  private String n_depart;
  private String k_pais;
  private String n_pais;

  public ResponseUbicacionesDeprecated() {}
  
  public ResponseUbicacionesDeprecated(String k_ciudad, String n_ciudad, String k_depart, String n_depart, String k_pais, String n_pais) {
    this.k_ciudad = k_ciudad;
    this.n_ciudad = n_ciudad;
    this.k_depart = k_depart;
    this.n_depart = n_depart;
    this.k_pais = k_pais;
    this.n_pais = n_pais;
  }

  public String getK_ciudad() {
    return this.k_ciudad;
  }

  public void setK_ciudad(String k_ciudad) {
    this.k_ciudad = k_ciudad;
  }

  public String getN_ciudad() {
    return this.n_ciudad;
  }

  public void setN_ciudad(String n_ciudad) {
    this.n_ciudad = n_ciudad;
  }

  public String getK_depart() {
    return this.k_depart;
  }

  public void setK_depart(String k_depart) {
    this.k_depart = k_depart;
  }

  public String getN_depart() {
    return this.n_depart;
  }

  public void setN_depart(String n_depart) {
    this.n_depart = n_depart;
  }

  public String getK_pais() {
    return this.k_pais;
  }

  public void setK_pais(String k_pais) {
    this.k_pais = k_pais;
  }

  public String getN_pais() {
    return this.n_pais;
  }

  public void setN_pais(String n_pais) {
    this.n_pais = n_pais;
  }

}
