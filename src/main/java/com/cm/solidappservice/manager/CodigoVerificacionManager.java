package com.cm.solidappservice.manager;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import com.cm.solidappservice.helpers.Network;
import com.cm.solidappservice.dao.*;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.codigoverificacion.bd.CodigoVerificacionMD;
import com.cm.solidappservice.model.codigoverificacion.request.RequestEnviarCodigo;
import com.cm.solidappservice.model.codigoverificacion.request.RequestValidarCodigo;
import com.cm.solidappservice.model.codigoverificacion.response.ResponseCodigo;
import com.cm.solidappservice.model.codigoverificacion.response.ResponseValidarCodigo;
import com.cm.solidappservice.model.datosasociado.bd.ConsultaDatosAsociadoMD;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;
import com.cm.solidappservice.utils.Utilities;

import org.codehaus.jettison.json.JSONObject;

public class CodigoVerificacionManager {
    
    private static CodigoVerificacionManager singleton = null;

	public static CodigoVerificacionManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (CodigoVerificacionManager.class) {
					if (null == singleton) {
						singleton = new CodigoVerificacionManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}
	
	public ResponseCodigo enviarCodigo(RequestEnviarCodigo request) throws Exception {
		ResponseCodigo response = null;
		//Tipo Envio 1: Email 2: Celular 3:Cel/EmailRegistrado
		if(request.getTipoEnvio() != null && request.getTipoEnvio() > 0 && request.getTipoEnvio() <= 3) {
			if(request.getTipoEnvio() == 1) {
				if(request.getCorreo() != null && !request.getCorreo().isEmpty()) {
					response = enviarCodigoEmail(request);
				}else {
					throw new Exception("Debes ingresar un correo");
				}				
			}
			if(request.getTipoEnvio() == 2) {
				if(request.getCelular() != null && !request.getCelular().isEmpty()) {
					response = enviarCodigoCelular(request);
				}else {
					throw new Exception("Debes ingresar un celular");
				}
			}
			if(request.getTipoEnvio() == 3) {
				if(request.getTipoCodigo() != null && request.getTipoCodigo()>0 && request.getTipoCodigo()<3) {
					response = enviarCodigoRegistrado(request);
				}else {
					throw new Exception("Debes ingresar un tipo de código");
				}
			}
			
			
		}else {
			throw new Exception("Tipo de código no valido");
		}
		return response;
	}
	
	
    public ResponseCodigo enviarCodigoEmail(RequestEnviarCodigo request) throws Exception {		
		List<CodigoVerificacionMD> listaCodigos = CodigoVerificacionDAO.getInstance().obtenerCodigosCedula(request.getCedula());
		if(listaCodigos != null && listaCodigos.size() > 0){
			for(CodigoVerificacionMD cv : listaCodigos){
				CodigoVerificacionMD codigo = new CodigoVerificacionMD();
				codigo.setK_codigo(cv.getK_codigo());
				codigo.setA_anumnit(cv.getA_anumnit());
				codigo.setI_expirado("Y");
				CodigoVerificacionDAO.getInstance().actualizarCodigo(codigo);
			}
		}
		CodigoVerificacionMD model = CodigoVerificacionDAO.getInstance().crearCodigo(request.getCedula(), "CORREO", request.getCorreo());		
		try {
			new Utilities().sendMail2(request.getCorreo(), model.getN_codigo(), "Verificar su identidad con este código de verificación", "8");
			//Actualizar resultado envio
			CodigoVerificacionMD codigo = new CodigoVerificacionMD();
			codigo.setK_codigo(model.getK_codigo());
			codigo.setA_anumnit(request.getCedula());
			codigo.setN_resultado(ResponseConstantes.RESULTADO_EXITOSO);
			CodigoVerificacionDAO.getInstance().actualizarResultadoEnvioCodigo(codigo);
		}
		catch(Exception ex){
			CodigoVerificacionMD codigo = new CodigoVerificacionMD();
			codigo.setK_codigo(model.getK_codigo());
			codigo.setA_anumnit(request.getCedula());
			codigo.setN_resultado("Error al enviar el código "+ex.getMessage());
			CodigoVerificacionDAO.getInstance().actualizarResultadoEnvioCodigo(codigo);
			throw new Exception("Error al enviar el código "+ex.getMessage());
		}

		ResponseCodigo response = new ResponseCodigo(
			model.getK_codigo(),
			model.getN_codigo(),
			model.getF_generacion(),
			model.getF_expiracion()
		);
		return response;
    }


	public ResponseCodigo enviarCodigoCelular(RequestEnviarCodigo request) throws Exception {

		List<CodigoVerificacionMD> listaCodigos = CodigoVerificacionDAO.getInstance().obtenerCodigosCedula(request.getCedula());

		if(listaCodigos != null && listaCodigos.size() > 0){
			for(CodigoVerificacionMD cv : listaCodigos){
				CodigoVerificacionMD codigo = new CodigoVerificacionMD();
				codigo.setK_codigo(cv.getK_codigo());
				codigo.setA_anumnit(cv.getA_anumnit());
				codigo.setI_expirado("Y");
				CodigoVerificacionDAO.getInstance().actualizarCodigo(codigo);
			}
		}		
		
		CodigoVerificacionMD model = CodigoVerificacionDAO.getInstance().crearCodigo(
			request.getCedula(), 
			"CELULAR", 
			request.getCelular());
			
		ParametrosGeneralesMD auth = CodigoVerificacionDAO.getInstance().obtenerCredencialesBasicApiSms();
		ParametrosGeneralesMD url = CodigoVerificacionDAO.getInstance().obtenerUrlApiSms();

		try{
			//JSON Request
			JSONObject obj = new JSONObject();
			obj.put("MessageText", "PRESENTE: Tu código de verificación es "+ model.getN_codigo());
			obj.put("TyPe", "Massive");
			obj.put("Devices", request.getCelular());
			obj.put("FlashSMS", "0");	
			
			//Instancia consumo web service, enviando url de consumo
			Network network = new Network(url.getN_value1());

			//Consumo de web service, parametros (Json, EndPoint, Base 64{clientId:secret})
			String resultApiSMS = network.writeService(obj, "MTMessage", 
					Base64.getEncoder().encodeToString(auth.getN_value1().getBytes()));
			//JSON Response
			JSONObject objResult = new JSONObject(resultApiSMS.toString());

			if(objResult.has("MessageText") && objResult.getString("MessageText").equals(ResponseConstantes.RESULTADO_EXITOSO) &&
				objResult.has("Status") && objResult.getInt("Status") == 0){
				CodigoVerificacionMD codigo = new CodigoVerificacionMD();
				codigo.setK_codigo(model.getK_codigo());
				codigo.setA_anumnit(request.getCedula());
				codigo.setN_resultado(ResponseConstantes.RESULTADO_EXITOSO);
				CodigoVerificacionDAO.getInstance().actualizarResultadoEnvioCodigo(codigo);
			}else{
				CodigoVerificacionMD codigo = new CodigoVerificacionMD();
				codigo.setK_codigo(model.getK_codigo());
				codigo.setA_anumnit(request.getCedula());
				codigo.setN_resultado(objResult.has("Error") && !objResult.isNull("Error") ? objResult.getString("Error") : "ERROR");
				CodigoVerificacionDAO.getInstance().actualizarResultadoEnvioCodigo(codigo);
				throw new Exception("Error al enviar el código "+
							(objResult.has("Error") && !objResult.isNull("Error") ? objResult.getString("Error") : ""));
			}
		} catch(Exception ex){
			CodigoVerificacionMD codigo = new CodigoVerificacionMD();
			codigo.setK_codigo(model.getK_codigo());
			codigo.setA_anumnit(request.getCedula());
			codigo.setN_resultado("Error al enviar el código "+ex.getMessage());
			CodigoVerificacionDAO.getInstance().actualizarResultadoEnvioCodigo(codigo);
			throw new Exception("Error al enviar el código "+ex.getMessage());
		}

		ResponseCodigo response = new ResponseCodigo(
			model.getK_codigo(),
			model.getN_codigo(),
			model.getF_generacion(),
			model.getF_expiracion()
		);
		return response;
	}


	 public ResponseCodigo enviarCodigoRegistrado(RequestEnviarCodigo request) throws Exception {
		List<CodigoVerificacionMD> listaCodigos = CodigoVerificacionDAO.getInstance().obtenerCodigosCedula(request.getCedula());
		if(listaCodigos != null && listaCodigos.size() > 0){
			for(CodigoVerificacionMD cv : listaCodigos){
				CodigoVerificacionMD codigo = new CodigoVerificacionMD();
				codigo.setK_codigo(cv.getK_codigo());
				codigo.setA_anumnit(cv.getA_anumnit());
				codigo.setI_expirado("Y");
				CodigoVerificacionDAO.getInstance().actualizarCodigo(codigo);
			}
		}
		//Tipo codigo 1:Email 2 : Celular
		ResponseCodigo response = new ResponseCodigo();
		if(request.getTipoCodigo() == 1) {
			ConsultaDatosAsociadoMD asociado = DatosAsociadoDAO.getInstance().consultarDatosAsociado(request.getCedula());
			request.setCorreo(asociado.getVd_email());
			response = enviarCodigoEmail(request);
		}else if(request.getTipoCodigo() == 2) {
			ConsultaDatosAsociadoMD asociado = DatosAsociadoDAO.getInstance().consultarDatosAsociado(request.getCedula());
			request.setCelular(asociado.getVt_celular());
			response = enviarCodigoCelular(request);
		}else {
			throw new Exception("Tipo de código no valido");
		}	
		return response;
	}

	

	public ResponseValidarCodigo validarCodigo(RequestValidarCodigo request) throws Exception {
		CodigoVerificacionMD model = CodigoVerificacionDAO.getInstance().obtenerCodigo(new CodigoVerificacionMD(
			request.getIdCodigoEnviado(),
			request.getCedula()
		));
		ResponseValidarCodigo response = new ResponseValidarCodigo();
		if(model != null && model.getN_codigo() != null && model.getN_codigo().equals(request.getCodigoIngresado())){
			
			if (model.getI_expirado().equals("N")) {
				long timeoutMinutos = 3L;
				long diferenciaMinutos = getDiferenciaMinutos(model.getF_generacion());
				if (diferenciaMinutos >= timeoutMinutos) {
					model = new CodigoVerificacionMD();
					model.setK_codigo(request.getIdCodigoEnviado());
					model.setA_anumnit(request.getCedula());
					model.setI_expirado("Y");
					CodigoVerificacionDAO.getInstance().actualizarCodigo(model);
					response = new ResponseValidarCodigo(
						ResponseConstantes.CAMPO_TRUE,
						ResponseConstantes.CAMPO_TRUE
					);
				}else{
					response = new ResponseValidarCodigo(
						ResponseConstantes.CAMPO_TRUE,
						ResponseConstantes.CAMPO_FALSE
					);
				}
			} else if (model.getI_expirado().equals("Y")){
				response = new ResponseValidarCodigo(
					ResponseConstantes.CAMPO_TRUE,
					ResponseConstantes.CAMPO_TRUE
				);
			}
		} else {
			response = new ResponseValidarCodigo(
				ResponseConstantes.CAMPO_FALSE,
				ResponseConstantes.CAMPO_FALSE
			);
		}
		return response;
	}

	private static long getDiferenciaMinutos(Date fechaHoraDesde) {
		Date fechaActual = new Date();
		long diferenciaMilisegundos = fechaActual.getTime() - fechaHoraDesde.getTime();
		long diferenciaMinutos = diferenciaMilisegundos / 1000L / 60L;
		return diferenciaMinutos;
	  }

}
