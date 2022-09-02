package com.cm.solidappservice.api;

import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.TyCManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.tyc.request.RequestTyC;
import com.cm.solidappservice.model.tyc.response.ResponseTyC;
import com.cm.solidappservice.utils.Utilities;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tyc")
public class TyC extends BaseService {
  
    private Utilities utilities;

    public TyC(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    @POST
    @Path("/registrarTerminosAceptados")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> insertarTerminosAceptados(RequestTyC request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_TYC_REGISTRARTERMINOSACEPTADOS);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
            } else {
                String response = TyCManager.getInstance().registrarTyCAceptados(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("tyc/registrarTerminosAceptados", e.getMessage());
            return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }
  
    @GET
    @Path("/obtenerTyC")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseTyC>> getTerminosyCondiciones() {
        try {
            List<ResponseTyC> response = TyCManager.getInstance().obtenerTerminos();
            return new BaseResponse<List<ResponseTyC>>(
                ResponseConstantes.ERROR_VACIO,
                ResponseConstantes.ERROR_VACIO,
                ResponseConstantes.ERROR_VACIO,
                response);
        } catch (Exception e) {
            logError("tyc/obtenerTyC", e.getMessage());
            return new BaseResponse<List<ResponseTyC>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }
  
}