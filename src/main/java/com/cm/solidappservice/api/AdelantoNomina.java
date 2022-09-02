package com.cm.solidappservice.api;

import com.cm.solidappservice.manager.AdelantoNominaManager;
import com.cm.solidappservice.model.adelantonomina.request.RequestProcesarSolicitudAdelanto;
import com.cm.solidappservice.model.adelantonomina.request.RequestRegistroLogs;
import com.cm.solidappservice.model.adelantonomina.request.RequestSolicitarAdelanto;
import com.cm.solidappservice.model.adelantonomina.response.ResponseEstadoAdelanto;
import com.cm.solidappservice.model.adelantonomina.response.ResponseMovimientosAdelanto;
import com.cm.solidappservice.model.adelantonomina.response.ResponseProcesarSolicitudAdelanto;
import com.cm.solidappservice.model.adelantonomina.response.ResponseSolicitarAdelanto;
import com.cm.solidappservice.model.adelantonomina.response.ResponseTips;
import com.cm.solidappservice.model.adelantonomina.response.ResponseTopes;
import com.cm.solidappservice.model.adelantonomina.response.ResponseValidarRequisitos;
import com.cm.solidappservice.model.adelantonomina.response.ResponseValorComision;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.utils.Utilities;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/adelantoNomina")
public class AdelantoNomina extends BaseService {
  
    private Utilities utilities;

    public AdelantoNomina(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    @POST
    @Path("/validarRequisitos")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseValidarRequisitos> validarRequisitos(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<ResponseValidarRequisitos>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            }else{
                ResponseValidarRequisitos response = AdelantoNominaManager.getInstance().validarRequisitos(request);
                return new BaseResponse<ResponseValidarRequisitos>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
            }
        } catch (Exception e) {
            logError("adelantoNomina/validarRequisitos", e.getMessage());
            registroLogsAdelantoNomina(
                new RequestRegistroLogs(
                    "Validando requisitos",
                    "Error al validar los requisitos: " + e.getMessage()
                )
            );
            return new BaseResponse<ResponseValidarRequisitos>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }
  
  
    @GET
    @Path("/obtenerValorComision")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseValorComision> obtenerValorComision() {
        try {
            ResponseValorComision response = AdelantoNominaManager.getInstance().obtenerValorComision();
            return new BaseResponse<ResponseValorComision>(
                ResponseConstantes.ERROR_VACIO,
                ResponseConstantes.ERROR_VACIO,
                ResponseConstantes.ERROR_VACIO,
                response);
        } catch (Exception e) {
            logError("adelantoNomina/obtenerValorComision", e.getMessage());
            return new BaseResponse<ResponseValorComision>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        }
    }

  
    @POST
    @Path("/obtenerTopes")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseTopes> obtenerTopes(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<ResponseTopes>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                ResponseTopes response = AdelantoNominaManager.getInstance().obtenerTopes(request);
                return new BaseResponse<ResponseTopes>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("adelantoNomina/obtenerTopes", e.getMessage());
            registroLogsAdelantoNomina(
                new RequestRegistroLogs(
                    "Obteniendo Topes",
                    "Error obteniendo topes: " + e.getMessage()
                )
            );
            return new BaseResponse<ResponseTopes>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        }
    }
  

    @POST
    @Path("/solicitarAdelanto")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseSolicitarAdelanto> solicitarAdelanto(RequestSolicitarAdelanto request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<ResponseSolicitarAdelanto>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                ResponseSolicitarAdelanto response = AdelantoNominaManager.getInstance().solicitarAdelanto(request);
                return new BaseResponse<ResponseSolicitarAdelanto>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("adelantoNomina/solicitarAdelanto", e.getMessage());
            registroLogsAdelantoNomina(
                new RequestRegistroLogs(
                    "Solicitando Adelanto",
                    "Error solicitando adelanto: " + e.getMessage()
                )
            );
            return new BaseResponse<ResponseSolicitarAdelanto>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }


    @POST
    @Path("/procesarSolicitudAdelanto")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseProcesarSolicitudAdelanto> procesarSolicitudAdelanto(RequestProcesarSolicitudAdelanto request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<ResponseProcesarSolicitudAdelanto>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                ResponseProcesarSolicitudAdelanto response = AdelantoNominaManager.getInstance().procesarSolicitudAdelanto(request);
                return new BaseResponse<ResponseProcesarSolicitudAdelanto>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("adelantoNomina/procesarSolicitudAdelanto", e.getMessage());
            registroLogsAdelantoNomina(
                new RequestRegistroLogs(
                    "Procesar Solicitud Adelanto",
                    "Error procesando solicitud: " + e.getMessage()
                )
            );
            return new BaseResponse<ResponseProcesarSolicitudAdelanto>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }
  
     
    
    @POST
    @Path("/obtenerMovimientos")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseMovimientosAdelanto>> getMovimientos(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<List<ResponseMovimientosAdelanto>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null);  
            } else {
                List<ResponseMovimientosAdelanto> response = AdelantoNominaManager.getInstance().obtenerMovimientosAdelanto(request);
                return new BaseResponse<List<ResponseMovimientosAdelanto>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("adelantoNomina/obtenerMovimientos", e.getMessage());
            registroLogsAdelantoNomina(
                new RequestRegistroLogs(
                    "Obteniendo Movimientos",
                    "Error obteniendo movimientos: " + e.getMessage()
                )
            );
            return new BaseResponse<List<ResponseMovimientosAdelanto>>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        }
    }
  

    @GET
    @Path("/obtenerTips")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseTips>> getTips() {
        try {
            List<ResponseTips> response = AdelantoNominaManager.getInstance().obtenerTipsFinancieros();
            return new BaseResponse<List<ResponseTips>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
        } catch (Exception e) {
            logError("adelantoNomina/obtenerTips", e.getMessage());
            return new BaseResponse<List<ResponseTips>>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }
  

    @GET
    @Path("/estadoAdelantoNomina")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseEstadoAdelanto> obtenerEstadoAN() {
        try {
            ResponseEstadoAdelanto response = AdelantoNominaManager.getInstance().getEstadoAdelantoNomina();
            return new BaseResponse<ResponseEstadoAdelanto>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
        } catch (Exception e) {
            logError("adelantoNomina/estadoAdelantoNomina", e.getMessage());
            return new BaseResponse<ResponseEstadoAdelanto>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        }
    }

    
    // @GET
    // @Path("/dependenciasActivas")
	// @Produces(MediaType.APPLICATION_JSON)
    // public ResponseRespuestaServicio<ParametroAppMD> obtenerDependenciasActivas() {
    //     try {
    //         ParametroAppMD resp = Manager.getInstance().getDependenciasActivasAN();
    //         return new ResponseRespuestaServicio<ParametroAppMD>(ResponseConstantes.ERROR_VACIO, ResponseConstantes.ERROR_VACIO, resp);
    //     } catch (Exception e) {
    //         return new ResponseRespuestaServicio<ParametroAppMD>(e.getMessage(), Utilities.ERROR_SERVICIO, null);
    //     } 
    // }


    @POST
    @Path("/logsAdelantoNomina")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> registroLogsAdelantoNomina(RequestRegistroLogs request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                String response = AdelantoNominaManager.getInstance().registroLogsAdelantoNomina(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            return new BaseResponse<String>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        }
    }


}