package com.cm.solidappservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.Timestamp;

import com.cm.solidappservice.security.Encripcion;
import com.cm.solidappservice.manager.DatosAsociadoManager;
import com.cm.solidappservice.manager.LoginManager;
import com.cm.solidappservice.manager.PortalUnicoManager;
import com.cm.solidappservice.utils.CustomException;
import com.cm.solidappservice.utils.Utilities;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.base.BaseResponse;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.datosasociado.response.ResponseDatosBasicosAsociadoDeprecated;
import com.cm.solidappservice.model.login.request.RequestLogin;
import com.cm.solidappservice.model.login.request.RequestTokenSession;
import com.cm.solidappservice.model.login.response.ResponseResultadoAutenticacion;
import com.cm.solidappservice.model.portalunico.request.RequestRegistroIngresoDeprecated;

@Path("/login")
public class Login extends BaseService {
	
    private Utilities utilities;

    public Login(){
        utilities = new Utilities();
        utilities.getResponseMessages();
    }

	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseResultadoAutenticacion> autenticarUsuario(RequestLogin request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
        try {
            crearLogApi(idLog, request.getCedula(), "/login/", "Login", "POST", "");
    		if (Utilities.IsNullOrEmpty(request.getCedula())) {
                actualizarLogApi(idLog, "", "ERROR", "Cédula vacía");
                return new BaseResponse<ResponseResultadoAutenticacion>(
                    "Cédula vacía",
                    "Cédula vacía",
                    ResponseConstantes.CADENA_VACIA, 
                    null);
    		}
    		
    		request.setCedula(Encripcion.getInstance().desencriptar(request.getCedula()));
    		if (!Utilities.isNumeric(request.getCedula())) {
                actualizarLogApi(idLog, "", "ERROR", "Cédula inválida");
                return new BaseResponse<ResponseResultadoAutenticacion>(
                    "Cédula inválida",
                    "Cédula inválida",
                    ResponseConstantes.CADENA_VACIA, 
                    null);
    		}
    		
			if (Utilities.IsNullOrEmpty(request.getClave())) {
                actualizarLogApi(idLog, "", "ERROR", "Clave vacía");
                return new BaseResponse<ResponseResultadoAutenticacion>(
                    "Clave vacía",
                    "Clave vacía",
                    ResponseConstantes.CADENA_VACIA, 
                    null);
			}
			
			request.setClave(Encripcion.getInstance().desencriptar(request.getClave()));

        	ResponseResultadoAutenticacion response = LoginManager.getInstance().autenticarUsuario(request);            
            actualizarLogApi(idLog, response, ResponseConstantes.RESULTADO_EXITOSO, "");
        	return new BaseResponse<ResponseResultadoAutenticacion>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);

        }catch (CustomException cEx){
            logError("login", cEx.getMessage());
            actualizarLogApi(idLog, "", "ERROR", cEx.getMessage()+" "+cEx.getCause());
			return new BaseResponse<ResponseResultadoAutenticacion>(
                    cEx.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		} catch (Exception e) {
			logError("login", e.getMessage());
            actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
			return new BaseResponse<ResponseResultadoAutenticacion>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

	@POST
    @Path("/validarTokenSession")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseResultadoAutenticacion> validarToken(RequestTokenSession request) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idLog = String.valueOf(timestamp.getTime());
        try {
            crearLogApi(idLog, null, "/login/validarTokenSession", "Login", "POST", request);  	
            Encripcion encripcion = new Encripcion();
            String tokenSession = encripcion.decryptAES(request.getTokenSession());
            String[] array = tokenSession.split(":");
            if(array.length <= 0){
                actualizarLogApi(idLog, "", "ERROR", "TokenSession Inválido");
                return new BaseResponse<ResponseResultadoAutenticacion>(
                    "TokenSession Inválido",
                    "El token no es valido",
                    ResponseConstantes.CADENA_VACIA, 
                    null); 
            }
    		String cedula = array[0];
    		String token = array[1];
            RequestAutenticacion autenticacion = new RequestAutenticacion(cedula, token);
			ResponseValidacionParametros validacion = validateParameter(autenticacion);			
            if (!validacion.isValid()){
                actualizarLogApi(idLog, "", "ERROR", validacion.getErrorToken() + validacion.getErrorParametros());
                return new BaseResponse<ResponseResultadoAutenticacion>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            } else {
                ResponseResultadoAutenticacion response = LoginManager.getInstance().crearNuevoToken(request.getOrigen(), autenticacion);
                actualizarLogApi(idLog, ResponseConstantes.RESULTADO_EXITOSO, ResponseConstantes.RESULTADO_EXITOSO, "");
                return new BaseResponse<ResponseResultadoAutenticacion>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("login/validarTokenSession", e.getMessage());
            actualizarLogApi(idLog, "", "ERROR", e.getMessage()+" "+e.getCause());
            return new BaseResponse<ResponseResultadoAutenticacion>(
                    e.getMessage(), 
                    Utilities.ERROR_SERVICIO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
        } 
    }

    @POST
    @Path("/olvidoClave")
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
			logError("login/olvidoClave", cEx.getMessage());
			return new BaseResponse<String>(
                    cEx.getMessage(), 
                    Utilities.CORREO_INVALIDO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
		catch (Exception e) {
			logError("login/olvidoClave", e.getMessage());
			return new BaseResponse<String>(
					e.getMessage(), 
                    Utilities.CORREO_INVALIDO,
                    ResponseConstantes.ERROR_VACIO,
                    null);
		}
	}

    @POST
    @Path("/consultarDatosAsociado")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<ResponseDatosBasicosAsociadoDeprecated> consultarDatosAsociadoDeprecated(RequestAutenticacion request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<ResponseDatosBasicosAsociadoDeprecated>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            } else {
                ResponseDatosBasicosAsociadoDeprecated response = DatosAsociadoManager.getInstance()
                    .obtenerDatosBasicosAsociadoDeprecated(request);
                return new BaseResponse<ResponseDatosBasicosAsociadoDeprecated>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("login/consultarDatosAsociado", e.getMessage());
            return new BaseResponse<ResponseDatosBasicosAsociadoDeprecated>(
                e.getMessage(), 
                Utilities.ERROR_SERVICIO,
                ResponseConstantes.ERROR_VACIO,
                null);
        } 
	}

    @POST
    @Path("/registrarPortalUnico")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public BaseResponse<String> registrarPortalUnicoDeprecated(RequestRegistroIngresoDeprecated request) {
        try {
            ResponseValidacionParametros validacion = validateParameter(request);
            if (!validacion.isValid()){
                return new BaseResponse<String>(
                    validacion.getErrorParametros(),
                    validacion.getErrorParametros(),
                    validacion.getErrorToken(), 
                    null); 
            } else {
                String response = PortalUnicoManager.getInstance().registrarIngresoPortalUnicoDeprecated(request);
                return new BaseResponse<String>(
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    ResponseConstantes.ERROR_VACIO,
                    response);
            }
        } catch (Exception e) {
            logError("login/consultarDatosAsociado", e.getMessage());
            return new BaseResponse<String>(
                e.getMessage(), 
                Utilities.ERROR_SERVICIO,
                ResponseConstantes.ERROR_VACIO,
                null);
        }
    }
    
}