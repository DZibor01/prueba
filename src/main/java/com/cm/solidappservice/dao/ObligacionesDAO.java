package com.cm.solidappservice.dao;

import java.util.Date;
import java.util.List;

import com.cm.solidappservice.model.obligaciones.bd.PagoObligacionMD;
import com.cm.solidappservice.model.obligaciones.request.RequestPagoObligacion;
import com.cm.solidappservice.model.obligaciones.request.RequestPagoObligacionDeprecated;

public class ObligacionesDAO extends DAO2 {
	private static ObligacionesDAO singleton = null;
	private static final String QUERY_CREAR_PAGO_OBLIGACION = "ObligacionesMapper.crearPagoObligacion";
	private static final String QUERY_OBTENER_PAGOS_INCOMPLETOS = "ObligacionesMapper.obtenerPagosIncompletos";

	public static ObligacionesDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (ObligacionesDAO.class) {
					if (null == singleton) {
						singleton = new ObligacionesDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public void crearSolicitudDeprecated(RequestPagoObligacionDeprecated request) throws Exception {
		PagoObligacionMD model = new PagoObligacionMD();
		model.setAanumnit(request.getCedula());
		model.setF_movimi(new Date());
		model.setA_numcta(request.getA_numcta());
		model.setA_numdoc(request.getA_numdoc());
		model.setA_tipodr(request.getA_tipodr());
		model.setId_dispositivo(request.getId_dispositivo());
		model.setK_tipodr(request.getK_tipodr());
		model.setN_produc(request.getN_produc());
		model.setN_tipodr(request.getN_tipodr());
		model.setV_valor(request.getV_valor());
		insertObject(QUERY_CREAR_PAGO_OBLIGACION, model);
	}
	public void crearSolicitud(RequestPagoObligacion request) throws Exception {
		PagoObligacionMD model = new PagoObligacionMD();
		model.setAanumnit(request.getCedula());
		model.setF_movimi(new Date());
		model.setA_numcta(request.getNumeroCuenta());
		model.setA_numdoc(request.getNumeroProducto());
		model.setA_tipodr(request.getCodigoProducto());
		model.setId_dispositivo(request.getIdDispositivo());
		model.setK_tipodr(request.getClasificacionProducto());
		model.setN_produc(request.getNombreProducto());
		model.setN_tipodr(request.getNombreCuenta());
		model.setV_valor(request.getValorPago());
		insertObject(QUERY_CREAR_PAGO_OBLIGACION, model);
	}


	public List<PagoObligacionMD> obtenerPagoObligacion(String cedula) throws Exception {
		PagoObligacionMD model = new PagoObligacionMD();
		model.setAanumnit(cedula);
		List<PagoObligacionMD> listModel = getList(QUERY_OBTENER_PAGOS_INCOMPLETOS, model);
		return listModel;
	}

	
}