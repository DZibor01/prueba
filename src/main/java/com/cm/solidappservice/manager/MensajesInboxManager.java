package com.cm.solidappservice.manager;

import java.util.ArrayList;
import java.util.List;

import com.cm.solidappservice.dao.MensajesInboxDAO;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.mensajesinbox.bd.*;
import com.cm.solidappservice.model.mensajesinbox.request.*;
import com.cm.solidappservice.model.mensajesinbox.response.ResponseMensajesInbox;
import com.cm.solidappservice.utils.Utilities;

public class MensajesInboxManager {
    
    private static MensajesInboxManager singleton = null;

	public static MensajesInboxManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (MensajesInboxManager.class) {
					if (null == singleton) {
						singleton = new MensajesInboxManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public List<ResponseMensajesInbox> obtenerMensajesInbox(RequestAutenticacion request) throws Exception {
		List<MensajesInboxMD> listModel = MensajesInboxDAO.getInstance().obtenerNotificaciones(request.getCedula());
		List<ResponseMensajesInbox> response = new ArrayList<ResponseMensajesInbox>();
		if (listModel != null && listModel.size() > 0) {
			for (MensajesInboxMD mensaje : listModel) {
				if (Utilities.IsNullOrEmpty(mensaje.getI_leido())) {
					mensaje.setI_leido(ResponseConstantes.CAMPO_FALSE);
				}
				response.add(new ResponseMensajesInbox(
					String.valueOf(mensaje.getK_proces()), 
					mensaje.getN_tipo(), 
					mensaje.getN_mensaj(),
					mensaje.getI_leido()
				));
			}
		}
		return response;
	}

	//En desusoproximamente
	public String enviarMensajeInboxDeprecated(RequestEnvioMensajeInboxDeprecated request) throws Exception {
		String response = MensajesInboxDAO.getInstance().enviarMensajeInboxDeprecated(request);
		return response;
	}
	public String enviarMensajeInbox(RequestEnvioMensajeInbox request) throws Exception {
		String response = MensajesInboxDAO.getInstance().enviarMensajeInbox(request);
		return response;
	}

	public void actualizarLecturaMensaje(RequestActualizarLectura request) throws Exception {
		MensajesInboxMD parametro = new MensajesInboxMD();
		parametro.setAanumnit(request.getCedula());
		parametro.setK_proces(Long.valueOf(request.getIdMensaje()).longValue());
		parametro.setI_leido(ResponseConstantes.CAMPO_TRUE);
		MensajesInboxDAO.getInstance().actualizarLecturaMensaje(parametro);
	}

}
