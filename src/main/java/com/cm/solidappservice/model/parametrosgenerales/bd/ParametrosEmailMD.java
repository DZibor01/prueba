package com.cm.solidappservice.model.parametrosgenerales.bd;

/**
 * TABLA TAB_APPGENERAL
 */
public class ParametrosEmailMD {
	
	private String k_parame;
	private String userEmail;
	private String passwordEmail;
	private String autorizacionSMPT; 
	private String servidorSMTP;
	private String tituloRemitente;
	private String startTLSSMPT;   
	private String Contenido_Email;
	private String puertoSMTP;
	private double v_numeri;
	private String n_version;
	private String v_alfabe;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPasswordEmail() {
		return passwordEmail;
	}
	public void setPasswordEmail(String passwordEmail) {
		this.passwordEmail = passwordEmail;
	}
	public String getAutorizacionSMPT() {
		return autorizacionSMPT;
	}
	public void setAutorizacionSMPT(String autorizacionSMPT) {
		this.autorizacionSMPT = autorizacionSMPT;
	}
	public String getServidorSMTP() {
		return servidorSMTP;
	}
	public void setServidorSMTP(String servidorSMTP) {
		this.servidorSMTP = servidorSMTP;
	}
	public String getTituloRemitente() {
		return tituloRemitente;
	}
	public void setTituloRemitente(String tituloRemitente) {
		this.tituloRemitente = tituloRemitente;
	}
	public String getStartTLSSMPT() {
		return startTLSSMPT;
	}
	public void setStartTLSSMPT(String startTLSSMPT) {
		this.startTLSSMPT = startTLSSMPT;
	}
	public String getContenido_Email() {
		return Contenido_Email;
	}
	public void setContenido_Email(String contenido_Email) {
		Contenido_Email = contenido_Email;
	}
	public String getK_parame() {
		return k_parame;
	}
	public void setK_parame(String k_parame) {
		this.k_parame = k_parame;
	}
	public String getPuertoSMTP() {
		return puertoSMTP;
	}
	public void setPuertoSMTP(String puertoSMTP) {
		this.puertoSMTP = puertoSMTP;
	}
	public double getV_numeri() {
		return v_numeri;
	}
	public void setV_numeri(double v_numeri) {
		this.v_numeri = v_numeri;
	}
	public void setN_version(String n_version) {
		this.n_version = n_version;
	}
	public String getN_version() {
		return n_version;
	}
	public String getV_alfabe() {
		return v_alfabe;
	}
	public void setV_alfabe(String v_alfabe) {
		this.v_alfabe = v_alfabe;
	}

}