package com.cm.solidappservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.DispositivoManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.dispositivo.request.RequestDispositivo;
import com.cm.solidappservice.model.dispositivo.response.ResponseRegistrarDispositivo;
import com.cm.solidappservice.model.dispositivo.response.ResponseValidarDispositivoRegistrado;
import com.cm.solidappservice.utils.Utilities;

@Path("/dispositivo")
public class Dispositivo extends BaseService {
  
    private Utilities utilities;

    public Dispositivo(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    @POST
    @Path("/validarDispositivo")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseValidarDispositivoRegistrado> validarDispositivoRegistrado(RequestDispositivo request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_DISPOSITIVO_VALIDARDISPOSITIVO);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<ResponseValidarDispositivoRegistrado>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
            }else{
                ResponseValidarDispositivoRegistrado response = DispositivoManager.getInstance().validarDispositivoRegistrado(request);
                return new BaseResponse<ResponseValidarDispositivoRegistrado>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("dispositivo/validarDispositivo", e.getMessage());
            return new BaseResponse<ResponseValidarDispositivoRegistrado>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }

    @POST
    @Path("/registrarDispositivo")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseRegistrarDispositivo> registrarNuevoDispositivo(RequestDispositivo request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_DISPOSITIVO_REGISTRARDISPOSITIVO);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<ResponseRegistrarDispositivo>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
            }else{
                ResponseRegistrarDispositivo response = DispositivoManager.getInstance().registrarDispositivo(request);
                return new BaseResponse<ResponseRegistrarDispositivo>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("dispositivo/registrarDispositivo", e.getMessage());
            return new BaseResponse<ResponseRegistrarDispositivo>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }
}
