package com.cm.solidappservice.model.transferencias.response;

import java.util.List;

public class ResponseCuentasInscritas {
    
    private String idAsociado; //k_idterc
    private String nombreAsociado; //nnasocia_o
    private String cedulaAsociado; //aanumnit_o
    private List<CuentaInscrita> cuentasInscritas;

    public ResponseCuentasInscritas(){}

    public String getIdAsociado() {
        return this.idAsociado;
    }

    public void setIdAsociado(String idAsociado) {
        this.idAsociado = idAsociado;
    }

    public String getNombreAsociado() {
        return this.nombreAsociado;
    }

    public void setNombreAsociado(String nombreAsociado) {
        this.nombreAsociado = nombreAsociado;
    }

    public String getCedulaAsociado() {
        return this.cedulaAsociado;
    }

    public void setCedulaAsociado(String cedulaAsociado) {
        this.cedulaAsociado = cedulaAsociado;
    }

    public List<CuentaInscrita> getCuentasInscritas() {
        return this.cuentasInscritas;
    }

    public void setCuentasInscritas(List<CuentaInscrita> cuentasInscritas) {
        this.cuentasInscritas = cuentasInscritas;
    }

}
