package com.cm.solidappservice.api;

import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.TransferenciasManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.transferencias.request.RequestCuentasDisponiblesDeprecated;
import com.cm.solidappservice.model.transferencias.request.RequestEliminacionCuenta;
import com.cm.solidappservice.model.transferencias.request.RequestRealizarTransferencia;
import com.cm.solidappservice.model.transferencias.request.RequestSolicitudInscripcionCuenta;
import com.cm.solidappservice.model.transferencias.response.ResponseBanco;
import com.cm.solidappservice.model.transferencias.response.ResponseCuentasDisponibles;
import com.cm.solidappservice.model.transferencias.response.ResponseCuentasInscritas;
import com.cm.solidappservice.model.transferencias.response.ResponseTransferenciasIncompletas;
import com.cm.solidappservice.utils.Utilities;

@Path("/transferencia")
public class Transferencias extends BaseService {
	
	private Utilities utilities;

    public Transferencias(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Path("/cuentasInscritas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<ResponseCuentasInscritas> getCuentasInscritas(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<ResponseCuentasInscritas>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				ResponseCuentasInscritas response = TransferenciasManager.getInstance().obtenerCuentasInscritas(request.getCedula());
				return new BaseResponse<ResponseCuentasInscritas>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("transferencia/cuentasInscritas", e.getMessage());
			return new BaseResponse<ResponseCuentasInscritas>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
	@Path("/cuentasDisponibles")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseCuentasDisponibles>> getCuentasDisponibles(RequestCuentasDisponiblesDeprecated request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<List<ResponseCuentasDisponibles>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				List<ResponseCuentasDisponibles> response = TransferenciasManager.getInstance().obtenerCuentasDisponibles(request.getCedulaConsulta());
				return new BaseResponse<List<ResponseCuentasDisponibles>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("transferencia/cuentasDisponibles", e.getMessage());
			return new BaseResponse<List<ResponseCuentasDisponibles>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	
	
	@GET
	@Path("/bancos")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseBanco>> getBancos() {
		try {
			List<ResponseBanco> response = TransferenciasManager.getInstance().getListadoBancos();
			return new BaseResponse<List<ResponseBanco>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("transferencia/bancos", e.getMessage());
			return new BaseResponse<List<ResponseBanco>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
		
	@POST
	@Path("/solicitarInscribirCuenta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> solicitarInscribirCuenta(RequestSolicitudInscripcionCuenta request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				String response = TransferenciasManager.getInstance().solicitarInscribirCuenta(request);
				return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("transferencia/solicitarInscribirCuenta", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	
	@POST
	@Path("/realizarTransferencia")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> realizarTransferencia(RequestRealizarTransferencia request) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
		try {
			crearLogApi(idLog, request.getCedula(), "/transferencias/realizarTransferencia", "Transferencias", "POST", request);
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
				return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				String response = TransferenciasManager.getInstance().realizarTransferencia(request);
				actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
				return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("transferencia/realizarTransferencia", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	
	@POST
	@Path("/consultarTransferenciasIncompletas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseTransferenciasIncompletas>> consultarTransferencia(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<List<ResponseTransferenciasIncompletas>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				List<ResponseTransferenciasIncompletas> response = TransferenciasManager.getInstance()
						.consultarTransferenciasIncompletas(request);
				return new BaseResponse<List<ResponseTransferenciasIncompletas>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("transferencia/consultarTransferenciasIncompletas", e.getMessage());
			return new BaseResponse<List<ResponseTransferenciasIncompletas>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
	@Path("/eliminarCuenta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> eliminarCuenta(RequestEliminacionCuenta request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				String response = TransferenciasManager.getInstance().eliminarCuenta(request);
				return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("transferencia/eliminarCuenta", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
}