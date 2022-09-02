package com.cm.solidappservice.model.agencias.response;

public class ContactoAgencia {
    
    // private String tipoSucursal; // i_tipage Tipo de sucursal
    private String tituloHorario; // n_cargo Nombre del cargo
    private String horarioAtencion; // n_nombre Nombre contacto
    private String telefonoContacto; //n_telefo Telefono contacto
    
    public ContactoAgencia() {
    }

    public ContactoAgencia(String tituloHorario,String horarioAtencion, String telefonoContacto) {
		super();
        this.tituloHorario = tituloHorario;
		this.horarioAtencion = horarioAtencion;
		this.telefonoContacto = telefonoContacto;
	}

    public String getTituloHorario() {
        return this.tituloHorario;
    }

    public void setTituloHorario(String tituloHorario) {
        this.tituloHorario = tituloHorario;
    }

    public String getHorarioAtencion() {
        return this.horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public String getTelefonoContacto() {
        return this.telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    
}
