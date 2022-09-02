package com.cm.solidappservice.model.transferencias.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestCuentasDisponiblesDeprecated extends RequestAutenticacion {
	
	private String cedulaConsulta;

	public String getCedulaConsulta() {
		return cedulaConsulta;
	}

	public void setCedulaConsulta(String cedulaConsulta) {
		this.cedulaConsulta = cedulaConsulta;
	}
}
