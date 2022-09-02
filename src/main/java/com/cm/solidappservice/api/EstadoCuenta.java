package com.cm.solidappservice.api;

import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.cm.solidappservice.manager.EstadoCuentaManager;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.estadocuenta.request.RequestMovimientosCuenta;
import com.cm.solidappservice.model.estadocuenta.response.ResponseConsultarCuentas;
import com.cm.solidappservice.model.estadocuenta.response.ResponseEstadoMisAportes;
import com.cm.solidappservice.model.estadocuenta.response.ResponseMovimientosCuenta;
import com.cm.solidappservice.utils.Utilities;

@Path("/estadoCuentas")
public class EstadoCuenta extends BaseService {

	private Utilities utilities;

    public EstadoCuenta(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Path("/consultarCuentas")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseConsultarCuentas>> obtenerCuentas(RequestAutenticacion request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
		try {
			crearLogApi(idLog, request.getCedula(), "/estadoCuenta/consultarCuentas", "EstadoCuenta", "POST", request);
        	ResponseValidacionParametros validacion = validateParameter(request);
        	if (!validacion.isValid()) {
				actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
				return new BaseResponse<List<ResponseConsultarCuentas>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			}else{
	        	List<ResponseConsultarCuentas> response = EstadoCuentaManager.getInstance().getCuentas(request.getCedula());
				actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
	    		return new BaseResponse<List<ResponseConsultarCuentas>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
        } catch (Exception e) {
        	logError("estadoCuentas/consultarCuentas", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<List<ResponseConsultarCuentas>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}


	@POST
	@Path("/consultarMovimientosCuenta")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseMovimientosCuenta> obtenerMovimientosCuenta(RequestMovimientosCuenta request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
        try {
			crearLogApi(idLog, request.getCedula(), "/estadoCuenta/consultarMovimientosCuenta", "EstadoCuenta", "POST", request);
        	ResponseValidacionParametros validacion = validateParameter(request);
        	if (!validacion.isValid()) {
				actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
				return new BaseResponse<ResponseMovimientosCuenta>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
	        	ResponseMovimientosCuenta response = EstadoCuentaManager.getInstance().getMovimientosCuenta(request);
				actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
	    		return new BaseResponse<ResponseMovimientosCuenta>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
        } catch (Exception e) {
			logError("estadoCuentas/consultarMovimientosCuenta", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<ResponseMovimientosCuenta>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}


	@GET
    @Path("/estadoMensajeMisAportes")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseEstadoMisAportes> obtenerEstadoMensajeMisAportes() {
        try {
            ResponseEstadoMisAportes response = EstadoCuentaManager.getInstance().getEstadoMensajeMisAportes();
            return new BaseResponse<ResponseEstadoMisAportes>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
        } catch (Exception e) {
			logError("estadoCuentas/estadoMensajeMisAportes", e.getMessage());
			return new BaseResponse<ResponseEstadoMisAportes>(
				e.getMessage(), 
				Utilities.ERROR_SERVICIO,
				ResponseConstantes.ERROR_VACIO,
				null);
        } 
    }
}