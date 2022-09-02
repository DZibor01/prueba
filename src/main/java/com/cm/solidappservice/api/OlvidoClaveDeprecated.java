package com.cm.solidappservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cm.solidappservice.security.Encripcion;
import com.cm.solidappservice.manager.LoginManager;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.login.request.RequestLogin;
import com.cm.solidappservice.utils.CustomException;
import com.cm.solidappservice.utils.Utilities;

@Path("/olvidoClave")
public class OlvidoClaveDeprecated extends BaseService {

	private Utilities utilities;

    public OlvidoClaveDeprecated(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public BaseResponse<String> recuperarClave(RequestLogin request) {
		try {
			if (Utilities.IsNullOrEmpty(request.getCedula())) {
				return new BaseResponse<String>(
					ResponseConstantes.ERROR_VACIO, "Debe especificar la cédula.", ResponseConstantes.CADENA_VACIA);
			}
			request.setCedula(Encripcion.getInstance().desencriptar(request.getCedula()));
			this.cedula = request.getCedula();
			LoginManager.getInstance().recordarClave(request);
			return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    Utilities.CORREO_CLAVE_ENVIADO);
		} catch (CustomException cEx){
			logError("olvidoClave", cEx.getMessage());
			return new BaseResponse<String>(
                    cEx.getMessage(), 
                    Utilities.CORREO_INVALIDO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
		catch (Exception e) {
			logError("olvidoClave", e.getMessage());
			return new BaseResponse<String>(
					e.getMessage(), 
                    Utilities.CORREO_INVALIDO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}
}