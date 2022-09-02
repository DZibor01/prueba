package com.cm.solidappservice.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.PortalUnicoManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.portalunico.request.RequestRegistroIngreso;
import com.cm.solidappservice.model.portalunico.request.RequestSolicitarCertificado;
import com.cm.solidappservice.model.portalunico.request.RequestRegistroVotaciones;
import com.cm.solidappservice.model.portalunico.response.ResponseBannerLogin;
import com.cm.solidappservice.model.portalunico.response.ResponseSolicitarCeriticado;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.utils.Utilities;

@Path("/portalServiciosDigitales")
public class PortalUnico extends BaseService {
	
    private Utilities utilities;

    public PortalUnico(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    @POST
    @Path("/registrarIngreso")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> registrarIngresoPortalUnico(RequestRegistroIngreso request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_PORTALSERVICIOSDIGITALES_REGISTRARINGRESO);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
            } else {
                String response = PortalUnicoManager.getInstance().registrarIngresoPortalUnico(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("portalServiciosDigitales/registrarIngreso", e.getMessage());
            return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }
    	
    @GET
    @Path("/bannerLogin")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseBannerLogin>> obtenerMensajesBanner() {
        try {
            List<ResponseBannerLogin> response = PortalUnicoManager.getInstance().obtenerBannerLogin();
            return new BaseResponse<List<ResponseBannerLogin>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
        } catch (Exception e) {
            logError("portalServiciosDigitales/bannerLogin", e.getMessage());
            return new BaseResponse<List<ResponseBannerLogin>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }

    @POST
    @Path("/solicitarCertificado")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseSolicitarCeriticado> solicitarCertificadoLibertad(RequestSolicitarCertificado request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_PORTALSERVICIOSDIGITALES_SOLICITARCERTIFICADO);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<ResponseSolicitarCeriticado>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
            } else {
                ResponseSolicitarCeriticado response = PortalUnicoManager.getInstance().solicitarCertificadoLibertad(request);
                return new BaseResponse<ResponseSolicitarCeriticado>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("portalServiciosDigitales/solicitarCertificado", e.getMessage());
            return new BaseResponse<ResponseSolicitarCeriticado>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }

    @POST
	@Path("/agregarHistorialVotacion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> agregarHistorialVotacion(RequestRegistroVotaciones request) {
    	try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_PORTALSERVICIOSDIGITALES_AGREGARHISTORIALVOTACION);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
            } else {
                String response = PortalUnicoManager.getInstance().registrarHistorialVotaciones(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("portalServiciosDigitales/agregarHistorialVotacion", e.getMessage());
            return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
	}

}