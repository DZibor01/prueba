package com.cm.solidappservice.model.transferencias.response;

import java.util.Date;

public class ResponseTransferenciasIncompletas {
 
    private String idDispositivo; // id_dispositivo
    private long idAsociadoOrigen; // k_idterc
    private String cedulaOrigen; // aanumnit_o
    private String cuentaOrigen; // a_numdoc
    private long idAsociadoDestino; // k_idterc_tit
    private String cuentaDestino; // n_numcta
    private Double valorTransferencia; // v_valor
    private String observacion; // n_observ
    private Date fechaSolicitud; // f_solici

    public ResponseTransferenciasIncompletas(){}

    
    public ResponseTransferenciasIncompletas(String idDispositivo, long idAsociadoOrigen, String cedulaOrigen,
			String cuentaOrigen, long idAsociadoDestino, String cuentaDestino, Double valorTransferencia,
			String observacion, Date fechaSolicitud) {
		super();
		this.idDispositivo = idDispositivo;
		this.idAsociadoOrigen = idAsociadoOrigen;
		this.cedulaOrigen = cedulaOrigen;
		this.cuentaOrigen = cuentaOrigen;
		this.idAsociadoDestino = idAsociadoDestino;
		this.cuentaDestino = cuentaDestino;
		this.valorTransferencia = valorTransferencia;
		this.observacion = observacion;
		this.fechaSolicitud = fechaSolicitud;
	}

    public String getIdDispositivo() {
        return this.idDispositivo;
    }

    public void setIdDispositivo(String idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public long getIdAsociadoOrigen() {
        return this.idAsociadoOrigen;
    }

    public void setIdAsociadoOrigen(long idAsociadoOrigen) {
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

    public long getIdAsociadoDestino() {
        return this.idAsociadoDestino;
    }

    public void setIdAsociadoDestino(long idAsociadoDestino) {
        this.idAsociadoDestino = idAsociadoDestino;
    }

    public String getCuentaDestino() {
        return this.cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Double getValorTransferencia() {
        return this.valorTransferencia;
    }

    public void setValorTransferencia(Double valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaSolicitud() {
        return this.fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

}
