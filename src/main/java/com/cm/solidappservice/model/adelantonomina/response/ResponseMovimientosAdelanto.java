package com.cm.solidappservice.model.adelantonomina.response;

public class ResponseMovimientosAdelanto {
    
    private String idTransaccion; // k_transa
    private String fechaSolicitud; // f_solictud
    private Integer valorSolicitado; // v_solicitado
    private Integer valorFinalSolicitado; // v_valorcre
    private String estado; // i_estado
    private Integer cupoTotal; // v_cupo
    private Integer idFlujo; // k_flujo
    private String idMovimiento; // k_numdoc
    private String codigoProducto; // k_tipodr
    private String fechaPrimeraCuota; // f_primcuota
    private String aceptaTerminos; // i_aceptacion
    private String fechaAceptacion; // f_aceptacion
    private String ip; // ip
    private String error; //n_error

    public ResponseMovimientosAdelanto(){}
    
    public ResponseMovimientosAdelanto(String idTransaccion, String fechaSolicitud, Integer valorSolicitado,
    Integer valorFinalSolicitado, String estado, Integer cupoTotal, Integer idFlujo, String idMovimiento,
			String codigoProducto, String fechaPrimeraCuota, String aceptaTerminos, String fechaAceptacion, String ip,
			String error) {
		super();
		this.idTransaccion = idTransaccion;
		this.fechaSolicitud = fechaSolicitud;
		this.valorSolicitado = valorSolicitado;
		this.valorFinalSolicitado = valorFinalSolicitado;
		this.estado = estado;
		this.cupoTotal = cupoTotal;
		this.idFlujo = idFlujo;
		this.idMovimiento = idMovimiento;
		this.codigoProducto = codigoProducto;
		this.fechaPrimeraCuota = fechaPrimeraCuota;
		this.aceptaTerminos = aceptaTerminos;
		this.fechaAceptacion = fechaAceptacion;
		this.ip = ip;
		this.error = error;
	}

	public String getIdTransaccion() {
        return this.idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFechaSolicitud() {
        return this.fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Integer getValorSolicitado() {
        return this.valorSolicitado;
    }

    public void setValorSolicitado(Integer valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public Integer getValorFinalSolicitado() {
        return this.valorFinalSolicitado;
    }

    public void setValorFinalSolicitado(Integer valorFinalSolicitado) {
        this.valorFinalSolicitado = valorFinalSolicitado;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCupoTotal() {
        return this.cupoTotal;
    }

    public void setCupoTotal(Integer cupoTotal) {
        this.cupoTotal = cupoTotal;
    }

    public Integer getIdFlujo() {
        return this.idFlujo;
    }

    public void setIdFlujo(Integer idFlujo) {
        this.idFlujo = idFlujo;
    }

    public String getIdMovimiento() {
        return this.idMovimiento;
    }

    public void setIdMovimiento(String idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getFechaPrimeraCuota() {
        return this.fechaPrimeraCuota;
    }

    public void setFechaPrimeraCuota(String fechaPrimeraCuota) {
        this.fechaPrimeraCuota = fechaPrimeraCuota;
    }

    public String getAceptaTerminos() {
        return this.aceptaTerminos;
    }

    public void setAceptaTerminos(String aceptaTerminos) {
        this.aceptaTerminos = aceptaTerminos;
    }

    public String getFechaAceptacion() {
        return this.fechaAceptacion;
    }

    public void setFechaAceptacion(String fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
