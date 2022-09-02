package com.cm.solidappservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.SegurosManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.seguros.bd.InmuebleMD;
import com.cm.solidappservice.model.seguros.bd.SolicitudSeguroMD;
import com.cm.solidappservice.model.seguros.bd.VehiculoMD;

@Path("/seguros")
public class Seguros extends BaseService {
	
	@POST
	@Path("/crearVehiculo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearVehiculo(VehiculoMD vehiculo) {
		try {
			SegurosManager.getInstance().crearVehiculo(vehiculo);
			return ResponseConstantes.RESULTADO_EXITOSO;
		} catch (Exception e) {
			logError("seguros/crearVehiculo", e.getMessage());
			return e.getMessage();
		}
	}
	
	@POST
	@Path("/crearInmueble")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearInmueble(InmuebleMD inmueble) {
		try {
			SegurosManager.getInstance().crearInmueble(inmueble);
			return ResponseConstantes.RESULTADO_EXITOSO;
		} catch (Exception e) {
			logError("seguros/crearInmueble", e.getMessage());
			return e.getMessage();
		}
	}
	
	@POST
	@Path("/crearSolicitudSeguro")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearSolicitudSeguro(SolicitudSeguroMD solicitud) {
		try {
			SegurosManager.getInstance().crearSolicitudAhorro(solicitud);
			return ResponseConstantes.RESULTADO_EXITOSO;
		} catch (Exception e) {
			logError("seguros/crearSolicitudSeguro", e.getMessage());
			return e.getMessage();
		}
	}
}