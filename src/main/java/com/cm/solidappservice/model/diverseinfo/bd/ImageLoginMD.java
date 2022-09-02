package com.cm.solidappservice.model.diverseinfo.bd;


/**
 **IMAGELOGIN
 TAB_APPIMAGENLOGIN
*/
public class ImageLoginMD {
	
	private int k_imagenlogin;
	private String n_url_imagenlogin;
	private String i_estado;

	public ImageLoginMD() {
	}

	public ImageLoginMD(int k_imagenlogin, String n_url_imagenlogin, String i_estado) {
		this.k_imagenlogin = k_imagenlogin;
		this.n_url_imagenlogin = n_url_imagenlogin;
		this.i_estado = i_estado;
	}

	public int getK_imagenlogin() {
		return k_imagenlogin;
	}

	public void setK_imagenlogin(int k_imagenlogin) {
		this.k_imagenlogin = k_imagenlogin;
	}

	public String getN_url_imagenlogin() {
		return n_url_imagenlogin;
	}

	public void setN_url_imagenlogin(String n_url_imagenlogin) {
		this.n_url_imagenlogin = n_url_imagenlogin;
	}

	public String getI_estado() {
		return i_estado;
	}

	public void setI_estado(String i_estado) {
		this.i_estado = i_estado;
	}
	
}
