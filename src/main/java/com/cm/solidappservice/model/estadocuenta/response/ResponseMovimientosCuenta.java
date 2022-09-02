package com.cm.solidappservice.model.estadocuenta.response;

import java.util.List;

public class ResponseMovimientosCuenta {
    
    private Integer tipoCuenta; //K_tipcuent
    private String codigoProducto; // a_tipodr;
    private String numeroProducto; // a_numdoc;
    private List<MovimientosProducto> movimientos;

    public ResponseMovimientosCuenta(){}    

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

    public List<MovimientosProducto> getMovimientos() {
        return this.movimientos;
    }

    public void setMovimientos(List<MovimientosProducto> movimientos) {
        this.movimientos = movimientos;
    }
}
