package com.cm.solidappservice.manager;

import java.util.ArrayList;
import java.util.List;

import com.cm.solidappservice.dao.ObligacionesDAO;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.obligaciones.bd.PagoObligacionMD;
import com.cm.solidappservice.model.obligaciones.request.RequestPagoObligacion;
import com.cm.solidappservice.model.obligaciones.request.RequestPagoObligacionDeprecated;
import com.cm.solidappservice.model.obligaciones.response.ResponsePagosObligaciones;
import com.cm.solidappservice.utils.Utilities;

public class ObligacionesManager {
    
    private static ObligacionesManager singleton = null;

	public static ObligacionesManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (ObligacionesManager.class) {
					if (null == singleton) {
						singleton = new ObligacionesManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	//EN DESUSO PROXIMAMENTE
	public void crearPagoObligacionDeprecated(RequestPagoObligacionDeprecated request) throws Exception {		
		ObligacionesDAO.getInstance().crearSolicitudDeprecated(request);
	}
	public void crearPagoObligacion(RequestPagoObligacion request) throws Exception {
		ObligacionesDAO.getInstance().crearSolicitud(request);
	}

	//EN DESUSO PROXIMAMENTE
	public List<PagoObligacionMD> getPagoObligacionDeprecated(RequestAutenticacion request) throws Exception {
		List<PagoObligacionMD> listaPagos = ObligacionesDAO.getInstance().obtenerPagoObligacion(request.getCedula());
		return listaPagos;
	}
	public List<ResponsePagosObligaciones> getPagoObligacion(RequestAutenticacion request) throws Exception {
		List<PagoObligacionMD> listModel = ObligacionesDAO.getInstance().obtenerPagoObligacion(request.getCedula());
		List<ResponsePagosObligaciones> response = new ArrayList<ResponsePagosObligaciones>();
		if(listModel != null && listModel.size()>0){
			for(PagoObligacionMD obligacion : listModel){
				response.add(new ResponsePagosObligaciones(
					obligacion.getId_dispositivo(),
					Utilities.getFechaString(obligacion.getF_movimi()),
					obligacion.getA_numdoc(),
					obligacion.getN_produc(),
					obligacion.getN_tipodr(),
					obligacion.getA_numcta(),
					obligacion.getA_tipodr(),
					obligacion.getK_tipodr(),
					obligacion.getV_valor()
				));
			}
		}
		return response;
	}

}
