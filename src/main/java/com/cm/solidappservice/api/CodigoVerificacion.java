package com.cm.solidappservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.CodigoVerificacionManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.codigoverificacion.request.RequestEnviarCodigo;
import com.cm.solidappservice.model.codigoverificacion.request.RequestValidarCodigo;
import com.cm.solidappservice.model.codigoverificacion.response.ResponseCodigo;
import com.cm.solidappservice.model.codigoverificacion.response.ResponseValidarCodigo;
import com.cm.solidappservice.utils.Utilities;

@Path("/codigo")
public class CodigoVerificacion extends BaseService {

    private Utilities utilities;

    public CodigoVerificacion(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    @POST
    @Path("/enviarCodigo")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseCodigo> enviarCodigoVerificacion(RequestEnviarCodigo request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<ResponseCodigo>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            }else{
                ResponseCodigo response = CodigoVerificacionManager.getInstance().enviarCodigo(request);
                return new BaseResponse<ResponseCodigo>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
            }
        } catch (Exception e) {
            logError("codigo/enviarCodigo", e.getMessage());
            return new BaseResponse<ResponseCodigo>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }


    @POST
    @Path("/validarCodigo")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseValidarCodigo> validarCodigoVerificacion(RequestValidarCodigo request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<ResponseValidarCodigo>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            }else{
                ResponseValidarCodigo response = CodigoVerificacionManager.getInstance().validarCodigo(request);
                return new BaseResponse<ResponseValidarCodigo>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
            }
        } catch (Exception e) {
            logError("codigo/validarCodigo", e.getMessage());
            return new BaseResponse<ResponseValidarCodigo>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }
}
