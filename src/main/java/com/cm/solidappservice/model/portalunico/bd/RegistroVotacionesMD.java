package com.cm.solidappservice.model.portalunico.bd;

public class RegistroVotacionesMD{
	
	private String a_anumnit;
	private String f_ingreso;

	public RegistroVotacionesMD() {
	}

	public RegistroVotacionesMD(String a_anumnit, String f_ingreso) {
		this.a_anumnit = a_anumnit;
		this.f_ingreso = f_ingreso;
	}

	public String getA_anumnit() {
		return a_anumnit;
	}

	public void setA_anumnit(String a_anumnit) {
		this.a_anumnit = a_anumnit;
	}

	public String getF_ingreso() {
		return f_ingreso;
	}

	public void setF_ingreso(String f_ingreso) {
		this.f_ingreso = f_ingreso;
	}
	
}