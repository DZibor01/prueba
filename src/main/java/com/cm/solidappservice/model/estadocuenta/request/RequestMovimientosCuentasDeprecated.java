package com.cm.solidappservice.model.estadocuenta.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestMovimientosCuentasDeprecated extends RequestAutenticacion{

	private String v_aanumnit; 
	private Integer k_tipcuent;
	private String v_tipodr;
	private String v_numdoc;

	public RequestMovimientosCuentasDeprecated() {
	}

	public RequestMovimientosCuentasDeprecated(String v_aanumnit, Integer k_tipcuent, String v_tipodr, String v_numdoc) {
		this.v_aanumnit = v_aanumnit;
		this.k_tipcuent = k_tipcuent;
		this.v_tipodr = v_tipodr;
		this.v_numdoc = v_numdoc;
	}

	public String getV_aanumnit() {
		return v_aanumnit;
	}

	public void setV_aanumnit(String v_aanumnit) {
		this.v_aanumnit = v_aanumnit;
	}

	public Integer getK_tipcuent() {
		return k_tipcuent;
	}

	public void setK_tipcuent(Integer k_tipcuent) {
		this.k_tipcuent = k_tipcuent;
	}

	public String getV_tipodr() {
		return v_tipodr;
	}

	public void setV_tipodr(String v_tipodr) {
		this.v_tipodr = v_tipodr;
	}

	public String getV_numdoc() {
		return v_numdoc;
	}

	public void setV_numdoc(String v_numdoc) {
		this.v_numdoc = v_numdoc;
	}

}
