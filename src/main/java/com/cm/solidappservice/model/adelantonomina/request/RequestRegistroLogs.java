package com.cm.solidappservice.model.adelantonomina.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestRegistroLogs extends RequestAutenticacion{

    
    private String titulo; // n_accion
    private String descripcion; // n_descr

    public RequestRegistroLogs(){}

    public RequestRegistroLogs(String titulo, String descripcion){
        super();
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
