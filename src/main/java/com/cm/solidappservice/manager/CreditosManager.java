package com.cm.solidappservice.manager;

import java.util.ArrayList;
import java.util.List;

import com.cm.solidappservice.dao.*;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.creditos.bd.*;
import com.cm.solidappservice.model.creditos.request.*;
import com.cm.solidappservice.model.creditos.response.*;
import com.cm.solidappservice.model.datosasociado.bd.DatosAsociadoMD;
import com.cm.solidappservice.model.datosasociado.bd.DatosPersonalesMD;
import com.cm.solidappservice.model.datosasociado.response.ResponseDatosAsociado;
import com.cm.solidappservice.model.datosasociado.response.ResponseDatosAsociadoDeprecated;

public class CreditosManager {
    
    private static CreditosManager singleton = null;

	public static CreditosManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (CreditosManager.class) {
					if (null == singleton) {
						singleton = new CreditosManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	//EN DESUSO PROXIMAMENTE
	public List<ResponseLineasCreditoDeprecated> obtenerLineaCreditosDeprecated() throws Exception {
		List<LineasCreditoMD> listModel = CreditosDAO.getInstance().obtenerCreditos();
		List<ResponseLineasCreditoDeprecated> response = new ArrayList<ResponseLineasCreditoDeprecated>();
		if(listModel != null && listModel.size()>0){
			for(LineasCreditoMD linea : listModel){
				response.add(new ResponseLineasCreditoDeprecated(
					linea.getK_linea(),
					linea.getN_linea(),
					linea.getI_estado(),
					linea.getK_productoarco()
				));
			}
		}
		return response;
	}
	public List<ResponseLineasCredito> obtenerLineaCreditos() throws Exception {
		List<LineasCreditoMD> listModel = CreditosDAO.getInstance().obtenerCreditos();
		List<ResponseLineasCredito> response = new ArrayList<ResponseLineasCredito>();
		if(listModel != null && listModel.size()>0){
			for(LineasCreditoMD linea : listModel){
				response.add(new ResponseLineasCredito(
					linea.getK_linea(),
					linea.getN_linea(),
					linea.getI_estado(),
					linea.getK_productoarco()
				));
			}
		}
		return response;
	}


	//EN DESUSO PROXIMAMENTE
	public ResponseDatosAsociadoDeprecated obtenerDatosAsosiadoDeprecated(RequestAutenticacion request) throws Exception {
		DatosAsociadoMD model = CreditosDAO.getInstance().obtenerDatosAsosiado(request);
		return new ResponseDatosAsociadoDeprecated(
			model.getCEDULA(),
			model.getCEDULA(),
			model.getN_APELL1(),
			model.getN_APELL2(),
			model.getN_NOMBR1(),
			model.getN_NOMBR2(),
			model.getD_EMAIL(),
			model.getTELEFONOFIJO(),
			model.getCELULAR(),
			model.getDIRECCION(),
			model.getN_BARRIO(),
			model.getN_CIUDAD().trim(),
			model.getK_CIUDAD(),
			model.getK_DEPART(),
			model.getESTADOCIVIL(),
			model.getV_SUELDO(),
			model.getF_ANTIGU(),
			model.getCODIGODEPENDENCIA(),
			model.getN_DEPENDENCIA(),
			model.getCODIGOREGIONAL(),
			model.getN_REGIONAL()	
		);
	}
	public ResponseDatosAsociado obtenerDatosAsosiado(RequestAutenticacion request) throws Exception {
		DatosAsociadoMD model = CreditosDAO.getInstance().obtenerDatosAsosiado(request);
		return new ResponseDatosAsociado(
			model.getCEDULA(),
			model.getN_APELL1(),
			model.getN_APELL2(),
			model.getN_NOMBR1(),
			model.getN_NOMBR2(),
			model.getD_EMAIL(),
			model.getTELEFONOFIJO(),
			model.getCELULAR(),
			model.getDIRECCION(),
			model.getN_BARRIO(),
			model.getN_CIUDAD().trim(),
			model.getK_CIUDAD(),
			model.getK_DEPART(),
			model.getESTADOCIVIL(),
			model.getF_ANTIGU(),
			"",			
			model.getV_SUELDO(),
			"",			
			model.getCODIGODEPENDENCIA(),
			model.getN_DEPENDENCIA(),
			model.getCODIGOREGIONAL(),
			model.getN_REGIONAL()
		);
	}

	//Datos Asociado 2
	public ResponseDatosAsociado obtenerDatosAsosiadoV2(RequestAutenticacion request) throws Exception {
		DatosPersonalesMD model = CreditosDAO.getInstance().obtenerDatosAsosiadoV2(request);
		return new ResponseDatosAsociado(
			model.getV_aanumnit(),
			model.getN_apell1(),
			model.getN_apell2(),
			model.getN_nombr1(),
			model.getN_nombr2(),
			model.getD_email(),
			model.getT_fijo(),
			model.getT_celular(),
			model.getN_direccion(),
			model.getN_barrio(),
			model.getN_ciudad().trim(),
			model.getK_ciudad(),
			model.getK_depart(),
			model.getN_estciv(),
			model.getF_antigu(),
			model.getN_cargo(),			
			model.getV_sueldo(),
			model.getI_tipnom(),			
			model.getK_dependencia(),
			model.getN_dependencia(),
			model.getK_regional(),
			model.getN_regional()
		);
	}

	
	// public String guardarReferencias(RequestCreditoReferencia parametros) throws Exception {
	// 	String resultCredito = CreditosDAO.getInstance().guardarReferencias(parametros);
	// 	return resultCredito;
	// }

	public ResponseSolicitudCredito realizarSolicitudCredito(RequestSolicitudCredito request) throws Exception{
		ResponseSolicitudCredito response = new ResponseSolicitudCredito();
		String idRadicado = radicarCredito(request);

		if(idRadicado == null || idRadicado.isEmpty()){
			throw new Exception("Ha ocurrido un error realizando la solicitud de credito");
		}else{
			response.setIdRadicado(idRadicado);
			response.setCreditoRadicado(ResponseConstantes.RESULTADO_EXITOSO);

			if(request.getInformacionCredito() != null && request.getInformacionCredito() != new InformacionCredito()){
				response.setDatosCredito(guardarInformacionAdicional(request, idRadicado));
			} else {
				response.setDatosCredito("Esta línea no requiere información del crédito");
			}

			if(request.getReferencias() != null && request.getReferencias().size() > 0){
				response.setReferenciasCredito(guardarReferencias(request, idRadicado));
			} else{
				response.setReferenciasCredito("Esta línea no requiere referencias del crédito");
			}
		}
		return response;
	}


	//EN DESUSO PROXIMAMENTE
	public ResponseRadicadoDeprecated radicarCreditoDeprecated(RequestRadicarCreditoDeprecated request) throws Exception{
		String idSolicitud = CreditosDAO.getInstance().radicarCreditoDeprecated(request);
		return new ResponseRadicadoDeprecated(idSolicitud);
	}
	//EN DESUSO PROXIMAMENTE
	public ResponseRadicado radicarCreditoDeprecated2(RequestRadicarCreditoDeprecated2 request) throws Exception{
		String idSolicitud = CreditosDAO.getInstance().radicarCreditoDeprecated2(request);
		return new ResponseRadicado(idSolicitud);
	}
	public String radicarCredito(RequestSolicitudCredito request) throws Exception {		
		String idSolicitud = CreditosDAO.getInstance().radicarCredito(request);
		return idSolicitud;
	}	

	//EN DESUSO PROXIMAMENTE
	public String guardarInformacionAdicionalDeprecated(RequestInformacionCreditoDeprecated request) throws Exception {
		String response = CreditosDAO.getInstance().guardarInformacionCreditodDeprecated(request);
		return response;
	}
	//EN DESUSO PROXIMAMENTE
	public String guardarInformacionAdicionalDeprecated2(RequestInformacionCreditoDeprecated2 request) throws Exception {
		String response = CreditosDAO.getInstance().guardarInformacionCreditodDeprecated2(
			request.getInformacionCredito(),
			request.getIdRadicado()
		);
		return response;
	}
	public String guardarInformacionAdicional(RequestSolicitudCredito request, String idRadicado) throws Exception {		
		String response = CreditosDAO.getInstance().guardarInformacionCredito(request, idRadicado);	
		return response;
	}	


	//EN DESUSO PROXIMAMENTE
	public String guardarReferenciasDeprecated(RequestReferenciaCreditoDeprecated request) throws Exception {
		String resultCredito = "";
		resultCredito =  CreditosDAO.getInstance().guardarReferencias(new ReferenciasCreditoMD(
				request.getK_solicitud(),
				request.getK_referencia(),
				request.getN_nombreape(),
				request.getT_tercel() == null ? "" : request.getT_tercel(),
				request.getT_telfijo() == null ? "" : request.getT_telfijo(),
				request.getD_email() == null ? "" : request.getD_email(),
				request.getD_direc(),
				request.getN_ciudad(),
				request.getK_ciudad(),
				request.getK_depart(),
				""
			)
		);
		return resultCredito;
	}
	//EN DESUSO PROXIMAMENTE
	public String guardarReferenciasDeprecated2(RequestReferenciaCreditoDeprecated2 request) throws Exception {
		String resultCredito = "";
		for(ReferenciaCredito rc : request.getReferencias()){
			resultCredito =  CreditosDAO.getInstance().guardarReferencias(new ReferenciasCreditoMD(
					request.getIdRadicado(),
					rc.getIdReferencia(),
					rc.getNombreReferencia(),
					rc.getTelefonoCelular() == null ? "" : rc.getTelefonoCelular(),
					rc.getTelefonoFijo() == null ? "" : rc.getTelefonoFijo(),
					rc.getEmail() == null ? "" : rc.getEmail(),
					rc.getDireccion(),
					rc.getNombreCiudad(),
					rc.getIdCiudad(),
					rc.getIdDepartamento(),
					""
				)
			);
		}
		return resultCredito;
	}
	public String guardarReferencias(RequestSolicitudCredito request, String idRadicado) throws Exception {
		String resultCredito = "";
		for(ReferenciaCredito rc : request.getReferencias()){
			resultCredito =  CreditosDAO.getInstance().guardarReferencias(new ReferenciasCreditoMD(
					idRadicado,
					rc.getIdReferencia(),
					rc.getNombreReferencia(),
					rc.getTelefonoCelular() == null ? "" : rc.getTelefonoCelular(),
					rc.getTelefonoFijo() == null ? "" : rc.getTelefonoFijo(),
					rc.getEmail() == null ? "" : rc.getEmail(),
					rc.getDireccion(),
					rc.getNombreCiudad(),
					rc.getIdCiudad(),
					rc.getIdDepartamento(),
					rc.getParentesco()
				)
			);
		}
		return resultCredito;
	}


	//EN DESUS PROXIMAMENTE
	public ResponseGestorAsociadoDeprecated obtenerGestorAsosiadoDeprecated(RequestAutenticacion request) throws Exception {
		GestorAsociadoMD model = CreditosDAO.getInstance().obtenerGestorAsosiado(request);
		return new ResponseGestorAsociadoDeprecated(
			model.getIDENTIFICACION(),
			model.getCEDGESTOR(),
			model.getNOMBGESTOR(),
			model.getIDTERCERO()
		);
	}
	public ResponseGestorAsociado obtenerGestorAsosiado(RequestAutenticacion request) throws Exception {
		GestorAsociadoMD model = CreditosDAO.getInstance().obtenerGestorAsosiado(request);
		return new ResponseGestorAsociado(
			model.getIDTERCERO(),
			model.getCEDGESTOR(),
			model.getNOMBGESTOR()
		);
	}


	//EN DESUS PROXIMAMENTE
	public List<ResponseUbicacionesDeprecated> obtenerUbicacionesDeprecated() throws Exception {
		List<UbicacionesMD> ubicaciones = CreditosDAO.getInstance().obtenerUbicacionesDeprecated();	
		List<ResponseUbicacionesDeprecated> response = new ArrayList<ResponseUbicacionesDeprecated>();		
		if(ubicaciones != null && ubicaciones.size()>0){
			for(UbicacionesMD ubicacion : ubicaciones){
				response.add(new ResponseUbicacionesDeprecated(
					ubicacion.getK_ciudad(),
					ubicacion.getN_ciudad().trim(),
					ubicacion.getK_depart(),
					ubicacion.getN_depart(),
					ubicacion.getK_pais(),
					ubicacion.getN_pais()
				));
			}
		}
		return response;
	}
	public ResponseUbicaciones obtenerUbicaciones() throws Exception {
		ResponseUbicaciones response = new ResponseUbicaciones();		
		response.setPaises(obtenerPaises());
		return response;
	}
	
	public List<Pais> obtenerPaises()throws Exception {
		List<UbicacionesMD> ubicaciones = CreditosDAO.getInstance().obtenerPaises();	
		List<Pais> paises = new ArrayList<Pais>();
		if(ubicaciones != null && ubicaciones.size()>0){
			for(UbicacionesMD ub : ubicaciones){
				paises.add(
					new Pais(
						ub.getK_pais(),
						ub.getN_pais(),
						obtenerDepartamentos(ub.getK_pais())
					)
				);
			}
		}
		return paises;
	}

	public List<Departamento> obtenerDepartamentos(String idPais) throws Exception {	
		List<UbicacionesMD> ubicaciones = CreditosDAO.getInstance().obtenerDepartamentos(idPais);	
		List<Departamento> departamentos = new ArrayList<Departamento>();
		if(ubicaciones != null && ubicaciones.size() > 0){
			for(UbicacionesMD ub : ubicaciones){
				departamentos.add(
					new Departamento(
						ub.getK_depart(),
						ub.getN_depart(),
						obtenerCiudades(idPais, ub.getK_depart())
					)
				);
			}
		}
		return departamentos;
	}

	public List<Ciudad> obtenerCiudades(String idPais, String idDepartamento) throws Exception {
		List<UbicacionesMD> ubicaciones = CreditosDAO.getInstance().obtenerCiudades(idPais, idDepartamento);	
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		if(ubicaciones != null && ubicaciones.size() > 0){
			for(UbicacionesMD ub : ubicaciones){
				ciudades.add(
					new Ciudad(
						ub.getK_ciudad(),
						ub.getN_ciudad().trim()
					)
				);
			}
		}
		return ciudades;
	}

	// public List<UbicacionesMD> obtenerCiudadesDepartamentos(RequestAutenticacion autenticacion) throws Exception {
	// 	List<UbicacionesMD> ciudadesDepartamentos = CreditosDAO.getInstance().obtenerCiudadesDepartamentos();
	// 	return ciudadesDepartamentos;
	// }

	//EN DESUSO PROXIMAMENTE
	public List<ResponseCreditosRadicadosDeprecated> obtenerCreditosRadicadosDeprecated(RequestAutenticacion request) throws Exception {
		List<SolicitudCreditoMD> model = CreditosDAO.getInstance().obtenerCreditosRadicados(request.getCedula());
		List<ResponseCreditosRadicadosDeprecated> response = new ArrayList<ResponseCreditosRadicadosDeprecated>();
		if(model != null && model.size() > 0){
			for(SolicitudCreditoMD sc : model){
				response.add(new ResponseCreditosRadicadosDeprecated(
					sc.getK_solicitud(),
					sc.getK_linea() == null ? "" : sc.getK_linea(),
					sc.getV_solicitado(),
					sc.getF_solicitud() == null ? "" : sc.getF_solicitud(),
					sc.getI_formaentrega() == null ? "" : sc.getI_formaentrega()
				));
			}
		}
		return response;
	}
	public List<ResponseCreditosRadicados> obtenerCreditosRadicados(RequestAutenticacion request) throws Exception {
		List<SolicitudCreditoMD> model = CreditosDAO.getInstance().obtenerCreditosRadicados(request.getCedula());
		List<ResponseCreditosRadicados> response = new ArrayList<ResponseCreditosRadicados>();
		if(model != null && model.size() > 0){
			for(SolicitudCreditoMD sc : model){
				response.add(new ResponseCreditosRadicados(
					sc.getK_solicitud(),
					sc.getK_linea(),
					sc.getI_formaentrega(),
					sc.getF_solicitud(),
					sc.getV_solicitado()
				));
			}
		}
		return response;
	}

	public List<ResponseParentescos> obtenerParentescos(RequestAutenticacion autenticacion) throws Exception {
		List<ParentescosMD> model = CreditosDAO.getInstance().obtenerParentescos();
		List<ResponseParentescos> response = new ArrayList<ResponseParentescos>();
		if(model != null && model.size() > 0){
			for(ParentescosMD pa : model){
				response.add(new ResponseParentescos(
					pa.getRv_abbreviation(),
					pa.getRv_meaning()
				));
			}
		}
		return response;
	}


}
