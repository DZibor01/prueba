package com.cm.solidappservice.api;

import com.cm.solidappservice.manager.DiverseInfoManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.diverseinfo.bd.MasServiciosMD;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.cm.solidappservice.utils.Utilities;

@Path("/menu")
public class MenuMasServiciosDeprecated extends BaseService {

    private Utilities utilities;

    public MenuMasServiciosDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

    //EN POCO ESTARA EN DESUSO
    @GET
    @Path("/Otrosservicios")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<MasServiciosMD>> obtenerMenuOtrosServicios() {
        try {
            List<MasServiciosMD> response = DiverseInfoManager.getInstance().obtenerOtrosServiciosDeprecated();
            return new BaseResponse<List<MasServiciosMD>>(
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				response);
        } catch (Exception e) {
            logError("menu/Otrosservicios", e.getMessage());
            return new BaseResponse<List<MasServiciosMD>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }

}