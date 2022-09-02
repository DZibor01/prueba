package com.cm.solidappservice.model.obligaciones.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestPagoObligacion extends RequestAutenticacion {
	
	private String idDispositivo; // id_dispositivo
	private String numeroProducto; // a_numdoc
	private String nombreProducto; // n_produc
	private String nombreCuenta; // n_tipodr
	private String numeroCuenta; // a_numcta
	private String codigoProducto; // a_tipodr
	private String clasificacionProducto; // k_tipodr
	private Double valorPago; //v_valor

	public RequestPagoObligacion(){}

	public String getIdDispositivo() {
		return this.idDispositivo;
	}

	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
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