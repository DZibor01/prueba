package com.cm.solidappservice.model.estadocuenta.response;

import java.util.Date;

public class MovimientosProducto {
    
    private String idMovimiento; // k_numdoc;
    private String nombreMovimiento; // n_tipdoc;
    private long valorMovimiento; // v_valor;
    private Date fechaMovimiento; // f_movimi;
        
    public MovimientosProducto(String idMovimiento, String nombreMovimiento, long valorMovimiento,
			Date fechaMovimiento) {
		super();
		this.idMovimiento = idMovimiento;
		this.nombreMovimiento = nombreMovimiento;
		this.valorMovimiento = valorMovimiento;
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getIdMovimiento() {
        return this.idMovimiento;
    }

    public void setIdMovimiento(String idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getNombreMovimiento() {
        return this.nombreMovimiento;
    }

    public void setNombreMovimiento(String nombreMovimiento) {
        this.nombreMovimiento = nombreMovimiento;
    }

    public long getValorMovimiento() {
        return this.valorMovimiento;
    }

    public void setValorMovimiento(long valorMovimiento) {
        this.valorMovimiento = valorMovimiento;
    }

    public Date getFechaMovimiento() {
        return this.fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }
}
