package com.cm.solidappservice.model.centrosvacacionales.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestSolicitudCentroVacacional extends RequestAutenticacion {
	public String getAsociadoViaja() {
		return asociadoViaja;
	}
	public void setAsociadoViaja(String asociadoViaja) {
		this.asociadoViaja = asociadoViaja;
	}
	public int getNumeroAdultos() {
		return numeroAdultos;
	}
	public void setNumeroAdultos(int numeroAdultos) {
		this.numeroAdultos = numeroAdultos;
	}
	public int getNumeroNinos() {
		return numeroNinos;
	}
	public void setNumeroNinos(int numeroNinos) {
		this.numeroNinos = numeroNinos;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigoPerfil() {
		return codigoPerfil;
	}
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	public int getNumeroDias() {
		return numeroDias;
	}
	public void setNumeroDias(int numeroDias) {
		this.numeroDias = numeroDias;
	}
	public String getEmailContacto() {
		return emailContacto;
	}
	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}
	private String asociadoViaja;
	private int numeroAdultos;
	private int numeroNinos;
	private String codigo;
	private String codigoPerfil;
	private String fecha;
	private int numeroDias;
	private String observaciones;
	private String idDispositivo;
	private String emailContacto;
}