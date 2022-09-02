package com.cm.solidappservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.MensajesInboxManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.mensajesinbox.request.RequestActualizarLectura;
import com.cm.solidappservice.utils.Utilities;

@Path("/actualizarNotificacionUsuario")
public class MensajesInboxActualizacionDeprecated extends BaseService {

	private Utilities utilities;

    public MensajesInboxActualizacionDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> actualizarLecturaMensaje(RequestActualizarLectura request) {	
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<String>(
					validacion.getErrorParametros(),
					validacion.getErrorParametros(),
					validacion.getErrorToken(),
					null);
			} else {
				MensajesInboxManager.getInstance().actualizarLecturaMensaje(request);
				return new BaseResponse<String>(
					ResponseConstantes.ERROR_VACIO,
					ResponseConstantes.ERROR_VACIO, 
					ResponseConstantes.ERROR_VACIO, 
					Utilities.SOLICITUD_CORRECTA);
			}
		} catch (Exception e) {
			logError("actualizarNotificacionUsuario", e.getMessage());
			return new BaseResponse<String>(
				e.getMessage(),
				Utilities.ERROR_SERVICIO,
				ResponseConstantes.ERROR_VACIO,
				null);
		}
	}
}
