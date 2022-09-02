package com.cm.solidappservice.model.ahorros.response;

public class ResponseTipoAhorroDisponible {

	private String clasificacionProducto; //k_tipodr
	private String nombreCuenta; //n_tipodr
	private Double cuotaMinima; //v_cuota_min
	private Double cuotaMaxima; //v_cuota_max
	private int valorPlazoMinimo; //v_plazo_min
	private int valorPlazoMaximo; //v_plazo_max
	private String requiereFecha; //i_fecha
	private String requiereObservacion; //i_observ
	private String fechaFinVigencia; //f_vigenci_fin
	private String activo; //i_activo
	private String[] descripciones;

	public ResponseTipoAhorroDisponible() {
	}

	public ResponseTipoAhorroDisponible(String clasificacionProducto, String nombreCuenta, Double cuotaMinima,
			Double cuotaMaxima, int valorPlazoMinimo, int valorPlazoMaximo, String requiereFecha,
			String requiereObservacion, String fechaFinVigencia, String activo, String[] descripciones) {
		this.clasificacionProducto = clasificacionProducto;
		this.nombreCuenta = nombreCuenta;
		this.cuotaMinima = cuotaMinima;
		this.cuotaMaxima = cuotaMaxima;
		this.valorPlazoMinimo = valorPlazoMinimo;
		this.valorPlazoMaximo = valorPlazoMaximo;
		this.requiereFecha = requiereFecha;
		this.requiereObservacion = requiereObservacion;
		this.fechaFinVigencia = fechaFinVigencia;
		this.activo = activo;
		this.descripciones = descripciones;
	}

	public String getClasificacionProducto() {
		return clasificacionProducto;
	}

	public void setClasificacionProducto(String clasificacionProducto) {
		this.clasificacionProducto = clasificacionProducto;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public Double getCuotaMinima() {
		return cuotaMinima;
	}

	public void setCuotaMinima(Double cuotaMinima) {
		this.cuotaMinima = cuotaMinima;
	}

	public Double getCuotaMaxima() {
		return cuotaMaxima;
	}

	public void setCuotaMaxima(Double cuotaMaxima) {
		this.cuotaMaxima = cuotaMaxima;
	}

	public int getValorPlazoMinimo() {
		return valorPlazoMinimo;
	}

	public void setValorPlazoMinimo(int valorPlazoMinimo) {
		this.valorPlazoMinimo = valorPlazoMinimo;
	}

	public int getValorPlazoMaximo() {
		return valorPlazoMaximo;
	}

	public void setValorPlazoMaximo(int valorPlazoMaximo) {
		this.valorPlazoMaximo = valorPlazoMaximo;
	}

	public String getRequiereFecha() {
		return requiereFecha;
	}

	public void setRequiereFecha(String requiereFecha) {
		this.requiereFecha = requiereFecha;
	}

	public String getRequiereObservacion() {
		return requiereObservacion;
	}

	public void setRequiereObservacion(String requiereObservacion) {
		this.requiereObservacion = requiereObservacion;
	}

	public String getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	public void setFechaFinVigencia(String fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String[] getDescripciones() {
		return descripciones;
	}

	public void setDescripciones(String[] descripciones) {
		this.descripciones = descripciones;
	}

	
	
	
}