package com.cm.solidappservice.model.adelantonomina.response;

import java.util.Date;

public class ResponseTopes {

    private Date fechaCorte; // f_corte
    private Integer cupoTotal; // v_cupo
    private Integer valorMinimo; // v_minimo
    private Integer valorMaximo; //v_maximo

    public ResponseTopes(){}
    
    public ResponseTopes(Date fechaCorte, Integer cupoTotal, Integer valorMinimo, Integer valorMaximo) {
		super();
		this.fechaCorte = fechaCorte;
		this.cupoTotal = cupoTotal;
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
	}

	public Date getFechaCorte() {
        return this.fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public Integer getCupoTotal() {
        return this.cupoTotal;
    }

    public void setCupoTotal(Integer cupoTotal) {
        this.cupoTotal = cupoTotal;
    }

    public Integer getValorMinimo() {
        return this.valorMinimo;
    }

    public void setValorMinimo(Integer valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Integer getValorMaximo() {
        return this.valorMaximo;
    }

    public void setValorMaximo(Integer valorMaximo) {
        this.valorMaximo = valorMaximo;
    }    
    
}
