package com.cm.solidappservice.model.login.request;

import com.cm.solidappservice.model.base.BaseRequest;

public class RequestLogin extends BaseRequest {
	
	private String clave;
	private String origen;
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}	
	
}