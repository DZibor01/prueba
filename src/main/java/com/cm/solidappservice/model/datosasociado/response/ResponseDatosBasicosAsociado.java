package com.cm.solidappservice.model.datosasociado.response;

public class ResponseDatosBasicosAsociado {
    
    private String tipoDocumento; // n_nombr2;
    private String documentoIdentidad; // v_aanumnit;
    private String pimerApellido; // n_apell1;
    private String segundoApellido; // n_apell2;
    private String primerNombre; // n_nombr1;
    private String segundoNombre; // n_nombr2;

    public ResponseDatosBasicosAsociado(){}

    public ResponseDatosBasicosAsociado(String tipoDocumento, String documentoIdentidad, String pimerApellido,
            String segundoApellido, String primerNombre, String segundoNombre) {
        this.tipoDocumento = tipoDocumento;
        this.documentoIdentidad = documentoIdentidad;
        this.pimerApellido = pimerApellido;
        this.segundoApellido = segundoApellido;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getPimerApellido() {
        return pimerApellido;
    }

    public void setPimerApellido(String pimerApellido) {
        this.pimerApellido = pimerApellido;
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

}


