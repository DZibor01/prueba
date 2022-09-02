package com.cm.solidappservice.model.tarjetapresente.bd;
import java.util.Date;

/*
* TAB_APPTJESTADO
*/
public class ActualizacionTarjetaMD {
	private String k_numpla;
	private String aanumnit;        
	private String n_motivo;        
	private Date f_solici;
	public String getK_numpla() {
		return k_numpla;
	}
	public void setK_numpla(String k_numpla) {
		this.k_numpla = k_numpla;
	}
	public String getAanumnit() {
		return aanumnit;
	}
	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}
	public String getN_motivo() {
		return n_motivo;
	}
	public void setN_motivo(String n_motivo) {
		this.n_motivo = n_motivo;
	}
	public Date getF_solici() {
		return f_solici;
	}
	public void setF_solici(Date f_solici) {
		this.f_solici = f_solici;
	}
	public String getI_estado() {
		return i_estado;
	}
	public void setI_estado(String i_estado) {
		this.i_estado = i_estado;
	}
	public String getId_dispositivo() {
		return id_dispositivo;
	}
	public void setId_dispositivo(String id_dispositivo) {
		this.id_dispositivo = id_dispositivo;
	}
	private String i_estado;
	private String id_dispositivo;
}
