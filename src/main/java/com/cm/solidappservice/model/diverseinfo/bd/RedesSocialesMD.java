package com.cm.solidappservice.model.diverseinfo.bd;

/*
**TAB_APPREDESSOC
*/
public class RedesSocialesMD {

	private Integer k_idred; // 20
	private String n_redsocial; // 20
	private String v_link; // 250

	public RedesSocialesMD() {
	}

	public RedesSocialesMD(Integer k_idred, String n_redsocial, String v_link) {
		this.k_idred = k_idred;
		this.n_redsocial = n_redsocial;
		this.v_link = v_link;
	}

	public Integer getK_idred() {
		return k_idred;
	}

	public void setK_idred(Integer k_idred) {
		this.k_idred = k_idred;
	}

	public String getN_redsocial() {
		return n_redsocial;
	}

	public void setN_redsocial(String n_redsocial) {
		this.n_redsocial = n_redsocial;
	}

	public String getV_link() {
		return v_link;
	}

	public void setV_link(String v_link) {
		this.v_link = v_link;
	}

	

	
}
