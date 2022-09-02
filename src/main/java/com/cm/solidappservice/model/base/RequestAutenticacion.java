package com.cm.solidappservice.model.base;

public class RequestAutenticacion extends BaseRequest {
	
	private String token;
	
	public RequestAutenticacion() {
	}

	public RequestAutenticacion(String cedula, String token) {
		super();
		this.setCedula(cedula);
		this.token = token;
	}

	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
}