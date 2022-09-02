package com.cm.solidappservice.model.estadocuenta.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestMovimientosCuenta extends RequestAutenticacion{
    
    private Integer tipoCuenta; //k_tipcuent
    private String codigoProducto; //v_tipodr
    private String numeroProducto; //v_numdoc

    public Integer getTipoCuenta() {
        return this.tipoCuenta;
    }

    public void setTipoCuenta(Integer tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNumeroProducto() {
        return this.numeroProducto;
    }

    public void setNumeroProducto(String numeroProducto) {
        this.numeroProducto = numeroProducto;
    }
}
