package com.cm.solidappservice.model.portalunico.bd;

/**
 * PK_APP_TRANSA.PR_REGISTRA_TRANSA_CERTYLIBER
 */
public class CompraCertificadoMD {
    
    private String V_K_TRANSA; //V_K_TRANSA
    private String V_AANUMNIT; //V_AANUMNIT
    private String V_N_NOMBRE; //V_N_NOMBRE
    private String V_D_EMAIL; //V_D_EMAIL
    private String V_T_TELCEL; //V_T_TELCEL
    private Integer V_VALOR_TOTAL; //V_VALOR_TOTAL
    private String V_PAGO_CREDITO; //V_PAGO_CREDITO
    private String V_A_NUMCTA; //V_A_NUMCTA
    private String V_F_SOLICITUD; //DD/MM/YYYY hh24:mi:ss
    private String V_RESULT; //V_RESULT
    private String V_MESSAGE_ERROR; //V_MESSAGE_ERROR
        
    public CompraCertificadoMD() {
    }

    public CompraCertificadoMD(String v_K_TRANSA, String v_AANUMNIT, String v_N_NOMBRE, String v_D_EMAIL,
            String v_T_TELCEL, Integer v_VALOR_TOTAL, String v_PAGO_CREDITO, String v_A_NUMCTA, String v_F_SOLICITUD, String v_RESULT, String v_MESSAGE_ERROR) {
        V_K_TRANSA = v_K_TRANSA;
        V_AANUMNIT = v_AANUMNIT;
        V_N_NOMBRE = v_N_NOMBRE;
        V_D_EMAIL = v_D_EMAIL;
        V_T_TELCEL = v_T_TELCEL;
        V_VALOR_TOTAL = v_VALOR_TOTAL;
        V_PAGO_CREDITO = v_PAGO_CREDITO;
        V_A_NUMCTA = v_A_NUMCTA;
        V_F_SOLICITUD = v_F_SOLICITUD;
        V_RESULT = v_RESULT;
        V_MESSAGE_ERROR = v_MESSAGE_ERROR;
    }

    public String getV_K_TRANSA() {
        return V_K_TRANSA;
    }

    public void setV_K_TRANSA(String v_K_TRANSA) {
        V_K_TRANSA = v_K_TRANSA;
    }

    public String getV_AANUMNIT() {
        return V_AANUMNIT;
    }

    public void setV_AANUMNIT(String v_AANUMNIT) {
        V_AANUMNIT = v_AANUMNIT;
    }

    public String getV_N_NOMBRE() {
        return V_N_NOMBRE;
    }

    public void setV_N_NOMBRE(String v_N_NOMBRE) {
        V_N_NOMBRE = v_N_NOMBRE;
    }

    public String getV_D_EMAIL() {
        return V_D_EMAIL;
    }

    public void setV_D_EMAIL(String v_D_EMAIL) {
        V_D_EMAIL = v_D_EMAIL;
    }

    public String getV_T_TELCEL() {
        return V_T_TELCEL;
    }

    public void setV_T_TELCEL(String v_T_TELCEL) {
        V_T_TELCEL = v_T_TELCEL;
    }

    public Integer getV_VALOR_TOTAL() {
        return V_VALOR_TOTAL;
    }

    public void setV_VALOR_TOTAL(Integer v_VALOR_TOTAL) {
        V_VALOR_TOTAL = v_VALOR_TOTAL;
    }

    public String getV_A_NUMCTA() {
        return V_A_NUMCTA;
    }

    public String getV_PAGO_CREDITO() {
        return V_PAGO_CREDITO;
    }

    public void setV_PAGO_CREDITO(String v_PAGO_CREDITO) {
        V_PAGO_CREDITO = v_PAGO_CREDITO;
    }

    public void setV_A_NUMCTA(String v_A_NUMCTA) {
        V_A_NUMCTA = v_A_NUMCTA;
    }

    public String getV_F_SOLICITUD() {
        return V_F_SOLICITUD;
    }

    public void setV_F_SOLICITUD(String v_F_SOLICITUD) {
        V_F_SOLICITUD = v_F_SOLICITUD;
    }

    public String getV_RESULT() {
        return V_RESULT;
    }

    public void setV_RESULT(String v_RESULT) {
        V_RESULT = v_RESULT;
    }

    public String getV_MESSAGE_ERROR() {
        return V_MESSAGE_ERROR;
    }

    public void setV_MESSAGE_ERROR(String v_MESSAGE_ERROR) {
        V_MESSAGE_ERROR = v_MESSAGE_ERROR;
    }

    
}
