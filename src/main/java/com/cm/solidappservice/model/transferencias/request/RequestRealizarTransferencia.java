package com.cm.solidappservice.model.transferencias.request;

import java.util.Date;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestRealizarTransferencia extends RequestAutenticacion {
	
	private String idDispositivo; // id_dispositivo
	private String idAsociadoOrigen; // k_idterc
	private String cedulaOrigen; // aanumnit_o
	private String cuentaOrigen; // a_numdoc
	private String idAsociadoDestino; // k_idterc_tit
	private String cuentaDestino; // n_numcta
	private Date fechaSolicitud; // f_solici
	private String valorTransferencia;  // v_valor

	public RequestRealizarTransferencia(){}

	public String getIdDispositivo() {
		return this.idDispositivo;
	}

	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getIdAsociadoOrigen() {
		return this.idAsociadoOrigen;
	}

	public void setIdAsociadoOrigen(String idAsociadoOrigen) {
		this.idAsociadoOrigen = idAsociadoOrigen;
	}

	public String getCedulaOrigen() {
		return this.cedulaOrigen;
	}

	public void setCedulaOrigen(String cedulaOrigen) {
		this.cedulaOrigen = cedulaOrigen;
	}

	public String getCuentaOrigen() {
		return this.cuentaOrigen;
	}

	public void setCuentaOrigen(String cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public String getIdAsociadoDestino() {
		return this.idAsociadoDestino;
	}

	public void setIdAsociadoDestino(String idAsociadoDestino) {
		this.idAsociadoDestino = idAsociadoDestino;
	}

	public String getCuentaDestino() {
		return this.cuentaDestino;
	}

	public void setCuentaDestino(String cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getValorTransferencia() {
		return this.valorTransferencia;
	}

	public void setValorTransferencia(String valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	} 
	
}