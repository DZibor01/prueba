package com.cm.solidappservice.model.creditos.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestInformacionCreditoDeprecated2 extends RequestAutenticacion{
    
	String idRadicado; //k_solicitud
	private InformacionCredito informacionCredito; //TAB_APPINFOFSOLICRED
		
	public RequestInformacionCreditoDeprecated2() {}
	
	public RequestInformacionCreditoDeprecated2(String idRadicado, InformacionCredito informacionCredito) {
		this.idRadicado = idRadicado;
		this.informacionCredito = informacionCredito;
	}

	public String getIdRadicado() {
		return idRadicado;
	}

	public void setIdRadicado(String idRadicado) {
		this.idRadicado = idRadicado;
	}

	public InformacionCredito getInformacionCredito() {
		return informacionCredito;
	}

	public void setInformacionCredito(InformacionCredito informacionCredito) {
		this.informacionCredito = informacionCredito;
	}
	
}
