package com.cm.solidappservice.model.diverseinfo.response;

public class ResponseMensajesBanner {

	private int idMensaje; //k_idmens
	private String mensaje; //n_mensaje

	public ResponseMensajesBanner() {
	}

	public ResponseMensajesBanner(int idMensaje, String mensaje) {
		this.idMensaje = idMensaje;
		this.mensaje = mensaje;
	}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
