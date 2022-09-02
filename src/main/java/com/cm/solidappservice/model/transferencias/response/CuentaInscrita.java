package com.cm.solidappservice.model.transferencias.response;
import java.util.Date;

public class CuentaInscrita {

    private String cedulaAsociadoInscrito;  //aanumnit 
    private String nombreAsociadoInscrito;  //nnasocia
    private String idAsociadoInscrito;  //k_idterc 
    private String idCuenta;  //k_cuenta
    private String numeroCuenta;  //n_numcta
    private Date fechaInscripcion;  //f_fecape
    private String estadoCuenta;  //i_estado
    
    public CuentaInscrita(){}

    public CuentaInscrita(String cedulaAsociadoInscrito, String nombreAsociadoInscrito, String idAsociadoInscrito, String idCuenta,
			String numeroCuenta, Date fechaInscripcion, String estadoCuenta) {
		super();
		this.cedulaAsociadoInscrito = cedulaAsociadoInscrito;
		this.nombreAsociadoInscrito = nombreAsociadoInscrito;
		this.idAsociadoInscrito = idAsociadoInscrito;
		this.idCuenta = idCuenta;
		this.numeroCuenta = numeroCuenta;
		this.fechaInscripcion = fechaInscripcion;
		this.estadoCuenta = estadoCuenta;
	}

	public String getCedulaAsociadoInscrita() {
        return this.cedulaAsociadoInscrito;
    }

    public void setCedulaAsociadoInscrita(String cedulaAsociadoInscrito) {
        this.cedulaAsociadoInscrito = cedulaAsociadoInscrito;
    }

    public String getNombreAsociadoInscrito() {
        return this.nombreAsociadoInscrito;
    }

    public void setNombreAsociadoInscrito(String nombreAsociadoInscrito) {
        this.nombreAsociadoInscrito = nombreAsociadoInscrito;
    }

    public String getIdAsociadoInscrito() {
        return this.idAsociadoInscrito;
    }

    public void setIdAsociadoInscrito(String idAsociadoInscrito) {
        this.idAsociadoInscrito = idAsociadoInscrito;
    }

    public String getIdCuenta() {
        return this.idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFechaInscripcion() {
        return this.fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstadoCuenta() {
        return this.estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }
    
}
