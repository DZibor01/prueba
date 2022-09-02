package com.cm.solidappservice.model.login.request;

public class RequestTokenSession {
   
	private String origen;
    private String tokenSession;
   
    public RequestTokenSession() {
    }

    public RequestTokenSession(String origen, String tokenSession) {
    	this.origen = origen;
        this.tokenSession = tokenSession;
    }

    public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getTokenSession() {
        return tokenSession;
    }

    public void setTokenSession(String tokenSession) {
        this.tokenSession = tokenSession;
    }

}
