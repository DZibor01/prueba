package com.cm.solidappservice.manager;

import com.cm.solidappservice.dao.SegurosDAO;
import com.cm.solidappservice.model.seguros.bd.InmuebleMD;
import com.cm.solidappservice.model.seguros.bd.SolicitudSeguroMD;
import com.cm.solidappservice.model.seguros.bd.VehiculoMD;

public class SegurosManager {

	private static SegurosManager singleton = null;

	public static SegurosManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (SegurosManager.class) {
					if (null == singleton) {
						singleton = new SegurosManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public void crearVehiculo(VehiculoMD parametro) throws Exception {
		SegurosDAO.getInstance().crearVehiculo(parametro);
	}

	public void crearInmueble(InmuebleMD parametro) throws Exception {
		SegurosDAO.getInstance().crearInmueble(parametro);
	}

	public void crearSolicitudAhorro(SolicitudSeguroMD parametro) throws Exception {
		SegurosDAO.getInstance().crearSolicitud(parametro);
	}
}