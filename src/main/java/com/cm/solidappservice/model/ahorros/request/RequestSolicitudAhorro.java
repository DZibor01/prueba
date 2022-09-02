package com.cm.solidappservice.model.ahorros.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestSolicitudAhorro extends RequestAutenticacion {
	
	private String clasificacionProducto; //k_tipodr
	private double valorCuota; //v_cuota
	private int valorPlazo; //v_plazo
	private String fechaVigenciaFin; //f_vigenci_fin
	private String destino; //n_destin
	private String idDispositivo; //id_dispositivo

	public RequestSolicitudAhorro() {
	}

	public RequestSolicitudAhorro(String clasificacionProducto, double valorCuota, int valorPlazo,
			String fechaVigenciaFin, String destino, String idDispositivo) {
		this.clasificacionProducto = clasificacionProducto;
		this.valorCuota = valorCuota;
		this.valorPlazo = valorPlazo;
		this.fechaVigenciaFin = fechaVigenciaFin;
		this.destino = destino;
		this.idDispositivo = idDispositivo;
	}

	public String getClasificacionProducto() {
		return clasificacionProducto;
	}
	public void setClasificacionProducto(String clasificacionProducto) {
		this.clasificacionProducto = clasificacionProducto;
	}
	public double getValorCuota() {
		return valorCuota;
	}
	public void setValorCuota(double valorCuota) {
		this.valorCuota = valorCuota;
	}
	public int getValorPlazo() {
		return valorPlazo;
	}
	public void setValorPlazo(int valorPlazo) {
		this.valorPlazo = valorPlazo;
	}
	public String getFechaVigenciaFin() {
		return fechaVigenciaFin;
	}
	public void setFechaVigenciaFin(String fechaVigenciaFin) {
		this.fechaVigenciaFin = fechaVigenciaFin;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	
	
	
}