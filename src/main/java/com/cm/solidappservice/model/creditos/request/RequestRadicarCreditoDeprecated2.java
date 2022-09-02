package com.cm.solidappservice.model.creditos.request;

import com.cm.solidappservice.model.base.RequestAutenticacion;

public class RequestRadicarCreditoDeprecated2 extends RequestAutenticacion{

	private String primerApellido; // n_apell1;
    private String segundoApellido; // n_apell2;
    private String primerNombre; // n_nombr1;
    private String segundoNombre; // n_nombr2;
    private String telefonoFijo; // t_telfijo;
    private String telefonoCelular; // t_tercel;
    private String barrio; // n_barrio;
    private String direccion; // d_direc;
    private String email; // d_email;
    private String nombreCiudad; // n_ciudad;
    private String idCiudad; // k_ciudad;
    private String idDepartamento; // k_depart;
    private String tipoVivienda; // i_tipvivienda;
    private String estadoCivil; // i_estciv;
    private String idDependencia; // k_coddependencia;
    private String idRegional; // k_regional;
    private String fechaAntiguedad; // f_antig;
    private Integer valorSueldo; // v_salario;
    private String idLinea; // k_linea;
    private String formaEntrega; // i_formaentrega;
    private Integer valorSolicitado; // v_solicitado;
    private String observacion; // n_observacion;
    private String aceptaTerminos; // i_aceptacon;
    private String fechaSolicitud; // f_solicitud;
    private String canal; // n_canal;
    private String fechaLogueo; // f_logeo;
    private String ip; // ip;
	private String codigoReserva; // n_codreserva;
        
	public RequestRadicarCreditoDeprecated2() {}
	
	public RequestRadicarCreditoDeprecated2(String primerApellido, String segundoApellido, String primerNombre,
			String segundoNombre, String telefonoFijo, String telefonoCelular, String barrio, String direccion,
			String email, String nombreCiudad, String idCiudad, String idDepartamento, String tipoVivienda,
			String estadoCivil, String idDependencia, String idRegional, String fechaAntiguedad, Integer valorSueldo,
			String idLinea, String formaEntrega, Integer valorSolicitado, String observacion, String aceptaTerminos,
			String fechaSolicitud, String canal, String fechaLogueo, String ip, String codigoReserva) {
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.telefonoFijo = telefonoFijo;
		this.telefonoCelular = telefonoCelular;
		this.barrio = barrio;
		this.direccion = direccion;
		this.email = email;
		this.nombreCiudad = nombreCiudad;
		this.idCiudad = idCiudad;
		this.idDepartamento = idDepartamento;
		this.tipoVivienda = tipoVivienda;
		this.estadoCivil = estadoCivil;
		this.idDependencia = idDependencia;
		this.idRegional = idRegional;
		this.fechaAntiguedad = fechaAntiguedad;
		this.valorSueldo = valorSueldo;
		this.idLinea = idLinea;
		this.formaEntrega = formaEntrega;
		this.valorSolicitado = valorSolicitado;
		this.observacion = observacion;
		this.aceptaTerminos = aceptaTerminos;
		this.fechaSolicitud = fechaSolicitud;
		this.canal = canal;
		this.fechaLogueo = fechaLogueo;
		this.ip = ip;
		this.codigoReserva = codigoReserva;
	}
	
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	public String getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getTipoVivienda() {
		return tipoVivienda;
	}
	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getIdDependencia() {
		return idDependencia;
	}
	public void setIdDependencia(String idDependencia) {
		this.idDependencia = idDependencia;
	}
	public String getIdRegional() {
		return idRegional;
	}
	public void setIdRegional(String idRegional) {
		this.idRegional = idRegional;
	}
	public String getFechaAntiguedad() {
		return fechaAntiguedad;
	}
	public void setFechaAntiguedad(String fechaAntiguedad) {
		this.fechaAntiguedad = fechaAntiguedad;
	}
	public Integer getValorSueldo() {
		return valorSueldo;
	}
	public void setValorSueldo(Integer valorSueldo) {
		this.valorSueldo = valorSueldo;
	}
	public String getIdLinea() {
		return idLinea;
	}
	public void setIdLinea(String idLinea) {
		this.idLinea = idLinea;
	}
	public String getFormaEntrega() {
		return formaEntrega;
	}
	public void setFormaEntrega(String formaEntrega) {
		this.formaEntrega = formaEntrega;
	}
	public Integer getValorSolicitado() {
		return valorSolicitado;
	}
	public void setValorSolicitado(Integer valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getAceptaTerminos() {
		return aceptaTerminos;
	}
	public void setAceptaTerminos(String aceptaTerminos) {
		this.aceptaTerminos = aceptaTerminos;
	}
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getFechaLogueo() {
		return fechaLogueo;
	}
	public void setFechaLogueo(String fechaLogueo) {
		this.fechaLogueo = fechaLogueo;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCodigoReserva() {
		return codigoReserva;
	}
	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
}
