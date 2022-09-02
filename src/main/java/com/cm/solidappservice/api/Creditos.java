package com.cm.solidappservice.api;

import com.cm.solidappservice.manager.CreditosManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.creditos.request.*;
import com.cm.solidappservice.model.creditos.response.*;
import com.cm.solidappservice.model.datosasociado.response.ResponseDatosAsociado;
import com.cm.solidappservice.utils.Utilities;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/creditoDigital")
public class Creditos extends BaseService {

	private Utilities utilities;

    public Creditos(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Path("/obtenerLineasCredito")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseLineasCredito>> obtenerLineasCredito(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()){
				return new BaseResponse<List<ResponseLineasCredito>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				List<ResponseLineasCredito> response = CreditosManager.getInstance().obtenerLineaCreditos();
				return new BaseResponse<List<ResponseLineasCredito>>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditoDigital/obtenerLineasCredito", e.getMessage());
			return new BaseResponse<List<ResponseLineasCredito>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
  
	@POST
	@Path("/obtenerDatosAsosiado")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<ResponseDatosAsociado> obtenerDatosAsosiado(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()){
				return new BaseResponse<ResponseDatosAsociado>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ResponseDatosAsociado response = CreditosManager.getInstance().obtenerDatosAsosiado(request);
				return new BaseResponse<ResponseDatosAsociado>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditoDigital/obtenerDatosAsosiado", e.getMessage());
			return new BaseResponse<ResponseDatosAsociado>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} 
	}

	@POST
	@Path("/obtener-DatosAsosiado")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<ResponseDatosAsociado> obtenerDatosAsosiadoV2(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()){
				return new BaseResponse<ResponseDatosAsociado>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ResponseDatosAsociado response = CreditosManager.getInstance().obtenerDatosAsosiadoV2(request);
				return new BaseResponse<ResponseDatosAsociado>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditoDigital/obtener-DatosAsosiado", e.getMessage());
			return new BaseResponse<ResponseDatosAsociado>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
  
	@POST
	@Path("/obtenerGestorAsosiado")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<ResponseGestorAsociado> obtenerGestorAsosiado(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()){
				return new BaseResponse<ResponseGestorAsociado>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ResponseGestorAsociado response = CreditosManager.getInstance().obtenerGestorAsosiado(request);
				return new BaseResponse<ResponseGestorAsociado>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditoDigital/obtenerGestorAsosiado", e.getMessage());
			return new BaseResponse<ResponseGestorAsociado>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} 
	}
	
	@GET
	@Path("/obtenerUbicaciones")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<ResponseUbicaciones> obtenerUbicaciones() {
		try {
			ResponseUbicaciones response = CreditosManager.getInstance().obtenerUbicaciones();
			return new BaseResponse<ResponseUbicaciones>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
		} catch (Exception e) {
			logError("creditoDigital/obtenerUbicaciones", e.getMessage());
			return new BaseResponse<ResponseUbicaciones>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
	@Path("/obtenerCreditosRadicados")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseCreditosRadicados>> obtenerCreditosRadicados(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()){
				return new BaseResponse<List<ResponseCreditosRadicados>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				List<ResponseCreditosRadicados> response = CreditosManager.getInstance().obtenerCreditosRadicados(request);
				return new BaseResponse<List<ResponseCreditosRadicados>>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditoDigital/obtenerCreditosRadicados", e.getMessage());
			return new BaseResponse<List<ResponseCreditosRadicados>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} 
	}

	@POST
	@Path("/obtenerParentescos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseParentescos>> obtenerParentescos(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()){
				return new BaseResponse<List<ResponseParentescos>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				List<ResponseParentescos> response = CreditosManager.getInstance().obtenerParentescos(request);
				return new BaseResponse<List<ResponseParentescos>>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditoDigital/obtenerParentescos", e.getMessage());
			return new BaseResponse<List<ResponseParentescos>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} 
	}


	@POST
	@Path("/solicitarCredito")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<ResponseSolicitudCredito> radicarCredito(RequestSolicitudCredito request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()){
				return new BaseResponse<ResponseSolicitudCredito>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ResponseSolicitudCredito response = CreditosManager.getInstance().realizarSolicitudCredito(request);
				return new BaseResponse<ResponseSolicitudCredito>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditoDigital/solicitarCredito", e.getMessage());
			return new BaseResponse<ResponseSolicitudCredito>(
				e.getMessage(), 
				Utilities.ERROR_SERVICIO,
				ResponseConstantes.ERROR_VACIO,
				null);
		}
	}


	@POST
	@Path("/radicarCredito")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<ResponseRadicado> radicarCredito(RequestRadicarCreditoDeprecated2 request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()){
				return new BaseResponse<ResponseRadicado>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ResponseRadicado response = CreditosManager.getInstance().radicarCreditoDeprecated2(request);
				return new BaseResponse<ResponseRadicado>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditoDigital/radicarCredito", e.getMessage());
			return new BaseResponse<ResponseRadicado>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
	@Path("/guardarInformacionCredito")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> infoCredito(RequestInformacionCreditoDeprecated2 request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()){
				return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				String response = CreditosManager.getInstance().guardarInformacionAdicionalDeprecated2(request);
				return new BaseResponse<String>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditoDigital/guardarInformacionCredito", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} 
	}
  
	@POST
	@Path("/guardarReferenciasCredito")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> guardarReferencias(RequestReferenciaCreditoDeprecated2 request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				String response = CreditosManager.getInstance().guardarReferenciasDeprecated2(request);
				return new BaseResponse<String>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditoDigital/guardarReferenciasCredito", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
}