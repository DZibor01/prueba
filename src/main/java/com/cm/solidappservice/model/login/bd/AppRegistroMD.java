package com.cm.solidappservice.model.login.bd;

import java.util.Date;

/*
 **MEDA_APPREGISTRO
 */
public class AppRegistroMD {

	private long k_idterc; 
	private	long a_numnit; // Nit del asociado, max-length: 11
	private String n_asocia; //Nombre del asociado, max-length: 200
	private Date f_registro; //Fecha de creación del registro
	private Date f_actual;//Fecha de actualización del registro
	private String o_clave; //Clave del afiliado, max-length: 30
	private String d_email; //Email del afiliado, max-length: 60
	private boolean e_activo; //Define si el afiliado se encuentra activo
	private Date f_caducidadClave; //Si el afiliado no ha activado su cuenta, este campo indica el tiempo  disponible que tiene para hacerlo
	private String d_llave; //Llave utilizada para encriptar con javax.crypto
	private Date f_ultingreso; //Fecha último ingreso del usuario
	private String celular; //Celular del afiliado
	private String estado; //Define el estado del registro de usuario:
	private Date f_expedicion; //Fecha de expedición de la cédula del afiliado
	
	public AppRegistroMD() {}

	public AppRegistroMD(long a_numnit, String n_asocia,
			Date f_registro, Date f_actual, String o_clave, String d_email,
			boolean e_activo, Date f_caducidadClave, String d_llave) {
		this.a_numnit = a_numnit;
		this.n_asocia = n_asocia;
		this.f_registro = f_registro;
		this.f_actual = f_actual;
		this.o_clave = o_clave;
		this.d_email = d_email;
		this.e_activo = e_activo;
		this.f_caducidadClave = f_caducidadClave;
		this.d_llave = d_llave;
	}

	public long getA_numnit() {
		return a_numnit;
	}

	public String getN_asocia() {
		return n_asocia;
	}

	public Date getF_registro() {
		return f_registro;
	}

	public Date getF_actual() {
		return f_actual;
	}

	public String getO_clave() {
		return o_clave;
	}

	public String getD_email() {
		return d_email;
	}

	public boolean isE_activo() {
		return e_activo;
	}

	public Date getF_caducidadClave() {
		return f_caducidadClave;
	}

	public String getD_llave() {
		return d_llave;
	}

	public void setA_numnit(long a_numnit) {
		this.a_numnit = a_numnit;
	}

	public void setN_asocia(String n_asocia) {
		this.n_asocia = n_asocia;
	}

	public void setF_registro(Date f_registro) {
		this.f_registro = f_registro;
	}

	public void setF_actual(Date f_actual) {
		this.f_actual = f_actual;
	}

	public void setO_clave(String o_clave) {
		this.o_clave = o_clave;
	}

	public void setD_email(String d_email) {
		this.d_email = d_email;
	}

	public void setE_activo(boolean e_activo) {
		this.e_activo = e_activo;
	}

	public void setF_caducidadClave(Date f_caducidadClave) {
		this.f_caducidadClave = f_caducidadClave;
	}

	public void setD_llave(String d_llave) {
		this.d_llave = d_llave;
	}
	
	//---------------------------------------------
	
	public long getK_idterc() {
		return k_idterc;
	}

	public void setK_idterc(long k_idterc) {
		this.k_idterc = k_idterc;
	}

	public String getCelular() {
		return celular;
	}

	public String getEstado() {
		return estado;
	}

	public Date getF_expedicion() {
		return f_expedicion;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setF_expedicion(Date f_expedicion) {
		this.f_expedicion = f_expedicion;
	}
	
	public Date getF_ultingreso() {
		return f_ultingreso;
	}
	
	public void setF_ultingreso(Date f_ultingreso) {
		this.f_ultingreso = f_ultingreso;
	}
	
	@Override
	public String toString() {
		return (a_numnit + n_asocia + o_clave + d_email + d_llave + " /RegistroApp");
	}
}