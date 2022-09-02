package com.cm.solidappservice.model.creditos.request;

import java.util.List;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestReferenciaCreditoDeprecated2 extends RequestAutenticacion{
    
	String idRadicado; //k_solicitud
	private List<ReferenciaCredito> referencias; //TAB_APPREFSOLICRED
		
	public RequestReferenciaCreditoDeprecated2() {}

	public RequestReferenciaCreditoDeprecated2(String idRadicado, List<ReferenciaCredito> referencias) {
		this.idRadicado = idRadicado;
		this.referencias = referencias;
	}

	public String getIdRadicado() {
		return idRadicado;
	}

	public void setIdRadicado(String idRadicado) {
		this.idRadicado = idRadicado;
	}

	public List<ReferenciaCredito> getReferencias() {
		return referencias;
	}

	public void setReferencias(List<ReferenciaCredito> referencias) {
		this.referencias = referencias;
	}
	
}
