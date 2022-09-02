package com.cm.solidappservice.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.AgenciasManager;
import com.cm.solidappservice.model.agencias.response.*;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.utils.Utilities;

@Path("/agencias")
public class AgenciasDeprecated extends BaseService {
	
    private Utilities utilities;

    public AgenciasDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseAgenciasDeprecated>> getAgencias() {
        try {
        	List<ResponseAgenciasDeprecated> response = AgenciasManager.getInstance().obtenerAgenciasDeprecated();
			return new BaseResponse<List<ResponseAgenciasDeprecated>>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
		} catch (Exception e) {
			logError("agencias", e.getMessage());
			return new BaseResponse<List<ResponseAgenciasDeprecated>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
    }
}