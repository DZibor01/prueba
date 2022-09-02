package com.cm.solidappservice.api;

import com.cm.solidappservice.helpers.scopeConstantes;
import com.cm.solidappservice.manager.DiverseInfoManager;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.diverseinfo.bd.BannerComercialMD;
import com.cm.solidappservice.utils.Utilities;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/mensajes")
public class BannerComercialDeprecated extends BaseService {

    private Utilities utilities;

    public BannerComercialDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    //PEndiente eliminar
    @POST
    @Path("/BannerMP")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<BannerComercialMD>> obtenerBannerComercial(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameterNew(request, scopeConstantes.SCOPE_MENSAJES_BANNERMP);
            if (!validacion.isValid()){
            	validacion.setErrorToken(Utilities.IsNullOrEmpty(validacion.getErrorToken()) == true ? "" : validacion.getErrorToken());
				validacion.setErrorParametros(Utilities.IsNullOrEmpty(validacion.getErrorParametros()) == true ? "Error obteniendo cedula" : validacion.getErrorToken());
                return new BaseResponse<List<BannerComercialMD>>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null);
            } else {
                List<BannerComercialMD> response = DiverseInfoManager.getInstance().obtenerBannerComercialDeprecated();
                return new BaseResponse<List<BannerComercialMD>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("mensajes/BannerMP", e.getMessage());
            return new BaseResponse<List<BannerComercialMD>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }


    
}