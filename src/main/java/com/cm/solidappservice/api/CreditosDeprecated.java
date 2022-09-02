package com.cm.solidappservice.api;

import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.CreditosManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.creditos.request.*;
import com.cm.solidappservice.model.creditos.response.*;
import com.cm.solidappservice.model.datosasociado.response.ResponseDatosAsociadoDeprecated;
import com.cm.solidappservice.utils.Utilities;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/creditos")
public class CreditosDeprecated extends BaseService {

	private Utilities utilities;

    public CreditosDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Path("/obtenerLineasCredito")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseLineasCreditoDeprecated>> obtenerLineasCredito(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CREDITOS_OBTENERLINEASCREDITO);
			if (!validacion.isValid()){
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<List<ResponseLineasCreditoDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				List<ResponseLineasCreditoDeprecated> response = CreditosManager.getInstance().obtenerLineaCreditosDeprecated();
				return new BaseResponse<List<ResponseLineasCreditoDeprecated>>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditos/obtenerLineasCredito", e.getMessage());
			return new BaseResponse<List<ResponseLineasCreditoDeprecated>>(
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
	public BaseResponse<ResponseDatosAsociadoDeprecated> obtenerDatosAsosiado(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CREDITOS_OBTENERDATOSASOSIADO);
			if (!validacion.isValid()){
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<ResponseDatosAsociadoDeprecated>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ResponseDatosAsociadoDeprecated response = CreditosManager.getInstance().obtenerDatosAsosiadoDeprecated(request);
				return new BaseResponse<ResponseDatosAsociadoDeprecated>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditos/obtenerDatosAsosiado", e.getMessage());
			return new BaseResponse<ResponseDatosAsociadoDeprecated>(
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
	public BaseResponse<ResponseRadicadoDeprecated> radicarCredito(RequestRadicarCreditoDeprecated request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CREDITOS_RADICARCREDITO);
			if (!validacion.isValid()){
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<ResponseRadicadoDeprecated>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ResponseRadicadoDeprecated response = CreditosManager.getInstance().radicarCreditoDeprecated(request);
				return new BaseResponse<ResponseRadicadoDeprecated>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditos/radicarCredito", e.getMessage());
			return new BaseResponse<ResponseRadicadoDeprecated>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
  
	@POST
	@Path("/infoCredito")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> infoCredito(RequestInformacionCreditoDeprecated request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CREDITOS_INFOCREDITO);
			if (!validacion.isValid()){
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				String response = CreditosManager.getInstance().guardarInformacionAdicionalDeprecated(request);
				return new BaseResponse<String>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditos/infoCredito", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} 
	}

	@POST
	@Path("/guardarReferencias")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> guardarReferencias(List<RequestReferenciaCreditoDeprecated> listRequest) {
		try {
			RequestReferenciaCreditoDeprecated request = listRequest.get(0);
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CREDITOS_GUARDARREFERENCIAS);
			if (!validacion.isValid()) {
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {

				String response = Utilities.ERROR_SERVICIO;
				for (int f = 0; f < listRequest.size(); f++) {
					RequestReferenciaCreditoDeprecated p = listRequest.get(f);
					if (f > 0)
						validateParameterNew(p, scopeConstantes.SCOPE_CREDITOS_GUARDARREFERENCIAS);
					response = CreditosManager.getInstance().guardarReferenciasDeprecated(p);
				}
				return new BaseResponse<String>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);

			}
		} catch (Exception e) {
			logError("creditos/guardarReferencias", e.getMessage());
			return new BaseResponse<String>(
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
	public BaseResponse<ResponseGestorAsociadoDeprecated> obtenerGestorAsosiado(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CREDITOS_OBTENERGESTORASOSIADO);
			if (!validacion.isValid()){
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<ResponseGestorAsociadoDeprecated>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ResponseGestorAsociadoDeprecated response = CreditosManager.getInstance().obtenerGestorAsosiadoDeprecated(request);
				return new BaseResponse<ResponseGestorAsociadoDeprecated>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditos/obtenerGestorAsosiado", e.getMessage());
			return new BaseResponse<ResponseGestorAsociadoDeprecated>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} 
	}
	
	@POST
	@Path("/obtenerCiudadesDepartamentos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseUbicacionesDeprecated>> obtenerUbicaciones(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CREDITOS_OBTENERCIUDADESDEPARTAMENTOS);
			if (!validacion.isValid()){
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<List<ResponseUbicacionesDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				List<ResponseUbicacionesDeprecated> response = CreditosManager.getInstance().obtenerUbicacionesDeprecated();
				return new BaseResponse<List<ResponseUbicacionesDeprecated>>(
							ResponseConstantes.ERROR_VACIO,
							ResponseConstantes.ERROR_VACIO,
							ResponseConstantes.ERROR_VACIO,
							response);
			}			
		} catch (Exception e) {
			logError("creditos/obtenerCiudadesDepartamentos", e.getMessage());
			return new BaseResponse<List<ResponseUbicacionesDeprecated>>(
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
			logError("creditos/obtenerUbicaciones", e.getMessage());
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
	public BaseResponse<List<ResponseCreditosRadicadosDeprecated>> obtenerCreditosRadicados(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CREDITOS_OBTENERCREDITOSRADICADOS);
			if (!validacion.isValid()){
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<List<ResponseCreditosRadicadosDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				List<ResponseCreditosRadicadosDeprecated> response = CreditosManager.getInstance().obtenerCreditosRadicadosDeprecated(request);
				return new BaseResponse<List<ResponseCreditosRadicadosDeprecated>>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("creditos/obtenerCreditosRadicados", e.getMessage());
			return new BaseResponse<List<ResponseCreditosRadicadosDeprecated>>(
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
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_CREDITOS_OBTENERPARENTESCOS);
			if (!validacion.isValid()){
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
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
			logError("creditos/obtenerParentescos", e.getMessage());
			return new BaseResponse<List<ResponseParentescos>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} 
	}
	
}