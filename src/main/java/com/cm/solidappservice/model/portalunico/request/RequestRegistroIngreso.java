package com.cm.solidappservice.model.portalunico.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestRegistroIngreso extends RequestAutenticacion{

	private String aceptaTyc;
	private String fechaLogin;

	public RequestRegistroIngreso() {}

	public RequestRegistroIngreso(String aceptaTyc, String fechaLogin) {
		this.aceptaTyc = aceptaTyc;
		this.fechaLogin = fechaLogin;
	}

	public String getAceptaTyc() {
		return aceptaTyc;
	}

	public void setAceptaTyc(String aceptaTyc) {
		this.aceptaTyc = aceptaTyc;
	}

	public String getFechaLogin() {
		return fechaLogin;
	}

	public void setFechaLogin(String fechaLogin) {
		this.fechaLogin = fechaLogin;
	}
  
	
	
}