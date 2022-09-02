package com.cm.solidappservice.model.datosasociado.bd;

/**
 **CG_REF_CODES 
*/
public class FormatoDireccionesMD {
    
    private String rv_abbreviation;
    private String rv_meaning;
    
    public FormatoDireccionesMD() {
    }

    public FormatoDireccionesMD(String rv_abbreviation, String rv_meaning) {
        this.rv_abbreviation = rv_abbreviation;
        this.rv_meaning = rv_meaning;
    }

    public String getRv_abbreviation() {
        return rv_abbreviation;
    }
    public void setRv_abbreviation(String rv_abbreviation) {
        this.rv_abbreviation = rv_abbreviation;
    }
    public String getRv_meaning() {
        return rv_meaning;
    }
    public void setRv_meaning(String rv_meaning) {
        this.rv_meaning = rv_meaning;
    }

}
