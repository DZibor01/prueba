package com.cm.solidappservice.model.ahorros.bd;

import java.util.Date;

/*
**TAB_APPSOLIAHOP
*/
public class SolicitudAhorroMD {

	private String aanumnit;
	private String k_tipodr;
	private double v_cuota;
	private int v_plazo;
	private Date f_vigenci_fin;
	private String n_destin;
	private String id_dispositivo;
	private Date f_solici;
	
	public SolicitudAhorroMD() {
	}

	public SolicitudAhorroMD(String aanumnit, String k_tipodr, double v_cuota, int v_plazo, Date f_vigenci_fin,
			String n_destin, String id_dispositivo, Date f_solici) {
		this.aanumnit = aanumnit;
		this.k_tipodr = k_tipodr;
		this.v_cuota = v_cuota;
		this.v_plazo = v_plazo;
		this.f_vigenci_fin = f_vigenci_fin;
		this.n_destin = n_destin;
		this.id_dispositivo = id_dispositivo;
		this.f_solici = f_solici;
	}

	public String getAanumnit() {
		return aanumnit;
	}

	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}

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

	public Date getF_vigenci_fin() {
		return f_vigenci_fin;
	}

	public void setF_vigenci_fin(Date f_vigenci_fin) {
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

	public Date getF_solici() {
		return f_solici;
	}

	public void setF_solici(Date f_solici) {
		this.f_solici = f_solici;
	}

}