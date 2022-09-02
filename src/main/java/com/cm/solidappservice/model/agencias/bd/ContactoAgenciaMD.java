package com.cm.solidappservice.model.agencias.bd;

/**
 * TABLA TAB_APPDCONTACTO *
 */
public class ContactoAgenciaMD {

	private String i_tipage;//Tipo de sucursal
	private String k_sucurs;// Código de sucursal
	private String n_cargo;//Nombre del cargo
	private String n_nombre;//Nombre contacto
	private String n_telefo;//Telefono contacto
	
	public ContactoAgenciaMD() {
	}
	
	public ContactoAgenciaMD(String i_tipage, String k_sucurs, String n_cargo,
			String n_nombre, String n_telefo) {
		super();
		this.i_tipage = i_tipage;
		this.k_sucurs = k_sucurs;
		this.n_cargo = n_cargo;
		this.n_nombre = n_nombre;
		this.n_telefo = n_telefo;
	}

	public ContactoAgenciaMD(String i_tipage, String k_sucurs) {
		this.i_tipage = i_tipage;
		this.k_sucurs = k_sucurs;
	}

	public String getI_tipage() {
		return i_tipage;
	}

	public String getK_sucurs() {
		return k_sucurs;
	}

	public String getN_cargo() {
		return n_cargo;
	}

	public String getN_nombre() {
		return n_nombre;
	}

	public String getN_telefo() {
		return n_telefo;
	}

	public void setI_tipage(String i_tipage) {
		this.i_tipage = i_tipage;
	}

	public void setK_sucurs(String k_sucurs) {
		this.k_sucurs = k_sucurs;
	}

	public void setN_cargo(String n_cargo) {
		this.n_cargo = n_cargo;
	}

	public void setN_nombre(String n_nombre) {
		this.n_nombre = n_nombre;
	}

	public void setN_telefo(String n_telefo) {
		this.n_telefo = n_telefo;
	}	
}