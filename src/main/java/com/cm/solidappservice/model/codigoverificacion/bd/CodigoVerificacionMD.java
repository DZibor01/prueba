package com.cm.solidappservice.model.codigoverificacion.bd;

import java.util.Date;

/**
**TAB_APPCODIGOVERIF
*/
public class CodigoVerificacionMD {
    
    private String k_codigo;
    private String n_codigo;
    private String a_anumnit;
    private Date f_generacion;
    private Date f_expiracion;
    private String i_expirado;
    private String n_tipoenvio;
	private String n_envio;
    private String n_resultado;

    public CodigoVerificacionMD() {
    }

    public CodigoVerificacionMD(String k_codigo, String a_anumnit) {
        this.k_codigo = k_codigo;
        this.a_anumnit = a_anumnit;
    }    

    public CodigoVerificacionMD(String k_codigo, String n_codigo, String a_anumnit, Date f_generacion,
            Date f_expiracion, String i_expirado, String n_tipoenvio, String n_envio, String n_resultado) {
        this.k_codigo = k_codigo;
        this.n_codigo = n_codigo;
        this.a_anumnit = a_anumnit;
        this.f_generacion = f_generacion;
        this.f_expiracion = f_expiracion;
        this.i_expirado = i_expirado;
        this.n_tipoenvio = n_tipoenvio;
        this.n_envio = n_envio;
        this.n_resultado = n_resultado;
    }

    public String getK_codigo() {
        return this.k_codigo;
    }

    public void setK_codigo(String k_codigo) {
        this.k_codigo = k_codigo;
    }

    public String getN_codigo() {
        return this.n_codigo;
    }

    public void setN_codigo(String n_codigo) {
        this.n_codigo = n_codigo;
    }

    public String getA_anumnit() {
        return this.a_anumnit;
    }

    public void setA_anumnit(String a_anumnit) {
        this.a_anumnit = a_anumnit;
    }

    public Date getF_generacion() {
        return this.f_generacion;
    }

    public void setF_generacion(Date f_generacion) {
        this.f_generacion = f_generacion;
    }

    public Date getF_expiracion() {
        return this.f_expiracion;
    }

    public void setF_expiracion(Date f_expiracion) {
        this.f_expiracion = f_expiracion;
    }

    public String getI_expirado() {
        return this.i_expirado;
    }

    public void setI_expirado(String i_expirado) {
        this.i_expirado = i_expirado;
    }

    public String getN_tipoenvio() {
        return n_tipoenvio;
    }

    public void setN_tipoenvio(String n_tipoenvio) {
        this.n_tipoenvio = n_tipoenvio;
    }

    public String getN_envio() {
        return n_envio;
    }

    public void setN_envio(String n_envio) {
        this.n_envio = n_envio;
    }

    public String getN_resultado() {
        return n_resultado;
    }

    public void setN_resultado(String n_resultado) {
        this.n_resultado = n_resultado;
    }  
        
}
