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
import com.cm.solidappservice.model.obligaciones.bd.PagoObligacionMD;
import com.cm.solidappservice.model.obligaciones.request.RequestPagoObligacionDeprecated;
import com.cm.solidappservice.manager.ObligacionesManager;
import com.cm.solidappservice.utils.Utilities;

@Path("/abonos")
public class ObligacionesDeprecated extends BaseService {
	
	private Utilities utilities;

    public ObligacionesDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }
	
	@POST
	@Path("/crearPagoObligacion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> crearSolicitudPagoObligacion(RequestPagoObligacionDeprecated request) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
		try {
			crearLogApi(idLog, request.getCedula(), "/abonos/crearPagoObligacion", "PagoObligacion", "POST", request);
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
				return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				ObligacionesManager.getInstance().crearPagoObligacionDeprecated(request);
				actualizarLogApi(idLog, Utilities.SOLICITUD_CORRECTA, ResponseConstantes.RESULTADO_EXITOSO, "");
				return new BaseResponse<String>(
					ResponseConstantes.ERROR_VACIO,    
					ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    Utilities.SOLICITUD_CORRECTA);
			}
		} catch (Exception e) {
			logError("abonos/crearPagoObligacion", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
	@Path("/consultarPagoObligacion")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<PagoObligacionMD>> consultarTransferencia(RequestAutenticacion request) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
		try {
			crearLogApi(idLog, request.getCedula(), "/abonos/consultarPagoObligacion", "PagoObligacion", "POST", request);
			ResponseValidacionParametros validacion = validateParameter(request);
			if (!validacion.isValid()) {
				actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
				return new BaseResponse<List<PagoObligacionMD>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
			} else {
				List<PagoObligacionMD> response = ObligacionesManager.getInstance().getPagoObligacionDeprecated(request);
				actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
				return new BaseResponse<List<PagoObligacionMD>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
			}
		} catch (Exception e) {
			logError("abonos/consultarPagoObligacion", e.getMessage());
			actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<List<PagoObligacionMD>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
}