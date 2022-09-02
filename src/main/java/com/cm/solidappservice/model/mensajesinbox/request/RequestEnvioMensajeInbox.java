package com.cm.solidappservice.model.mensajesinbox.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestEnvioMensajeInbox extends RequestAutenticacion{
	
	private String fechaInicio; //f_inicio
	private String fechaFinal; //f_final
	private String contenidoMensaje; //n_mensaj
	private String tipoContenido; //n_tipo
	
	public RequestEnvioMensajeInbox() {
	}

	public RequestEnvioMensajeInbox(String fechaInicio, String fechaFinal, String contenidoMensaje,
			String tipoContenido) {
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.contenidoMensaje = contenidoMensaje;
		this.tipoContenido = tipoContenido;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getContenidoMensaje() {
		return contenidoMensaje;
	}

	public void setContenidoMensaje(String contenidoMensaje) {
		this.contenidoMensaje = contenidoMensaje;
	}

	public String getTipoContenido() {
		return tipoContenido;
	}

	public void setTipoContenido(String tipoContenido) {
		this.tipoContenido = tipoContenido;
	}

	

}