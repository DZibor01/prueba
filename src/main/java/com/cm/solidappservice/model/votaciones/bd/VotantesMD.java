package com.cm.solidappservice.model.votaciones.bd;

public class VotantesMD {

	private String cedula;	
	private int ZonaElectoral;
	private String voto;
	private String fechavoto;
	
	public VotantesMD( String cedula,int ZonaElectoral,String voto,String fechavoto) {
		this.cedula=cedula;
		this.ZonaElectoral=ZonaElectoral;
		this.voto=voto;
		this.fechavoto=fechavoto;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getZonaElectoral() {
		return ZonaElectoral;
	}

	public void setZonaElectoral(int zonaElectoral) {
		ZonaElectoral = zonaElectoral;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public String getFechavoto() {
		return fechavoto;
	}

	public void setFechavoto(String fechavoto) {
		this.fechavoto = fechavoto;
	}

}
