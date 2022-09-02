package com.cm.solidappservice.model.dispositivo.bd;

import java.util.Date;

/*
 **TAB_APPREGISTRODISPOS
 */
public class RegistroDispositivoMD{

    private String k_registrodispos;
    private String a_anumnit;
    private String n_fabricante;
    private String n_modelo;
    private String id_dispositivo;
    private String k_imei;
    private String t_celprincipal;
    private String n_sistoperativo;
    private String k_version;
    private String i_estadoregistro;    
    private Date f_registro;

    public String getK_registrodispos() {
        return this.k_registrodispos;
    }

    public void setK_registrodispos(String k_registrodispos) {
        this.k_registrodispos = k_registrodispos;
    }

    public String getA_anumnit() {
        return this.a_anumnit;
    }

    public void setA_anumnit(String a_anumnit) {
        this.a_anumnit = a_anumnit;
    }

    public String getN_fabricante() {
        return this.n_fabricante;
    }

    public void setN_fabricante(String n_fabricante) {
        this.n_fabricante = n_fabricante;
    }

    public String getN_modelo() {
        return this.n_modelo;
    }

    public void setN_modelo(String n_modelo) {
        this.n_modelo = n_modelo;
    }

    public String getId_dispositivo() {
        return this.id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getK_imei() {
        return this.k_imei;
    }

    public void setK_imei(String k_imei) {
        this.k_imei = k_imei;
    }

    public String getT_celprincipal() {
        return this.t_celprincipal;
    }

    public void setT_celprincipal(String t_celprincipal) {
        this.t_celprincipal = t_celprincipal;
    }

    public String getN_sistoperativo() {
        return this.n_sistoperativo;
    }

    public void setN_sistoperativo(String n_sistoperativo) {
        this.n_sistoperativo = n_sistoperativo;
    }

    public String getK_version() {
        return this.k_version;
    }

    public void setK_version(String k_version) {
        this.k_version = k_version;
    }

    public String getI_estadoregistro() {
        return this.i_estadoregistro;
    }

    public void setI_estadoregistro(String i_estadoregistro) {
        this.i_estadoregistro = i_estadoregistro;
    }

    public Date getF_registro() {
        return this.f_registro;
    }

    public void setF_registro(Date f_registro) {
        this.f_registro = f_registro;
    }
    
}