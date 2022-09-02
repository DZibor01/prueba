package com.cm.solidappservice.manager;

import com.cm.solidappservice.dao.ParametrosGeneralesDAO;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosEmailMD;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;
import com.cm.solidappservice.model.parametrosgenerales.response.ResponseParametrosGenerales;

public class ParametrosGeneralesManager {
    
    private static ParametrosGeneralesManager singleton = null;

	public static ParametrosGeneralesManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (ParametrosGeneralesManager.class) {
					if (null == singleton) {
						singleton = new ParametrosGeneralesManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public ParametrosEmailMD getParametrosEmail(String idParametro) throws Exception {
		ParametrosEmailMD parametro = ParametrosGeneralesDAO.getInstance().obtenerParametrosEmail(idParametro);
		if (parametro == null) {
			throw new Exception("Los parámetros de la aplicación están nulos.");
		}
		return parametro;
	}

	public ResponseParametrosGenerales getParametro(Integer idParametro) throws Exception {
		ParametrosGeneralesMD model = ParametrosGeneralesDAO.getInstance().obtenerParametrosGenerales(idParametro);
		ResponseParametrosGenerales response = null;
		if(model!=null){
			response = new ResponseParametrosGenerales(
				model.getK_parametro(),
				model.getN_parametro(),
				model.getI_estado(),
				model.getN_value1() == null ? "" : model.getN_value1(),
				model.getN_value2() == null ? "" : model.getN_value2(),
				model.getN_value3() == null ? "" : model.getN_value3(),
				model.getN_value4() == null ? "" : model.getN_value4()
			);
		}
		return response;
	}

}
