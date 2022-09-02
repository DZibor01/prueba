package com.cm.solidappservice.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.TarjetaPresenteManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.tarjetapresente.request.RequestActualizarEstadoTarjeta;
import com.cm.solidappservice.model.tarjetapresente.request.RequestReposicionTarjeta;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseDatosAsociadoTarjeta;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseTarjeta;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseValorReposicionTarjeta;
import com.cm.solidappservice.utils.Utilities;

@Path("/tarjetaPresente")
public class TarjetaPresente extends BaseService {

	private Utilities utilities;

    public TarjetaPresente(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Path("/obtenerTarjetas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseTarjeta>> getTarjetas(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_TARJETAPRESENTE_OBTENERTARJETAS);
			if (!validacion.isValid()) {
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<List<ResponseTarjeta>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				List<ResponseTarjeta> response = TarjetaPresenteManager.getInstance().getListadoTarjetas(request);
				return new BaseResponse<List<ResponseTarjeta>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("tarjetaPresente/obtenerTarjetas", e.getMessage());
			return new BaseResponse<List<ResponseTarjeta>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
	@Path("/cambiarEstado")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> updateTarjeta(RequestActualizarEstadoTarjeta request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_TARJETAPRESENTE_CAMBIARESTADO);
			if (!validacion.isValid()) {
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				TarjetaPresenteManager.getInstance().actualizarEstadoTarjeta(request);
				return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    Utilities.SOLICITUD_CORRECTA);
			}
		} catch (Exception e) {
			logError("tarjetaPresente/cambiarEstado", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	
	@POST
	@Path("/motivosBloqueo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String[]> getMotivosBloqueo(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_TARJETAPRESENTE_MOTIVOSBLOQUEO);
			if (!validacion.isValid()) {
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<String[]>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				String[] response = TarjetaPresenteManager.getInstance().getMotivosBloqueoTarjeta();
				return new BaseResponse<String[]>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("tarjetaPresente/motivosBloqueo", e.getMessage());
			return new BaseResponse<String[]>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@GET
    @Path("/valorReposicionTarjeta")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseValorReposicionTarjeta> getValorReposicionTarjeta() {
		try {
            ResponseValorReposicionTarjeta response = TarjetaPresenteManager.getInstance().getValorReposicionTarjeta();
			return new BaseResponse<ResponseValorReposicionTarjeta>(
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				response);
        } catch (Exception e) {
			logError("tarjetaPresente/valorReposicionTarjeta", e.getMessage());
            return new BaseResponse<ResponseValorReposicionTarjeta>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
	}
	
	@POST
    @Path("/reposicionTarjeta")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> registrarReposicionTarjeta(RequestReposicionTarjeta request) {
		try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_TARJETAPRESENTE_REPOSICIONTARJETA);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
            } else {
                String response = TarjetaPresenteManager.getInstance().registrarReposicionTarjeta(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
			logError("tarjetaPresente/reposicionTarjeta", e.getMessage());
			return new BaseResponse<String>(
				e.getMessage(), 
				Utilities.ERROR_SERVICIO,
				ResponseConstantes.ERROR_VACIO,
				null);
        } 
	}

	@POST
	@Path("/datosAsosiado")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<ResponseDatosAsociadoTarjeta> getDatosAsosiadoTarjeta(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_TARJETAPRESENTE_DATOSASOSIADO);
			if (!validacion.isValid()){
				validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
				return new BaseResponse<ResponseDatosAsociadoTarjeta>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ResponseDatosAsociadoTarjeta response = TarjetaPresenteManager.getInstance().obtenerDatosAsosiadoTarjeta(request);
				return new BaseResponse<ResponseDatosAsociadoTarjeta>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
			}
		} catch (Exception e) {
			logError("tarjetaPresente/datosAsosiado", e.getMessage());
			return new BaseResponse<ResponseDatosAsociadoTarjeta>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} 
	}
	
}