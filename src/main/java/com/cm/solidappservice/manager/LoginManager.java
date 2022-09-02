package com.cm.solidappservice.manager;

import java.util.Date;
import java.util.UUID;

import com.cm.solidappservice.dao.LoginDAO;
import com.cm.solidappservice.dao.ParametrosGeneralesDAO;
import com.cm.solidappservice.dao.TokenDAO;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.login.bd.*;
import com.cm.solidappservice.model.login.request.*;
import com.cm.solidappservice.model.login.response.*;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;
import com.cm.solidappservice.model.token.bd.TokenMD;
import com.cm.solidappservice.utils.CustomException;
import com.cm.solidappservice.utils.Utilities;

public class LoginManager {
    
    private static LoginManager singleton = null;
	private static long timeoutMinutos = 5L;  
	private static long timeoutMilisegundos = timeoutMinutos * 60L * 1000L;
	
	public static LoginManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (LoginManager.class) {
					if (null == singleton) {
						singleton = new LoginManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public ResponseResultadoAutenticacion autenticarUsuario(RequestLogin request) throws CustomException, Exception {

		String fechaUltimoIngreso = LoginDAO.getInstance().fechaUltimoIngreso(request.getCedula());

		String resultado = LoginDAO.getInstance().autenticarUsuario(request);
		// String resultado = LoginDAO2.getInstance().login(credencial);
		if (Utilities.IsNullOrEmpty(resultado)) {
			throw new CustomException("Resultado inválido.");
		}

		String[] separacion = resultado.split(":");
		if (separacion[0].toUpperCase().equals("ERROR")) {
			if (separacion[1].toUpperCase().contains("INFORMACION ERRADA")) {
				throw new CustomException("Tu usuario y/o clave es incorrecta");
			} else if (separacion[1].toUpperCase().contains("BLOQUEAD")) {
				throw new CustomException("Tu clave ha sido bloqueada, comunícate a las oficinas de PRESENTE");
			} else {
				throw new CustomException(separacion[1]);
			}
		}
		
		String topeTransacciones = getTopeTransacciones();
		RequestAutenticacion token = TokenManager.getInstance().GenerarToken(request);
		DatosActualizados tieneDatosActualizados = DatosAsociadoManager.getInstance().validarDatosActualizados(request.getCedula());
		String aceptoUltimosTyC = TyCManager.getInstance().getValidarTerminosAceptados(request.getCedula());

		ResponseResultadoAutenticacion response = new ResponseResultadoAutenticacion();		
		response.setNombreAsociado(resultado);
		response.setToken(token.getToken());
		response.setTopeTransacciones(topeTransacciones);
		response.setFechaUltimoIngreso(fechaUltimoIngreso);
		response.setAceptoUltimosTyC(aceptoUltimosTyC);
		response.setDatosActualizados(tieneDatosActualizados);
		return response;
	}

	public String getTopeTransacciones() throws Exception {
		ParametrosGeneralesMD model = ParametrosGeneralesDAO.getInstance().obtenerParametrosTransacciones();
		if (model == null) {
			throw new Exception("Los parámetros de la aplicación están nulos.");
		}
		return String.valueOf(model.getN_value1());
	}

	public ResponseResultadoAutenticacion crearNuevoToken(String origen, RequestAutenticacion request) throws Exception {		
		TokenMD token = new TokenMD();
		token.setToken(origen != null && origen.equals("APP") ? request.getToken() : UUID.randomUUID().toString());
		token.setOldToken(request.getToken());
		token.setAanumnit(request.getCedula());
		token.setFechaGeneracion(new Date());
		token.setFechaExpiracion(new Date(token.getFechaGeneracion().getTime() + timeoutMilisegundos));
		token.setI_expirado("N");
		TokenDAO.getInstance().updateNewToken(token);
		
		String topeTransacciones = getTopeTransacciones();
		DatosActualizados tieneDatosActualizados = DatosAsociadoManager.getInstance().validarDatosActualizados(token.getAanumnit());
		String nombre = DatosAsociadoManager.getInstance().consultarDatosAsociado(request).getNombreCompleto().split(" ")[0];
		String aceptoUltimosTyC = TyCManager.getInstance().getValidarTerminosAceptados(token.getAanumnit());

		ResponseResultadoAutenticacion response = new ResponseResultadoAutenticacion();		
		response.setNombreAsociado(nombre);
		response.setToken(token.getToken());
		response.setTopeTransacciones(topeTransacciones);
		response.setAceptoUltimosTyC(aceptoUltimosTyC);
		response.setDatosActualizados(tieneDatosActualizados);
		return response;
	}


	public void recordarClave(RequestLogin request) throws CustomException, Exception {
		RecordarClaveMD parameter = LoginDAO.getInstance().recordarClave(request);
		if (Utilities.IsNullOrEmpty(parameter.getV_vclave())) { // ERROR
			if (Utilities.IsNullOrEmpty(parameter.getV_email())) { // Hubo algún error, por lo tanto voy a verificarlo en el campo Email
				throw new CustomException("Error recordando la clave."); // Hay error, pero no se pudo obtener una descripción
			} else {
				throw new CustomException(parameter.getV_email());
			}
		} else {
			if (Utilities.IsNullOrEmpty(parameter.getV_email())) {
				throw new CustomException(Utilities.CORREO_INVALIDO);
			}
			if (parameter.getV_email().toUpperCase().contains("ERROR:")) {
				String[] separacion = parameter.getV_email().split(":");
				throw new CustomException(separacion[1]);
			}
			new Utilities().sendMail2(parameter.getV_email(), parameter.getV_vclave(), "Recuperación Clave Presente", "1");
		}
	}
	
	// CAMBIOS PARA IMPLEMENTACION DE WSO2
	
	public ResponseResultadoAutenticacion autenticarUsuarioNew(String cedulaUsuario, String token) throws CustomException, Exception {

		String fechaUltimoIngreso = LoginDAO.getInstance().fechaUltimoIngreso(cedulaUsuario);
		String topeTransacciones = getTopeTransacciones();
		//TokenManager.getInstance().GenerarTokenWso2(cedulaUsuario, origen, token);
		String nombre = DatosAsociadoManager.getInstance().consultarDatosAsociadoNew(cedulaUsuario).getNombreCompleto().split(" ")[0];
		DatosActualizados tieneDatosActualizados = DatosAsociadoManager.getInstance().validarDatosActualizados(cedulaUsuario);
		String aceptoUltimosTyC = TyCManager.getInstance().getValidarTerminosAceptados(cedulaUsuario);

		ResponseResultadoAutenticacion response = new ResponseResultadoAutenticacion();
		response.setCedula(cedulaUsuario);
		//response.setToken(token);
		response.setNombreAsociado(nombre);
		response.setTopeTransacciones(topeTransacciones);
		response.setFechaUltimoIngreso(fechaUltimoIngreso);
		response.setAceptoUltimosTyC(aceptoUltimosTyC);
		response.setDatosActualizados(tieneDatosActualizados);
		return response;
	}

}
