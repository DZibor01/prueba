package com.cm.solidappservice.api;

import java.util.Date;

import com.cm.solidappservice.security.Encripcion;
import com.cm.solidappservice.security.TokenException;
import com.cm.solidappservice.manager.TokenManager;
import com.cm.solidappservice.helpers.Network;
import com.cm.solidappservice.manager.LogsManager;
import com.cm.solidappservice.model.ahorros.request.RequestSolicitudAhorroDeprecated;
import com.cm.solidappservice.model.base.BaseRequest;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseValidacionParametros;
import com.cm.solidappservice.model.base.UrlsParametrizadas;
import com.cm.solidappservice.model.centrosvacacionales.request.RequestSolicitudCentroVacacional;
import com.cm.solidappservice.model.login.request.RequestLogin;
import com.cm.solidappservice.model.login.response.ResponseCheckToken;
import com.cm.solidappservice.model.logs.bd.LogErrorMD;
import com.cm.solidappservice.model.obligaciones.request.RequestPagoObligacionDeprecated;
import com.cm.solidappservice.model.tarjetapresente.request.RequestActualizarEstadoTarjeta;
import com.cm.solidappservice.model.transferencias.request.RequestSolicitudInscripcionCuenta;
import com.cm.solidappservice.utils.Log;
import com.cm.solidappservice.utils.Utilities;
import com.google.gson.Gson;

import org.codehaus.jackson.map.ObjectMapper;

public class BaseService {
	protected String cedula;
	
	/*public final ResponseValidacionParametros validateParameter(BaseRequest parametro) throws Exception {
		if (parametro == null) {
			return new ResponseValidacionParametros(null, "Parámetros nulos");
		}

		if (Utilities.IsNullOrEmpty(parametro.getCedula())) {
			return new ResponseValidacionParametros("Cédula vacía", null);
		}

		parametro.setCedula(Encripcion.getInstance().desencriptar(parametro.getCedula()));
		if (!Utilities.isNumeric(parametro.getCedula())) {
			return new ResponseValidacionParametros("Cédula inválida", null);
		}
		
		if (parametro.getClass().equals(RequestLogin.class)) { // No usa token, por lo
																	// cual voy a generar el token
			RequestLogin parametroLogin = (RequestLogin) parametro;
			if (Utilities.IsNullOrEmpty(parametroLogin.getClave())) {
				return new ResponseValidacionParametros("Clave vacía", null);
			}			
			parametroLogin.setClave(Encripcion.getInstance().desencriptar(parametroLogin.getClave()));
			// return
			// TokenManager.getInstance().GenerarToken((ParametroLogin)credencial).getToken();
		} else { // Usa Token
			RequestAutenticacion credencialAutenticacion = (RequestAutenticacion) parametro;
			if (Utilities.IsNullOrEmpty(credencialAutenticacion.getToken())) {
				return new ResponseValidacionParametros("Token vacío", null);
			}

			// Ahora voy a verificar la validez del token
			try {
				TokenManager.getInstance().ValidarToken(credencialAutenticacion);
			} catch (TokenException ex) {
				return new ResponseValidacionParametros(ex.getMessage(), null);
			}

			if (parametro.getClass().equals(RequestAutenticacion.class)) {
				// ParametroAutenticacion parametroAutenticacion =
				// (ParametroAutenticacion)parametro;
				// if (parametroAutenticacion.getToken()) {
				//
				// }
			} else if (parametro.getClass().equals(RequestActualizarEstadoTarjeta.class)) {
				RequestActualizarEstadoTarjeta parametroTarjeta = (RequestActualizarEstadoTarjeta) parametro;
				
				if (Utilities.IsNullOrEmpty(parametroTarjeta.getNumeroTarjeta())) {
					return new ResponseValidacionParametros(null, "Debe especificar el número de la tarjeta.");
				}
				if (Utilities.IsNullOrEmpty(parametroTarjeta.getEstado())) {
					return new ResponseValidacionParametros(null,
							"Debe especificar la operación que desea realizar en la tarjeta.");
				}
				if (parametroTarjeta.getEstado().equals(RequestActualizarEstadoTarjeta.BLOQUEAR_TARJETA)) {
					if (Utilities.IsNullOrEmpty(parametroTarjeta.getMotivo())) {
						return new ResponseValidacionParametros(null, "Debe especificar el motivo para bloquer la tarjeta.");
					}
				} else if (parametroTarjeta.getEstado().equals(RequestActualizarEstadoTarjeta.ACTIVAR_TARJETA)) {
					parametroTarjeta.setMotivo(null);
				} else {
					return new ResponseValidacionParametros(null, "Acción inválida.");
				}
				if (Utilities.IsNullOrEmpty(parametroTarjeta.getId_dispositivo())) {
					return new ResponseValidacionParametros(null, "Debe especificar el identificador del dispositivo.");
				}
				parametroTarjeta.setNumeroTarjeta(Encripcion.getInstance().desencriptar(parametroTarjeta.getNumeroTarjeta()));
			} else if (parametro.getClass().equals(RequestSolicitudAhorroDeprecated.class)) {
				RequestSolicitudAhorroDeprecated parametroSolicitudAhorro = (RequestSolicitudAhorroDeprecated) parametro;
				if (Utilities.IsNullOrEmpty(parametroSolicitudAhorro.getK_tipodr())) {
					return new ResponseValidacionParametros(null, "Debe especificar el tipo de ahorro.");
				}
				if (Utilities.IsNullOrEmpty(parametroSolicitudAhorro.getId_dispositivo())) {
					return new ResponseValidacionParametros(null, "Debe especificar el identificador del dispositivo.");
				}
				if (parametroSolicitudAhorro.getV_cuota() == 0) {
					return new ResponseValidacionParametros(null, "Debe especificar el valor de la cuota.");
				}
				if (Utilities.IsNullOrEmpty(parametroSolicitudAhorro.getF_vigenci_fin())) {
					if (parametroSolicitudAhorro.getV_plazo() == 0) {
						return new ResponseValidacionParametros(null, "Debe especificar el plazo de la cuota.");
					}
				}
			} else if (parametro.getClass().equals(RequestPagoObligacionDeprecated.class)) {
				RequestPagoObligacionDeprecated parametroPagoObligacion = (RequestPagoObligacionDeprecated) parametro;
				if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getA_numcta())) {
					return xyz("Debe especificar el campo a_numcta");
				}
				if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getA_numdoc())) {
					return xyz("Debe especificar el campo a_numdoc");
				}
				if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getA_tipodr())) {
					return xyz("Debe especificar el campo a_tipodr");
				}
				if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getId_dispositivo())) {
					return xyz("Debbe especificar el identificador del dispositivo.");
				}
				if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getK_tipodr())) {
					return xyz("Debe especificar el campo k_tipodr");
				}
				if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getN_produc())) {
					return xyz("Debe especificar el campo n_produc");
				}
				if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getN_tipodr())) {
					return xyz("Debe especificar el campo n_tipodr");
				}
				if (parametroPagoObligacion.getV_valor() <= 0) {
					return xyz("El valor del pago debe ser mayor que cero");
				}

				//TMP: Para Bug IPHONE, mientras se habilita la versión correcta en el appstore
				//if (!Utilities.isNumeric(parametroPagoObligacion.getA_numdoc())) { //Viene encriptado
					parametroPagoObligacion.setA_numdoc(Encripcion.getInstance().desencriptar(parametroPagoObligacion.getA_numdoc()));
				//}
				//if (!Utilities.isNumeric(parametroPagoObligacion.getA_numcta())) { //Viene encriptado
					parametroPagoObligacion.setA_numcta(Encripcion.getInstance().desencriptar(parametroPagoObligacion.getA_numcta()));
				//}					
			} else if (parametro.getClass().equals(RequestSolicitudCentroVacacional.class)) {
				RequestSolicitudCentroVacacional parametroSolicitudCentroVacacional = (RequestSolicitudCentroVacacional) parametro;
				if (Utilities.IsNullOrEmpty(parametroSolicitudCentroVacacional.getCodigo())) {
					return xyz("Debe especificar el cóigo del centro vacacional.");
				}
				if (Utilities.IsNullOrEmpty(parametroSolicitudCentroVacacional.getCodigoPerfil())) {
					return xyz("Debe especificar el código del perfil del centro vacacional.");
				}
				if (parametroSolicitudCentroVacacional.getNumeroDias() > 90) {
					return xyz("El número de días debe ser menor o igual que 90.");
				}
			} else if (parametro.getClass().equals(RequestSolicitudInscripcionCuenta.class)){
				RequestSolicitudInscripcionCuenta parametroInscripcionCuenta = (RequestSolicitudInscripcionCuenta) parametro;
				if (Utilities.IsNullOrEmpty(parametroInscripcionCuenta.getCedulaInscripcion())) {
					return xyz("Debe especificar la cédula asociada a la cuenta que desea inscribir.");
				}
				if (Utilities.IsNullOrEmpty(parametroInscripcionCuenta.getCodigoBanco())) {
					return xyz("Debe especificar el código del banco.");
				}
				if (Utilities.IsNullOrEmpty(parametroInscripcionCuenta.getNombreCuenta())) {
					return xyz("Debe especificar el nombre de la cuenta.");
				}
				if (Utilities.IsNullOrEmpty(parametroInscripcionCuenta.getNumeroCuenta())) {
					return xyz("Debe especificar el número de la cuenta.");
				}
				if (Utilities.IsNullOrEmpty(parametroInscripcionCuenta.getTipoCuenta())) {
					return xyz("Debe especificar el tipo de cuenta.");
				}
				//parametroInscripcionCuenta.setIdDispositivo(Encripcion.getInstance().desencriptar(parametroInscripcionCuenta.getIdDispositivo()));
				parametroInscripcionCuenta.setCedulaInscripcion(Encripcion.getInstance().desencriptar(parametroInscripcionCuenta.getCedulaInscripcion()));
				parametroInscripcionCuenta.setCodigoBanco(Encripcion.getInstance().desencriptar(parametroInscripcionCuenta.getCodigoBanco()));
				parametroInscripcionCuenta.setNumeroCuenta(Encripcion.getInstance().desencriptar(parametroInscripcionCuenta.getNumeroCuenta()));
			}
		}

		return new ResponseValidacionParametros(null, null);
	}*/

	private ResponseValidacionParametros xyz(String descripcion) {
		return new ResponseValidacionParametros(null, descripcion, null);
	}
		
	protected void logError(String origenError, String descripcion){
		LogsManager.getInstance().logError(new LogErrorMD(
			this.cedula==null?"":
			this.cedula, 
			origenError, 
			descripcion,
			new Date())
		);
	}
	
	public final void crearLogApi(String idLog, String aanumnit, String endPoint, String controlador, String metodo, Object requestBody){	
		try{
			Log logs = new Log(Utilities.RUTA_LOGS);
			logs.add("| "+idLog+"INS | "+
					metodo+" |"+
					(aanumnit == null ? "-" : Encripcion.getInstance().desencriptar(aanumnit))+" | "+
					endPoint+" | "+
					controlador+" | "+					
					(new ObjectMapper() .writeValueAsString(requestBody).length() > 200 ? 
						new ObjectMapper().writeValueAsString(requestBody).substring(0,199) :
						new ObjectMapper().writeValueAsString(requestBody))+" | "+
					new Date()+" |"
				);
		} catch(Exception ex){
			System.out.print(ex.getMessage());
		}
	}
	public final void actualizarLogApi(String idLog, Object responseBody, String resultado, String error){
		try{
			Log logs = new Log(Utilities.RUTA_LOGS);
			logs.add("| "+idLog+"UPD | "+
					(new ObjectMapper().writeValueAsString(responseBody).length() > 200 ?
						new ObjectMapper().writeValueAsString(responseBody).substring(0,199) :
							new ObjectMapper().writeValueAsString(responseBody))+" | "+
					resultado+" | "+
					(error.length()>200 ? error.substring(0,199) : error)+" | "+
					new Date()+" |"
				);

		}catch(Exception ex){
			System.out.print(ex.getMessage());
		}
	}
	
	// CAMBIOS PARA IMPLEMENTACION DE WSO2
	
	public final ResponseValidacionParametros validateParameterNew(RequestAutenticacion parametro, String scope)
			throws Exception {
		RequestAutenticacion credencialAutenticacion = parametro;
		if (Utilities.IsNullOrEmpty(credencialAutenticacion.getToken())) {
			return new ResponseValidacionParametros("Token vacío", null, null);
		}
		if (!Utilities.IsNullOrEmpty(parametro.getCedula())) {
			parametro.setCedula(Encripcion.getInstance().desencriptar(parametro.getCedula()));
		}

		if (parametro.getClass().equals(RequestAutenticacion.class)) {
			// ParametroAutenticacion parametroAutenticacion =
			// (ParametroAutenticacion)parametro;
			// if (parametroAutenticacion.getToken()) {
			//
			// }
		} else if (parametro.getClass().equals(RequestActualizarEstadoTarjeta.class)) {
			RequestActualizarEstadoTarjeta parametroTarjeta = (RequestActualizarEstadoTarjeta) parametro;

			if (Utilities.IsNullOrEmpty(parametroTarjeta.getNumeroTarjeta())) {
				return new ResponseValidacionParametros(null, "Debe especificar el número de la tarjeta.", null);
			}
			if (Utilities.IsNullOrEmpty(parametroTarjeta.getEstado())) {
				return new ResponseValidacionParametros(null,
						"Debe especificar la operación que desea realizar en la tarjeta.", null);
			}
			if (parametroTarjeta.getEstado().equals(RequestActualizarEstadoTarjeta.BLOQUEAR_TARJETA)) {
				if (Utilities.IsNullOrEmpty(parametroTarjeta.getMotivo())) {
					return new ResponseValidacionParametros(null, "Debe especificar el motivo para bloquer la tarjeta.",
							null);
				}
			} else if (parametroTarjeta.getEstado().equals(RequestActualizarEstadoTarjeta.ACTIVAR_TARJETA)) {
				parametroTarjeta.setMotivo(null);
			} else {
				return new ResponseValidacionParametros(null, "Acción inválida.", null);
			}
			if (Utilities.IsNullOrEmpty(parametroTarjeta.getId_dispositivo())) {
				return new ResponseValidacionParametros(null, "Debe especificar el identificador del dispositivo.",
						null);
			}
			parametroTarjeta
					.setNumeroTarjeta(Encripcion.getInstance().desencriptar(parametroTarjeta.getNumeroTarjeta()));
		} else if (parametro.getClass().equals(RequestSolicitudAhorroDeprecated.class)) {
			RequestSolicitudAhorroDeprecated parametroSolicitudAhorro = (RequestSolicitudAhorroDeprecated) parametro;
			if (Utilities.IsNullOrEmpty(parametroSolicitudAhorro.getK_tipodr())) {
				return new ResponseValidacionParametros(null, "Debe especificar el tipo de ahorro.", null);
			}
			if (Utilities.IsNullOrEmpty(parametroSolicitudAhorro.getId_dispositivo())) {
				return new ResponseValidacionParametros(null, "Debe especificar el identificador del dispositivo.",
						null);
			}
			if (parametroSolicitudAhorro.getV_cuota() == 0) {
				return new ResponseValidacionParametros(null, "Debe especificar el valor de la cuota.", null);
			}
			if (Utilities.IsNullOrEmpty(parametroSolicitudAhorro.getF_vigenci_fin())) {
				if (parametroSolicitudAhorro.getV_plazo() == 0) {
					return new ResponseValidacionParametros(null, "Debe especificar el plazo de la cuota.", null);
				}
			}
		} else if (parametro.getClass().equals(RequestPagoObligacionDeprecated.class)) {
			RequestPagoObligacionDeprecated parametroPagoObligacion = (RequestPagoObligacionDeprecated) parametro;
			if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getA_numcta())) {
				return xyz("Debe especificar el campo a_numcta");
			}
			if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getA_numdoc())) {
				return xyz("Debe especificar el campo a_numdoc");
			}
			if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getA_tipodr())) {
				return xyz("Debe especificar el campo a_tipodr");
			}
			if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getId_dispositivo())) {
				return xyz("Debbe especificar el identificador del dispositivo.");
			}
			if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getK_tipodr())) {
				return xyz("Debe especificar el campo k_tipodr");
			}
			if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getN_produc())) {
				return xyz("Debe especificar el campo n_produc");
			}
			if (Utilities.IsNullOrEmpty(parametroPagoObligacion.getN_tipodr())) {
				return xyz("Debe especificar el campo n_tipodr");
			}
			if (parametroPagoObligacion.getV_valor() <= 0) {
				return xyz("El valor del pago debe ser mayor que cero");
			}

			// TMP: Para Bug IPHONE, mientras se habilita la versión correcta en el appstore
			// if (!Utilities.isNumeric(parametroPagoObligacion.getA_numdoc())) { //Viene
			// encriptado
			parametroPagoObligacion
					.setA_numdoc(Encripcion.getInstance().desencriptar(parametroPagoObligacion.getA_numdoc()));
			// }
			// if (!Utilities.isNumeric(parametroPagoObligacion.getA_numcta())) { //Viene
			// encriptado
			parametroPagoObligacion
					.setA_numcta(Encripcion.getInstance().desencriptar(parametroPagoObligacion.getA_numcta()));
			// }
		} else if (parametro.getClass().equals(RequestSolicitudCentroVacacional.class)) {
			RequestSolicitudCentroVacacional parametroSolicitudCentroVacacional = (RequestSolicitudCentroVacacional) parametro;
			if (Utilities.IsNullOrEmpty(parametroSolicitudCentroVacacional.getCodigo())) {
				return xyz("Debe especificar el cóigo del centro vacacional.");
			}
			if (Utilities.IsNullOrEmpty(parametroSolicitudCentroVacacional.getCodigoPerfil())) {
				return xyz("Debe especificar el código del perfil del centro vacacional.");
			}
			if (parametroSolicitudCentroVacacional.getNumeroDias() > 90) {
				return xyz("El número de días debe ser menor o igual que 90.");
			}
		} else if (parametro.getClass().equals(RequestSolicitudInscripcionCuenta.class)) {
			RequestSolicitudInscripcionCuenta parametroInscripcionCuenta = (RequestSolicitudInscripcionCuenta) parametro;
			if (Utilities.IsNullOrEmpty(parametroInscripcionCuenta.getCedulaInscripcion())) {
				return xyz("Debe especificar la cédula asociada a la cuenta que desea inscribir.");
			}
			if (Utilities.IsNullOrEmpty(parametroInscripcionCuenta.getCodigoBanco())) {
				return xyz("Debe especificar el código del banco.");
			}
			if (Utilities.IsNullOrEmpty(parametroInscripcionCuenta.getNombreCuenta())) {
				return xyz("Debe especificar el nombre de la cuenta.");
			}
			if (Utilities.IsNullOrEmpty(parametroInscripcionCuenta.getNumeroCuenta())) {
				return xyz("Debe especificar el número de la cuenta.");
			}
			if (Utilities.IsNullOrEmpty(parametroInscripcionCuenta.getTipoCuenta())) {
				return xyz("Debe especificar el tipo de cuenta.");
			}
			// parametroInscripcionCuenta.setIdDispositivo(Encripcion.getInstance().desencriptar(parametroInscripcionCuenta.getIdDispositivo()));
			parametroInscripcionCuenta.setCedulaInscripcion(
					Encripcion.getInstance().desencriptar(parametroInscripcionCuenta.getCedulaInscripcion()));
			parametroInscripcionCuenta
					.setCodigoBanco(Encripcion.getInstance().desencriptar(parametroInscripcionCuenta.getCodigoBanco()));
			parametroInscripcionCuenta.setNumeroCuenta(
					Encripcion.getInstance().desencriptar(parametroInscripcionCuenta.getNumeroCuenta()));
		}

		// Ahora voy a verificar la validez del token
		try {
			// TokenManager.getInstance().ValidarToken(credencialAutenticacion);
			Network network = new Network(UrlsParametrizadas.API_SEGURIDAD_PRESENTE);
			String jsonToken = network.checkToken(parametro.getToken(), scope, parametro.getBasicEncodeClient());
			// return new ResponseValidacionParametros(null, null, cedula);
			ResponseCheckToken responseChecktoken = new Gson().fromJson(jsonToken, ResponseCheckToken.class);
			String cedulaResponse = responseChecktoken.getIdUser();
			if(!Utilities.IsNullOrEmpty(cedulaResponse)) {
				return new ResponseValidacionParametros(null, null, cedulaResponse);
			}
		} catch (Exception ex) {
			if (ex.getMessage().equals("status!=200")) {
				return new ResponseValidacionParametros(
						"token invalido, no tienes permisos para solicitar este recurso", null, null);
			}
			if (!ex.getMessage().equals("status!=200")) {
				return new ResponseValidacionParametros(ex.getMessage(), null, null);
			}
		}
		return new ResponseValidacionParametros(null, null, null);
	}

}