package com.cm.solidappservice.api;

import com.cm.solidappservice.manager.VotacionesManager;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.votaciones.request.RequestRegistrarVoto;
import com.cm.solidappservice.model.votaciones.response.ResponseCandidato;
import com.cm.solidappservice.utils.Utilities;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/votaciones")
public class Votaciones extends BaseService {
  
    private Utilities utilities;

    public Votaciones(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    @POST
    @Path("/obtenerCandidatos")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseCandidato>> obtenerCandidatos(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<List<ResponseCandidato>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            }else{
                List<ResponseCandidato> response = VotacionesManager.getInstance().obtenerCandidatosZona(request);
                return new BaseResponse<List<ResponseCandidato>>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
            }
        } catch (Exception e) {
            logError("votaciones/obtenerCandidatos", e.getMessage());
            return new BaseResponse<List<ResponseCandidato>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }

    @POST
    @Path("/registrarVoto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> registrarVoto(RequestRegistrarVoto request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            }else {
                String response = VotacionesManager.getInstance().registrarVoto(request);
                return new BaseResponse<String>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
            }
        } catch (Exception e) {
            logError("portalServiciosDigitales/bannerLogin", e.getMessage());
            return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }

}