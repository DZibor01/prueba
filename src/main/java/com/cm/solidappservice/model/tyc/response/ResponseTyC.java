package com.cm.solidappservice.model.tyc.response;

import java.sql.Date;

public class ResponseTyC {
	
	private Integer idTyC; //k_termycond
	private String contenidoTyC; //n_termycond
	private Date fechaModificacion; //f_modificacion
	private String estado; //i_estado;
	
	public ResponseTyC() {
	}

	public ResponseTyC(Integer idTyC, String contenidoTyC, Date fechaModificacion, String estado) {
		this.idTyC = idTyC;
		this.contenidoTyC = contenidoTyC;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
	}

	public Integer getIdTyC() {
		return idTyC;
	}

	public void setIdTyC(Integer idTyC) {
		this.idTyC = idTyC;
	}

	public String getContenidoTyC() {
		return contenidoTyC;
	}

	public void setContenidoTyC(String contenidoTyC) {
		this.contenidoTyC = contenidoTyC;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}