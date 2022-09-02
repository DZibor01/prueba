package com.cm.solidappservice.model.adelantonomina.response;
import java.util.Date;
import java.util.List;

public class ResponseValidarRequisitos {
    
    private String idValidacion; // k_identificador
    private String idRequistio; // k_supreq
    private String idModalidad; // k_modali
    private Date fechaCorte; // f_corte
    private String cumpleRequisitos; //cumple
    private List<NoCumple> motivos;   
    
    public ResponseValidarRequisitos(){}
    
    public ResponseValidarRequisitos(String idValidacion, String idRequistio, String idModalidad, Date fechaCorte,
			String cumpleRequisitos, List<NoCumple> motivos) {
		super();
		this.idValidacion = idValidacion;
		this.idRequistio = idRequistio;
		this.idModalidad = idModalidad;
		this.fechaCorte = fechaCorte;
		this.cumpleRequisitos = cumpleRequisitos;
        this.motivos = motivos;
	}
    
	public String getIdValidacion() {
        return this.idValidacion;
    }

    public void setIdValidacion(String idValidacion) {
        this.idValidacion = idValidacion;
    }

    public String getIdRequistio() {
        return this.idRequistio;
    }

    public void setIdRequistio(String idRequistio) {
        this.idRequistio = idRequistio;
    }

    public String getIdModalidad() {
        return this.idModalidad;
    }

    public void setIdModalidad(String idModalidad) {
        this.idModalidad = idModalidad;
    }

    public Date getFechaCorte() {
        return this.fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public String getCumpleRequisitos() {
        return this.cumpleRequisitos;
    }

    public void setCumpleRequisitos(String cumpleRequisitos) {
        this.cumpleRequisitos = cumpleRequisitos;
    }

    public List<NoCumple> getMotivos() {
        return this.motivos;
    }

    public void setMotivos(List<NoCumple> motivos) {
        this.motivos = motivos;
    }

}
