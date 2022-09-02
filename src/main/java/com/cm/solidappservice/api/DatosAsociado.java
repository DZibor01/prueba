package com.cm.solidappservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.DatosAsociadoManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.datosasociado.request.*;
import com.cm.solidappservice.model.datosasociado.response.*;
import com.cm.solidappservice.utils.Utilities;

@Path("/datosAsociado")
public class DatosAsociado extends BaseService{

    private Utilities utilities;

    public DatosAsociado(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    @POST
    @Path("/consultarDatos")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseConsultarDatosAsociado> consultarDatosAsociado(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<ResponseConsultarDatosAsociado>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
            }else{
                ResponseConsultarDatosAsociado response = DatosAsociadoManager.getInstance().consultarDatosAsociado(request);
                return new BaseResponse<ResponseConsultarDatosAsociado>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
        	logError("datosAsociado/consultarDatos", e.getMessage());
            return new BaseResponse<ResponseConsultarDatosAsociado>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }

    @POST
    @Path("/actualizarDatos")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> actualizarDatosAsociado(RequestActualizarDatos request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            }else{
                String response = DatosAsociadoManager.getInstance().actualizarDatosAsociado(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("datosAsociado/actualizarDatos", e.getMessage());
            return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }

    @GET
    @Path("/formatoDirecciones")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseFormatoDirecciones> obtenerFormatoDirecciones() {
        try {
            ResponseFormatoDirecciones response = DatosAsociadoManager.getInstance().obtenerFormatoDirecciones();
            return new BaseResponse<ResponseFormatoDirecciones>(
                ResponseConstantes.ERROR_VACIO,
                ResponseConstantes.ERROR_VACIO,
                ResponseConstantes.ERROR_VACIO,
                response);
        } catch (Exception e) {
            logError("datosAsociado/formatoDirecciones", e.getMessage());
            return new BaseResponse<ResponseFormatoDirecciones>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }
    
    @POST
    @Path("/consultarDatosBasicos")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseDatosBasicosAsociado> obtenerDatosBasicosAsociado(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<ResponseDatosBasicosAsociado>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            } else {
                ResponseDatosBasicosAsociado response = DatosAsociadoManager.getInstance().obtenerDatosBasicosAsociado(request);
                return new BaseResponse<ResponseDatosBasicosAsociado>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("datosAsociado/consultarDatosBasicos", e.getMessage());
            return new BaseResponse<ResponseDatosBasicosAsociado>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
	}



}
