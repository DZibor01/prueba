package com.cm.solidappservice.model.datosasociado.bd;

/*
 **PK_APP_GESTIONDATOSASOCIADO.PR_ACTUALIZA_DATOSASOCIADO 
 */
public class ActualizaDatosAsociadoMD{

	private String vk_actdatos;
    private String vk_regisdisposi;
    private String va_anumnit;
    private String vn_nombre;
    private String vd_direcc;
    private String vt_celular;
    private String vd_email;
    private String vn_barrio;
    private String vk_ciudad;
    private String vk_depart;
    private String vk_pais;
	private String v_ip;
	private String vn_canal;

	public ActualizaDatosAsociadoMD() {
	}

	public ActualizaDatosAsociadoMD(String vk_actdatos, String vk_regisdisposi, String va_anumnit, String vn_nombre,
			String vd_direcc, String vt_celular, String vd_email, String vn_barrio, String vk_ciudad, String vk_depart, 
			String vk_pais, String v_ip, String vn_canal) {
		this.vk_actdatos = vk_actdatos;
		this.vk_regisdisposi = vk_regisdisposi;
		this.va_anumnit = va_anumnit;
		this.vn_nombre = vn_nombre;
		this.vd_direcc = vd_direcc;
		this.vt_celular = vt_celular;
		this.vd_email = vd_email;
		this.vn_barrio = vn_barrio;
		this.vk_ciudad = vk_ciudad;
		this.vk_depart = vk_depart;
		this.vk_pais = vk_pais;
		this.v_ip = v_ip;
		this.vn_canal = vn_canal;
	}

	public String getVk_regisdisposi() {
		return vk_regisdisposi;
	}
	public void setVk_regisdisposi(String vk_regisdisposi) {
		this.vk_regisdisposi = vk_regisdisposi;
	}
	public String getVa_anumnit() {
		return va_anumnit;
	}
	public void setVa_anumnit(String va_anumnit) {
		this.va_anumnit = va_anumnit;
	}
	public String getVn_nombre1() {
		return vn_nombre;
	}
	public void setVn_nombre(String vn_nombre) {
		this.vn_nombre = vn_nombre;
	}
	public String getVd_direcc() {
		return vd_direcc;
	}
	public void setVd_direcc(String vd_direcc) {
		this.vd_direcc = vd_direcc;
	}
	public String getVt_celular() {
		return vt_celular;
	}
	public void setVt_celular(String vt_celular) {
		this.vt_celular = vt_celular;
	}
	public String getVd_email() {
		return vd_email;
	}
	public void setVd_email(String vd_email) {
		this.vd_email = vd_email;
	}
	public String getVn_barrio() {
		return vn_barrio;
	}
	public void setVn_barrio(String vn_barrio) {
		this.vn_barrio = vn_barrio;
	}
	public String getVk_ciudad() {
		return vk_ciudad;
	}
	public void setVk_ciudad(String vk_ciudad) {
		this.vk_ciudad = vk_ciudad;
	}
	public String getVk_depart() {
		return vk_depart;
	}
	public void setVk_depart(String vk_depart) {
		this.vk_depart = vk_depart;
	}
	public String getVk_pais() {
		return vk_pais;
	}
	public void setVk_pais(String vk_pais) {
		this.vk_pais = vk_pais;
	}
	public String getV_ip() {
		return this.v_ip;
	}
	public void setV_ip(String v_ip) {
		this.v_ip = v_ip;
	}
	public String getVn_canal() {
		return this.vn_canal;
	}
	public void setVn_canal(String vn_canal) {
		this.vn_canal = vn_canal;
	}

	public String getVk_actdatos() {
		return vk_actdatos;
	}

	public void setVk_actdatos(String vk_actdatos) {
		this.vk_actdatos = vk_actdatos;
	}

	
}
