package com.cm.solidappservice.model.estadocuenta.response;

import java.util.List;

public class ResponseConsultarCuentas {
	
	// private String aanumnit; //Cédula del cliente
	private String nombreCuenta; // n_tipodr
	private List<Producto> productos;
		
	public ResponseConsultarCuentas(){}

	public ResponseConsultarCuentas(String nombreCuenta, List<Producto> productos) {
		this.nombreCuenta = nombreCuenta;
		this.productos = productos;
	}

	public String getNombreCuenta() {
		return this.nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}

