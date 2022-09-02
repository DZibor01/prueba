package com.cm.solidappservice.model.parametrosgenerales.bd;

/**
 * TABLA TAB_APPPARAMETROS
 */

public class ParametrosGeneralesMD {
    
    private Integer k_parametro;
    private String n_parametro;
    private String i_estado;
    private String n_value1;
    private String n_value2;
    private String n_value3;
    private String n_value4;
    
    public ParametrosGeneralesMD() {
    }

    public ParametrosGeneralesMD(Integer k_parametro, String n_parametro, String i_estado, String n_value1,
            String n_value2, String n_value3, String n_value4) {
        this.k_parametro = k_parametro;
        this.n_parametro = n_parametro;
        this.i_estado = i_estado;
        this.n_value1 = n_value1;
        this.n_value2 = n_value2;
        this.n_value3 = n_value3;
        this.n_value4 = n_value4;
    }

    public Integer getK_parametro() {
        return k_parametro;
    }

    public void setK_parametro(Integer k_parametro) {
        this.k_parametro = k_parametro;
    }

    public String getN_parametro() {
        return n_parametro;
    }

    public void setN_parametro(String n_parametro) {
        this.n_parametro = n_parametro;
    }

    public String getI_estado() {
        return i_estado;
    }

    public void setI_estado(String i_estado) {
        this.i_estado = i_estado;
    }

    public String getN_value1() {
        return n_value1;
    }

    public void setN_value1(String n_value1) {
        this.n_value1 = n_value1;
    }

    public String getN_value2() {
        return n_value2;
    }

    public void setN_value2(String n_value2) {
        this.n_value2 = n_value2;
    }

    public String getN_value3() {
        return n_value3;
    }

    public void setN_value3(String n_value3) {
        this.n_value3 = n_value3;
    }

    public String getN_value4() {
        return n_value4;
    }

    public void setN_value4(String n_value4) {
        this.n_value4 = n_value4;
    }

    

}
