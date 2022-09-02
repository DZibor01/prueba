package com.cm.solidappservice.model.tarjetapresente.response;

public class ResponseTarjeta {

	private String nombreTarjeta; // n_percol Nombre producto-tarjeta
	private String numeroTarjeta; // k_mnumpl Número tarjeta
	private String numeroPlastico; // k_numpla Número Tarjeta (Bolsillo)
	private String estadoTarjeta; // i_estado ( A-ACTIVO, I-INACTIVO, B-BLOQUEADO, BC-CUPO BLOQUEADO )
	private double valorCupo; // v_cupo
	private String numeroCuenta; // a_numcta Cuenta de ahorros
	private String tipoProducto; // a_tipodr Tipo de obligación
	private String numeroProducto; // a_obliga Número de obligación
	private String fechaUltimoMovimiento; //f_movim Fecha de actualizacion

	public ResponseTarjeta(){}

	public ResponseTarjeta(String nombreTarjeta, String numeroTarjeta, String numeroPlastico, String estadoTarjeta,
			double valorCupo, String numeroCuenta, String tipoProducto, String numeroProducto,
			String fechaUltimoMovimiento) {
		this.nombreTarjeta = nombreTarjeta;
		this.numeroTarjeta = numeroTarjeta;
		this.numeroPlastico = numeroPlastico;
		this.estadoTarjeta = estadoTarjeta;
		this.valorCupo = valorCupo;
		this.numeroCuenta = numeroCuenta;
		this.tipoProducto = tipoProducto;
		this.numeroProducto = numeroProducto;
		this.fechaUltimoMovimiento = fechaUltimoMovimiento;
	}

	public String getNombreTarjeta() {
		return this.nombreTarjeta;
	}

	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}

	public String getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getNumeroPlastico() {
		return this.numeroPlastico;
	}

	public void setNumeroPlastico(String numeroPlastico) {
		this.numeroPlastico = numeroPlastico;
	}

	public String getEstadoTarjeta() {
		return this.estadoTarjeta;
	}

	public void setEstadoTarjeta(String estadoTarjeta) {
		this.estadoTarjeta = estadoTarjeta;
	}

	public double getValorCupo() {
		return this.valorCupo;
	}

	public void setValorCupo(double valorCupo) {
		this.valorCupo = valorCupo;
	}

	public String getNumeroCuenta() {
		return this.numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getNumeroProducto() {
		return this.numeroProducto;
	}

	public void setNumeroProducto(String numeroProducto) {
		this.numeroProducto = numeroProducto;
	}

	public String getFechaUltimoMovimiento() {
		return this.fechaUltimoMovimiento;
	}

	public void setFechaUltimoMovimiento(String fechaUltimoMovimiento) {
		this.fechaUltimoMovimiento = fechaUltimoMovimiento;
	}

}