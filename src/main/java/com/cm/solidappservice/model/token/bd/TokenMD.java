package com.cm.solidappservice.model.token.bd;

import java.util.Date;

/**
 * TAB_APPTOKEN
 */
public class TokenMD {
	private String token;
	private String oldToken;
	private String aanumnit;
	private Date fechaGeneracion;
	private Date fechaExpiracion;
	private String i_expirado;	
	private String n_origaplic;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOldToken() {
		return oldToken;
	}
	public void setOldToken(String oldToken) {
		this.oldToken = oldToken;
	}
	public String getAanumnit() {
		return aanumnit;
	}
	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}
	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	public String getI_expirado() {
		return i_expirado;
	}
	public void setI_expirado(String i_expirado) {
		this.i_expirado = i_expirado;
	}
	public String getN_origaplic() {
		return n_origaplic;
	}
	public void setN_origaplic(String v_origaplic) {
		this.n_origaplic = v_origaplic;
	}	
	
}
