package com.cm.solidappservice.model.estadocuenta.response;

import java.util.Date;

public class Producto {
    
    private String nombreProducto; // n_produc - Nombre del producto
    private String clasificacionProducto; // k_tipodr - Clasificación del producto ( CA, AP, AH, OS ….. )
    private Integer tipoCuenta; // k_tipcuent - Tipo de cuenta ("1.Cuenta de ahorros 2. Obligaciones de documento, 3. Obligaciones de cartera")
    private String codigoProducto; // a_tipodr - Tipo o código de clasificación de producto
    private String numeroProducto; // a_numdoc - Número del producto del cliente
    private long saldoProducto; // v_saldo - Saldo del producto
    private long saldoVencido; // v_vencid - Valor vencido del producto
    private Date fechaVencimiento; // f_vencim - Fecha de vencimiento
    private Date fechaActual; // f_actual - Fecha de corte
    private int diasVencidos; // q_diaven - Días vencidos
    private long valorTransferible; // v_transf
    private long valorCuota; // v_cuota - Cuota que se muestra en el estado de cuenta.
    private String aceptaPagoSuperior; // i_pagsup - 'Y o N': Pago superior permitido: Especifica SI una obligación se uede pagar con un valor superior al saldo 
    private String productoDebitable; //i_debito - 'Y o N': Especifica si desde ese producto se puede debitar para pagos de obligaciones 


    public Producto(){}

    public Producto(String nombreProducto, String clasificacionProducto,
			Integer tipoCuenta, String codigoProducto, String numeroProducto, long saldoProducto, long saldoVencido,
			Date fechaVencimiento, Date fechaActual, int diasVencidos, long valorTransferible, long valorCuota,
			String aceptaPagoSuperior, String productoDebitable) {
		this.nombreProducto = nombreProducto;
		this.clasificacionProducto = clasificacionProducto;
		this.tipoCuenta = tipoCuenta;
		this.codigoProducto = codigoProducto;
		this.numeroProducto = numeroProducto;
		this.saldoProducto = saldoProducto;
		this.saldoVencido = saldoVencido;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaActual = fechaActual;
		this.diasVencidos = diasVencidos;
		this.valorTransferible = valorTransferible;
		this.valorCuota = valorCuota;
		this.aceptaPagoSuperior = aceptaPagoSuperior;
		this.productoDebitable = productoDebitable;
	}

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getClasificacionProducto() {
        return this.clasificacionProducto;
    }

    public void setClasificacionProducto(String clasificacionProducto) {
        this.clasificacionProducto = clasificacionProducto;
    }

    public Integer getTipoCuenta() {
        return this.tipoCuenta;
    }

    public void setTipoCuenta(Integer tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNumeroProducto() {
        return this.numeroProducto;
    }

    public void setNumeroProducto(String numeroProducto) {
        this.numeroProducto = numeroProducto;
    }

    public long getSaldoProducto() {
        return this.saldoProducto;
    }

    public void setSaldoProducto(long saldoProducto) {
        this.saldoProducto = saldoProducto;
    }

    public long getSaldoVencido() {
        return this.saldoVencido;
    }

    public void setSaldoVencido(long saldoVencido) {
        this.saldoVencido = saldoVencido;
    }

    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaActual() {
        return this.fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public int getDiasVencidos() {
        return this.diasVencidos;
    }

    public void setDiasVencidos(int diasVencidos) {
        this.diasVencidos = diasVencidos;
    }

    public long getValorTransferible() {
        return this.valorTransferible;
    }

    public void setValorTransferible(long valorTransferible) {
        this.valorTransferible = valorTransferible;
    }

    public long getValorCuota() {
        return this.valorCuota;
    }

    public void setValorCuota(long valorCuota) {
        this.valorCuota = valorCuota;
    }

    public String getAceptaPagoSuperior() {
        return this.aceptaPagoSuperior;
    }

    public void setAceptaPagoSuperior(String aceptaPagoSuperior) {
        this.aceptaPagoSuperior = aceptaPagoSuperior;
    }

    public String getProductoDebitable() {
        return this.productoDebitable;
    }

    public void setProductoDebitable(String productoDebitable) {
        this.productoDebitable = productoDebitable;
    }
}

