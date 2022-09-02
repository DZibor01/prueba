package com.cm.solidappservice.dao;

import java.util.List;

import com.cm.solidappservice.model.ahorros.bd.DescripcionTipoAhorroMD;
import com.cm.solidappservice.model.ahorros.bd.SolicitudAhorroMD;
import com.cm.solidappservice.model.ahorros.bd.TipoAhorroMD;
import com.cm.solidappservice.model.base.ResponseConstantes;

public class AhorrosDAO extends DAO2 {
	private static AhorrosDAO singleton = null;
	private static final String QUERY_CREAR_SOLICITUD_AHORRO = "AhorrosMapper.crearSolicitudAhorro";

	private static final String QUERY_TIPOS_AHORRO_DISPONIBLES = "AhorrosMapper.obtenerTiposAhorro";
	private static final String QUERY_DESCRIPCIONES_AHORROS = "AhorrosMapper.obtenerDescripcionesTiposAhorro";

	public static AhorrosDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (AhorrosDAO.class) {
					if (null == singleton) {
						singleton = new AhorrosDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public void crearSolicitud(SolicitudAhorroMD parametro) throws Exception {
		insertObject(QUERY_CREAR_SOLICITUD_AHORRO, parametro);
	}

	public List<TipoAhorroMD> obtenerTiposAhorro() throws Exception {
		List<TipoAhorroMD> result = null;
		TipoAhorroMD parametro = new TipoAhorroMD();
		parametro.setI_activo(ResponseConstantes.CAMPO_TRUE);
		result = getList(QUERY_TIPOS_AHORRO_DISPONIBLES, parametro);
		for (TipoAhorroMD tipoAhorroDisponible : result) {
			if (tipoAhorroDisponible.getI_observ().equals(ResponseConstantes.CAMPO_TRUE)) {//Requiere descripciones
				String[] descripciones = obtenerListadoDescripcion(tipoAhorroDisponible.getK_tipodr());
				if (descripciones.length == 0) {
					String titulo =tipoAhorroDisponible.getN_tipodr();
					descripciones = new String[] { titulo +  " DESCRIPCION 1", titulo +  " DESCRIPCION 2", titulo +  " DESCRIPCION 3"};
				}
				tipoAhorroDisponible.setDescripciones(descripciones);
			}
		}
		return result;
	}
	
	private String[] obtenerListadoDescripcion(String k_tipodr) throws Exception {
		List<DescripcionTipoAhorroMD> result = null;
		DescripcionTipoAhorroMD parametro = new DescripcionTipoAhorroMD();
		parametro.setK_tipodr(k_tipodr);
		result = getList(QUERY_DESCRIPCIONES_AHORROS, parametro);
		String[] descripciones = new String[result.size()];
		for (int i = 0; i < result.size(); i++) {
			descripciones[i]=result.get(i).getV_descrip();
		}
		return descripciones;
	}
}