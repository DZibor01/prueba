package com.cm.solidappservice.model.ahorros.response;

public class ResponseTipoAhorroDisponibleDeprecated {
		
	private String k_tipodr;
	private String n_tipodr;
	private Double v_cuota_min;
	private Double v_cuota_max;
	private int v_plazo_min;
	private int v_plazo_max;
	private String i_fecha;
	private String i_observ;
	private String f_vigenci_fin;
	private String i_activo;
	private String[] descripciones;
	
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
	public ResponseTipoAhorroDisponibleDeprecated(){}
	
//	public TipoAhorroDisponible(String _k_tipodr, String _n_tipodr, 
//			Double _v_cuota_minima, Double _v_cuota_maxima, 
//			int _v_plazo_minimo, int _v_plazo_maximo,
//			String _i_fecha, 
//			String _i_observ,
//			Date _f_vigenci_fin,
//			String[] _descripciones){
//		setK_tipodr(_k_tipodr);
//		setN_tipodr(_n_tipodr);
//		setV_cuota_minima(_v_cuota_minima);
//		setV_cuota_maxima(_v_cuota_maxima);
//		setV_plazo_max(_v_plazo_maximo);
//		setV_plazo_min(_v_plazo_minimo);
//		setI_fecha(_i_fecha);
//		setI_observ(_i_observ);
//		setF_vigenci_fin(_f_vigenci_fin);
//		setDescripciones(_descripciones);
//	}
	
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
	public void setV_cuota_minima(Double v_cuota_min) {
		this.v_cuota_min = v_cuota_min;
	}
	public Double getV_cuota_maxima() {
		return v_cuota_max;
	}
	public void setV_cuota_maxima(Double v_cuota_max) {
		this.v_cuota_max = v_cuota_max;
	}
	public int getV_plazo_min() {
		return v_plazo_min;
	}
	public void setV_plazo_min(int v_plazo_minimo) {
		this.v_plazo_min = v_plazo_minimo;
	}
	public int getV_plazo_max() {
		return v_plazo_max;
	}
	public void setV_plazo_max(int v_plazo_maximo) {
		this.v_plazo_max = v_plazo_maximo;
	}

	public String[] getDescripciones() {
		return descripciones;
	}

	public void setDescripciones(String[] descripciones) {
		this.descripciones = descripciones;
	}

	public String getF_vigenci_fin() {
		return f_vigenci_fin;
	}

	public void setF_vigenci_fin(String f_vigenci_fin) {
		this.f_vigenci_fin = f_vigenci_fin;
	}

	public String getI_activo() {
		return i_activo;
	}

	public void setI_activo(String i_activo) {
		this.i_activo = i_activo;
	}
}