package com.cm.solidappservice.manager;

import java.util.List;

import com.cm.solidappservice.dao.DispositivoDAO;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.dispositivo.bd.RegistroDispositivoMD;
import com.cm.solidappservice.model.dispositivo.request.RequestDispositivo;
import com.cm.solidappservice.model.dispositivo.response.ResponseRegistrarDispositivo;
import com.cm.solidappservice.model.dispositivo.response.ResponseValidarDispositivoRegistrado;

public class DispositivoManager {
    
    private static DispositivoManager singleton = null;

	public static DispositivoManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (DispositivoManager.class) {
					if (null == singleton) {
						singleton = new DispositivoManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public ResponseValidarDispositivoRegistrado validarDispositivoRegistrado(RequestDispositivo request) throws Exception {
		List<RegistroDispositivoMD> model = DispositivoDAO.getInstance().obtenerDispositivoRegistrado(request);
		ResponseValidarDispositivoRegistrado response = new ResponseValidarDispositivoRegistrado(
			ResponseConstantes.CAMPO_FALSE,
			ResponseConstantes.CADENA_VACIA
		);
		if(model != null && model.size()>0){
			response = new ResponseValidarDispositivoRegistrado(
				ResponseConstantes.CAMPO_TRUE,
				model.get(0).getK_registrodispos()
			);
		}
		return response;
	}

	public ResponseRegistrarDispositivo registrarDispositivo(RequestDispositivo request) throws Exception {
		String idRegistro = DispositivoDAO.getInstance().insertarNuevoDispositivo(request);
		ResponseRegistrarDispositivo response = new ResponseRegistrarDispositivo(idRegistro);
		return response;
	}


	

}
