package com.cm.solidappservice.model.mensajesinbox.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestActualizarLectura extends RequestAutenticacion {
	
	private String idMensaje;

	public RequestActualizarLectura() {
	}

	public RequestActualizarLectura(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}
}
