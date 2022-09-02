package com.cm.solidappservice.model.adelantonomina.response;

public class ResponseTips {
    
    private Integer idTip; // k_TIP
    private String nombreTip; // n_TIP

    public ResponseTips(){}

    public ResponseTips(Integer idTip, String nombreTip){
        super();
        this.idTip = idTip;
        this.nombreTip = nombreTip;
    }   

    public Integer getIdTip() {
        return this.idTip;
    }

    public void setIdTip(Integer idTip) {
        this.idTip = idTip;
    }

    public String getNombreTip() {
        return this.nombreTip;
    }

    public void setNombreTip(String nombreTip) {
        this.nombreTip = nombreTip;
    }



}
