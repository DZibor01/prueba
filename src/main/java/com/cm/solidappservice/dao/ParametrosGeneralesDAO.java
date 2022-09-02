package com.cm.solidappservice.dao;

import java.util.List;

import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosEmailMD;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;

public class ParametrosGeneralesDAO extends DAO2 {

	private static ParametrosGeneralesDAO singleton = null;

	private final String QUERY_PARAMETROS_EMAIL = "ParametrosGeneralesMapper.cargarParametrosEmail";
	private final String QUERY_PARAMETROS_GENERALES = "ParametrosGeneralesMapper.cargarParametrosGenerales";

	public static ParametrosGeneralesDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (ParametrosGeneralesDAO.class) {
					if (null == singleton) {
						singleton = new ParametrosGeneralesDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public ParametrosEmailMD obtenerParametrosEmail(String idParametro) throws Exception {
		ParametrosEmailMD parametro = new ParametrosEmailMD();
		parametro.setK_parame(idParametro);
		List<ParametrosEmailMD> listModel = getList(QUERY_PARAMETROS_EMAIL, parametro);
		if (listModel == null) {
			return null;
		} else if (listModel.size() == 0) {
			return null;
		} else
			return listModel.get(0);
	}
	
	public ParametrosGeneralesMD obtenerParametrosTransacciones() throws Exception {
		return getObject(QUERY_PARAMETROS_GENERALES, 2);
	}
	
	public ParametrosGeneralesMD obtenerParametrosVersionActual() throws Exception {
		return getObject(QUERY_PARAMETROS_GENERALES, 2);
	}

	public ParametrosGeneralesMD obtenerParametrosMesesActualizarDatos() throws Exception {
		return getObject(QUERY_PARAMETROS_GENERALES, 7);
	}

	public ParametrosGeneralesMD obtenerValorReposicionTarjeta() throws Exception {
		return getObject(QUERY_PARAMETROS_GENERALES, 4);
	}

	public ParametrosGeneralesMD obtenerParametrosGenerales(Integer idParametro) throws Exception {
		return getObject(QUERY_PARAMETROS_GENERALES, idParametro);
	}
}