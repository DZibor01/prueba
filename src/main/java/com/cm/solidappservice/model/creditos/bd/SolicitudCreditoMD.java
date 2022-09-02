package com.cm.solidappservice.model.creditos.bd;

/*
**INSERT INTO TAB_APPSOLCREDITO
*/
public class SolicitudCreditoMD {

	private String aanumnit;
	private String k_solicitud;
	private String identificacion;
	private String n_apell1;
	private String n_apell2;
	private String n_nombr1;
	private String n_nombr2;
	private String t_telfijo;
	private String t_tercel;
	private String n_barrio;
	private String d_direc;
	private String d_email;
	private String n_ciudad;
	private String k_ciudad;
	private String k_depart;
	private String i_tipvivienda;
	private String i_estciv;
	private String k_coddependencia;
	private String k_regional;
	private String f_antig;
	private String k_linea;
	private String i_formaentrega;
	private String n_observacion;
	private String i_aceptacon;
	private String f_solicitud;
	private String n_canal;
	private String f_logeo;
	private String ip;
	private Integer v_salario;
	private Integer v_solicitado;
	private String n_refhotel;
		
	public SolicitudCreditoMD() {
		super();
	}

	public SolicitudCreditoMD(String aanumnit, String k_solicitud, String identificacion, String n_apell1,
			String n_apell2, String n_nombr1, String n_nombr2, String t_telfijo, String t_tercel, String n_barrio,
			String d_direc, String d_email, String n_ciudad, String k_ciudad, String k_depart, String i_tipvivienda,
			String i_estciv, String k_coddependencia, String k_regional, String f_antig, String k_linea,
			String i_formaentrega, String n_observacion, String i_aceptacon, String f_solicitud, String n_canal,
			String f_logeo, String ip, Integer v_salario, Integer v_solicitado, String n_refhotel) {
		super();
		this.aanumnit = aanumnit;
		this.k_solicitud = k_solicitud;
		this.identificacion = identificacion;
		this.n_apell1 = n_apell1;
		this.n_apell2 = n_apell2;
		this.n_nombr1 = n_nombr1;
		this.n_nombr2 = n_nombr2;
		this.t_telfijo = t_telfijo;
		this.t_tercel = t_tercel;
		this.n_barrio = n_barrio;
		this.d_direc = d_direc;
		this.d_email = d_email;
		this.n_ciudad = n_ciudad;
		this.k_ciudad = k_ciudad;
		this.k_depart = k_depart;
		this.i_tipvivienda = i_tipvivienda;
		this.i_estciv = i_estciv;
		this.k_coddependencia = k_coddependencia;
		this.k_regional = k_regional;
		this.f_antig = f_antig;
		this.k_linea = k_linea;
		this.i_formaentrega = i_formaentrega;
		this.n_observacion = n_observacion;
		this.i_aceptacon = i_aceptacon;
		this.f_solicitud = f_solicitud;
		this.n_canal = n_canal;
		this.f_logeo = f_logeo;
		this.ip = ip;
		this.v_salario = v_salario;
		this.v_solicitado = v_solicitado;
		this.n_refhotel = n_refhotel;
	}

	public String getAanumnit() {
	  return this.aanumnit;
	}
	
	public void setAanumnit(String aanumnit) {
	  this.aanumnit = aanumnit;
	}
	
	public String getK_solicitud() {
	  return this.k_solicitud;
	}
	
	public void setK_solicitud(String k_solicitud) {
	  this.k_solicitud = k_solicitud;
	}
	
	public String getIdentificacion() {
	  return this.identificacion;
	}
	
	public void setIdentificacion(String identificacion) {
	  this.identificacion = identificacion;
	}
	
	public String getN_apell1() {
	  return this.n_apell1;
	}
	
	public void setN_apell1(String n_apell1) {
	  this.n_apell1 = n_apell1;
	}
	
	public String getN_apell2() {
	  return this.n_apell2;
	}
	
	public void setN_apell2(String n_apell2) {
	  this.n_apell2 = n_apell2;
	}
	
	public String getN_nombr1() {
	  return this.n_nombr1;
	}
	
	public void setN_nombr1(String n_nombr1) {
	  this.n_nombr1 = n_nombr1;
	}
	
	public String getN_nombr2() {
	  return this.n_nombr2;
	}
	
	public void setN_nombr2(String n_nombr2) {
	  this.n_nombr2 = n_nombr2;
	}
	
	public String getT_telfijo() {
	  return this.t_telfijo;
	}
	
	public void setT_telfijo(String t_telfijo) {
	  this.t_telfijo = t_telfijo;
	}
	
	public String getT_tercel() {
	  return this.t_tercel;
	}
	
	public void setT_tercel(String t_tercel) {
	  this.t_tercel = t_tercel;
	}
	
	public String getN_barrio() {
	  return this.n_barrio;
	}
	
	public void setN_barrio(String n_barrio) {
	  this.n_barrio = n_barrio;
	}
	
	public String getD_direc() {
	  return this.d_direc;
	}
	
	public void setD_direc(String d_direc) {
	  this.d_direc = d_direc;
	}
	
	public String getD_email() {
	  return this.d_email;
	}
	
	public void setD_email(String d_email) {
	  this.d_email = d_email;
	}
	
	public String getN_ciudad() {
	  return this.n_ciudad;
	}
	
	public void setN_ciudad(String n_ciudad) {
	  this.n_ciudad = n_ciudad;
	}
	
	public String getK_ciudad() {
	  return this.k_ciudad;
	}
	
	public void setK_ciudad(String k_ciudad) {
	  this.k_ciudad = k_ciudad;
	}
	
	public String getK_depart() {
	  return this.k_depart;
	}
	
	public void setK_depart(String k_depart) {
	  this.k_depart = k_depart;
	}
	
	public String getI_tipvivienda() {
	  return this.i_tipvivienda;
	}
	
	public void setI_tipvivienda(String i_tipvivienda) {
	  this.i_tipvivienda = i_tipvivienda;
	}
	
	public String getI_estciv() {
	  return this.i_estciv;
	}
	
	public void setI_estciv(String i_estciv) {
	  this.i_estciv = i_estciv;
	}
	
	public String getK_coddependencia() {
	  return this.k_coddependencia;
	}
	
	public void setK_coddependencia(String k_coddependencia) {
	  this.k_coddependencia = k_coddependencia;
	}
	
	public String getK_regional() {
	  return this.k_regional;
	}
	
	public void setK_regional(String k_regional) {
	  this.k_regional = k_regional;
	}
	
	public String getF_antig() {
	  return this.f_antig;
	}
	
	public void setF_antig(String f_antig) {
	  this.f_antig = f_antig;
	}
	
	public String getK_linea() {
	  return this.k_linea;
	}
	
	public void setK_linea(String k_linea) {
	  this.k_linea = k_linea;
	}
	
	public String getI_formaentrega() {
	  return this.i_formaentrega;
	}
	
	public void setI_formaentrega(String i_formaentrega) {
	  this.i_formaentrega = i_formaentrega;
	}
	
	public String getN_observacion() {
	  return this.n_observacion;
	}
	
	public void setN_observacion(String n_observacion) {
	  this.n_observacion = n_observacion;
	}
	
	public String getI_aceptacon() {
	  return this.i_aceptacon;
	}
	
	public void setI_aceptacon(String i_aceptacon) {
	  this.i_aceptacon = i_aceptacon;
	}
	
	public String getF_solicitud() {
	  return this.f_solicitud;
	}
	
	public void setF_solicitud(String f_solicitud) {
	  this.f_solicitud = f_solicitud;
	}
	
	public String getN_canal() {
	  return this.n_canal;
	}
	
	public void setN_canal(String n_canal) {
	  this.n_canal = n_canal;
	}
	
	public String getF_logeo() {
	  return this.f_logeo;
	}
	
	public void setF_logeo(String f_logeo) {
	  this.f_logeo = f_logeo;
	}
	
	public String getIp() {
	  return this.ip;
	}
	
	public void setIp(String ip) {
	  this.ip = ip;
	}
	
	public Integer getV_salario() {
	  return this.v_salario;
	}
	
	public void setV_salario(Integer v_salario) {
	  this.v_salario = v_salario;
	}
	
	public Integer getV_solicitado() {
	  return this.v_solicitado;
	}
	
	public void setV_solicitado(Integer v_solicitado) {
	  this.v_solicitado = v_solicitado;
	}

	public String getN_refhotel() {
		return n_refhotel;
	}

	public void setN_refhotel(String n_refhotel) {
		this.n_refhotel = n_refhotel;
	}
	
}
  