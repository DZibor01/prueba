package com.cm.solidappservice.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.MensajesInboxManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.mensajesinbox.response.*;
import com.cm.solidappservice.utils.Utilities;
import com.cm.solidappservice.model.mensajesinbox.request.*;

@Path("/inbox")
public class MensajesInbox extends BaseService {
	
	private Utilities utilities;

    public MensajesInbox(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Path("/obtenerMensajes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseMensajesInbox>> obtenerMensajesInbox(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_INBOX_OBTENERMENSAJES);
			if (!validacion.isValid()) {
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
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
			logError("inbox/obtenerMensajes", e.getMessage());
			return new BaseResponse<List<ResponseMensajesInbox>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
	@Path("/enviarMensaje")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> enviarMensajeInbox(RequestEnvioMensajeInbox request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_INBOX_ENVIARMENSAJE);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
            } else {
                String response = MensajesInboxManager.getInstance().enviarMensajeInbox(request);
                return new BaseResponse<String>(
					ResponseConstantes.ERROR_VACIO,
					ResponseConstantes.ERROR_VACIO,
					ResponseConstantes.ERROR_VACIO,
					response);
            }
        } catch (Exception e) {
            logError("inbox/enviarMensaje", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }

	@POST
	@Path("/actualizarMensaje")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> actualizarLecturaMensaje(RequestActualizarLectura request) {	
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_INBOX_ACTUALIZARMENSAJE);
			if (!validacion.isValid()) {
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
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
			logError("inbox/actualizarMensaje", e.getMessage());
			return new BaseResponse<String>(
				e.getMessage(),
				Utilities.ERROR_SERVICIO,
				ResponseConstantes.ERROR_VACIO,
				null);
		}
	}


}