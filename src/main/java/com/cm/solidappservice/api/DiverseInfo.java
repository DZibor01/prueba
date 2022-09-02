package com.cm.solidappservice.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.manager.DiverseInfoManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.diverseinfo.response.*;
import com.cm.solidappservice.utils.Utilities;

@Path("/diverseInfo")
public class DiverseInfo extends BaseService {

    private Utilities utilities;

    public DiverseInfo(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@GET
	@Path("/portafolio")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponsePortafolio>> getPortafolio() {
		try {
			List<ResponsePortafolio> response = DiverseInfoManager.getInstance().getPortafolio();
			return new BaseResponse<List<ResponsePortafolio>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("diverseInfo/portafolio", e.getMessage());
			return new BaseResponse<List<ResponsePortafolio>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	
	@GET
	@Path("/preguntasFrecuentes")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponsePreguntaFrecuente>> getPreguntasFrecuentes() {
		try {
			List<ResponsePreguntaFrecuente> response = DiverseInfoManager.getInstance().getPreguntasFrecuentes();
			return new BaseResponse<List<ResponsePreguntaFrecuente>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("diverseInfo/preguntasFrecuentes", e.getMessage());
			return new BaseResponse<List<ResponsePreguntaFrecuente>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	
	@GET
	@Path("/redesSociales")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseRedesSociales>> getRedesSociales() {
		try {
			List<ResponseRedesSociales> response = DiverseInfoManager.getInstance().getRedesSociales();
			return new BaseResponse<List<ResponseRedesSociales>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("diverseInfo/redesSociales", e.getMessage());
			return new BaseResponse<List<ResponseRedesSociales>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	
	@GET
	@Path("/directorio")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseDirectorioDeprecated>> getDirectorioDeprecated() {
		try {
			List<ResponseDirectorioDeprecated> response = DiverseInfoManager.getInstance().getDirectorioDeprecated();
			return new BaseResponse<List<ResponseDirectorioDeprecated>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("diverseInfo/directorio", e.getMessage());
			return new BaseResponse<List<ResponseDirectorioDeprecated>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	@GET
	@Path("/contactos")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<List<ResponseDirectorio>> getDirectorio() {
		try {
			List<ResponseDirectorio> response = DiverseInfoManager.getInstance().getDirectorio();
			return new BaseResponse<List<ResponseDirectorio>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("diverseInfo/contactos", e.getMessage());
			return new BaseResponse<List<ResponseDirectorio>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
	
	@GET
	@Path("/versionActual")
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> getVersionActual() {
		try {
			String response = DiverseInfoManager.getInstance().getVersionActual();
			return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("diverseInfo/versionActual", e.getMessage());
			return new BaseResponse<String>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@GET 
	@Path("/imagenesBeneficios")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String[]> getImagenesBeneficios() {
        try {
        	String[] response = DiverseInfoManager.getInstance().getImagenesBeneficios();
        	return new BaseResponse<String[]>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("diverseInfo/imagenesBeneficios", e.getMessage());
			return new BaseResponse<String[]>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@GET
	@Path("/bannerImageLogin")
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
			logError("diverseInfo/bannerImageLogin", e.getMessage());
			return new BaseResponse<ResponseImagenLogin>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@GET 
	@Path("/mensajesBanner")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseMensajesBanner>> getMensajes() {
        try {
        	List<ResponseMensajesBanner> response = DiverseInfoManager.getInstance().getMensajesBanner();
        	return new BaseResponse<List<ResponseMensajesBanner>>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
		} catch (Exception e) {
			logError("diverseInfo/mensajesBanner", e.getMessage());
			return new BaseResponse<List<ResponseMensajesBanner>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@GET
    @Path("/bannerComercial")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseBannerComercial>> obtenerBannerComercial() {
        try {
            List<ResponseBannerComercial> response = DiverseInfoManager.getInstance().obtenerBannerComercial();
			return new BaseResponse<List<ResponseBannerComercial>>(
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				response);
        } catch (Exception e) {
            logError("diverseInfo/bannerComercial", e.getMessage());
            return new BaseResponse<List<ResponseBannerComercial>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        }
    }

	@GET
    @Path("/menuMasServicios")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseMenuMasServicios>> obtenerMenuOtrosServicios() {
        try {
            List<ResponseMenuMasServicios> response = DiverseInfoManager.getInstance().obtenerOtrosServicios();
            return new BaseResponse<List<ResponseMenuMasServicios>>(
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				response);
        } catch (Exception e) {
            logError("diverseInfo/menuMasServicios", e.getMessage());
            return new BaseResponse<List<ResponseMenuMasServicios>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }

	@GET
    @Path("/mensajesRespuesta")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<List<ResponseMensajesRespuesta>> obtenerMensajesRespuesta() {
        try {
            List<ResponseMensajesRespuesta> response = DiverseInfoManager.getInstance().obtenerMensajesRespuesta();
            return new BaseResponse<List<ResponseMensajesRespuesta>>(
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				ResponseConstantes.ERROR_VACIO,
				response);
        } catch (Exception e) {
            logError("diverseInfo/mensajesRespuesta", e.getMessage());
            return new BaseResponse<List<ResponseMensajesRespuesta>>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }

}

