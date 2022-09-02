package com.cm.solidappservice.api;

import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.CentrosVacacionalesManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.centrosvacacionales.request.RequestSolicitudCentroVacacional;
import com.cm.solidappservice.model.centrosvacacionales.response.ResponseCentroVacacional;
import com.cm.solidappservice.utils.Utilities;

@Path("/centrosVacacionales")
public class CentrosVacacionales extends BaseService {

	private Utilities utilities;

    public CentrosVacacionales(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseCentroVacacional>> getCentrosVacacionales(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CENTROSVACACIONALES);
			if (!validacion.isValid()) {
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<List<ResponseCentroVacacional>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
			} else {
				List<ResponseCentroVacacional> response = CentrosVacacionalesManager.getInstance().getListadoCentrosVacacionales();
				return new BaseResponse<List<ResponseCentroVacacional>>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("centrosVacacionales", e.getMessage());
			return new BaseResponse<List<ResponseCentroVacacional>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	
	@POST
	@Path("/crearSolicitud")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> createSolicitudCentroVacacional(RequestSolicitudCentroVacacional request) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CENTROSVACACIONALES_CREARSOLICITUD);
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
				CentrosVacacionalesManager.getInstance().createSolicitudCentroVacacional(request);
				return new BaseResponse<String>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        Utilities.SOLICITUD_CORRECTA_CENTRO_VACACIONAL);
			}
		} catch (Exception e) {
			logError("crearSolicitud/centrosVacacionales", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

}