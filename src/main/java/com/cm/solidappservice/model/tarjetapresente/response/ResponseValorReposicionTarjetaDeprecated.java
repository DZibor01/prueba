package com.cm.solidappservice.model.tarjetapresente.response;

public class ResponseValorReposicionTarjetaDeprecated {
	
	private String k_parame;
	private String n_parame;
	private double v_numeri;

	public ResponseValorReposicionTarjetaDeprecated() {
	}

	public ResponseValorReposicionTarjetaDeprecated(String k_parame, String n_parame, double v_numeri) {
		this.k_parame = k_parame;
		this.n_parame = n_parame;
		this.v_numeri = v_numeri;
	}

	public String getK_parame() {
		return k_parame;
	}
	public void setK_parame(String k_parame) {
		this.k_parame = k_parame;
	}
	public String getN_parame() {
		return n_parame;
	}
	public void setN_parame(String n_parame) {
		this.n_parame = n_parame;
	}

	public double getV_numeri() {
		return v_numeri;
	}
	public void setV_numeri(double v_numeri) {
		this.v_numeri = v_numeri;
	}

}