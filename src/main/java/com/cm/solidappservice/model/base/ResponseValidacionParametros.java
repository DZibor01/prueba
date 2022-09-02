package com.cm.solidappservice.model.base;

import com.cm.solidappservice.utils.Utilities;

public class ResponseValidacionParametros {
	private String errorToken;
	private String errorParametros;
	
	public ResponseValidacionParametros(String _errorToken, String _errorParametros){
		setErrorToken(_errorToken);
		setErrorParametros(_errorParametros);
	}

	public boolean isValid() {
		return Utilities.IsNullOrEmpty(this.errorToken) && Utilities.IsNullOrEmpty(this.errorParametros);
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
}