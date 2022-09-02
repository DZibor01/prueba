package com.cm.solidappservice.model.dispositivo.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestDispositivo extends RequestAutenticacion {

    private String fabricante;
    private String modelo;
    private String idDispositivo;
    private String imei;
    private String celPrincipal;
    private String sistemaOperativo;
    private String versionSistemaOperativo;

    public String getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getIdDispositivo() {
        return this.idDispositivo;
    }

    public void setIdDispositivo(String idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getCelPrincipal() {
        return this.celPrincipal;
    }

    public void setCelPrincipal(String celPrincipal) {
        this.celPrincipal = celPrincipal;
    }

    public String getSistemaOperativo() {
        return this.sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getVersionSistemaOperativo() {
        return this.versionSistemaOperativo;
    }

    public void setVersionSistemaOperativo(String versionSistemaOperativo) {
        this.versionSistemaOperativo = versionSistemaOperativo;
    }


}
