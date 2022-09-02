package com.cm.solidappservice.model.portalunico.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestRegistroVotaciones extends RequestAutenticacion {

	private String fechaIngreso;

	public RequestRegistroVotaciones() {
	}

	public RequestRegistroVotaciones(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}