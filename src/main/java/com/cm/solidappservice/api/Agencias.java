package com.cm.solidappservice.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.AgenciasManager;
import com.cm.solidappservice.model.agencias.response.ResponseObtenerAgencias;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.utils.Utilities;

@Path("/puntosAtencion")
public class Agencias extends BaseService {
	
  private Utilities utilities;

  public Agencias(){
    utilities = new Utilities();
    utilities.getResponseMessages();
  }

	@GET
	@Path("/locaciones")
  @Produces(MediaType.APPLICATION_JSON)
  public BaseResponse<List<ResponseObtenerAgencias>> getAgencias() {
		try {
      List<ResponseObtenerAgencias> response = AgenciasManager.getInstance().obtenerAgencias();
			return new BaseResponse<List<ResponseObtenerAgencias>>(
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        ResponseConstantes.ERROR_VACIO,
                        response);
		} catch (Exception e) {
			logError("puntosAtencion/locaciones", e.getMessage());
			return new BaseResponse<List<ResponseObtenerAgencias>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
  }

}