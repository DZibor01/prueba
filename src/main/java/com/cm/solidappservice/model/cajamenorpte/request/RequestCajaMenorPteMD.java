package com.cm.solidappservice.model.cajamenorpte.request;

import java.util.Date;

public class RequestCajaMenorPteMD {
	
	private String id_nova;
	private String k_numdoc;
	private String k_perano;
	private String k_cencos;
	private String n_cencos;
	private Date   f_movimi;
	private String n_movimi;
	private String o_numdoc;
	private String k_codocn;
	private String n_cocnep;
	private String a_numnit;
	private String nnomter;
	private String k_cencos_det;
	private String n_cencos_det;
	private Double v_gasto;
	private Double v_iva;
	private Double v_inpoco;
	private String aanumnit_res;
	private String nnomter_res;
	private String aanumnit_caj;
	private String nnomter_caj;
	private String id_registro;

	public RequestCajaMenorPteMD() {
	}

	public RequestCajaMenorPteMD(String id_nova, String k_numdoc, String k_perano, String k_cencos, String n_cencos,
			Date f_movimi, String n_movimi, String o_numdoc, String k_codocn, String n_cocnep, String a_numnit,
			String nnomter, String k_cencos_det, String n_cencos_det, Double v_gasto, Double v_iva, Double v_inpoco,
			String aanumnit_res, String nnomter_res, String aanumnit_caj, String nnomter_caj, String id_registro) {
		this.id_nova = id_nova;
		this.k_numdoc = k_numdoc;
		this.k_perano = k_perano;
		this.k_cencos = k_cencos;
		this.n_cencos = n_cencos;
		this.f_movimi = f_movimi;
		this.n_movimi = n_movimi;
		this.o_numdoc = o_numdoc;
		this.k_codocn = k_codocn;
		this.n_cocnep = n_cocnep;
		this.a_numnit = a_numnit;
		this.nnomter = nnomter;
		this.k_cencos_det = k_cencos_det;
		this.n_cencos_det = n_cencos_det;
		this.v_gasto = v_gasto;
		this.v_iva = v_iva;
		this.v_inpoco = v_inpoco;
		this.aanumnit_res = aanumnit_res;
		this.nnomter_res = nnomter_res;
		this.aanumnit_caj = aanumnit_caj;
		this.nnomter_caj = nnomter_caj;
		this.id_registro = id_registro;
	}

	public String getId_nova() {
		return id_nova;
	}

	public void setId_nova(String id_nova) {
		this.id_nova = id_nova;
	}

	public String getK_numdoc() {
		return k_numdoc;
	}

	public void setK_numdoc(String k_numdoc) {
		this.k_numdoc = k_numdoc;
	}

	public String getK_perano() {
		return k_perano;
	}

	public void setK_perano(String k_perano) {
		this.k_perano = k_perano;
	}

	public String getK_cencos() {
		return k_cencos;
	}

	public void setK_cencos(String k_cencos) {
		this.k_cencos = k_cencos;
	}

	public String getN_cencos() {
		return n_cencos;
	}

	public void setN_cencos(String n_cencos) {
		this.n_cencos = n_cencos;
	}

	public Date getF_movimi() {
		return f_movimi;
	}

	public void setF_movimi(Date f_movimi) {
		this.f_movimi = f_movimi;
	}

	public String getN_movimi() {
		return n_movimi;
	}

	public void setN_movimi(String n_movimi) {
		this.n_movimi = n_movimi;
	}

	public String getO_numdoc() {
		return o_numdoc;
	}

	public void setO_numdoc(String o_numdoc) {
		this.o_numdoc = o_numdoc;
	}

	public String getK_codocn() {
		return k_codocn;
	}

	public void setK_codocn(String k_codocn) {
		this.k_codocn = k_codocn;
	}

	public String getN_cocnep() {
		return n_cocnep;
	}

	public void setN_cocnep(String n_cocnep) {
		this.n_cocnep = n_cocnep;
	}

	public String getA_numnit() {
		return a_numnit;
	}

	public void setA_numnit(String a_numnit) {
		this.a_numnit = a_numnit;
	}

	public String getNnomter() {
		return nnomter;
	}

	public void setNnomter(String nnomter) {
		this.nnomter = nnomter;
	}

	public String getK_cencos_det() {
		return k_cencos_det;
	}

	public void setK_cencos_det(String k_cencos_det) {
		this.k_cencos_det = k_cencos_det;
	}

	public String getN_cencos_det() {
		return n_cencos_det;
	}

	public void setN_cencos_det(String n_cencos_det) {
		this.n_cencos_det = n_cencos_det;
	}

	public Double getV_gasto() {
		return v_gasto;
	}

	public void setV_gasto(Double v_gasto) {
		this.v_gasto = v_gasto;
	}

	public Double getV_iva() {
		return v_iva;
	}

	public void setV_iva(Double v_iva) {
		this.v_iva = v_iva;
	}

	public Double getV_inpoco() {
		return v_inpoco;
	}

	public void setV_inpoco(Double v_inpoco) {
		this.v_inpoco = v_inpoco;
	}

	public String getAanumnit_res() {
		return aanumnit_res;
	}

	public void setAanumnit_res(String aanumnit_res) {
		this.aanumnit_res = aanumnit_res;
	}

	public String getNnomter_res() {
		return nnomter_res;
	}

	public void setNnomter_res(String nnomter_res) {
		this.nnomter_res = nnomter_res;
	}

	public String getAanumnit_caj() {
		return aanumnit_caj;
	}

	public void setAanumnit_caj(String aanumnit_caj) {
		this.aanumnit_caj = aanumnit_caj;
	}

	public String getNnomter_caj() {
		return nnomter_caj;
	}

	public void setNnomter_caj(String nnomter_caj) {
		this.nnomter_caj = nnomter_caj;
	}

	public String getId_registro() {
		return id_registro;
	}

	public void setId_registro(String id_registro) {
		this.id_registro = id_registro;
	}
}
