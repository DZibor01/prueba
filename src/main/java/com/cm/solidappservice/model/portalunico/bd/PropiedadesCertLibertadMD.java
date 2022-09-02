package com.cm.solidappservice.model.portalunico.bd;

/**
 * TAB_APPPROPERTLIBER
 */
public class PropiedadesCertLibertadMD {
    
    private String k_propiedad;  //K_PROPIEDAD NUMBER(10) 
    private String k_transaccion; //K_TRANSACCION  VARCHAR2(25 BYTE),
    private String a_nummatricula; //A_NUMMATRICULA VARCHAR2(25 BYTE),
    private String d_direccion; //D_DIRECCION VARCHAR2(250 BYTE),
    private String k_depart; //K_DEPART VARCHAR2(10 BYTE),
    private String n_depart; //N_DEPART VARCHAR2(50 BYTE),
    private String k_ciudad; //K_CIUDAD VARCHAR2(10 BYTE),
    private String n_ciudad; //N_CIUDAD VARCHAR2(50 BYTE)
    
    public PropiedadesCertLibertadMD() {
    }
    
    public PropiedadesCertLibertadMD(String k_transaccion, String a_nummatricula,
            String d_direccion, String k_depart, String n_depart, String k_ciudad, String n_ciudad) {
        this.k_transaccion = k_transaccion;
        this.a_nummatricula = a_nummatricula;
        this.d_direccion = d_direccion;
        this.k_depart = k_depart;
        this.n_depart = n_depart;
        this.k_ciudad = k_ciudad;
        this.n_ciudad = n_ciudad;
    }

    public String getK_propiedad() {
        return k_propiedad;
    }

    public void setK_propiedad(String k_propiedad) {
        this.k_propiedad = k_propiedad;
    }

    public String getK_transaccion() {
        return k_transaccion;
    }

    public void setK_transaccion(String k_transaccion) {
        this.k_transaccion = k_transaccion;
    }

    public String getA_nummatricula() {
        return a_nummatricula;
    }

    public void setA_nummatricula(String a_nummatricula) {
        this.a_nummatricula = a_nummatricula;
    }

    public String getD_direccion() {
        return d_direccion;
    }

    public void setD_direccion(String d_direccion) {
        this.d_direccion = d_direccion;
    }

    public String getK_depart() {
        return k_depart;
    }

    public void setK_depart(String k_depart) {
        this.k_depart = k_depart;
    }

    public String getN_depart() {
        return n_depart;
    }

    public void setN_depart(String n_depart) {
        this.n_depart = n_depart;
    }

    public String getK_ciudad() {
        return k_ciudad;
    }

    public void setK_ciudad(String k_ciudad) {
        this.k_ciudad = k_ciudad;
    }

    public String getN_ciudad() {
        return n_ciudad;
    }

    public void setN_ciudad(String n_ciudad) {
        this.n_ciudad = n_ciudad;
    }


    
}
