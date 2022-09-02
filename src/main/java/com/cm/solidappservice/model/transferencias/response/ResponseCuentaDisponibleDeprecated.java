package com.cm.solidappservice.model.transferencias.response;

public class ResponseCuentaDisponibleDeprecated {
	
	private String a_numcta;
	private String nnasocia;
	private String aanumnit;
	
	public ResponseCuentaDisponibleDeprecated() {
	}

	public ResponseCuentaDisponibleDeprecated(String a_numcta, String nnasocia, String aanumnit) {
		this.a_numcta = a_numcta;
		this.nnasocia = nnasocia;
		this.aanumnit = aanumnit;
	}

	public String getNnasocia() {
		return nnasocia;
	}
	public void setNnasocia(String nnasocia) {
		this.nnasocia = nnasocia;
	}
	public String getA_numcta() {
		return a_numcta;
	}
	public void setA_numcta(String a_numcta) {
		this.a_numcta = a_numcta;
	}
	public String getAanumnit() {
		return aanumnit;
	}
	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}
}