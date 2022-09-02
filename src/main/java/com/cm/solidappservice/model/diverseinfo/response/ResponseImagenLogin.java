package com.cm.solidappservice.model.diverseinfo.response;

public class ResponseImagenLogin {
	
	private String imageUrl;
	
	public ResponseImagenLogin() {
	}

	public ResponseImagenLogin(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}