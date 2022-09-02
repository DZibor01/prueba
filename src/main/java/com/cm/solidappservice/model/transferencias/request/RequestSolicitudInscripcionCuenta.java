package com.cm.solidappservice.model.transferencias.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestSolicitudInscripcionCuenta extends RequestAutenticacion {
	
	private String idDispositivo;
	private String tipoCuenta;
	private String codigoBanco;
	private String numeroCuenta;
	private String cedulaInscripcion;
	private String nombreCuenta;
	
	public String getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public String getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getCedulaInscripcion() {
		return cedulaInscripcion;
	}
	public void setCedulaInscripcion(String cedulaInscripcion) {
		this.cedulaInscripcion = cedulaInscripcion;
	}
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
}