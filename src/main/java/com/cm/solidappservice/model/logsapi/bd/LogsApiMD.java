package com.cm.solidappservice.model.logsapi.bd;

import java.util.Date;

/**
 * TAB_APPLOGSAPI
 */
public class LogsApiMD {
 
    private String k_log;
    private String aanumnit;
    private String n_endpoint;
    private String n_controlador;
    private String n_metodo;
    private String n_requestbody;
    private Date f_iniciopeticion;
    private String n_responsebody;
    private String n_resultado;
    private String n_error;
    private Date f_finpeticion;

    public LogsApiMD() {
    }

    public LogsApiMD(String k_log, String aanumnit, String n_endpoint, String n_controlador, String n_metodo,
            String n_requestbody, Date f_iniciopeticion, String n_responsebody, String n_resultado, String n_error, Date f_finpeticion) {
        this.k_log = k_log;
        this.aanumnit = aanumnit;
        this.n_endpoint = n_endpoint;
        this.n_controlador = n_controlador;
        this.n_metodo = n_metodo;
        this.n_requestbody = n_requestbody;
        this.f_iniciopeticion = f_iniciopeticion;
        this.n_responsebody = n_responsebody;
        this.n_resultado = n_resultado;
        this.n_error = n_error;
        this.f_finpeticion = f_finpeticion;
    }    

    public LogsApiMD(String k_log, String aanumnit, String n_endpoint, String n_controlador, String n_metodo,
            String n_requestbody, Date f_iniciopeticion) {
        this.k_log = k_log;
        this.aanumnit = aanumnit;
        this.n_endpoint = n_endpoint;
        this.n_controlador = n_controlador;
        this.n_metodo = n_metodo;
        this.f_iniciopeticion = f_iniciopeticion;
        this.n_requestbody = n_requestbody;
    }

    public LogsApiMD(String k_log, String n_responsebody, String n_resultado, String n_error, Date f_finpeticion) {
        this.k_log = k_log;
        this.n_responsebody = n_responsebody;
        this.n_resultado = n_resultado;
        this.n_error = n_error;
        this.f_finpeticion = f_finpeticion;
    }

    public String getK_log() {
        return k_log;
    }

    public void setK_log(String k_log) {
        this.k_log = k_log;
    }

    public String getAanumnit() {
        return aanumnit;
    }

    public void setAanumnit(String aanumnit) {
        this.aanumnit = aanumnit;
    }

    public String getN_endpoint() {
        return n_endpoint;
    }

    public void setN_endpoint(String n_endpoint) {
        this.n_endpoint = n_endpoint;
    }

    public String getN_controlador() {
        return n_controlador;
    }

    public void setN_controlador(String n_controlador) {
        this.n_controlador = n_controlador;
    }

    public String getN_metodo() {
        return n_metodo;
    }

    public void setN_metodo(String n_metodo) {
        this.n_metodo = n_metodo;
    }

    public Date getF_iniciopeticion() {
        return f_iniciopeticion;
    }

    public void setF_iniciopeticion(Date f_iniciopeticion) {
        this.f_iniciopeticion = f_iniciopeticion;
    }

    public String getN_requestbody() {
        return n_requestbody;
    }

    public void setN_requestbody(String n_requestbody) {
        this.n_requestbody = n_requestbody;
    }

    public String getN_responsebody() {
        return n_responsebody;
    }

    public void setN_responsebody(String n_responsebody) {
        this.n_responsebody = n_responsebody;
    }

    public String getN_resultado() {
        return n_resultado;
    }

    public void setN_resultado(String n_resultado) {
        this.n_resultado = n_resultado;
    }

    public String getN_error() {
        return n_error;
    }

    public void setN_error(String n_error) {
        this.n_error = n_error;
    }

    public Date getF_finpeticion() {
        return f_finpeticion;
    }

    public void setF_finpeticion(Date f_finpeticion) {
        this.f_finpeticion = f_finpeticion;
    }

}
