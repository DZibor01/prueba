package com.cm.solidappservice.model.base;

public class BaseRequest {
	
	private String cedula;
		
	public BaseRequest() {
	}

	public BaseRequest(String cedula) {
		this.cedula = cedula;
	}

	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}