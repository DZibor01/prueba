package com.cm.solidappservice.model.diverseinfo.bd;

/*
**SERVERPARAMETERS
*/
public class ServerParametersMD {
	
	private int serverparametersid;
	private String affair;
	private String content;
	private String serversmtp;
	private String username;
	private String password;
	private String port;
	private String sender;
	
	public int getServerparametersid() {
		return serverparametersid;
	}
	public String getAffair() {
		return affair;
	}
	public String getContent() {
		return content;
	}
	public String getServersmtp() {
		return serversmtp;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getPort() {
		return port;
	}
	public String getSender() {
		return sender;
	}
	public void setServerparametersid(int serverparametersid) {
		this.serverparametersid = serverparametersid;
	}
	public void setAffair(String affair) {
		this.affair = affair;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setServersmtp(String serversmtp) {
		this.serversmtp = serversmtp;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	
}
