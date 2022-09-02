package com.cm.solidappservice.model.diverseinfo.response;


public class ResponseMenuMasServicios {

  private Integer idServicio; //k_servicio
  private String nombreServicio; //n_servicio
  private String urlIcono;  //n_url_icono
  private String urlEnlace; //n_url_enlace
  private String estado; //i_estado
  private Integer order; //q_orden
  
  public ResponseMenuMasServicios() {}

  public ResponseMenuMasServicios(Integer idServicio, String nombreServicio, String urlIcono, String urlEnlace,
      String estado, Integer order) {
    this.idServicio = idServicio;
    this.nombreServicio = nombreServicio;
    this.urlIcono = urlIcono;
    this.urlEnlace = urlEnlace;
    this.estado = estado;
    this.order = order;
  }

  public Integer getIdServicio() {
    return idServicio;
  }

  public void setIdServicio(Integer idServicio) {
    this.idServicio = idServicio;
  }

  public String getNombreServicio() {
    return nombreServicio;
  }

  public void setNombreServicio(String nombreServicio) {
    this.nombreServicio = nombreServicio;
  }

  public String getUrlIcono() {
    return urlIcono;
  }

  public void setUrlIcono(String urlIcono) {
    this.urlIcono = urlIcono;
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

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }
    
}