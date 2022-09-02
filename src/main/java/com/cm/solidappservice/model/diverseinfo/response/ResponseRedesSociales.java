package com.cm.solidappservice.model.diverseinfo.response;

public class ResponseRedesSociales {

	private Integer idRedSocial;
	private String nombreRedSocial;
	private String linkRedSocial; 

	public ResponseRedesSociales() {
	}

	public ResponseRedesSociales(Integer idRedSocial, String nombreRedSocial, String linkRedSocial) {
		this.idRedSocial = idRedSocial;
		this.nombreRedSocial = nombreRedSocial;
		this.linkRedSocial = linkRedSocial;
	}

	public Integer getIdRedSocial() {
		return idRedSocial;
	}

	public void setIdRedSocial(Integer idRedSocial) {
		this.idRedSocial = idRedSocial;
	}

	public String getNombreRedSocial() {
		return nombreRedSocial;
	}

	public void setNombreRedSocial(String nombreRedSocial) {
		this.nombreRedSocial = nombreRedSocial;
	}

	public String getLinkRedSocial() {
		return linkRedSocial;
	}

	public void setLinkRedSocial(String linkRedSocial) {
		this.linkRedSocial = linkRedSocial;
	}

	
}
