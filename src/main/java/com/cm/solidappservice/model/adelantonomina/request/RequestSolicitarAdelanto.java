package com.cm.solidappservice.model.adelantonomina.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestSolicitarAdelanto extends RequestAutenticacion{
    
    //Paquete
    private String fechaSolicitud; // f_solici - f_solicitud
    //Tabla
    private Integer valorSolicitado; // v_solicitado
    private Integer valorFinalSolicitado; // v_valorcre, v_monto(Paquete)
    private Integer cupoTotal; // v_cupo
    private String estado; // i_estado,
    // private String error; // n_error
    // private Integer idFlujo; // k_flujo
    private String aceptaTerminos; // i_aceptacion
    private String fechaAceptacion; // f_aceptacion
    private String ip; // ip

    public RequestSolicitarAdelanto(){}
    
    public RequestSolicitarAdelanto(String fechaSolicitud) {
		super();
		this.fechaSolicitud = fechaSolicitud;
	}

	public RequestSolicitarAdelanto(String fechaSolicitud, Integer valorSolicitado,
			Integer valorFinalSolicitado, Integer cupoTotal, String estado, String aceptaTerminos,
			String fechaAceptacion, String ip) {
		super();
		this.fechaSolicitud = fechaSolicitud;
		this.valorSolicitado = valorSolicitado;
		this.valorFinalSolicitado = valorFinalSolicitado;
		this.cupoTotal = cupoTotal;
		this.estado = estado;
		this.aceptaTerminos = aceptaTerminos;
		this.fechaAceptacion = fechaAceptacion;
		this.ip = ip;
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

    public Integer getCupoTotal() {
        return this.cupoTotal;
    }

    public void setCupoTotal(Integer cupoTotal) {
        this.cupoTotal = cupoTotal;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

}
