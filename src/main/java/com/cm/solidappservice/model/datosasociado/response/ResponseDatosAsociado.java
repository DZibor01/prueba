package com.cm.solidappservice.model.datosasociado.response;

public class ResponseDatosAsociado {
    
    private String cedula; // v_aanumnit;
    private String primerApellido; // n_apell1;
    private String segundoApellido; // n_apell2;
    private String primerNombre; // n_nombr1;
    private String segundoNombre; // n_nombr2;
    private String email; // d_email;
    private String telefonoFijo; // t_fijo;
    private String telefonoCelular; // t_celular;
    private String direccion; // n_direccion;
    private String barrio; // n_barrio;
    private String nombreCiudad; // n_ciudad;
    private String idCiudad; // k_ciudad;
    private String idDepartamento; // k_depart;
    private String estadoCivil; // n_estciv;
    private String fechaAntiguedad; // f_antigu;
    private String cargo; // n_cargo;
    private Integer valorSueldo; // v_sueldo;
    private String tipoNomina; // i_tipnom;
    private String idDependencia; // k_dependencia;
    private String nombreDependencia; // n_dependencia;
    private String idRegional; // k_regional;
    private String nombreRegional; // n_regional;

    public ResponseDatosAsociado(){}

    public ResponseDatosAsociado(String cedula, String primerApellido, String segundoApellido, String primerNombre,
			String segundoNombre, String email, String telefonoFijo, String telefonoCelular, String direccion,
			String barrio, String nombreCiudad, String idCiudad, String idDepartamento, String estadoCivil,
			String fechaAntiguedad, String cargo, Integer valorSueldo, String tipoNomina, String idDependencia,
			String nombreDependencia, String idRegional, String nombreRegional) {
		this.cedula = cedula;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.email = email;
		this.telefonoFijo = telefonoFijo;
		this.telefonoCelular = telefonoCelular;
		this.direccion = direccion;
		this.barrio = barrio;
		this.nombreCiudad = nombreCiudad;
		this.idCiudad = idCiudad;
		this.idDepartamento = idDepartamento;
		this.estadoCivil = estadoCivil;
		this.fechaAntiguedad = fechaAntiguedad;
		this.cargo = cargo;
		this.valorSueldo = valorSueldo;
		this.tipoNomina = tipoNomina;
		this.idDependencia = idDependencia;
		this.nombreDependencia = nombreDependencia;
		this.idRegional = idRegional;
		this.nombreRegional = nombreRegional;
	}

	public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return this.primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return this.segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonoFijo() {
        return this.telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return this.telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return this.barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getNombreCiudad() {
        return this.nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getIdCiudad() {
        return this.idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getIdDepartamento() {
        return this.idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFechaAntiguedad() {
        return this.fechaAntiguedad;
    }

    public void setFechaAntiguedad(String fechaAntiguedad) {
        this.fechaAntiguedad = fechaAntiguedad;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getValorSueldo() {
        return this.valorSueldo;
    }

    public void setValorSueldo(Integer valorSueldo) {
        this.valorSueldo = valorSueldo;
    }

    public String getTipoNomina() {
        return this.tipoNomina;
    }

    public void setTipoNomina(String tipoNomina) {
        this.tipoNomina = tipoNomina;
    }

    public String getIdDependencia() {
        return this.idDependencia;
    }

    public void setIdDependencia(String idDependencia) {
        this.idDependencia = idDependencia;
    }

    public String getNombreDependencia() {
        return this.nombreDependencia;
    }

    public void setNombreDependencia(String nombreDependencia) {
        this.nombreDependencia = nombreDependencia;
    }

    public String getIdRegional() {
        return this.idRegional;
    }

    public void setIdRegional(String idRegional) {
        this.idRegional = idRegional;
    }

    public String getNombreRegional() {
        return this.nombreRegional;
    }

    public void setNombreRegional(String nombreRegional) {
        this.nombreRegional = nombreRegional;
    }
}


