package com.cm.solidappservice.model.adelantonomina.response;

import java.util.Date;

public class NoCumple {

    private Date fechaEvaluacion; // _evaluacion
    private String observacion; //n_observacion

    public NoCumple(){}
    
    public NoCumple(Date fechaEvaluacion, String observacion) {
		super();
		this.fechaEvaluacion = fechaEvaluacion;
		this.observacion = observacion;
	}

	public Date getFechaEvaluacion() {
        return this.fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }


}
