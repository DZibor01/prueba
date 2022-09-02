package com.cm.solidappservice.model.creditos.bd;

/*
** TAB_APPINFOFSOLICRED
*/
public class InformacionCreditoMD{
	
	String k_solicitud;
	String i_otrosingresos;
	Integer v_otrosingresos;
	Integer v_egresos;
	String i_tienevehiculo;
	String o_placa;
	Integer v_vehiculo;
	String n_prendaafovorde;
	String i_tienepropiedad;
	String n_direpropiedad;
	String n_ciudadpropi;
	String n_departpropi;
	Integer v_comercialpropi;
	String n_hipoteca;
	Integer v_activos;
	Integer v_pasivos;
	Integer v_patrimonio;
		
	public InformacionCreditoMD() {
		super();
	}
	
	public InformacionCreditoMD(String k_solicitud, String i_otrosingresos, Integer v_otrosingresos, Integer v_egresos,
			String i_tienevehiculo, String o_placa, Integer v_vehiculo, String n_prendaafovorde,
			String i_tienepropiedad, String n_direpropiedad, String n_ciudadpropi, String n_departpropi,
			Integer v_comercialpropi, String n_hipoteca, Integer v_activos, Integer v_pasivos, Integer v_patrimonio) {
		super();
		this.k_solicitud = k_solicitud;
		this.i_otrosingresos = i_otrosingresos;
		this.v_otrosingresos = v_otrosingresos;
		this.v_egresos = v_egresos;
		this.i_tienevehiculo = i_tienevehiculo;
		this.o_placa = o_placa;
		this.v_vehiculo = v_vehiculo;
		this.n_prendaafovorde = n_prendaafovorde;
		this.i_tienepropiedad = i_tienepropiedad;
		this.n_direpropiedad = n_direpropiedad;
		this.n_ciudadpropi = n_ciudadpropi;
		this.n_departpropi = n_departpropi;
		this.v_comercialpropi = v_comercialpropi;
		this.n_hipoteca = n_hipoteca;
		this.v_activos = v_activos;
		this.v_pasivos = v_pasivos;
		this.v_patrimonio = v_patrimonio;
	}
	
	public String getK_solicitud() {
		return k_solicitud;
	}
	public void setK_solicitud(String k_solicitud) {
		this.k_solicitud = k_solicitud;
	}
	public String getI_otrosingresos() {
		return i_otrosingresos;
	}
	public void setI_otrosingresos(String i_otrosingresos) {
		this.i_otrosingresos = i_otrosingresos;
	}
	public Integer getV_otrosingresos() {
		return v_otrosingresos;
	}
	public void setV_otrosingresos(Integer v_otrosingresos) {
		this.v_otrosingresos = v_otrosingresos;
	}
	public Integer getV_egresos() {
		return v_egresos;
	}
	public void setV_egresos(Integer v_egresos) {
		this.v_egresos = v_egresos;
	}
	public String getI_tienevehiculo() {
		return i_tienevehiculo;
	}
	public void setI_tienevehiculo(String i_tienevehiculo) {
		this.i_tienevehiculo = i_tienevehiculo;
	}
	public String getO_placa() {
		return o_placa;
	}
	public void setO_placa(String o_placa) {
		this.o_placa = o_placa;
	}
	public Integer getV_vehiculo() {
		return v_vehiculo;
	}
	public void setV_vehiculo(Integer v_vehiculo) {
		this.v_vehiculo = v_vehiculo;
	}
	public String getN_prendaafovorde() {
		return n_prendaafovorde;
	}
	public void setN_prendaafovorde(String n_prendaafovorde) {
		this.n_prendaafovorde = n_prendaafovorde;
	}
	public String getI_tienepropiedad() {
		return i_tienepropiedad;
	}
	public void setI_tienepropiedad(String i_tienepropiedad) {
		this.i_tienepropiedad = i_tienepropiedad;
	}
	public String getN_direpropiedad() {
		return n_direpropiedad;
	}
	public void setN_direpropiedad(String n_direpropiedad) {
		this.n_direpropiedad = n_direpropiedad;
	}
	public String getN_ciudadpropi() {
		return n_ciudadpropi;
	}
	public void setN_ciudadpropi(String n_ciudadpropi) {
		this.n_ciudadpropi = n_ciudadpropi;
	}
	public String getN_departpropi() {
		return n_departpropi;
	}
	public void setN_departpropi(String n_departpropi) {
		this.n_departpropi = n_departpropi;
	}
	public Integer getV_comercialpropi() {
		return v_comercialpropi;
	}
	public void setV_comercialpropi(Integer v_comercialpropi) {
		this.v_comercialpropi = v_comercialpropi;
	}
	public String getN_hipoteca() {
		return n_hipoteca;
	}
	public void setN_hipoteca(String n_hipoteca) {
		this.n_hipoteca = n_hipoteca;
	}
	public Integer getV_activos() {
		return v_activos;
	}
	public void setV_activos(Integer v_activos) {
		this.v_activos = v_activos;
	}
	public Integer getV_pasivos() {
		return v_pasivos;
	}
	public void setV_pasivos(Integer v_pasivos) {
		this.v_pasivos = v_pasivos;
	}
	public Integer getV_patrimonio() {
		return v_patrimonio;
	}
	public void setV_patrimonio(Integer v_patrimonio) {
		this.v_patrimonio = v_patrimonio;
	}
	
}