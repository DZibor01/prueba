package com.cm.solidappservice.model.tyc.response;

public class ResponseTyCAceptadosDeprecated{
	
	private String k_aceptacion;
	private String aanumnit;
	private Integer k_termycond;
	private String f_aceptacion;
	private String i_aceptacion;
	private String ip;
	
	public ResponseTyCAceptadosDeprecated() {
	}

	public ResponseTyCAceptadosDeprecated(String k_aceptacion, String aanumnit, Integer k_termycond, String f_aceptacion,
			String i_aceptacion, String ip) {
		this.k_aceptacion = k_aceptacion;
		this.aanumnit = aanumnit;
		this.k_termycond = k_termycond;
		this.f_aceptacion = f_aceptacion;
		this.i_aceptacion = i_aceptacion;
		this.ip = ip;
	}

	public String getK_aceptacion() {
		return k_aceptacion;
	}
	public void setK_aceptacion(String k_aceptacion) {
		this.k_aceptacion = k_aceptacion;
	}

	public String getAanumnit() {
		return aanumnit;
	}
	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}

	public Integer getK_termycond() {
		return k_termycond;
	}
	public void setK_termycond(Integer k_termycond) {
		this.k_termycond = k_termycond;
	}

	public String getF_aceptacion() {
		return f_aceptacion;
	}
	public void setF_aceptacion(String f_aceptacion) {
		this.f_aceptacion = f_aceptacion;
	}

	public String getI_aceptacion() {
		return i_aceptacion;
	}
	public void setI_aceptacion(String i_aceptacion) {
		this.i_aceptacion = i_aceptacion;
	}

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}