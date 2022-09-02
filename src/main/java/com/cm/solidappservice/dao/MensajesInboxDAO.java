package com.cm.solidappservice.dao;

import java.util.Date;
import java.util.List;

import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.mensajesinbox.bd.MensajesInboxMD;
import com.cm.solidappservice.model.mensajesinbox.request.RequestEnvioMensajeInbox;
import com.cm.solidappservice.model.mensajesinbox.request.RequestEnvioMensajeInboxDeprecated;
import com.cm.solidappservice.utils.Utilities;
import org.apache.ibatis.session.SqlSession;

public class MensajesInboxDAO extends DAO2 {

	private static MensajesInboxDAO singleton = null;
	private final String QUERY_OBTENER_MENSAJES_INBOX = "MensajesInboxMapper.obtenerMensajesInbox";
	private final String QUERY_ENVIAR_MENSAJE_INBOX = "MensajesInboxMapper.enviarMensajeInbox";
	private final String QUERY_ACTUALIZAR_LECTURA_MENSAJE = "MensajesInboxMapper.actualizarMensajeLeido";
	
	public static MensajesInboxDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (MensajesInboxDAO.class) {
					if (null == singleton) {
						singleton = new MensajesInboxDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public List<MensajesInboxMD> obtenerNotificaciones(String cedula) throws Exception {
		List<MensajesInboxMD> listModel = null;
		MensajesInboxMD model = new MensajesInboxMD();
		model.setAanumnit(cedula);
		model.setF_inicio(Utilities.getFechaString(new Date()));
		model.setF_final(Utilities.getFechaString(new Date()));
		listModel = getList(QUERY_OBTENER_MENSAJES_INBOX, model);
		return listModel;
	}

	//EN DESUSO PROXIMAMENTE
	public String enviarMensajeInboxDeprecated(RequestEnvioMensajeInboxDeprecated request) throws Exception {
		int id = (int) new Date().getTime();
		MensajesInboxMD model = new MensajesInboxMD();
		model.setAanumnit(request.getCedula());
		model.setF_inicio(request.getF_inicio());
		model.setF_final(request.getF_final());
		model.setN_mensaj(request.getN_mensaj());
		model.setQ_orden(0);
		model.setK_proces(id);
		model.setI_leido("");
		model.setN_tipo(request.getN_tipo());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ENVIAR_MENSAJE_INBOX, model);
		} finally {
			session.close();
		} 
		return ResponseConstantes.RESULTADO_EXITOSO;
	}
	public String enviarMensajeInbox(RequestEnvioMensajeInbox request) throws Exception {
		int id = (int) new Date().getTime();
		MensajesInboxMD model = new MensajesInboxMD();
		model.setAanumnit(request.getCedula());
		model.setF_inicio(request.getFechaInicio());
		model.setF_final(request.getFechaFinal());
		model.setN_mensaj(request.getContenidoMensaje());
		model.setQ_orden(0);
		model.setK_proces(id);
		model.setI_leido("");
		model.setN_tipo(request.getTipoContenido());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ENVIAR_MENSAJE_INBOX, model);
		} finally {
			session.close();
		} 
		return ResponseConstantes.RESULTADO_EXITOSO;
	}

	public void actualizarLecturaMensaje(MensajesInboxMD parametro) throws Exception {
		updateObject(QUERY_ACTUALIZAR_LECTURA_MENSAJE, parametro);
	}

}