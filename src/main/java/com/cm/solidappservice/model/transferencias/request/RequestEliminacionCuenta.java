package com.cm.solidappservice.model.transferencias.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestEliminacionCuenta extends RequestAutenticacion {
	
	private String cedulaInscrita;
	private String numeroCuenta;
	
	public RequestEliminacionCuenta() {
	}
	
	public RequestEliminacionCuenta(String cedulaInscrita, String numeroCuenta) {
		this.cedulaInscrita = cedulaInscrita;
		this.numeroCuenta = numeroCuenta;
	}

	public String getCedulaInscrita() {
		return cedulaInscrita;
	}
	public void setCedulaInscrita(String cedulaInscrita) {
		this.cedulaInscrita = cedulaInscrita;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
}