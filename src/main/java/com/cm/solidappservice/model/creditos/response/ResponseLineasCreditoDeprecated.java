package com.cm.solidappservice.model.creditos.response;

public class ResponseLineasCreditoDeprecated {
    
    private String K_LINEA;
	private String N_LINEA;
	private String I_ESTADO;
	private String K_PRODUCTOARCO;
	
	public ResponseLineasCreditoDeprecated() {
		
	}
	
	public ResponseLineasCreditoDeprecated(String k_LINEA, String n_LINEA, String i_ESTADO, String k_PRODUCTOARCO) {
		super();		K_LINEA = k_LINEA;
		N_LINEA = n_LINEA;
		I_ESTADO = i_ESTADO;
		K_PRODUCTOARCO = k_PRODUCTOARCO;
	}

	public String getK_LINEA() {
		return K_LINEA;
	}

	public void setK_LINEA(String k_LINEA) {
		K_LINEA = k_LINEA;
	}

	public String getN_LINEA() {
		return N_LINEA;
	}

	public void setN_LINEA(String n_LINEA) {
		N_LINEA = n_LINEA;
	}

	public String getI_ESTADO() {
		return I_ESTADO;
	}

	public void setI_ESTADO(String i_ESTADO) {
		I_ESTADO = i_ESTADO;
	}

	public String getK_PRODUCTOARCO() {
		return K_PRODUCTOARCO;
	}

	public void setK_PRODUCTOARCO(String k_PRODUCTOARCO) {
		K_PRODUCTOARCO = k_PRODUCTOARCO;
	}

}
