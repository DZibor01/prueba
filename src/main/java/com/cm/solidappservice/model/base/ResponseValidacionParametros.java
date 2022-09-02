package com.cm.solidappservice.model.base;

import com.cm.solidappservice.utils.Utilities;

public class ResponseValidacionParametros extends BaseRequest{
	private String errorToken;
	private String errorParametros;
	
	public ResponseValidacionParametros(String _errorToken, String _errorParametros, String cedula){
		super();
		this.setCedula(cedula);
		setErrorToken(_errorToken);
		setErrorParametros(_errorParametros);
	}
	
	public boolean isValid() {
		return Utilities.IsNullOrEmpty(this.errorToken) && Utilities.IsNullOrEmpty(this.errorParametros) && isValidId();
	}
	
	public String getErrorToken() {
		return errorToken;
	}
	public void setErrorToken(String errorToken) {
		this.errorToken = errorToken;
	}
	public String getErrorParametros() {
		return errorParametros;
	}
	public void setErrorParametros(String errorParametros) {
		this.errorParametros = errorParametros;
	}
	
	/*public ResponseValidacionParametros(String _errorToken, String _errorParametros){
	setErrorToken(_errorToken);
	setErrorParametros(_errorParametros);}*/
	
	/*public boolean isValid() {
	return Utilities.IsNullOrEmpty(this.errorToken) && Utilities.IsNullOrEmpty(this.errorParametros);}*/
}