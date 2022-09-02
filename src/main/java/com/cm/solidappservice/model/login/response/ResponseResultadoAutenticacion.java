package com.cm.solidappservice.model.login.response;

import com.cm.solidappservice.model.base.BaseRequest;

public class ResponseResultadoAutenticacion extends BaseRequest {
	
	private String token;
	private String nombreAsociado;
	private String topeTransacciones;
	private String fechaUltimoIngreso;
	private String aceptoUltimosTyC;
	private DatosActualizados datosActualizados;

	public ResponseResultadoAutenticacion(){
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getNombreAsociado() {
		return nombreAsociado;
	}
	public void setNombreAsociado(String nombreAsociado) {
		this.nombreAsociado = nombreAsociado;
	}
	
	public String getTopeTransacciones() {
		return topeTransacciones;
	}
	public void setTopeTransacciones(String topeTransacciones) {
		this.topeTransacciones = topeTransacciones;
	}	
	
	public String getFechaUltimoIngreso() {
		return fechaUltimoIngreso;
	}
	public void setFechaUltimoIngreso(String fechaUltimoIngreso) {
		this.fechaUltimoIngreso = fechaUltimoIngreso;
	}

	public String getAceptoUltimosTyC() {
		return this.aceptoUltimosTyC;
	}
	public void setAceptoUltimosTyC(String aceptoUltimosTyC) {
		this.aceptoUltimosTyC = aceptoUltimosTyC;
	}

	public DatosActualizados getDatosActualizados() {
		return this.datosActualizados;
	}
	public void setDatosActualizados(DatosActualizados datosActualizados) {
		this.datosActualizados = datosActualizados;
	}
}
