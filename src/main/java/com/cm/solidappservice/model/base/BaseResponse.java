package com.cm.solidappservice.model.base;

public class BaseResponse<T> {
	
	private String descripcionError;
	private String mensajeErrorUsuario;
	private String errorToken;
	private T resultado;
	
	public BaseResponse(String _errorToken, String _descripcionError, T _resultado){
		this.descripcionError = _descripcionError;
		this.resultado = _resultado;
		this.errorToken = _errorToken;
	}
	
	public BaseResponse(String descripcionError, String mensajeErrorUsuario, String errorToken,
			T resultado) {
		this.descripcionError = descripcionError;
		this.mensajeErrorUsuario = mensajeErrorUsuario;
		this.errorToken = errorToken;
		this.resultado = resultado;
	}

	public String getDescripcionError() {
		return descripcionError;
	}
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}
	
	public String getMensajeErrorUsuario() {
		return mensajeErrorUsuario;
	}

	public void setMensajeErrorUsuario(String mensajeErrorUsuario) {
		this.mensajeErrorUsuario = mensajeErrorUsuario;
	}

	public T getResultado() {
		return resultado;
	}
	public void setResultado(T resultado) {
		this.resultado = resultado;
	}

	public String getErrorToken() {
		return errorToken;
	}

	public void setErrorToken(String errorToken) {
		this.errorToken = errorToken;
	}
}
