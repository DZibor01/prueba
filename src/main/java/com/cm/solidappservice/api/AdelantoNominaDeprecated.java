package com.cm.solidappservice.api;

import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.AdelantoNominaManager;
import com.cm.solidappservice.model.adelantonomina.request.*;
import com.cm.solidappservice.model.adelantonomina.response.*;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.security.Encripcion;
import com.cm.solidappservice.utils.Utilities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/AdelantoDeNomina")
public class AdelantoNominaDeprecated extends BaseService {
  
    private Utilities utilities;

    public AdelantoNominaDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    @POST
    @Path("/validarRequisitos")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseValidarRequisitosDeprecated> validarRequisitos(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_ADELANTODENOMINA_VALIDARREQUISITOS);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<ResponseValidarRequisitosDeprecated>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            }else{
                ResponseValidarRequisitosDeprecated response = AdelantoNominaManager.getInstance().validarRequisitosDeprecated(request);
                return new BaseResponse<ResponseValidarRequisitosDeprecated>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
            }
        } catch (Exception e) {
            logError("AdelantoDeNomina/validarRequisitos", e.getMessage());
            registrarLogsAdelantoNomina(new RequestRegistroLogsDeprecated(
                Encripcion.getInstance().encriptar(request.getCedula()),
                request.getToken(),
                new Date().toString(),
                "ValidarRequisitos",
                "Error al validar los requisitos " + e.getMessage()
            ));
            return new BaseResponse<ResponseValidarRequisitosDeprecated>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }
  
    @POST
    @Path("/obtenerNoCumple")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseMotivosNoCumple>> obtenerNoCumple(RequestMotivosNoCumple request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_ADELANTODENOMINA_OBTENERNOCUMPLE);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<List<ResponseMotivosNoCumple>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                List<ResponseMotivosNoCumple> response = AdelantoNominaManager.getInstance().obtenerMotivosNoCumpleDeprecated(request);
                return new BaseResponse<List<ResponseMotivosNoCumple>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO, 
                    ResponseConstantes.ERROR_VACIO, 
                    response);
            }
        } catch (Exception e) {
            logError("AdelantoDeNomina/obtenerNoCumple", e.getMessage());
            registrarLogsAdelantoNomina(new RequestRegistroLogsDeprecated(
                Encripcion.getInstance().encriptar(request.getCedula()),
                request.getToken(),
                new Date().toString(),
                "obtenerNoCumple",
                "Error al obtener el motivo por el que no cumple los requisitos" + e.getMessage()
            ));
            return new BaseResponse<List<ResponseMotivosNoCumple>>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO, 
                null);
        }
    }
  
    @GET
    @Path("/obtenerValorComision")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseValorComisionDeprecated> obtenerValorComision() {
        try {
            ResponseValorComisionDeprecated response = AdelantoNominaManager.getInstance().obtenerValorComisionDeprecatend();
            return new BaseResponse<ResponseValorComisionDeprecated>(
                ResponseConstantes.ERROR_VACIO,
                ResponseConstantes.ERROR_VACIO,
                ResponseConstantes.ERROR_VACIO,
                response);
        } catch (Exception e) {
            logError("AdelantoDeNomina/obtenerValorComision", e.getMessage());
            return new BaseResponse<ResponseValorComisionDeprecated>(
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
    public BaseResponse<ResponseTopesDeprecated> obtenerTopes(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_ADELANTODENOMINA_OBTENERTOPES);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<ResponseTopesDeprecated>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                ResponseTopesDeprecated response = AdelantoNominaManager.getInstance().obtenerTopesDeprecated(request);
                return new BaseResponse<ResponseTopesDeprecated>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("AdelantoDeNomina/obtenerTopes", e.getMessage());
            registrarLogsAdelantoNomina(new RequestRegistroLogsDeprecated(
                Encripcion.getInstance().encriptar(request.getCedula()),
                request.getToken(),
                new Date().toString(),
                "obtenerTopes",
                "Error al obtener valor my min. " + e.getMessage()
            ));
            return new BaseResponse<ResponseTopesDeprecated>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        }
    }
  
    @POST
    @Path("/adelantar")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseSolicitarAdelantoDeprecated> solicitarAdelantoNomina(RequestSolicitarAdelantoDeprecated request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_ADELANTODENOMINA_ADELANTAR);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<ResponseSolicitarAdelantoDeprecated>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                ResponseSolicitarAdelantoDeprecated response = AdelantoNominaManager.getInstance().solicitarAdelantoNominaDeprecated(request);
                return new BaseResponse<ResponseSolicitarAdelantoDeprecated>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("AdelantoDeNomina/adelantar", e.getMessage());
            registrarLogsAdelantoNomina(new RequestRegistroLogsDeprecated(
                Encripcion.getInstance().encriptar(request.getCedula()),
                request.getToken(),
                new Date().toString(),
                "Adelantar",
                "Error al ingresar el adelanto " + e.getMessage()
            ));
            return new BaseResponse<ResponseSolicitarAdelantoDeprecated>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }
  
    @POST
    @Path("/adelantarConsulta")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseProcesarSolicitudAdelantoDeprecated> procesarAdelantoNomina(RequestProcesarSolicitudAdelantoDeprecated request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_ADELANTODENOMINA_ADELANTARCONSULTA);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<ResponseProcesarSolicitudAdelantoDeprecated>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                ResponseProcesarSolicitudAdelantoDeprecated response = AdelantoNominaManager.getInstance().procesarSolicitudAdelantoDeprecated(request);
                return new BaseResponse<ResponseProcesarSolicitudAdelantoDeprecated>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("AdelantoDeNomina/adelantarConsulta", e.getMessage());
            registrarLogsAdelantoNomina(new RequestRegistroLogsDeprecated(
                Encripcion.getInstance().encriptar(request.getCedula()),
                request.getToken(),
                new Date().toString(),
                "adelantarConsultaSolicitud",
                "Error al consultar la solicitud de adelanto " + e.getMessage()
            ));
            return new BaseResponse<ResponseProcesarSolicitudAdelantoDeprecated>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }
  
    @POST
    @Path("/insertarAdelanto")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> registrarAdelantoNomina(RequestAdelantoNomina request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
        try {
            crearLogApi(idLog, request.getCedula(), "/AdelantoDeNomina/insertarAdelanto", "AdelantoDeNomina", "POST", request);
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_ADELANTODENOMINA_INSERTARADELANTO);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                String response = AdelantoNominaManager.getInstance().registrarAdelantoNomina(request);
                actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("AdelantoDeNomina/insertarAdelanto", e.getMessage());
            actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
            registrarLogsAdelantoNomina(new RequestRegistroLogsDeprecated(
                Encripcion.getInstance().encriptar(request.getCedula()),
                request.getToken(),
                new Date().toString(),
                "insertarAdelanto",
                "Error al insertar el adelanto de n" + e.getMessage()
            ));
            return new BaseResponse<String>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }
  
    @POST
    @Path("/actualizarAdelanto")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> actualizarAdelantoNomina(RequestActualizarAdelantoNomina request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_ADELANTODENOMINA_ACTUALIZARADELANTO);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                String response = AdelantoNominaManager.getInstance().actualizarAdelantoNominaDeprecated(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("AdelantoDeNomina/actualizarAdelanto", e.getMessage());
            registrarLogsAdelantoNomina(new RequestRegistroLogsDeprecated(
                Encripcion.getInstance().encriptar(request.getCedula()),
                request.getToken(),
                new Date().toString(),
                "actualizarAdelanto",
                "Error al actualizar la consulta del adelanto" + e.getMessage()
            ));
            return new BaseResponse<String>(
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
    public BaseResponse<List<ResponseMovimientosAdelantoDeprecated>> obtenerMovimientosAdelantoNomina(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_ADELANTODENOMINA_OBTENERMOVIMIENTOS);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<List<ResponseMovimientosAdelantoDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null);  
            } else {
                List<ResponseMovimientosAdelantoDeprecated> response = AdelantoNominaManager.getInstance().obtenerMovimientosAdelantoDeprecated(request);
                return new BaseResponse<List<ResponseMovimientosAdelantoDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("AdelantoDeNomina/obtenerMovimientos", e.getMessage());
            registrarLogsAdelantoNomina(new RequestRegistroLogsDeprecated(
                Encripcion.getInstance().encriptar(request.getCedula()),
                request.getToken(),
                new Date().toString(),
                "obtenerMovimientos",
                "Error al obtener los movimientos " + e.getMessage()
            ));
            return new BaseResponse<List<ResponseMovimientosAdelantoDeprecated>>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }
  
    @GET
    @Path("/obtenerTips")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseTipsDeprecated>> obtenerTipsFinancieros() {
        try {
            List<ResponseTipsDeprecated> response = AdelantoNominaManager.getInstance().obtenerTipsFinancierosDeprecated();
            return new BaseResponse<List<ResponseTipsDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
        } catch (Exception e) {
            logError("AdelantoDeNomina/obtenerTips", e.getMessage());
            return new BaseResponse<List<ResponseTipsDeprecated>>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }
  
    @POST
    @Path("/registroAdelantoNomina")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> registrarLogsAdelantoNomina(RequestRegistroLogsDeprecated request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_ADELANTODENOMINA_REGISTROADELANTONOMINA);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(),
                    null); 
            } else {
                String response = AdelantoNominaManager.getInstance().registroLogsAdelantoNominaDeprecated(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("AdelantoDeNomina/registroAdelantoNomina", e.getMessage());
            return new BaseResponse<String>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }
  
    @GET
    @Path("/estadoAdelantoNomina")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseEstadoAdelantoDeprecated> obtenerEstadoAN() {
        try {
            ResponseEstadoAdelantoDeprecated response = AdelantoNominaManager.getInstance().getEstadoAdelantoNominaDeprecated();
            return new BaseResponse<ResponseEstadoAdelantoDeprecated>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
        } catch (Exception e) {
            logError("AdelantoDeNomina/estadoAdelantoNomina", e.getMessage());
            return new BaseResponse<ResponseEstadoAdelantoDeprecated>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }

    
    @GET
    @Path("/dependenciasActivas")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseDependenciasAdelantoNomina> obtenerDependenciasActivas() {
        try {
            ResponseDependenciasAdelantoNomina response = AdelantoNominaManager.getInstance().getDependenciasActivasDeprecated();
            return new BaseResponse<ResponseDependenciasAdelantoNomina>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
        } catch (Exception e) {
            logError("AdelantoDeNomina/dependenciasActivas", e.getMessage());
            return new BaseResponse<ResponseDependenciasAdelantoNomina>(
                e.getMessage(),
                Utilities.ERROR_SERVICIO, 
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
    }

}