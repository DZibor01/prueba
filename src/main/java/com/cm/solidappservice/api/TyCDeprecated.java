package com.cm.solidappservice.api;

import com.cm.solidappservice.manager.TyCManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.tyc.request.RequestTyCDeprecated;
import com.cm.solidappservice.model.tyc.response.ResponseTyCAceptadosDeprecated;
import com.cm.solidappservice.model.tyc.response.ResponseTyCDeprecated;
import com.cm.solidappservice.utils.Utilities;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/TerminosyCondiciones")
public class TyCDeprecated extends BaseService {
  
    private Utilities utilities;

    public TyCDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    @POST
    @Path("/insertarTerminosAceptados")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> insertarTerminosAceptados(RequestTyCDeprecated request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
            } else {
                String response = TyCManager.getInstance().registrarTyCAceptadosDeprecated(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("TerminosyCondiciones/insertarTerminosAceptados", e.getMessage());
            return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }
  
    @POST
    @Path("/obtenerTerminosAceptados")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseTyCAceptadosDeprecated>> obtenerTerminosAceptados(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<List<ResponseTyCAceptadosDeprecated>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);  
            } else {
                List<ResponseTyCAceptadosDeprecated> response = TyCManager.getInstance().obtenerTerminosAceptadosDeprecated(request);
                return new BaseResponse<List<ResponseTyCAceptadosDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("TerminosyCondiciones/obtenerTerminosAceptados", e.getMessage());
            return new BaseResponse<List<ResponseTyCAceptadosDeprecated>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }
  
    @GET
    @Path("/obtenerTerminos")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseTyCDeprecated>> getTerminosyCondiciones() {
        try {
            List<ResponseTyCDeprecated> response = TyCManager.getInstance().obtenerTerminosDeprecated();
            return new BaseResponse<List<ResponseTyCDeprecated>>(
                ResponseConstantes.ERROR_VACIO,
                ResponseConstantes.ERROR_VACIO,
                ResponseConstantes.ERROR_VACIO,
                response);
        } catch (Exception e) {
            logError("TerminosyCondiciones/obtenerTerminos", e.getMessage());
            return new BaseResponse<List<ResponseTyCDeprecated>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }
  
}