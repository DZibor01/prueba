package com.cm.solidappservice.api;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.DiverseInfoManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.diverseinfo.response.ResponseImagenLogin;
import com.cm.solidappservice.utils.Utilities;

@Path("/bannerImage")
public class ImagenLoginDeprecated extends BaseService {
	
	private Utilities utilities;

    public ImagenLoginDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<ResponseImagenLogin> getImageLogin() {
		try {
			ResponseImagenLogin response = DiverseInfoManager.getInstance().getImageLogin();
			return new BaseResponse<ResponseImagenLogin>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("bannerImage", e.getMessage());
			return new BaseResponse<ResponseImagenLogin>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
}