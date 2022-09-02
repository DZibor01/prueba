package com.cm.solidappservice.model.agencias.response;

import java.util.List;
import com.cm.solidappservice.model.agencias.bd.ContactoAgenciaMD;

public class ResponseAgenciasDeprecated {

	private String n_latitu;
	private String n_longit;	
	private String n_sucurs;	
	private String i_tipage; 
	private String k_sucurs; 
	private String d_sucurs;
	private String n_depart;
	private String n_ciudad;
	private String t_sucurs;
	private List<ContactoAgenciaMD> contactos;
	
	public ResponseAgenciasDeprecated() {
	}

	public ResponseAgenciasDeprecated(String n_latitu, String n_longit, String n_sucurs, String i_tipage, String k_sucurs,
			String d_sucurs, String n_depart, String n_ciudad, String t_sucurs, List<ContactoAgenciaMD> contactos) {
		this.n_latitu = n_latitu;
		this.n_longit = n_longit;
		this.n_sucurs = n_sucurs;
		this.i_tipage = i_tipage;
		this.k_sucurs = k_sucurs;
		this.d_sucurs = d_sucurs;
		this.n_depart = n_depart;
		this.n_ciudad = n_ciudad;
		this.t_sucurs = t_sucurs;
		this.contactos = contactos;
	}

	public String getN_latitu() {
		return n_latitu;
	}

	public void setN_latitu(String n_latitu) {
		this.n_latitu = n_latitu;
	}

	public String getN_longit() {
		return n_longit;
	}

	public void setN_longit(String n_longit) {
		this.n_longit = n_longit;
	}

	public String getN_sucurs() {
		return n_sucurs;
	}

	public void setN_sucurs(String n_sucurs) {
		this.n_sucurs = n_sucurs;
	}

	public String getI_tipage() {
		return i_tipage;
	}

	public void setI_tipage(String i_tipage) {
		this.i_tipage = i_tipage;
	}

	public String getK_sucurs() {
		return k_sucurs;
	}

	public void setK_sucurs(String k_sucurs) {
		this.k_sucurs = k_sucurs;
	}

	public String getD_sucurs() {
		return d_sucurs;
	}

	public void setD_sucurs(String d_sucurs) {
		this.d_sucurs = d_sucurs;
	}

	public String getN_depart() {
		return n_depart;
	}

	public void setN_depart(String n_depart) {
		this.n_depart = n_depart;
	}

	public String getN_ciudad() {
		return n_ciudad;
	}

	public void setN_ciudad(String n_ciudad) {
		this.n_ciudad = n_ciudad;
	}

	public String getT_sucurs() {
		return t_sucurs;
	}

	public void setT_sucurs(String t_sucurs) {
		this.t_sucurs = t_sucurs;
	}

	public List<ContactoAgenciaMD> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoAgenciaMD> contactos) {
		this.contactos = contactos;
	}
	
}