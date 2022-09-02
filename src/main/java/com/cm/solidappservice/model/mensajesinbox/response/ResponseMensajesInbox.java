package com.cm.solidappservice.model.mensajesinbox.response;

public class ResponseMensajesInbox {

	private String idMensaje; //k_proces
	private String titulo; //n_tipo
	private String contenido; //n_mensaj
	private String leido; //i_leido
	
	public ResponseMensajesInbox() {
	}

	public ResponseMensajesInbox(String idMensaje, String titulo, String contenido, String leido) {
		this.idMensaje = idMensaje;
		this.titulo = titulo;
		this.contenido = contenido;
		this.leido = leido;
	}

	public String getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getLeido() {
		return leido;
	}

	public void setLeido(String leido) {
		this.leido = leido;
	}
}