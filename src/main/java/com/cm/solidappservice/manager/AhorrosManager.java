package com.cm.solidappservice.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cm.solidappservice.dao.AhorrosDAO;
import com.cm.solidappservice.model.ahorros.bd.*;
import com.cm.solidappservice.model.ahorros.request.*;
import com.cm.solidappservice.model.ahorros.response.*;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.utils.Utilities;

public class AhorrosManager {

    private static AhorrosManager singleton = null;

	public static AhorrosManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (AhorrosManager.class) {
					if (null == singleton) {
						singleton = new AhorrosManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	//EN DESUSO PROXIMAMENTE
	public void crearSolicitudAhorroDeprecated(RequestSolicitudAhorroDeprecated request) throws Exception {
		SolicitudAhorroMD model = new SolicitudAhorroMD();
		model.setAanumnit(request.getCedula());
		model.setF_solici(new Date());
		if (!Utilities.IsNullOrEmpty(request.getF_vigenci_fin())) {
			model.setF_vigenci_fin(Utilities.getFechaDate(request.getF_vigenci_fin()));
		} else {
			model.setF_vigenci_fin(null);
		}
		model.setId_dispositivo(request.getId_dispositivo());
		model.setK_tipodr(request.getK_tipodr());
		model.setN_destin(request.getN_destin());
		model.setV_cuota(request.getV_cuota());
		model.setV_plazo(request.getV_plazo());
		AhorrosDAO.getInstance().crearSolicitud(model);
	}
	public void crearSolicitudAhorro(RequestSolicitudAhorro request) throws Exception {
		SolicitudAhorroMD model = new SolicitudAhorroMD();
		model.setAanumnit(request.getCedula());
		model.setF_solici(new Date());
		if (!Utilities.IsNullOrEmpty(request.getFechaVigenciaFin())) {
			model.setF_vigenci_fin(Utilities.getFechaDate(request.getFechaVigenciaFin()));
		} else {
			model.setF_vigenci_fin(null);
		}
		model.setId_dispositivo(request.getIdDispositivo());
		model.setK_tipodr(request.getClasificacionProducto());
		model.setN_destin(request.getDestino());
		model.setV_cuota(request.getValorCuota());
		model.setV_plazo(request.getValorPlazo());
		AhorrosDAO.getInstance().crearSolicitud(model);
	}

	//EN DESUSO PROXIMAMENTE
	public List<ResponseTipoAhorroDisponibleDeprecated> getTiposAhorroDisponiblesDeprecated() throws Exception {
		List<TipoAhorroMD> listModel = AhorrosDAO.getInstance().obtenerTiposAhorro();
		List<ResponseTipoAhorroDisponibleDeprecated> response = new ArrayList<ResponseTipoAhorroDisponibleDeprecated>();
		for (TipoAhorroMD tipo : listModel) {
			ResponseTipoAhorroDisponibleDeprecated n = new ResponseTipoAhorroDisponibleDeprecated();
			n.setDescripciones(tipo.getDescripciones());
			// n.setF_vigenci_fin(dato.setF_vigenci_fin(f_vigenci_fin));
			if (tipo.getF_vigenci_fin() != null) {
				n.setF_vigenci_fin(Utilities.getFechaString(tipo.getF_vigenci_fin()));
			} else {
				n.setF_vigenci_fin(ResponseConstantes.ERROR_VACIO);
			}
			n.setI_activo(tipo.getI_activo());
			n.setI_fecha(tipo.getI_fecha());
			n.setI_observ(tipo.getI_observ());
			n.setK_tipodr(tipo.getK_tipodr());
			n.setN_tipodr(tipo.getN_tipodr());
			n.setV_cuota_maxima(tipo.getV_cuota_max());
			n.setV_cuota_minima(tipo.getV_cuota_min());
			n.setV_plazo_max(tipo.getV_plazo_max());
			n.setV_plazo_min(tipo.getV_plazo_min());
			response.add(n);
		}
		return response;
	}
	public List<ResponseTipoAhorroDisponible> getTiposAhorroDisponibles() throws Exception {
		List<TipoAhorroMD> listModel = AhorrosDAO.getInstance().obtenerTiposAhorro();
		List<ResponseTipoAhorroDisponible> response = new ArrayList<ResponseTipoAhorroDisponible>();
		if(listModel != null && listModel.size()>0){
			for (TipoAhorroMD tipo : listModel) {
				response.add(new ResponseTipoAhorroDisponible(
					tipo.getK_tipodr(),
					tipo.getN_tipodr(),
					tipo.getV_cuota_min(),
					tipo.getV_cuota_max(),
					tipo.getV_plazo_min(), 
					tipo.getV_plazo_max(),
					tipo.getI_fecha(),
					tipo.getI_observ(),
					tipo.getF_vigenci_fin() != null ? Utilities.getFechaString(tipo.getF_vigenci_fin()) : "",
					tipo.getI_activo(),
					tipo.getDescripciones()
				));
			}
		}
		return response;
	}
    
}
