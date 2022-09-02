package com.cm.solidappservice.model.creditos.response;

import java.util.List;

public class ResponseUbicaciones {

	private List<Pais> paises;
	
	public ResponseUbicaciones() {
		super();
	}

	public ResponseUbicaciones(List<Pais> paises) {
		super();
		this.paises = paises;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}    
    
    
}
