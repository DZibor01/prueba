package com.cm.solidappservice.model.creditos.request;


import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestReferenciaCreditoDeprecated extends RequestAutenticacion{
    
	String k_solicitud;
	String k_referencia;
	String n_nombreape;
	String t_tercel;
	String t_telfijo;
	String d_email;
	String d_direc;
	String n_ciudad;
	String k_ciudad;
	String k_depart;
		
	public RequestReferenciaCreditoDeprecated() {}
	
	public RequestReferenciaCreditoDeprecated(String k_solicitud, String k_referencia, String n_nombreape,
			String t_tercel, String t_telfijo, String d_email, String d_direc, String n_ciudad, String k_ciudad,
			String k_depart) {
		this.k_solicitud = k_solicitud;
		this.k_referencia = k_referencia;
		this.n_nombreape = n_nombreape;
		this.t_tercel = t_tercel;
		this.t_telfijo = t_telfijo;
		this.d_email = d_email;
		this.d_direc = d_direc;
		this.n_ciudad = n_ciudad;
		this.k_ciudad = k_ciudad;
		this.k_depart = k_depart;
	}

	public String getK_solicitud() {
		return k_solicitud;
	}

	public void setK_solicitud(String k_solicitud) {
		this.k_solicitud = k_solicitud;
	}

	public String getK_referencia() {
		return k_referencia;
	}

	public void setK_referencia(String k_referencia) {
		this.k_referencia = k_referencia;
	}

	public String getN_nombreape() {
		return n_nombreape;
	}

	public void setN_nombreape(String n_nombreape) {
		this.n_nombreape = n_nombreape;
	}

	public String getT_tercel() {
		return t_tercel;
	}

	public void setT_tercel(String t_tercel) {
		this.t_tercel = t_tercel;
	}

	public String getT_telfijo() {
		return t_telfijo;
	}

	public void setT_telfijo(String t_telfijo) {
		this.t_telfijo = t_telfijo;
	}

	public String getD_email() {
		return d_email;
	}

	public void setD_email(String d_email) {
		this.d_email = d_email;
	}

	public String getD_direc() {
		return d_direc;
	}

	public void setD_direc(String d_direc) {
		this.d_direc = d_direc;
	}

	public String getN_ciudad() {
		return n_ciudad;
	}

	public void setN_ciudad(String n_ciudad) {
		this.n_ciudad = n_ciudad;
	}

	public String getK_ciudad() {
		return k_ciudad;
	}

	public void setK_ciudad(String k_ciudad) {
		this.k_ciudad = k_ciudad;
	}

	public String getK_depart() {
		return k_depart;
	}

	public void setK_depart(String k_depart) {
		this.k_depart = k_depart;
	}

	
	
}
