package com.cm.solidappservice.model.base;

import com.cm.solidappservice.model.login.request.RequestBasicSession;
import com.cm.solidappservice.utils.Utilities;

public class BaseRequest extends RequestBasicSession{
	
	private String cedula;
		
	public BaseRequest() {
	}

	public BaseRequest(String cedula) {
		this.cedula = cedula;
	}

	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public boolean isValidId() {
		return Utilities.IsNullOrEmpty(this.cedula) == true ? false : true;
	}
}