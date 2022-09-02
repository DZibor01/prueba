package com.cm.solidappservice.model.ahorros.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestSolicitudAhorroDeprecated extends RequestAutenticacion {
	
	private String k_tipodr;
	private double v_cuota;
	private int v_plazo;
	private String f_vigenci_fin;
	private String n_destin;
	private String id_dispositivo;
	
	public String getK_tipodr() {
		return k_tipodr;
	}
	public void setK_tipodr(String k_tipodr) {
		this.k_tipodr = k_tipodr;
	}
	public double getV_cuota() {
		return v_cuota;
	}
	public void setV_cuota(double v_cuota) {
		this.v_cuota = v_cuota;
	}
	public int getV_plazo() {
		return v_plazo;
	}
	public void setV_plazo(int v_plazo) {
		this.v_plazo = v_plazo;
	}
	public String getF_vigenci_fin() {
		return f_vigenci_fin;
	}
	public void setF_vigenci_fin(String f_vigenci_fin) {
		this.f_vigenci_fin = f_vigenci_fin;
	}
	public String getN_destin() {
		return n_destin;
	}
	public void setN_destin(String n_destin) {
		this.n_destin = n_destin;
	}
	public String getId_dispositivo() {
		return id_dispositivo;
	}
	public void setId_dispositivo(String id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}
}