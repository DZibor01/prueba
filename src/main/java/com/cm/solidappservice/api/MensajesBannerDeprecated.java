package com.cm.solidappservice.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.DiverseInfoManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.diverseinfo.bd.MensajesBannerMD;
import com.cm.solidappservice.model.diverseinfo.response.ResponseMensajesVersion;
import com.cm.solidappservice.utils.Utilities;

@Path("/mensajesBanner")
public class MensajesBannerDeprecated extends BaseService {

    private Utilities utilities;

    public MensajesBannerDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }


    //EN DESUSO CUANDO APLIQUEN OTROS CAMBIOS
	@GET 
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<MensajesBannerMD>> getMensajes() {
        try {
        	List<MensajesBannerMD> response = DiverseInfoManager.getInstance().getMensajesBannerDeprecated();
        	return new BaseResponse<List<MensajesBannerMD>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("mensajesBanner", e.getMessage());
			return new BaseResponse<List<MensajesBannerMD>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@GET 
	@Path("/mensajesBannerVersion")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseMensajesVersion> getMensajesVersion() {
        try {
        	ResponseMensajesVersion response = DiverseInfoManager.getInstance().getMensajesBannerVersionDeprecated();
        	return new BaseResponse<ResponseMensajesVersion>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("mensajesBanner/mensajesBannerVersion", e.getMessage());
			return new BaseResponse<ResponseMensajesVersion>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
}