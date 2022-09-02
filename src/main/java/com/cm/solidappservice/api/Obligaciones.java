package com.cm.solidappservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.Timestamp;
import java.util.List;

import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.obligaciones.request.*;
import com.cm.solidappservice.model.obligaciones.response.*;
import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.ObligacionesManager;
import com.cm.solidappservice.utils.Utilities;

@Path("/obligaciones")
public class Obligaciones extends BaseService {
	
	private Utilities utilities;

    public Obligaciones(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Path("/realizarPago")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> crearSolicitudPagoObligacion(RequestPagoObligacion request) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
		try {
			crearLogApi(idLog, request.getCedula(), "/abonos/pagarObligacion", "PagoObligacion", "POST", request);
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_OBLIGACIONES_REALIZARPAGO);
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
				ObligacionesManager.getInstance().crearPagoObligacion(request);
				actualizarLogApi(idLog, Utilities.SOLICITUD_CORRECTA, ResponseConstantes.RESULTADO_EXITOSO, "");
				return new BaseResponse<String>(
					ResponseConstantes.ERROR_VACIO,    
					ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    Utilities.SOLICITUD_CORRECTA);
			}
		} catch (Exception e) {
			logError("obligaciones/realizarPago", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
	@Path("/consultarPagosIncompletos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponsePagosObligaciones>> consultarTransferencia(RequestAutenticacion request) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
		try {
			crearLogApi(idLog, request.getCedula(), "/abonos/consultarPagosIncompletos", "PagoObligacion", "POST", request);
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_OBLIGACIONES_CONSULTARPAGOSINCOMPLETOS);
			if (!validacion.isValid()) {
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
				return new BaseResponse<List<ResponsePagosObligaciones>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				List<ResponsePagosObligaciones> response = ObligacionesManager.getInstance().getPagoObligacion(request);
				actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
				return new BaseResponse<List<ResponsePagosObligaciones>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("obligaciones/consultarPagosIncompletos", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<List<ResponsePagosObligaciones>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
}