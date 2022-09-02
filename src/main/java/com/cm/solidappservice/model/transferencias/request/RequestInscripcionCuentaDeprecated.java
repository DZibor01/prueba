package com.cm.solidappservice.model.transferencias.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestInscripcionCuentaDeprecated extends RequestAutenticacion {
	private String cedulaInscripcion;
	private String cuentaInscripcion;
	
	public String getCedulaInscripcion() {
		return cedulaInscripcion;
	}
	public void setCedulaInscripcion(String cedulaInscripcion) {
		this.cedulaInscripcion = cedulaInscripcion;
	}
	public String getCuentaInscripcion() {
		return cuentaInscripcion;
	}
	public void setCuentaInscripcion(String cuentaInscripcion) {
		this.cuentaInscripcion = cuentaInscripcion;
	}
}