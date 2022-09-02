package com.cm.solidappservice.model.votaciones.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestRegistrarVoto extends RequestAutenticacion{

    private int idCandidato;
    private int zonaElectoral;
    
    public RequestRegistrarVoto() {
    }

    public RequestRegistrarVoto(int idCandidato, int zonaElectoral) {
        this.idCandidato = idCandidato;
        this.zonaElectoral = zonaElectoral;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public int getZonaElectoral() {
        return zonaElectoral;
    }

    public void setZonaElectoral(int zonaElectoral) {
        this.zonaElectoral = zonaElectoral;
    }
    
    
}
