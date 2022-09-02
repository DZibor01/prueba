package com.cm.solidappservice.model.transferencias.response;

public class ResponseCuentasDisponibles {
    
    private String cedulaAsociado;
    private String nombreAsociado;
    private String numeroCuenta;
    
    public ResponseCuentasDisponibles(){}

    public ResponseCuentasDisponibles(String cedulaAsociado, String nombreAsociado, String numeroCuenta) {
		super();
		this.cedulaAsociado = cedulaAsociado;
		this.nombreAsociado = nombreAsociado;
		this.numeroCuenta = numeroCuenta;
	}

	public String getCedulaAsociado() {
        return this.cedulaAsociado;
    }

    public void setCedulaAsociado(String cedulaAsociado) {
        this.cedulaAsociado = cedulaAsociado;
    }

    public String getNombreAsociado() {
        return this.nombreAsociado;
    }

    public void setNombreAsociado(String nombreAsociado) {
        this.nombreAsociado = nombreAsociado;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
