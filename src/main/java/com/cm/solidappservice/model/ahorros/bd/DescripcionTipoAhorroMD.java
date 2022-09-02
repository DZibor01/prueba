package com.cm.solidappservice.model.ahorros.bd;

/*
**TAB_APPDESCXTIPAHO
*/
public class DescripcionTipoAhorroMD {

	private String k_tipodr;
	private float q_orden;
	private String v_descrip;

	public DescripcionTipoAhorroMD() {
	}

	public DescripcionTipoAhorroMD(String k_tipodr, float q_orden, String v_descrip) {
		this.k_tipodr = k_tipodr;
		this.q_orden = q_orden;
		this.v_descrip = v_descrip;
	}

	public String getK_tipodr() {
		return k_tipodr;
	}

	public void setK_tipodr(String k_tipodr) {
		this.k_tipodr = k_tipodr;
	}

	public float getQ_orden() {
		return q_orden;
	}

	public void setQ_orden(float q_orden) {
		this.q_orden = q_orden;
	}

	public String getV_descrip() {
		return v_descrip;
	}

	public void setV_descrip(String v_descrip) {
		this.v_descrip = v_descrip;
	}
		
}