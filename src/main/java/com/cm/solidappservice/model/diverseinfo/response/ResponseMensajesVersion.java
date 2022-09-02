package com.cm.solidappservice.model.diverseinfo.response;

import java.util.List;

import com.cm.solidappservice.model.diverseinfo.bd.MensajesBannerMD;

public class ResponseMensajesVersion {
	
	private  List<MensajesBannerMD> mensajes;
	private String Version;
	
	public List<MensajesBannerMD> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajesBannerMD> mensajes) {
		this.mensajes = mensajes;
	}

	public String getVersion() {
		return Version;
	}	
	
	public void setVersion(String version) {
		Version = version;
	}
	
}
