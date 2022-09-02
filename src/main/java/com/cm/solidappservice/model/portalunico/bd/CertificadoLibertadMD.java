package com.cm.solidappservice.model.portalunico.bd;

/**
 * TAB_APPTRANCERTLIBER
 */
public class CertificadoLibertadMD {
    
    private String k_transaccion; //K_TRANSACCION  VARCHAR2(25 BYTE),
    private String n_nombre; //N_NOMBRE VARCHAR2(100 BYTE),
    private String a_anumnit; //A_ANUMNIT VARCHAR2(20 BYTE),
    private String k_idterc; //K_IDTERC VARCHAR2(10 BYTE)
    private String d_email; //D_EMAIL VARCHAR2(100 BYTE),
    private String t_telcel; //T_TELCEL VARCHAR2(15 BYTE),
    private String f_solicitud; //F_SOLICITUD DATE,
    private Integer v_valorcert; //V_VALORCERT NUMBER(16),
    private Integer v_valortotal; //V_VALORTOTAL NUMBER(16),
    private String n_numcta; //A_NUMCTA VARCHAR2(20 BYTE),
    private String k_numdoc_mov; //K_NUMDOC_MOV VARCHAR2(20 BYTE)

    private String i_estadotransaccion; //I_ESTADOTRANSACCION VARCHAR2(2 BYTE)
    private String i_estadoheader; //I_ESTADOHEADER VARCHAR2(2 BYTE)
    private String i_estadodebito; //I_ESTADODEBITO VARCHAR2(2 BYTE)
    private String i_estadocredito; //I_ESTADOCREDITO VARCHAR2(2 BYTE)
    private String n_error; //N_ERROR VARCHAR2(2 BYTE)

    public CertificadoLibertadMD() {
    }

    public CertificadoLibertadMD(String k_transaccion, String n_nombre, String a_anumnit, String k_idterc,
            String d_email, String t_telcel, String f_solicitud, Integer v_valorcert, Integer v_valortotal,
            String n_numcta, String k_numdoc_mov, String i_estadotransaccion, String i_estadoheader,
            String i_estadodebito, String i_estadocredito, String n_error) {
        this.k_transaccion = k_transaccion;
        this.n_nombre = n_nombre;
        this.a_anumnit = a_anumnit;
        this.k_idterc = k_idterc;
        this.d_email = d_email;
        this.t_telcel = t_telcel;
        this.f_solicitud = f_solicitud;
        this.v_valorcert = v_valorcert;
        this.v_valortotal = v_valortotal;
        this.n_numcta = n_numcta;
        this.k_numdoc_mov = k_numdoc_mov;
        this.i_estadotransaccion = i_estadotransaccion;
        this.i_estadoheader = i_estadoheader;
        this.i_estadodebito = i_estadodebito;
        this.i_estadocredito = i_estadocredito;
        this.n_error = n_error;
    }

    public String getK_transaccion() {
        return k_transaccion;
    }

    public void setK_transaccion(String k_transaccion) {
        this.k_transaccion = k_transaccion;
    }

    public String getN_nombre() {
        return n_nombre;
    }

    public void setN_nombre(String n_nombre) {
        this.n_nombre = n_nombre;
    }

    public String getA_anumnit() {
        return a_anumnit;
    }

    public void setA_anumnit(String a_anumnit) {
        this.a_anumnit = a_anumnit;
    }

    public String getK_idterc() {
        return k_idterc;
    }

    public void setK_idterc(String k_idterc) {
        this.k_idterc = k_idterc;
    }

    public String getD_email() {
        return d_email;
    }

    public void setD_email(String d_email) {
        this.d_email = d_email;
    }

    public String getT_telcel() {
        return t_telcel;
    }

    public void setT_telcel(String t_telcel) {
        this.t_telcel = t_telcel;
    }

    public String getF_solicitud() {
        return f_solicitud;
    }

    public void setF_solicitud(String f_solicitud) {
        this.f_solicitud = f_solicitud;
    }

    public Integer getV_valorcert() {
        return v_valorcert;
    }

    public void setV_valorcert(Integer v_valorcert) {
        this.v_valorcert = v_valorcert;
    }

    public Integer getV_valortotal() {
        return v_valortotal;
    }

    public void setV_valortotal(Integer v_valortotal) {
        this.v_valortotal = v_valortotal;
    }

    public String getN_numcta() {
        return n_numcta;
    }

    public void setN_numcta(String n_numcta) {
        this.n_numcta = n_numcta;
    }

    public String getK_numdoc_mov() {
        return k_numdoc_mov;
    }

    public void setK_numdoc_mov(String k_numdoc_mov) {
        this.k_numdoc_mov = k_numdoc_mov;
    }

    public String getI_estadotransaccion() {
        return i_estadotransaccion;
    }

    public void setI_estadotransaccion(String i_estadotransaccion) {
        this.i_estadotransaccion = i_estadotransaccion;
    }

    public String getI_estadoheader() {
        return i_estadoheader;
    }

    public void setI_estadoheader(String i_estadoheader) {
        this.i_estadoheader = i_estadoheader;
    }

    public String getI_estadodebito() {
        return i_estadodebito;
    }

    public void setI_estadodebito(String i_estadodebito) {
        this.i_estadodebito = i_estadodebito;
    }

    public String getI_estadocredito() {
        return i_estadocredito;
    }

    public void setI_estadocredito(String i_estadocredito) {
        this.i_estadocredito = i_estadocredito;
    }

    public String getN_error() {
        return n_error;
    }

    public void setN_error(String n_error) {
        this.n_error = n_error;
    }
   
    

}
