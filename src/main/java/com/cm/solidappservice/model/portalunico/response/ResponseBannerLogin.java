package com.cm.solidappservice.model.portalunico.response;

public class ResponseBannerLogin {

  private Integer idBanner; //k_banner
  private String nombreBanner; //n_banner
  private String urlImagen; //n_url_imagen
  private String urlEnlace; //n_url_enlace
  private String estado; //i_estado
  
  public ResponseBannerLogin() {}

  public ResponseBannerLogin(Integer idBanner, String nombreBanner, String urlImagen, String urlEnlace,
      String estado) {
    this.idBanner = idBanner;
    this.nombreBanner = nombreBanner;
    this.urlImagen = urlImagen;
    this.urlEnlace = urlEnlace;
    this.estado = estado;
  }

  public Integer getIdBanner() {
    return idBanner;
  }

  public void setIdBanner(Integer idBanner) {
    this.idBanner = idBanner;
  }

  public String getNombreBanner() {
    return nombreBanner;
  }

  public void setNombreBanner(String nombreBanner) {
    this.nombreBanner = nombreBanner;
  }

  public String getUrlImagen() {
    return urlImagen;
  }

  public void setUrlImagen(String urlImagen) {
    this.urlImagen = urlImagen;
  }

  public String getUrlEnlace() {
    return urlEnlace;
  }

  public void setUrlEnlace(String urlEnlace) {
    this.urlEnlace = urlEnlace;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
  
}