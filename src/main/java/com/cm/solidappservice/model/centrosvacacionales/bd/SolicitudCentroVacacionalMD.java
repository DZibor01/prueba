package com.cm.solidappservice.model.centrosvacacionales.bd;

import java.util.Date;

/*
**TAB_APP_SOLICV
*/
public class SolicitudCentroVacacionalMD{

	private String aanumnit;
	private String i_asousa;
	private int q_totadu;
	private int q_totnin;
	private String k_cenvac;
	private String k_peruni;
	private Date f_llegad;
	private int q_perman;
	private String o_observ;
	private String d_email;
	private String id_dispositivo;

	public SolicitudCentroVacacionalMD() {
	}

	public SolicitudCentroVacacionalMD(String aanumnit, String i_asousa, int q_totadu, int q_totnin, String k_cenvac,
			String k_peruni, Date f_llegad, int q_perman, String o_observ, String d_email, String id_dispositivo) {
		this.aanumnit = aanumnit;
		this.i_asousa = i_asousa;
		this.q_totadu = q_totadu;
		this.q_totnin = q_totnin;
		this.k_cenvac = k_cenvac;
		this.k_peruni = k_peruni;
		this.f_llegad = f_llegad;
		this.q_perman = q_perman;
		this.o_observ = o_observ;
		this.d_email = d_email;
		this.id_dispositivo = id_dispositivo;
	}

	public String getAanumnit() {
		return aanumnit;
	}

	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}

	public String getI_asousa() {
		return i_asousa;
	}

	public void setI_asousa(String i_asousa) {
		this.i_asousa = i_asousa;
	}

	public int getQ_totadu() {
		return q_totadu;
	}

	public void setQ_totadu(int q_totadu) {
		this.q_totadu = q_totadu;
	}

	public int getQ_totnin() {
		return q_totnin;
	}

	public void setQ_totnin(int q_totnin) {
		this.q_totnin = q_totnin;
	}

	public String getK_cenvac() {
		return k_cenvac;
	}

	public void setK_cenvac(String k_cenvac) {
		this.k_cenvac = k_cenvac;
	}

	public String getK_peruni() {
		return k_peruni;
	}

	public void setK_peruni(String k_peruni) {
		this.k_peruni = k_peruni;
	}

	public Date getF_llegad() {
		return f_llegad;
	}

	public void setF_llegad(Date f_llegad) {
		this.f_llegad = f_llegad;
	}

	public int getQ_perman() {
		return q_perman;
	}

	public void setQ_perman(int q_perman) {
		this.q_perman = q_perman;
	}

	public String getO_observ() {
		return o_observ;
	}

	public void setO_observ(String o_observ) {
		this.o_observ = o_observ;
	}

	public String getD_email() {
		return d_email;
	}

	public void setD_email(String d_email) {
		this.d_email = d_email;
	}

	public String getId_dispositivo() {
		return id_dispositivo;
	}

	public void setId_dispositivo(String id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}
}