package com.cm.solidappservice.model.votaciones.bd;

public class CandidatosMD {

	private int consecutivo;
	private String nombre;
	private int ZonaElectoral;
	private int votos;
	
	public CandidatosMD() {
	}

	public CandidatosMD(int consecutivo,String nombre,int ZonaElectoral, int votos) {
		this.consecutivo=consecutivo;
		this.nombre=nombre;
		this.ZonaElectoral=ZonaElectoral;
		this.votos = votos;
	}

	public CandidatosMD(int consecutivo, int zonaElectoral) {
		this.consecutivo = consecutivo;
		ZonaElectoral = zonaElectoral;
	}

	public int getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getZonaElectoral() {
		return ZonaElectoral;
	}

	public void setZonaElectoral(int zonaElectoral) {
		ZonaElectoral = zonaElectoral;
	}

	
}
