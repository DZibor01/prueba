package com.cm.solidappservice.model.agencias.bd;

import java.util.List;

import com.cm.solidappservice.utils.Utilities;

/**
 * tabla TAB_APPAGENCIA 
 */
public class AgenciaMD {

	private String n_latitu;
	private String n_longit;	
	private String n_sucurs;	
	private String i_tipage; //Tipo de sucursal
	private String k_sucurs; //Codigo de sucursal
	private String d_sucurs;//Dirección sucursal	
	private String n_depart;//Nombre departamento
	private String n_ciudad;//Nombre de la ciudad	
	private String t_sucurs;//Telefono sucursal	
	private List<ContactoAgenciaMD> contactos;
	
	public AgenciaMD() {
	}

	public String getN_latitu() {
		return n_latitu;
	}

	public String getN_longit() {
		return n_longit;
	}

	public String getN_sucurs() {
		return n_sucurs;
	}

	public String getI_tipage() {
		return i_tipage;
	}

	public String getK_sucurs() {
		return k_sucurs;
	}

	public String getD_sucurs() {
		return d_sucurs;
	}

	public void setN_latitu(String n_latitu) {
		if (!Utilities.IsNullOrEmpty(n_latitu)) {
			this.n_latitu = n_latitu.replace(',', '.');
		}else{
			this.n_latitu = n_latitu;	
		}
	}

	public void setN_longit(String n_longit) {
		if (!Utilities.IsNullOrEmpty(n_longit)) {
			this.n_longit = n_longit.replace(',', '.');
		}else
		{
			this.n_longit = n_longit;
		}
	}

	public void setN_sucurs(String n_sucurs) {
		this.n_sucurs = n_sucurs;
	}

	public void setI_tipage(String i_tipage) {
		this.i_tipage = i_tipage;
	}

	public void setK_sucurs(String k_sucurs) {
		this.k_sucurs = k_sucurs;
	}

	public void setD_sucurs(String d_sucurs) {
		this.d_sucurs = d_sucurs;
	}

	public String getT_sucurs() {
		return t_sucurs;
	}

	public void setT_sucurs(String t_sucurs) {
		this.t_sucurs = t_sucurs;
	}

	public String getN_ciudad() {
		return n_ciudad;
	}

	public void setN_ciudad(String n_ciudad) {
		this.n_ciudad = n_ciudad;
	}

	public String getN_depart() {
		return n_depart;
	}

	public void setN_depart(String n_depart) {
		this.n_depart = n_depart;
	}

	public List<ContactoAgenciaMD> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoAgenciaMD> contactos) {
		this.contactos = contactos;
	}
}