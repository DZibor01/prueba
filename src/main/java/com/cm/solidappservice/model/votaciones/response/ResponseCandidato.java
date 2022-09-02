package com.cm.solidappservice.model.votaciones.response;

public class ResponseCandidato {
    
    private int idCandidato;
	private String nombreCandidato;
    private int zonaElectoral;

    public ResponseCandidato() {
    }

    public ResponseCandidato(int idCandidato, String nombreCandidato, int zonaElectoral) {
        this.idCandidato = idCandidato;
        this.nombreCandidato = nombreCandidato;
        this.zonaElectoral = zonaElectoral;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public int getZonaElectoral() {
        return zonaElectoral;
    }

    public void setZonaElectoral(int zonaElectoral) {
        this.zonaElectoral = zonaElectoral;
    }

}
