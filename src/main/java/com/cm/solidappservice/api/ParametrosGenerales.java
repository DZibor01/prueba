package com.cm.solidappservice.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.ParametrosGeneralesManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.parametrosgenerales.response.ResponseParametrosGenerales;
import com.cm.solidappservice.utils.Utilities;

@Path("/parametrosApp")
public class ParametrosGenerales extends BaseService {
	
    private Utilities utilities;

    public ParametrosGenerales(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@GET
    @Path("/obtenerParametro/{idParametro}")
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseParametrosGenerales> obtenerParametrosGenerales(@PathParam("idParametro") Integer idParametro) {
        try {
            ResponseParametrosGenerales response = ParametrosGeneralesManager.getInstance().getParametro(idParametro);
            return new BaseResponse<ResponseParametrosGenerales>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
        } catch (Exception e) {
            logError("parametrosApp/obtenerParametro/"+idParametro, e.getMessage());
            return new BaseResponse<ResponseParametrosGenerales>(
                e.getMessage(), 
                Utilities.ERROR_SERVICIO,
                ResponseConstantes.ERROR_VACIO,
                null);
        }
    }

}
