package com.cm.solidappservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.CajaMenorPteManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.cajamenorpte.request.RequestCajaMenorPteMD;

@Path("/crearPteCajaMenor")
public class CajaMenorPte extends BaseService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String crearCajaMenorPte(RequestCajaMenorPteMD request) {
		try {
			CajaMenorPteManager.getInstance().crearCajaMenorPte(request);
			return ResponseConstantes.RESULTADO_EXITOSO;
		} catch (Exception e) {
			logError("crearPteCajaMenor", e.getMessage());
			return e.getMessage();
		}
	}
}