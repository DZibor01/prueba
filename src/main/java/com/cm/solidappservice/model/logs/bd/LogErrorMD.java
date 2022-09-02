package com.cm.solidappservice.model.logs.bd;

import java.util.Date;

/**
 * TAB_APPLOGERROR
 */
public class LogErrorMD {

	private String a_anumnit;
	private String n_origen;
	private String n_error;
	private Date f_registro;
	
	public LogErrorMD() {
	}

	public LogErrorMD(String a_anumnit, String n_origen, String n_error, Date f_registro) {
		this.a_anumnit = a_anumnit;
		this.n_origen = n_origen;
		this.n_error = n_error;
		this.f_registro = f_registro;
	}

	public String getA_anumnit() {
		return a_anumnit;
	}

	public void setA_anumnit(String a_anumnit) {
		this.a_anumnit = a_anumnit;
	}

	public String getN_origen() {
		return n_origen;
	}

	public void setN_origen(String n_origen) {
		this.n_origen = n_origen;
	}

	public String getN_error() {
		return n_error;
	}

	public void setN_error(String n_error) {
		this.n_error = n_error;
	}

	public Date getF_registro() {
		return f_registro;
	}

	public void setF_registro(Date f_registro) {
		this.f_registro = f_registro;
	}

}