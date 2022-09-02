package com.cm.solidappservice.dao;

import com.cm.solidappservice.model.cajamenorpte.bd.CajaMenorPteMD;
import com.cm.solidappservice.model.cajamenorpte.request.RequestCajaMenorPteMD;

public class CajaMenorPteDAO extends DAO2 {
	private static CajaMenorPteDAO singleton = null;
	private final String QUERY_CREAR_REGISTRO = "CajaMenorPteMapper.crearRegistro";

	public static CajaMenorPteDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (CajaMenorPteDAO.class) {
					if (null == singleton) {
						singleton = new CajaMenorPteDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public void crearSolicitud(RequestCajaMenorPteMD request) throws Exception {
		CajaMenorPteMD model = new CajaMenorPteMD(
			request.getId_nova(),
			request.getK_numdoc(),
			request.getK_perano(),
			request.getK_cencos(),
			request.getN_cencos(),
			request.getF_movimi(),
			request.getN_movimi(),
			request.getO_numdoc(),
			request.getK_codocn(),
			request.getN_cocnep(),
			request.getA_numnit(),
			request.getNnomter(),
			request.getK_cencos_det(),
			request.getN_cencos_det(),
			request.getV_gasto(),
			request.getV_iva(),
			request.getV_inpoco(),
			request.getAanumnit_res(),
			request.getNnomter_caj(),
			request.getAanumnit_caj(),
			request.getNnomter_res(),
			request.getId_registro()
		);
		insertObject(QUERY_CREAR_REGISTRO, model);
	}
}