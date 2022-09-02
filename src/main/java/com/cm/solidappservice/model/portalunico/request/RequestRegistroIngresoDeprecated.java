package com.cm.solidappservice.model.portalunico.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestRegistroIngresoDeprecated extends RequestAutenticacion{

	private String aanumnit;
	private String i_aceptacion;
	private String f_login;

	public RequestRegistroIngresoDeprecated() {}
  
	public RequestRegistroIngresoDeprecated(String aanumnit, String i_aceptacion, String f_login) {
	  this.aanumnit = aanumnit;
	  this.i_aceptacion = i_aceptacion;
	  this.f_login = f_login;
	}

	public String getAanumnit() {
		return aanumnit;
	}
	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}

	public String getI_aceptacion() {
		return i_aceptacion;
	}
	public void setI_aceptacion(String i_aceptacion) {
		this.i_aceptacion = i_aceptacion;
	}

	public String getF_login() {
		return f_login;
	}
	public void setF_login(String f_login) {
		this.f_login = f_login;
	}
	
}