package com.cm.solidappservice.model.obligaciones.response;

public class ResponsePagosObligaciones{
	
	private String idDispositivo; // id_dispositivo
	private String fechaMovimiento; // f_movimi
	private String numeroProducto; // a_numdoc
	private String nombreProducto; // n_produc
	private String nombreCuenta; // n_tipodr
	private String numeroCuenta; // a_numcta
	private String codigoProducto; // a_tipodr
	private String clasificacionProducto; // k_tipodr
	private Double valorPago; //v_valor

	public ResponsePagosObligaciones(){}

	public ResponsePagosObligaciones(String idDispositivo, String fechaMovimiento, String numeroProducto, String nombreProducto,
			String nombreCuenta, String numeroCuenta, String codigoProducto, String clasificacionProducto,
			Double valorPago) {
		this.idDispositivo = idDispositivo;
		this.fechaMovimiento = fechaMovimiento;
		this.numeroProducto = numeroProducto;
		this.nombreProducto = nombreProducto;
		this.nombreCuenta = nombreCuenta;
		this.numeroCuenta = numeroCuenta;
		this.codigoProducto = codigoProducto;
		this.clasificacionProducto = clasificacionProducto;
		this.valorPago = valorPago;
	}



	public String getIdDispositivo() {
		return this.idDispositivo;
	}

	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	public String getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(String fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getNumeroProducto() {
		return this.numeroProducto;
	}

	public void setNumeroProducto(String numeroProducto) {
		this.numeroProducto = numeroProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreCuenta() {
		return this.nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public String getNumeroCuenta() {
		return this.numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getCodigoProducto() {
		return this.codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getClasificacionProducto() {
		return this.clasificacionProducto;
	}

	public void setClasificacionProducto(String clasificacionProducto) {
		this.clasificacionProducto = clasificacionProducto;
	}

	public Double getValorPago() {
		return this.valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

}