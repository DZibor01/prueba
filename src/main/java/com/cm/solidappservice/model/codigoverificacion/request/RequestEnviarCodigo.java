package com.cm.solidappservice.model.codigoverificacion.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestEnviarCodigo extends RequestAutenticacion{
    
	private Integer tipoEnvio;
	private Integer tipoCodigo;
    private String celular;
    private String correo;

    public RequestEnviarCodigo(){}

	public RequestEnviarCodigo(Integer tipoEnvio, Integer tipoCodigo, String celular, String correo) {
		super();
		this.tipoEnvio = tipoEnvio;
		this.tipoCodigo = tipoCodigo;
		this.celular = celular;
		this.correo = correo;
	}

	public Integer getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(Integer tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}    
	
	public Integer getTipoCodigo() {
		return tipoCodigo;
	}

	public void setTipoCodigo(Integer tipoCodigo) {
		this.tipoCodigo = tipoCodigo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


}
