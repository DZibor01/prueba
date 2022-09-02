package com.cm.solidappservice.api;

import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.estadocuenta.request.*;
import com.cm.solidappservice.model.estadocuenta.response.*;
import com.cm.solidappservice.manager.EstadoCuentaManager;
import com.cm.solidappservice.utils.Utilities;

@Path("/estadoCuenta")
public class EstadoCuentaDeprecated extends BaseService {

	private Utilities utilities;

    public EstadoCuentaDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Path("/consultarCuentas")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseConsultarCuentasDeprecated>> getCuentas(RequestAutenticacion request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
		try {
			crearLogApi(idLog, request.getCedula(), "/estadoCuenta/consultarCuentas", "EstadoCuenta", "POST", request);
        	ResponseValidacionParametros validacion = validateParameter(request);
        	if (!validacion.isValid()) {
				actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
				return new BaseResponse<List<ResponseConsultarCuentasDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			}else{
	        	List<ResponseConsultarCuentasDeprecated> response = EstadoCuentaManager.getInstance().getCuentasDeprecated(request);
				actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
	    		return new BaseResponse<List<ResponseConsultarCuentasDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
        } catch (Exception e) {
        	logError("estadoCuenta/consultarCuentas", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<List<ResponseConsultarCuentasDeprecated>>(
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
    public BaseResponse<List<ResponseMovimientoCuentaDeprecated>> getMovimientosCuenta(RequestMovimientosCuentasDeprecated request) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
        try {
			crearLogApi(idLog, request.getCedula(), "/estadoCuenta/consultarMovimientosCuenta", "EstadoCuenta", "POST", request);
        	ResponseValidacionParametros validacion = validateParameter(request);
        	if (!validacion.isValid()) {
				actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
				return new BaseResponse<List<ResponseMovimientoCuentaDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
	        	List<ResponseMovimientoCuentaDeprecated> response = EstadoCuentaManager.getInstance().getMovimientosCuentaDeprecated(request);
				actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
	    		return new BaseResponse<List<ResponseMovimientoCuentaDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
        } catch (Exception e) {
			logError("estadoCuenta/consultarMovimientosCuenta", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<List<ResponseMovimientoCuentaDeprecated>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@GET
    @Path("/estadoMensajeMisAportes")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseEstadoMisAportesDeprecated> obtenerEstadoMensajeMisAportes() {
        try {
            ResponseEstadoMisAportesDeprecated response = EstadoCuentaManager.getInstance().getEstadoMensajeMisAportesDeprecated();
            return new BaseResponse<ResponseEstadoMisAportesDeprecated>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
        } catch (Exception e) {
			logError("estadoCuenta/estadoMensajeMisAportes", e.getMessage());
			return new BaseResponse<ResponseEstadoMisAportesDeprecated>(
				e.getMessage(), 
				Utilities.ERROR_SERVICIO,
				ResponseConstantes.ERROR_VACIO,
				null);
        } 
    }


	// @POST
	// @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    // public ResponseRespuestaServicio<List<ResponseConsultarCuentas>> getEstadoCuenta(RequestAutenticacion request) {
	// 	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	// 	String idLog = String.valueOf(timestamp.getTime());
    //     try {
	// 		crearLogApi(idLog, request.getCedula(), "/estadoCuenta/", "EstadoCuenta", "POST", request);
    //     	ResponseValidacionParametros validacion = validateParameter(request);
    //     	if (!validacion.isValid()) {
	// 			actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
	//     		return new ResponseRespuestaServicio<List<ResponseConsultarCuentas>>(
	// 				validacion.getErrorToken(), validacion.getErrorParametros(), null);
	// 		}else{
	//         	List<ResponseConsultarCuentas> response = Manager.getInstance().getEstadoCuenta(request.getCedula());
	// 			actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
	//     		return new ResponseRespuestaServicio<List<ResponseConsultarCuentas>>(
	// 				ResponseConstantes.ERROR_VACIO, ResponseConstantes.ERROR_VACIO, response);
	// 		}
    //     } catch (Exception e) {
	// 		actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
    //     	logError(e.getMessage());
	// 		return new ResponseRespuestaServicio<List<ResponseConsultarCuentas>>(
    //                 e.getMessage(), 
    //                 Utilities.ERROR_SERVICIO,
    //                 ResponseConstantes.ERROR_VACIO,
    //                 null);
	// 	}
	// }
}