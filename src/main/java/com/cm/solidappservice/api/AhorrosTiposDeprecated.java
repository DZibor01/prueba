package com.cm.solidappservice.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.AhorrosManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.ahorros.response.ResponseTipoAhorroDisponibleDeprecated;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.utils.Utilities;

@Path("/tipoAhorroDisponible")
public class AhorrosTiposDeprecated extends BaseService{
	
    private Utilities utilities;

    public AhorrosTiposDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseTipoAhorroDisponibleDeprecated>> getTiposAhorroDisponibles(RequestAutenticacion request) {
        try {
        	List<ResponseTipoAhorroDisponibleDeprecated> response = AhorrosManager.getInstance().getTiposAhorroDisponiblesDeprecated();
    		return new BaseResponse<List<ResponseTipoAhorroDisponibleDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("tipoAhorroDisponible", e.getMessage());
			return new BaseResponse<List<ResponseTipoAhorroDisponibleDeprecated>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
}