package com.cm.solidappservice.model.creditos.request;

public class InformacionCredito {

	String tieneOtrosIngresos; //i_otrosingresos
	Integer valorOtrosIngresos; //v_otrosingresos
	Integer valorEgresos; //v_egresos
	String tieneVehiculo; //i_tienevehiculo
	String placa; //o_placa
	Integer valorVehiculo; //v_vehiculo
	String prenda; //n_prendaafovorde
	String tienePropiedad; //i_tienepropiedad
	String direccionPropiedad; //n_direpropiedad
	String ciudadPropiedad; //n_ciudadpropi
	String departamentoPropiedad; //n_departpropi
	Integer valorComercialPropiedad; //v_comercialpropi
	String hipoteca; //n_hipoteca
	Integer valorActivos; //v_activos
	Integer valorPasivos; //v_pasivos
	Integer valoPatrimonio; //v_patrimonio
		
	public InformacionCredito() {
		super();
	}
	
	public InformacionCredito(String tieneOtrosIngresos, Integer valorOtrosIngresos, Integer valorEgresos,
			String tieneVehiculo, String placa, Integer valorVehiculo, String prenda, String tienePropiedad,
			String direccionPropiedad, String ciudadPropiedad, String departamentoPropiedad,
			Integer valorComercialPropiedad, String hipoteca, Integer valorActivos, Integer valorPasivos,
			Integer valoPatrimonio) {
		super();
		this.tieneOtrosIngresos = tieneOtrosIngresos;
		this.valorOtrosIngresos = valorOtrosIngresos;
		this.valorEgresos = valorEgresos;
		this.tieneVehiculo = tieneVehiculo;
		this.placa = placa;
		this.valorVehiculo = valorVehiculo;
		this.prenda = prenda;
		this.tienePropiedad = tienePropiedad;
		this.direccionPropiedad = direccionPropiedad;
		this.ciudadPropiedad = ciudadPropiedad;
		this.departamentoPropiedad = departamentoPropiedad;
		this.valorComercialPropiedad = valorComercialPropiedad;
		this.hipoteca = hipoteca;
		this.valorActivos = valorActivos;
		this.valorPasivos = valorPasivos;
		this.valoPatrimonio = valoPatrimonio;
	}
	
	public String getTieneOtrosIngresos() {
		return tieneOtrosIngresos;
	}
	public void setTieneOtrosIngresos(String tieneOtrosIngresos) {
		this.tieneOtrosIngresos = tieneOtrosIngresos;
	}
	public Integer getValorOtrosIngresos() {
		return valorOtrosIngresos;
	}
	public void setValorOtrosIngresos(Integer valorOtrosIngresos) {
		this.valorOtrosIngresos = valorOtrosIngresos;
	}
	public Integer getValorEgresos() {
		return valorEgresos;
	}
	public void setValorEgresos(Integer valorEgresos) {
		this.valorEgresos = valorEgresos;
	}
	public String getTieneVehiculo() {
		return tieneVehiculo;
	}
	public void setTieneVehiculo(String tieneVehiculo) {
		this.tieneVehiculo = tieneVehiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Integer getValorVehiculo() {
		return valorVehiculo;
	}
	public void setValorVehiculo(Integer valorVehiculo) {
		this.valorVehiculo = valorVehiculo;
	}
	public String getPrenda() {
		return prenda;
	}
	public void setPrenda(String prenda) {
		this.prenda = prenda;
	}
	public String getTienePropiedad() {
		return tienePropiedad;
	}
	public void setTienePropiedad(String tienePropiedad) {
		this.tienePropiedad = tienePropiedad;
	}
	public String getDireccionPropiedad() {
		return direccionPropiedad;
	}
	public void setDireccionPropiedad(String direccionPropiedad) {
		this.direccionPropiedad = direccionPropiedad;
	}
	public String getCiudadPropiedad() {
		return ciudadPropiedad;
	}
	public void setCiudadPropiedad(String ciudadPropiedad) {
		this.ciudadPropiedad = ciudadPropiedad;
	}
	public String getDepartamentoPropiedad() {
		return departamentoPropiedad;
	}
	public void setDepartamentoPropiedad(String departamentoPropiedad) {
		this.departamentoPropiedad = departamentoPropiedad;
	}
	public Integer getValorComercialPropiedad() {
		return valorComercialPropiedad;
	}
	public void setValorComercialPropiedad(Integer valorComercialPropiedad) {
		this.valorComercialPropiedad = valorComercialPropiedad;
	}
	public String getHipoteca() {
		return hipoteca;
	}
	public void setHipoteca(String hipoteca) {
		this.hipoteca = hipoteca;
	}
	public Integer getValorActivos() {
		return valorActivos;
	}
	public void setValorActivos(Integer valorActivos) {
		this.valorActivos = valorActivos;
	}
	public Integer getValorPasivos() {
		return valorPasivos;
	}
	public void setValorPasivos(Integer valorPasivos) {
		this.valorPasivos = valorPasivos;
	}
	public Integer getValoPatrimonio() {
		return valoPatrimonio;
	}
	public void setValoPatrimonio(Integer valoPatrimonio) {
		this.valoPatrimonio = valoPatrimonio;
	}
    
}
