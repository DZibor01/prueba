package com.cm.solidappservice.api;

import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.AhorrosManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.ahorros.request.RequestSolicitudAhorro;
import com.cm.solidappservice.model.ahorros.response.ResponseTipoAhorroDisponible;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.utils.Utilities;

@Path("/ahorros")
public class Ahorros extends BaseService {
	
	private Utilities utilities;

    public Ahorros(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Path("/crearSolicitudAhorro")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> crearSolicitudAhorro(RequestSolicitudAhorro request) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
		try {
			crearLogApi(idLog, request.getCedula(), "/crearSolicitudAhorro/", "SolicitudAhorro", "POST", request);
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_AHORROS_CREARSOLICITUDAHORRO);
			if (!validacion.isValid()) {
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
				return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				AhorrosManager.getInstance().crearSolicitudAhorro(request);
				actualizarLogApi(idLog, Utilities.SOLICITUD_CORRECTA, ResponseConstantes.RESULTADO_EXITOSO, "");
				return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    Utilities.SOLICITUD_CORRECTA);
			}
		} catch (Exception e) {
			logError("ahorros/crearSolicitudAhorro", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
	@Path("/tiposAhorroDisponible")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseTipoAhorroDisponible>> getTiposAhorroDisponibles(RequestAutenticacion request) {
        try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_AHORROS_TIPOSAHORRODISPONIBLE);
			if (!validacion.isValid()) {
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<List<ResponseTipoAhorroDisponible>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			}else{
				List<ResponseTipoAhorroDisponible> response = AhorrosManager.getInstance().getTiposAhorroDisponibles();
				return new BaseResponse<List<ResponseTipoAhorroDisponible>>(
						ResponseConstantes.ERROR_VACIO,
						ResponseConstantes.ERROR_VACIO,
						ResponseConstantes.ERROR_VACIO,
						response);
			}
		} catch (Exception e) {
			logError("ahorros/tiposAhorroDisponible", e.getMessage());
			return new BaseResponse<List<ResponseTipoAhorroDisponible>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
}