package com.cm.solidappservice.model.adelantonomina.response;

import java.util.Date;

public class ResponseProcesarSolicitudAdelanto {
    
    private Integer idFlujo; // v_k_flujo
    private Date fechaSolicitud; // f_solici
    private Integer valorFinalSolicitado; // v_solici
    private Integer anio; // k_ano
    private String idSucursal; // k_sucurs
    private String idMovimiento; // k_numdoc
    private String tipoMovimiento; // k_tipdoc
    private Date fechaPrimeraCuota; // f_primera
    private String codigoProducto; // a_tipodr
    private String numeroProducto; // a_obliga
    private String resultado; // n_resultado
    private String error; // n_error

    public ResponseProcesarSolicitudAdelanto(){}
    
    public ResponseProcesarSolicitudAdelanto(Integer idFlujo, Date fechaSolicitud, Integer valorFinalSolicitado,
			Integer anio, String idSucursal, String idMovimiento, String tipoMovimiento, Date fechaPrimeraCuota,
			String codigoProducto, String numeroProducto, String resultado, String error) {
		super();
		this.idFlujo = idFlujo;
		this.fechaSolicitud = fechaSolicitud;
		this.valorFinalSolicitado = valorFinalSolicitado;
		this.anio = anio;
		this.idSucursal = idSucursal;
		this.idMovimiento = idMovimiento;
		this.tipoMovimiento = tipoMovimiento;
		this.fechaPrimeraCuota = fechaPrimeraCuota;
		this.codigoProducto = codigoProducto;
		this.numeroProducto = numeroProducto;
		this.resultado = resultado;
		this.error = error;
	}

	public Integer getIdFlujo() {
        return this.idFlujo;
    }

    public void setIdFlujo(Integer idFlujo) {
        this.idFlujo = idFlujo;
    }

    public Date getFechaSolicitud() {
        return this.fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Integer getValorFinalSolicitado() {
        return this.valorFinalSolicitado;
    }

    public void setValorFinalSolicitado(Integer valorFinalSolicitado) {
        this.valorFinalSolicitado = valorFinalSolicitado;
    }

    public Integer getAnio() {
        return this.anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getIdSucursal() {
        return this.idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getIdMovimiento() {
        return this.idMovimiento;
    }

    public void setIdMovimiento(String idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getTipoMovimiento() {
        return this.tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFechaPrimeraCuota() {
        return this.fechaPrimeraCuota;
    }

    public void setFechaPrimeraCuota(Date fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNumeroProducto() {
        return this.numeroProducto;
    }

    public void setNumeroProducto(String numeroProducto) {
        this.numeroProducto = numeroProducto;
    }

    public String getResultado() {
        return this.resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
