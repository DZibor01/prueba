package com.cm.solidappservice.model.adelantonomina.bd;

/*
**TAB_APPTIPS
*/
public class TipsMD {
	
	private int K_TIP;
	private String N_TIP;
	
	public TipsMD() {
	}
	
	public TipsMD(int k_TIP, String n_TIP) {
		super();
		K_TIP = k_TIP;
		N_TIP = n_TIP;
	}
	
	public int getK_TIP() {
		return K_TIP;
	}
	public void setK_TIP(int k_TIP) {
		K_TIP = k_TIP;
	}
	public String getN_TIP() {
		return N_TIP;
	}
	public void setN_TIP(String n_TIP) {
		N_TIP = n_TIP;
	}
	
	
	
}