package com.cm.solidappservice.model.datosasociado.bd;

import java.util.Date;

/**
**TAB_APPACTDATOS 
*/
public class RegistraDatosActualizadosMD {
    
    private String k_actddatos;
    private String a_anumnit;
    private String n_nombre;
    private String t_celular;
    private String d_email;
    private String k_pais;
    private String k_depart;
    private String k_ciudad;
    private String n_barrio;
    private String n_direcc;
    private Date f_actdatos;
    private String k_registrodispos;
    private String ip;
    private String n_canal;

    public RegistraDatosActualizadosMD() {
    }

    public RegistraDatosActualizadosMD(String k_actddatos, String a_anumnit, String n_nombre, String t_celular, 
        String d_email, String k_pais, String k_depart, String k_ciudad, String n_barrio, String n_direcc, 
        Date f_actdatos, String k_registrodispos, String ip, String n_canal) {
        this.k_actddatos = k_actddatos;
        this.a_anumnit = a_anumnit;
        this.n_nombre = n_nombre;
        this.t_celular = t_celular;
        this.d_email = d_email;
        this.k_pais = k_pais;
        this.k_depart = k_depart;
        this.k_ciudad = k_ciudad;
        this.n_barrio = n_barrio;
        this.n_direcc = n_direcc;
        this.f_actdatos = f_actdatos;
        this.k_registrodispos = k_registrodispos;
        this.ip = ip;
        this.n_canal = n_canal;
    }
    
    public String getK_actddatos() {
        return k_actddatos;
    }
    public void setK_actddatos(String k_actddatos) {
        this.k_actddatos = k_actddatos;
    }
    public String getA_anumnit() {
        return a_anumnit;
    }
    public void setA_anumnit(String a_anumnit) {
        this.a_anumnit = a_anumnit;
    }
    public String getN_nombre() {
        return n_nombre;
    }
    public void setN_nombre(String n_nombre) {
        this.n_nombre = n_nombre;
    }
    public String getT_celular() {
        return t_celular;
    }
    public void setT_celular(String t_celular) {
        this.t_celular = t_celular;
    }
    public String getD_email() {
        return d_email;
    }
    public void setD_email(String d_email) {
        this.d_email = d_email;
    }
    public String getK_pais() {
        return k_pais;
    }
    public void setK_pais(String k_pais) {
        this.k_pais = k_pais;
    }
    public String getK_depart() {
        return k_depart;
    }
    public void setK_depart(String k_depart) {
        this.k_depart = k_depart;
    }
    public String getK_ciudad() {
        return k_ciudad;
    }
    public void setK_ciudad(String k_ciudad) {
        this.k_ciudad = k_ciudad;
    }
    public String getN_barrio() {
        return n_barrio;
    }
    public void setN_barrio(String n_barrio) {
        this.n_barrio = n_barrio;
    }
    public String getN_direcc() {
        return n_direcc;
    }
    public void setN_direcc(String n_direcc) {
        this.n_direcc = n_direcc;
    }
    public Date getF_actdatos() {
        return f_actdatos;
    }
    public void setF_actdatos(Date f_actdatos) {
        this.f_actdatos = f_actdatos;
    }
    public String getK_registrodispos() {
        return k_registrodispos;
    }
    public void setK_registrodispos(String k_registrodispos) {
        this.k_registrodispos = k_registrodispos;
    }
    public String getIp() {
        return this.ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getN_canal() {
        return this.n_canal;
    }
    public void setN_canal(String n_canal) {
        this.n_canal = n_canal;
    }
    
}
