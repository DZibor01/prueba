package com.cm.solidappservice.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.DiverseInfoManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.utils.Utilities;

@Path("/imagenesBeneficios")
public class ImagenesBeneficiosDeprecated extends BaseService{

    private Utilities utilities;

    public ImagenesBeneficiosDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	//EN DESUSO
	@GET 
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String[]> getMensajes() {
        try {
        	String[] response = DiverseInfoManager.getInstance().getImagenesBeneficios();
        	return new BaseResponse<String[]>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
            logError("imagenesBeneficios", e.getMessage());
            return new BaseResponse<String[]>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

}