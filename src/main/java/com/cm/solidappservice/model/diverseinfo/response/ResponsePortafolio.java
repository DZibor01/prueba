package com.cm.solidappservice.model.diverseinfo.response;

import java.util.ArrayList;
import java.util.List;

public class ResponsePortafolio {
	
	private String categoriaPadre;
	private String categoria;	
	public List<DetallePortafolio> detalle = new ArrayList<DetallePortafolio>();
	
	public ResponsePortafolio() {
	}

	public ResponsePortafolio(String categoriaPadre, String categoria, List<DetallePortafolio> detalle) {
		this.categoriaPadre = categoriaPadre;
		this.categoria = categoria;
		this.detalle = detalle;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoriaPadre() {
		return categoriaPadre;
	}

	public void setCategoriaPadre(String categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}
	
	public static class DetallePortafolio{
		
		String nombre;
		String descripcionCorta;
		String descripcionLarga;

		public DetallePortafolio() {
		}

		public DetallePortafolio(String nombre, String descripcionCorta, String descripcionLarga){
			this.nombre = nombre;
			this.descripcionCorta = descripcionCorta;
			this.descripcionLarga = descripcionLarga;
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcionCorta() {
			return descripcionCorta;
		}

		public void setDescripcionCorta(String descripcionCorta) {
			this.descripcionCorta = descripcionCorta;
		}

		public String getDescripcionLarga() {
			return descripcionLarga;
		}
		
		public void setDescripcionLarga(String descripcionLarga) {
			this.descripcionLarga = descripcionLarga;
		}		
	}
}