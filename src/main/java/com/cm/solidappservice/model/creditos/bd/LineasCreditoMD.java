package com.cm.solidappservice.model.creditos.bd;

/*
**TAB_APPLINEASCRED
*/
public class LineasCreditoMD {
	
	private String k_linea;
	private String n_linea;
	private String i_estado;
	private String k_productoarco;

	public LineasCreditoMD(){}

	public LineasCreditoMD(String k_linea, String n_linea, String i_estado, String k_productoarco){
        super();
        this.k_linea = k_linea;
        this.n_linea = n_linea;
        this.i_estado = i_estado;
        this.k_productoarco = k_productoarco;
    }

	public String getK_linea() {
		return this.k_linea;
	}

	public void setK_linea(String k_linea) {
		this.k_linea = k_linea;
	}

	public String getN_linea() {
		return this.n_linea;
	}

	public void setN_linea(String n_linea) {
		this.n_linea = n_linea;
	}

	public String getI_estado() {
		return this.i_estado;
	}

	public void setI_estado(String i_estado) {
		this.i_estado = i_estado;
	}

	public String getK_productoarco() {
		return this.k_productoarco;
	}

	public void setK_productoarco(String k_productoarco) {
		this.k_productoarco = k_productoarco;
	}		
}