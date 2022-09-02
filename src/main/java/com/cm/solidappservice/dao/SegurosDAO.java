package com.cm.solidappservice.dao;

import com.cm.solidappservice.model.seguros.bd.InmuebleMD;
import com.cm.solidappservice.model.seguros.bd.SolicitudSeguroMD;
import com.cm.solidappservice.model.seguros.bd.VehiculoMD;

public class SegurosDAO extends DAO2 {
	private static SegurosDAO singleton = null;
	private final String QUERY_CREAR_VEHICULO = "SegurosMapper.insertVehiculo";
	private final String QUERY_CREAR_INMUEBLE = "SegurosMapper.insertInmueble";
	private final String QUERY_CREAR_SOLICITUDAHORRO = "SegurosMapper.insertSolicitudSeguro";

	public static SegurosDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (SegurosDAO.class) {
					if (null == singleton) {
						singleton = new SegurosDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public void crearVehiculo(VehiculoMD parametro) throws Exception {
		insertObject(QUERY_CREAR_VEHICULO, parametro);
	}
	public void crearInmueble(InmuebleMD parametro) throws Exception {
		insertObject(QUERY_CREAR_INMUEBLE, parametro);
	}
	public void crearSolicitud(SolicitudSeguroMD parametro) throws Exception {
		insertObject(QUERY_CREAR_SOLICITUDAHORRO, parametro);
	}
}