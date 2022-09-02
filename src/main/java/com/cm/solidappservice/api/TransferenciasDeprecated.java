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
import com.cm.solidappservice.model.transferencias.request.RequestSolicitudInscripcionCuenta;
import com.cm.solidappservice.model.transferencias.request.RequestTransferenciaDeprecated;
import com.cm.solidappservice.model.transferencias.response.ResponseBanco;
import com.cm.solidappservice.model.transferencias.response.ResponseCuentaDisponibleDeprecated;
import com.cm.solidappservice.model.transferencias.response.ResponseCuentaInscritaDeprecated;
import com.cm.solidappservice.model.transferencias.response.ResponseTransferenciasIncompletasDeprecated;
import com.cm.solidappservice.utils.Utilities;

@Path("/transferencias")
public class TransferenciasDeprecated extends BaseService {
	
	private Utilities utilities;

    public TransferenciasDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Path("/cuentasInscritas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseCuentaInscritaDeprecated>> getCuentasInscritas(RequestAutenticacion request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<List<ResponseCuentaInscritaDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				List<ResponseCuentaInscritaDeprecated> response = TransferenciasManager.getInstance().obtenerCuentasInscritasDeprecated(request.getCedula());
				return new BaseResponse<List<ResponseCuentaInscritaDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("transferencias/cuentasInscritas", e.getMessage());
			return new BaseResponse<List<ResponseCuentaInscritaDeprecated>>(
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
	public BaseResponse<List<ResponseCuentaDisponibleDeprecated>> getCuentasDisponibles(RequestCuentasDisponiblesDeprecated request) {
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<List<ResponseCuentaDisponibleDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				List<ResponseCuentaDisponibleDeprecated> response = TransferenciasManager.getInstance()
						.obtenerCuentasDisponiblesDeprecated(request.getCedulaConsulta());
				return new BaseResponse<List<ResponseCuentaDisponibleDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("transferencias/cuentasDisponibles", e.getMessage());
			return new BaseResponse<List<ResponseCuentaDisponibleDeprecated>>(
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
			logError("transferencias/bancos", e.getMessage());
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
			logError("transferencias/solicitarInscribirCuenta", e.getMessage());
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
	public BaseResponse<String> realizarTransferencia(RequestTransferenciaDeprecated request) {
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
				String response = TransferenciasManager.getInstance().realizarTransferenciaDeprecated(request);
				actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
				return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("transferencias/realizarTransferencia", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	
	@POST
	@Path("/consultarTransferencias")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseTransferenciasIncompletasDeprecated>> consultarTransferencia(RequestAutenticacion request) {		
		try {
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				return new BaseResponse<List<ResponseTransferenciasIncompletasDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
			} else {
				List<ResponseTransferenciasIncompletasDeprecated> response = TransferenciasManager.getInstance()
						.consultarTransferenciasIncompletasDeprecated(request);
				return new BaseResponse<List<ResponseTransferenciasIncompletasDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("transferencias/consultarTransferencias", e.getMessage());
			return new BaseResponse<List<ResponseTransferenciasIncompletasDeprecated>>(
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
			logError("transferencias/eliminarCuenta", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
}