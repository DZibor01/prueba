package com.cm.solidappservice.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.MensajesInboxManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.mensajesinbox.request.RequestEnvioMensajeInboxDeprecated;
import com.cm.solidappservice.model.mensajesinbox.response.ResponseMensajesInbox;
import com.cm.solidappservice.utils.Utilities;

@Path("/notificacionesInbox")
public class MensajesInboxDeprecated extends BaseService {
	
	private Utilities utilities;

    public MensajesInboxDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseMensajesInbox>> obtenerMensajesInbox(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<List<ResponseMensajesInbox>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				List<ResponseMensajesInbox> response = MensajesInboxManager.getInstance().obtenerMensajesInbox(request);
				return new BaseResponse<List<ResponseMensajesInbox>>(
					ResponseConstantes.ERROR_VACIO,
					ResponseConstantes.ERROR_VACIO,
					ResponseConstantes.ERROR_VACIO,
					response);
			}
		} catch (Exception e) {
			logError("notificacionesInbox", e.getMessage());
			return new BaseResponse<List<ResponseMensajesInbox>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
	@Path("/enviarNotificacionInbox")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> enviarNotificacionInbox(RequestEnvioMensajeInboxDeprecated request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
            } else {
                String response = MensajesInboxManager.getInstance().enviarMensajeInboxDeprecated(request);
                return new BaseResponse<String>(
					ResponseConstantes.ERROR_VACIO,
					ResponseConstantes.ERROR_VACIO,
					ResponseConstantes.ERROR_VACIO,
					response);
            }
        } catch (Exception e) {
            logError("notificacionesInbox/enviarNotificacionInbox", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }
}