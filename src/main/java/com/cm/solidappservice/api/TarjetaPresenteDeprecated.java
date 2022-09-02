package com.cm.solidappservice.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.TarjetaPresenteManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.tarjetapresente.request.RequestActualizarEstadoTarjeta;
import com.cm.solidappservice.model.tarjetapresente.request.RequestReposicionTarjetaDeprecated;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseDatosAsociadoTarjetaDeprecated;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseTarjetaDeprecated;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseValorReposicionTarjetaDeprecated;
import com.cm.solidappservice.utils.Utilities;

@Path("/tarjetas")
public class TarjetaPresenteDeprecated extends BaseService {

	private Utilities utilities;

    public TarjetaPresenteDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseTarjetaDeprecated>> getTarjetas(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<List<ResponseTarjetaDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				List<ResponseTarjetaDeprecated> response = TarjetaPresenteManager.getInstance().getListadoTarjetasDeprecated(request);
				return new BaseResponse<List<ResponseTarjetaDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("tarjetas", e.getMessage());
			return new BaseResponse<List<ResponseTarjetaDeprecated>>(
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
	public BaseResponse<String> actualizarEstadoTarjeta(RequestActualizarEstadoTarjeta request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
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
			logError("tarjetas/cambiarEstado", e.getMessage());
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
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
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
			logError("tarjetas/motivosBloqueo", e.getMessage());
			return new BaseResponse<String[]>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@GET
    @Path("/valorRepoTarjeta")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseValorReposicionTarjetaDeprecated> getValorReposicionTarjeta() {
        try {
            ResponseValorReposicionTarjetaDeprecated response = TarjetaPresenteManager.getInstance().getValorReposicionTarjetaDeprecated();
			return new BaseResponse<ResponseValorReposicionTarjetaDeprecated>(
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				response);
        } catch (Exception e) {
			logError("tarjetas/valorRepoTarjeta", e.getMessage());
            return new BaseResponse<ResponseValorReposicionTarjetaDeprecated>(
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
    public BaseResponse<String> registrarReposicionTarjeta(RequestReposicionTarjetaDeprecated request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
            } else {
                String response = TarjetaPresenteManager.getInstance().registrarReposicionTarjetaDeprecated(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
			logError("tarjetas/reposicionTarjeta", e.getMessage());
			return new BaseResponse<String>(
				e.getMessage(), 
				Utilities.ERROR_SERVICIO,
				ResponseConstantes.ERROR_VACIO,
				null);
        } 
	}
	
	@POST
	@Path("/tarjetaDatosAsosiado")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<ResponseDatosAsociadoTarjetaDeprecated> getDatosAsosiadoTarjeta(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()){
				return new BaseResponse<ResponseDatosAsociadoTarjetaDeprecated>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ResponseDatosAsociadoTarjetaDeprecated response = TarjetaPresenteManager.getInstance().obtenerDatosAsosiadoTarjetaDeprecated(request);
				return new BaseResponse<ResponseDatosAsociadoTarjetaDeprecated>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
					response);
			}
		} catch (Exception e) {
			logError("tarjetas/tarjetaDatosAsosiado", e.getMessage());
			return new BaseResponse<ResponseDatosAsociadoTarjetaDeprecated>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} 
	}
}