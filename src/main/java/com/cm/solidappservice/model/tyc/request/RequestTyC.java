package com.cm.solidappservice.model.tyc.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestTyC extends RequestAutenticacion{
	
	private String idAceptacion; //k_aceptacion
	private String cedula; ///aanumnit
	private Integer idTyc; //k_termycond
	private String fechaAceptacion; //f_aceptacion
	private String aceptaTyC; //i_aceptacion
	private String ip;

	public RequestTyC() {
	}

	public RequestTyC(String idAceptacion, String cedula, Integer idTyc, String fechaAceptacion, String aceptaTyC,
			String ip) {
		this.idAceptacion = idAceptacion;
		this.cedula = cedula;
		this.idTyc = idTyc;
		this.fechaAceptacion = fechaAceptacion;
		this.aceptaTyC = aceptaTyC;
		this.ip = ip;
	}

	public String getIdAceptacion() {
		return idAceptacion;
	}

	public void setIdAceptacion(String idAceptacion) {
		this.idAceptacion = idAceptacion;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Integer getIdTyc() {
		return idTyc;
	}

	public void setIdTyc(Integer idTyc) {
		this.idTyc = idTyc;
	}

	public String getFechaAceptacion() {
		return fechaAceptacion;
	}

	public void setFechaAceptacion(String fechaAceptacion) {
		this.fechaAceptacion = fechaAceptacion;
	}

	public String getAceptaTyC() {
		return aceptaTyC;
	}

	public void setAceptaTyC(String aceptaTyC) {
		this.aceptaTyC = aceptaTyC;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}