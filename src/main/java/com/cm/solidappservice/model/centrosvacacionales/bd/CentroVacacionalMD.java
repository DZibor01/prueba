package com.cm.solidappservice.model.centrosvacacionales.bd;

/*
**VISTA VIEW_APP_CV
*/
public class CentroVacacionalMD{
	
	private String k_cenvac;
	private String n_cenvac;
	private String d_cenvac;
	private String k_peruni;
	private String n_peruni;
	
	public CentroVacacionalMD() {
	}

	public CentroVacacionalMD(String k_cenvac, String n_cenvac, String d_cenvac, String k_peruni, String n_peruni) {
		this.k_cenvac = k_cenvac;
		this.n_cenvac = n_cenvac;
		this.d_cenvac = d_cenvac;
		this.k_peruni = k_peruni;
		this.n_peruni = n_peruni;
	}

	public String getK_cenvac() {
		return k_cenvac;
	}

	public void setK_cenvac(String k_cenvac) {
		this.k_cenvac = k_cenvac;
	}

	public String getN_cenvac() {
		return n_cenvac;
	}

	public void setN_cenvac(String n_cenvac) {
		this.n_cenvac = n_cenvac;
	}

	public String getD_cenvac() {
		return d_cenvac;
	}

	public void setD_cenvac(String d_cenvac) {
		this.d_cenvac = d_cenvac;
	}

	public String getK_peruni() {
		return k_peruni;
	}

	public void setK_peruni(String k_peruni) {
		this.k_peruni = k_peruni;
	}

	public String getN_peruni() {
		return n_peruni;
	}

	public void setN_peruni(String n_peruni) {
		this.n_peruni = n_peruni;
	}
	
}