package com.cm.solidappservice.model.estadocuenta.bd;

import java.util.Date;
import java.util.List;

/**
 * Tabla TAB_APPESTCTA
 */
public class EstadoCuentaMD{
	
	private String aanumnit; //Cédula del cliente
	private String n_tipodr; 
	private String a_tipodr; //Tipo o código de clasificación de producto
	private String a_numdoc; //Número del producto del cliente
	private long v_saldo;    //Saldo del producto
	private long v_vencid;   //Valor vencido del producto
	private Date f_vencim;   //Fecha de vencimiento
	private String n_produc; //Nombre del producto
	private Date f_actual;   //Fecha de corte
	private int q_diaven;    //Días vencidos
	private long v_cuota;    //Cuota que se muestra en el estado de cuenta.
	private String i_debito; // 'Y ó N': Especifica si desde ese producto se puede debitar para pagos de obligaciones
	private String i_pagsup; // 'Y ó N': Pago superior permitido: Especifica SI una obligación se puede pagar con un valor superior al saldo 
	private String k_tipodr; //Clasificación del producto ( CA, AP, AH, OS ….. )
	private long v_transf;
	//Variables para ejecucion de paquetes de estado de cuenta
	private String v_aanumnit; //Cédula del cliente variable para ejecutar paquetes
	private Integer k_tipcuent;
	private String v_tipodr;
	private String v_numdoc;
		
	//---------------------
	private List<MovimientoMD> movimientos;
	
	public EstadoCuentaMD() {}
	
	public EstadoCuentaMD(String aanumnit){
		this.aanumnit = aanumnit;
	}
	
	public EstadoCuentaMD(String aanumnit, String n_tipodr, String a_tipodr,
			String a_numdoc, long v_saldo, long v_vencid, Date f_vencim,
			String n_produc, Date f_actual, int q_diaven, long v_cuota, String i_debito, 
			String i_pagsup, String k_tipodr, long v_transf) {
		super();
		this.aanumnit = aanumnit;
		this.n_tipodr = n_tipodr;
		this.a_tipodr = a_tipodr;
		this.a_numdoc = a_numdoc;
		this.v_saldo = v_saldo;
		this.v_vencid = v_vencid;
		this.f_vencim = f_vencim;
		this.n_produc = n_produc;
		this.f_actual = f_actual;
		this.q_diaven = q_diaven;
		this.v_cuota = v_cuota;
		this.i_debito = i_debito;
		this.i_pagsup = i_pagsup;
		this.k_tipodr = k_tipodr;
		this.v_transf = v_transf;
	}
	
	public String getAanumnit() {
		return aanumnit;
	}
	public void setAanumnit(String aanumnit) {
		this.aanumnit = aanumnit;
	}
	
	
	public String getN_tipodr() {
		return n_tipodr;
	}	
	public void setN_tipodr(String n_tipodr) {
		this.n_tipodr = n_tipodr;
	}

	
	public String getA_tipodr() {
		return a_tipodr;
	}
	public void setA_tipodr(String a_tipodr) {
		this.a_tipodr = a_tipodr;
	}


	public String getA_numdoc() {
		return a_numdoc;
	}
	public void setA_numdoc(String a_numdoc) {
		this.a_numdoc = a_numdoc;
	}
	

	public long getV_saldo() {
		return v_saldo;
	}
	public void setV_saldo(long v_saldo) {
		this.v_saldo = v_saldo;
	}


	public long getV_vencid() {
		return v_vencid;
	}
	public void setV_vencid(long v_vencid) {
		this.v_vencid = v_vencid;
	}

	
	public Date getF_vencim() {
		return f_vencim;
	}
	public void setF_vencim(Date f_vencim) {
		this.f_vencim = f_vencim;
	}


	public String getN_produc() {
		return n_produc;
	}
	public void setN_produc(String n_produc) {
		this.n_produc = n_produc;
	}


	public Date getF_actual() {
		return f_actual;
	}
	public void setF_actual(Date f_actual) {
		this.f_actual = f_actual;
	}


	public int getQ_diaven() {
		return q_diaven;
	}
	public void setQ_diaven(int q_diaven) {
		this.q_diaven = q_diaven;
	}
	
	
	public long getV_cuota() {
		return v_cuota;
	}
	public void setV_cuota(long v_cuota) {
		this.v_cuota = v_cuota;
	}


	
	
	public String getI_debito() {
		return i_debito;
	}
	public void setI_debito(String i_debito) {
		this.i_debito = i_debito;
	}
	
	
	public String getI_pagsup() {
		return i_pagsup;
	}
	public void setI_pagsup(String i_pagsup) {
		this.i_pagsup = i_pagsup;
	}
	
	
	public String getK_tipodr() {
		return k_tipodr;
	}
	public void setK_tipodr(String k_tipodr) {
		this.k_tipodr = k_tipodr;
	}
	
	
	public long getV_transf() {
		return v_transf;
	}
	public void setV_transf(long v_transf) {
		this.v_transf = v_transf;
	}
	
	
	//----------------------
	
	public List<MovimientoMD> getMovimientos() {
		return movimientos;
	}
	
	public void setMovimientos(List<MovimientoMD> movimientos) {
		this.movimientos = movimientos;
	}
	
	public String getV_aanumnit() {
		return v_aanumnit;
	}
	public void setV_aanumnit(String v_aanumnit) {
		this.v_aanumnit = v_aanumnit;
	}
	
	
	public Integer getK_tipcuent() {
		return k_tipcuent;
	}
	public void setK_tipcuent(Integer k_tipcuent) {
		this.k_tipcuent = k_tipcuent;
	}

	
	public String getV_tipodr() {
		return v_tipodr;
	}
	public void setV_tipodr(String v_tipodr) {
		this.v_tipodr = v_tipodr;
	}

	
	public String getV_numdoc() {
		return v_numdoc;
	}
	public void setV_numdoc(String v_numdoc) {
		this.v_numdoc = v_numdoc;
	}

	
	
}

