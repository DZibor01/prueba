package com.cm.solidappservice.model.ahorros.bd;

import java.util.Date;

/*
**TAB_APPAHOP
*/
public class TipoAhorroMD {

	private String k_tipodr; //codigo del producto
	private String n_tipodr; //nombre del ahorro
	private Double v_cuota_min; //cuota minima
	private Double v_cuota_max; //cuota Maxima
	private int v_plazo_min; //plazo minimo
	private int v_plazo_max; //plazo maximo
	private String i_fecha; //requiere fecha
	private String i_observ; //Requiere observaciones
	private Date f_vigenci_fin; //fecha vigencia
	private String i_activo; //activo
	private String[] descripciones;
	
	public TipoAhorroMD(){}
	
	public TipoAhorroMD(String k_tipodr, String n_tipodr, Double v_cuota_min, Double v_cuota_max,
			int v_plazo_min, int v_plazo_max, String i_fecha, String i_observ, Date f_vigenci_fin, String i_activo,
			String[] descripciones) {
		this.k_tipodr = k_tipodr;
		this.n_tipodr = n_tipodr;
		this.v_cuota_min = v_cuota_min;
		this.v_cuota_max = v_cuota_max;
		this.v_plazo_min = v_plazo_min;
		this.v_plazo_max = v_plazo_max;
		this.i_fecha = i_fecha;
		this.i_observ = i_observ;
		this.f_vigenci_fin = f_vigenci_fin;
		this.i_activo = i_activo;
		this.descripciones = descripciones;
	}

	public String getK_tipodr() {
		return k_tipodr;
	}

	public void setK_tipodr(String k_tipodr) {
		this.k_tipodr = k_tipodr;
	}

	public String getN_tipodr() {
		return n_tipodr;
	}

	public void setN_tipodr(String n_tipodr) {
		this.n_tipodr = n_tipodr;
	}

	public Double getV_cuota_min() {
		return v_cuota_min;
	}

	public void setV_cuota_min(Double v_cuota_min) {
		this.v_cuota_min = v_cuota_min;
	}

	public Double getV_cuota_max() {
		return v_cuota_max;
	}

	public void setV_cuota_max(Double v_cuota_max) {
		this.v_cuota_max = v_cuota_max;
	}

	public int getV_plazo_min() {
		return v_plazo_min;
	}

	public void setV_plazo_min(int v_plazo_min) {
		this.v_plazo_min = v_plazo_min;
	}

	public int getV_plazo_max() {
		return v_plazo_max;
	}

	public void setV_plazo_max(int v_plazo_max) {
		this.v_plazo_max = v_plazo_max;
	}

	public String getI_fecha() {
		return i_fecha;
	}

	public void setI_fecha(String i_fecha) {
		this.i_fecha = i_fecha;
	}

	public String getI_observ() {
		return i_observ;
	}

	public void setI_observ(String i_observ) {
		this.i_observ = i_observ;
	}

	public Date getF_vigenci_fin() {
		return f_vigenci_fin;
	}

	public void setF_vigenci_fin(Date f_vigenci_fin) {
		this.f_vigenci_fin = f_vigenci_fin;
	}

	public String getI_activo() {
		return i_activo;
	}

	public void setI_activo(String i_activo) {
		this.i_activo = i_activo;
	}

	public String[] getDescripciones() {
		return descripciones;
	}

	public void setDescripciones(String[] descripciones) {
		this.descripciones = descripciones;
	}

	
	
}