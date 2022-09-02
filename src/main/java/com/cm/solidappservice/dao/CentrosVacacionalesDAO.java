package com.cm.solidappservice.dao;

import java.util.List;

import com.cm.solidappservice.model.centrosvacacionales.bd.CentroVacacionalMD;
import com.cm.solidappservice.model.centrosvacacionales.bd.SolicitudCentroVacacionalMD;

public class CentrosVacacionalesDAO extends DAO2{
	private final String QUERY_CARGAR_LISTADO = "CentrosVacacionalesMapper.cargarListado";
	private final String QUERY_CREAR_SOLICITUD_CENTRO_VACACIONAL = "CentrosVacacionalesMapper.crearSolicitudCentroVacacional";
	
	private static CentrosVacacionalesDAO singleton = null;
	
	public static CentrosVacacionalesDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (CentrosVacacionalesDAO.class) {
					if (null == singleton) {
						singleton = new CentrosVacacionalesDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}
	
	public List<CentroVacacionalMD> getList() throws Exception{
		return getList(QUERY_CARGAR_LISTADO, null);
	}
	
	public void insert(SolicitudCentroVacacionalMD solicitud) throws Exception{
		insertObject(QUERY_CREAR_SOLICITUD_CENTRO_VACACIONAL, solicitud);
	}
}