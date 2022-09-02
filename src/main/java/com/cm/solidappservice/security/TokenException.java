package com.cm.solidappservice.security;

public class TokenException extends Exception{
	public enum ReasonException{
		TimeoutExpirado,
		TokenNoExiste, //El token especificado no existe
		SuplantacionToken, //Cuando alguien trata de usar un token asignado a otra persona (token existente con cédula distinta)
		NuevoInicioSesion //Cuando se detecta que el mismo usuario inició sesión desde otro dispositivo.
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TokenException(ReasonException reason){
		super(getReasonDescription(reason));
	}
	
	public TokenException(String reason){
		super(reason);
	}
	
	private static String getReasonDescription(ReasonException reason){
		String description = "";
		switch (reason) {
		case SuplantacionToken:
			description = "Suplantación de identidad."; //Cuando alguien trata de usar un token asignado a otra persona (token existente con cédula distinta)
			break;
		case TimeoutExpirado:
			description = "Has estado inactivo un tiempo, por tu seguridad hemos finalizado tu sesión, ingresa nuevamente.";
			break;
		case TokenNoExiste:
			description = "Por tu seguridad se ha cerrado tu sesión.";
			break;
		case NuevoInicioSesion:
			description = //"Su token de sesión expiró debido a un posible inició de sesión desde otro dispositivo.";
				"Tu sesion expiró debido a un posible inicio de sesión desde otro dispositivo";
			break;
		default:
			description = "opción desconocida.";
			break;
		}
		return description;
	}
}
