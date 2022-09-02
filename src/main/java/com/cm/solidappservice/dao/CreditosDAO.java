package com.cm.solidappservice.dao;

import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.creditos.bd.*;
import com.cm.solidappservice.model.creditos.request.*;
import com.cm.solidappservice.model.datosasociado.bd.DatosAsociadoMD;
import com.cm.solidappservice.model.datosasociado.bd.DatosPersonalesMD;

import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class CreditosDAO extends DAO2 {

	private static com.cm.solidappservice.dao.CreditosDAO singleton = null;  
	private static final String QUERY_OBTENER_CREDITOS = "CreditosMapper.obtenerModalidadesCreditos";  
	private static final String QUERY_OBTENER_DATOS_ASOCIADO = "CreditosMapper.obtenerDatosAsociadoFunction";	
	private static final String QUERY_OBTENER_DATOS_DEL_ASOCIADO = "CreditosMapper.obtenerDatosAsociado"; //DatosAsociado2  

	private static final String QUERY_RADICAR_CREDITO = "CreditosMapper.radicarCreditos";  
	private static final String QUERY_GUARDAR_INFORMACION_CREDITO = "CreditosMapper.guardarInformacionCredito";  
	private static final String QUERY_GUARDAR_REFS_CREDITOS = "CreditosMapper.guardarReferencia";

	private static final String QUERY_OBTENER_GESTOR_ASOCIADO = "CreditosMapper.obtenerGestorAsociadoFunction";

	private static final String QUERY_OBTENER_PAISES = "CreditosMapper.obtenerPaises";
	private static final String QUERY_OBTENER_DEPARTAMENTOS = "CreditosMapper.obtenerDepartamentos";
	private static final String QUERY_OBTENER_CIUDADES = "CreditosMapper.obtenerCiudades";

	private static final String QUERY_OBTENER_CREDITOSRADICADOS = "CreditosMapper.cargarCreditosRadicados";  

	private static final String QUERY_OBTENER_PARENTESCOS = "CreditosMapper.obtenerParentescos";
	
	private static final String QUERY_OBTENER_UBICACIONES_DEPRECATED = "CreditosMapper.cargarCiudadesDepartamentos";  
	// private static final String QUERY_RADICAR_CREDITOS = "CreditosMapper.radicarCreditos";  
	// private static final String QUERY_GUARDAR_INFO_CREDITO = "CreditosMapper.guardarInfo";  


	public static com.cm.solidappservice.dao.CreditosDAO getInstance() {
		if (singleton == null)
		try {
			synchronized (com.cm.solidappservice.dao.CreditosDAO.class) {
			if (singleton == null)
				singleton = new com.cm.solidappservice.dao.CreditosDAO(); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return singleton;
	}
	
	public List<LineasCreditoMD> obtenerCreditos() throws Exception {
		return getList(QUERY_OBTENER_CREDITOS, null);
	}
	
	public DatosAsociadoMD obtenerDatosAsosiado(RequestAutenticacion request) throws Exception {
		DatosAsociadoMD datos = new DatosAsociadoMD();
		datos.setV_AANUMNIT(request.getCedula());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_OBTENER_DATOS_ASOCIADO, datos);
		} finally {
			session.close();
		} 
		return datos;
	}

	//Datos del asociado 2
	public DatosPersonalesMD obtenerDatosAsosiadoV2(RequestAutenticacion request) throws Exception {
		DatosPersonalesMD datos = new DatosPersonalesMD();
		datos.setV_aanumnit(request.getCedula());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_OBTENER_DATOS_DEL_ASOCIADO, datos);
		} finally {
			session.close();
		}
		return datos;
	}
	

	//EN DESUSO PROXIMAMENTE
	public String radicarCreditoDeprecated(RequestRadicarCreditoDeprecated request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		SolicitudCreditoMD model = new SolicitudCreditoMD(
			request.getCedula(),
			id,
			request.getCedula(),
			request.getN_apell1() == null ? "" : request.getN_apell1(),
			request.getN_apell2() == null ? "" : request.getN_apell2(),
			request.getN_nombr1() == null ? "" : request.getN_nombr1(),
			request.getN_nombr2() == null ? "" : request.getN_nombr2(),
			request.getT_telfijo() == null ? "" : request.getT_telfijo(),
			request.getT_tercel() == null ? "" : request.getT_tercel(),
			request.getN_barrio() == null ? "" : request.getN_barrio(),
			request.getD_direc() == null ? "" : request.getD_direc(),
			request.getD_email() == null ? "" : request.getD_email(),
			request.getN_ciudad() == null ? "" : request.getN_ciudad(),
			request.getK_ciudad() == null ? "" : request.getK_ciudad(),
			request.getK_depart() == null ? "" : request.getK_depart(),
			request.getI_tipvivienda() == null ? "" : request.getI_tipvivienda(),
			request.getI_estciv() == null ? "" : request.getI_estciv(),
			request.getK_coddependencia() == null ? "" : request.getK_coddependencia(),
			request.getK_regional() == null ? "" : request.getK_regional(),
			request.getF_antig() == null ? "" : request.getF_antig(),
			request.getK_linea() == null ? "" : request.getK_linea(),
			request.getI_formaentrega() == null ? "" : request.getI_formaentrega(),
			request.getN_observacion() == null ? "" : request.getN_observacion(),
			request.getI_aceptacon() == null ? "" : request.getI_aceptacon(),
			request.getF_solicitud() == null ? "" : request.getF_solicitud(),
			request.getN_canal() == null ? "" : request.getN_canal(),
			request.getF_logeo() == null ? "" : request.getF_logeo(),
			request.getIp() == null ? "" : request.getIp(),
			request.getV_salario(),
			request.getV_solicitado(),
			"" 
		);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_RADICAR_CREDITO, model);
		} finally {
			session.close();
		} 
		return id;
	}
	//EN DESUSO PROXIMAMENTE
	public String radicarCreditoDeprecated2(RequestRadicarCreditoDeprecated2 request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		SolicitudCreditoMD model = new SolicitudCreditoMD(
			request.getCedula(),
			id,
			request.getCedula(),
			request.getPrimerApellido() == null ? "" : request.getPrimerApellido(),
			request.getSegundoApellido() == null ? "" : request.getSegundoApellido(),
			request.getPrimerNombre() == null ? "" : request.getPrimerNombre(),
			request.getSegundoNombre() == null ? "" : request.getSegundoNombre(),
			request.getTelefonoFijo() == null ? "" : request.getTelefonoFijo(),
			request.getTelefonoCelular() == null ? "" : request.getTelefonoCelular(),
			request.getBarrio() == null ? "" : request.getBarrio(),
			request.getDireccion() == null ? "" : request.getDireccion(),
			request.getEmail() == null ? "" : request.getEmail(),
			request.getNombreCiudad() == null ? "" : request.getNombreCiudad(),
			request.getIdCiudad() == null ? "" : request.getIdCiudad(),
			request.getIdDepartamento() == null ? "" : request.getIdDepartamento(),
			request.getTipoVivienda() == null ? "" : request.getTipoVivienda(),
			request.getEstadoCivil() == null ? "" : request.getEstadoCivil(),
			request.getIdDependencia() == null ? "" : request.getIdDependencia(),
			request.getIdRegional() == null ? "" : request.getIdRegional(),
			request.getFechaAntiguedad() == null ? "" : request.getFechaAntiguedad(),
			request.getIdLinea() == null ? "" : request.getIdLinea(),
			request.getFormaEntrega() == null ? "" : request.getFormaEntrega(),
			request.getObservacion() == null ? "" : request.getObservacion(),
			request.getAceptaTerminos() == null ? "" : request.getAceptaTerminos(),
			request.getFechaSolicitud() == null ? "" : request.getFechaSolicitud(),
			request.getCanal() == null ? "" : request.getCanal(),
			request.getFechaLogueo() == null ? "" : request.getFechaLogueo(),
			request.getIp() == null ? "" : request.getIp(),
			request.getValorSueldo(),
			request.getValorSolicitado(),
			request.getCodigoReserva() == null ? "" : request.getCodigoReserva()
		);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_RADICAR_CREDITO, model);
		} finally {
			session.close();
		} 
		return id;
	}
	public String radicarCredito(RequestSolicitudCredito request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		SolicitudCreditoMD model = new SolicitudCreditoMD(
			request.getCedula(),
			id,
			request.getCedula(),
			request.getPrimerApellido() == null ? "" : request.getPrimerApellido(),
			request.getSegundoApellido() == null ? "" : request.getSegundoApellido(),
			request.getPrimerNombre() == null ? "" : request.getPrimerNombre(),
			request.getSegundoNombre() == null ? "" : request.getSegundoNombre(),
			request.getTelefonoFijo() == null ? "" : request.getTelefonoFijo(),
			request.getTelefonoCelular() == null ? "" : request.getTelefonoCelular(),
			request.getBarrio() == null ? "" : request.getBarrio(),
			request.getDireccion() == null ? "" : request.getDireccion(),
			request.getEmail() == null ? "" : request.getEmail(),
			request.getNombreCiudad() == null ? "" : request.getNombreCiudad(),
			request.getIdCiudad() == null ? "" : request.getIdCiudad(),
			request.getIdDepartamento() == null ? "" : request.getIdDepartamento(),
			request.getTipoVivienda() == null ? "" : request.getTipoVivienda(),
			request.getEstadoCivil() == null ? "" : request.getEstadoCivil(),
			request.getIdDependencia() == null ? "" : request.getIdDependencia(),
			request.getIdRegional() == null ? "" : request.getIdRegional(),
			request.getFechaAntiguedad() == null ? "" : request.getFechaAntiguedad(),
			request.getIdLinea() == null ? "" : request.getIdLinea(),
			request.getFormaEntrega() == null ? "" : request.getFormaEntrega(),
			request.getObservacion() == null ? "" : request.getObservacion(),
			request.getAceptaTerminos() == null ? "" : request.getAceptaTerminos(),
			request.getFechaSolicitud() == null ? "" : request.getFechaSolicitud(),
			request.getCanal() == null ? "" : request.getCanal(),
			request.getFechaLogueo() == null ? "" : request.getFechaLogueo(),
			request.getIp() == null ? "" : request.getIp(),
			request.getValorSueldo(),
			request.getValorSolicitado(),
			request.getreferenciaHotel() == null ? "" : request.getreferenciaHotel()		
		);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_RADICAR_CREDITO, model);
		} finally {
			session.close();
		} 
		return id;
	}


	//EN DESUSO PROXIMAMENTE
	public String guardarInformacionCreditodDeprecated(RequestInformacionCreditoDeprecated request) throws Exception {
		InformacionCreditoMD model = new InformacionCreditoMD(
			request.getK_solicitud(),
			request.getI_otrosingresos() == null ? "" : request.getI_otrosingresos(),
			request.getV_otrosingresos() == null ? 0 : request.getV_otrosingresos(),
			request.getV_egresos() == null ? 0 : request.getV_egresos(),
			request.getI_tienevehiculo() == null ? "" : request.getI_tienevehiculo(),
			request.getO_placa() == null ? "" : request.getO_placa(),
			request.getV_vehiculo() == null ? 0 : request.getV_vehiculo(),
			request.getN_prendaafovorde() == null ? "" : request.getN_prendaafovorde(),
			request.getI_tienepropiedad() == null ? "" : request.getI_tienepropiedad(),
			request.getN_direpropiedad() == null ? "" : request.getN_direpropiedad(),
			request.getN_ciudadpropi() == null ? "" : request.getN_ciudadpropi(),
			request.getN_departpropi() == null ? "" : request.getN_departpropi(),
			request.getV_comercialpropi() == null ? 0 : request.getV_comercialpropi(),
			request.getN_hipoteca() == null ? "" : request.getN_hipoteca(),
			request.getV_activos() == null ? 0 : request.getV_activos(),
			request.getV_pasivos() == null ? 0 : request.getV_pasivos(),
			request.getV_patrimonio() == null ? 0 : request.getV_patrimonio()
		);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_GUARDAR_INFORMACION_CREDITO, model);
		} finally {
			session.close();
		} 
		return ResponseConstantes.RESULTADO_EXITOSO;
	}
	//EN DESUSO PROXIMAMENTE
	public String guardarInformacionCreditodDeprecated2(InformacionCredito datosCredito, String idSolicitud) throws Exception {
		InformacionCreditoMD model = new InformacionCreditoMD(
			idSolicitud,
			datosCredito.getTieneOtrosIngresos() == null ? "" : datosCredito.getTieneOtrosIngresos(),
			datosCredito.getValorOtrosIngresos() == null ? 0 : datosCredito.getValorOtrosIngresos(),
			datosCredito.getValorEgresos() == null ? 0 : datosCredito.getValorEgresos(),
			datosCredito.getTieneVehiculo() == null ? "" : datosCredito.getTieneVehiculo(),
			datosCredito.getPlaca() == null ? "" : datosCredito.getPlaca(),
			datosCredito.getValorVehiculo() == null ? 0 : datosCredito.getValorVehiculo(),
			datosCredito.getPrenda() == null ? "" : datosCredito.getPrenda(),
			datosCredito.getTienePropiedad() == null ? "" : datosCredito.getTienePropiedad(),
			datosCredito.getDireccionPropiedad() == null ? "" : datosCredito.getDireccionPropiedad(),
			datosCredito.getCiudadPropiedad() == null ? "" : datosCredito.getCiudadPropiedad(),
			datosCredito.getDepartamentoPropiedad() == null ? "" : datosCredito.getDepartamentoPropiedad(),
			datosCredito.getValorComercialPropiedad() == null ? 0 : datosCredito.getValorComercialPropiedad(),
			datosCredito.getHipoteca() == null ? "" : datosCredito.getHipoteca(),
			datosCredito.getValorActivos() == null ? 0 : datosCredito.getValorActivos(),
			datosCredito.getValorPasivos() == null ? 0 : datosCredito.getValorPasivos(),
			datosCredito.getValoPatrimonio() == null ? 0 : datosCredito.getValoPatrimonio()
		);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_GUARDAR_INFORMACION_CREDITO, model);
		} finally {
			session.close();
		} 
		return ResponseConstantes.RESULTADO_EXITOSO;
	}
	public String guardarInformacionCredito(RequestSolicitudCredito request, String idSolicitud) throws Exception {
		InformacionCredito datosCredito = request.getInformacionCredito();
		InformacionCreditoMD model = new InformacionCreditoMD(
			idSolicitud,
			datosCredito.getTieneOtrosIngresos() == null ? "" : datosCredito.getTieneOtrosIngresos(),
			datosCredito.getValorOtrosIngresos() == null ? 0 : datosCredito.getValorOtrosIngresos(),
			datosCredito.getValorEgresos() == null ? 0 : datosCredito.getValorEgresos(),
			datosCredito.getTieneVehiculo() == null ? "" : datosCredito.getTieneVehiculo(),
			datosCredito.getPlaca() == null ? "" : datosCredito.getPlaca(),
			datosCredito.getValorVehiculo() == null ? 0 : datosCredito.getValorVehiculo(),
			datosCredito.getPrenda() == null ? "" : datosCredito.getPrenda(),
			datosCredito.getTienePropiedad() == null ? "" : datosCredito.getTienePropiedad(),
			datosCredito.getDireccionPropiedad() == null ? "" : datosCredito.getDireccionPropiedad(),
			datosCredito.getCiudadPropiedad() == null ? "" : datosCredito.getCiudadPropiedad(),
			datosCredito.getDepartamentoPropiedad() == null ? "" : datosCredito.getDepartamentoPropiedad(),
			datosCredito.getValorComercialPropiedad() == null ? 0 : datosCredito.getValorComercialPropiedad(),
			datosCredito.getHipoteca() == null ? "" : datosCredito.getHipoteca(),
			datosCredito.getValorActivos() == null ? 0 : datosCredito.getValorActivos(),
			datosCredito.getValorPasivos() == null ? 0 : datosCredito.getValorPasivos(),
			datosCredito.getValoPatrimonio() == null ? 0 : datosCredito.getValoPatrimonio()
		);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_GUARDAR_INFORMACION_CREDITO, model);
		} finally {
			session.close();
		} 
		return ResponseConstantes.RESULTADO_EXITOSO;
	}
	
	// public String infoCredito(RequestCreditoInfo parametros) throws Exception {
	// 	SqlSession session = getFactory().openSession();
	// 	try {
	// 		session.selectOne(QUERY_GUARDAR_INFO_CREDITO, parametros);
	// 		return ResponseConstantes.RESULTADO_EXITOSO;
	// 	} finally {
	// 		session.close();
	// 	} 
	// }

	public String guardarReferencias(ReferenciasCreditoMD parametros) throws Exception {
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_GUARDAR_REFS_CREDITOS, parametros);
		} finally {
			session.close();
		}
		return ResponseConstantes.RESULTADO_EXITOSO;
	}

	// public String guardarReferencias(RequestCreditoReferencia parametros) throws Exception {
	// 	SqlSession session = getFactory().openSession();
	// 	try {
	// 		session.selectOne(QUERY_GUARDAR_REFS_CREDITOS, parametros);
	// 		return ResponseConstantes.RESULTADO_EXITOSO;
	// 	} finally {
	// 		session.close();
	// 	} 
	// }

	public GestorAsociadoMD obtenerGestorAsosiado(RequestAutenticacion request) throws Exception {
		GestorAsociadoMD datos = new GestorAsociadoMD();
		datos.setIDENTIFICACION(request.getCedula());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_OBTENER_GESTOR_ASOCIADO, datos);
		} finally {
			session.close();
		} 
		return datos;
	}


	//EN DESUSO PROXIMAMENTE
	public List<UbicacionesMD> obtenerUbicacionesDeprecated() throws Exception {
		return getList(QUERY_OBTENER_UBICACIONES_DEPRECATED, null);
	}

	public List<UbicacionesMD> obtenerPaises() throws Exception {
		return getList(QUERY_OBTENER_PAISES, null);
	}

	public List<UbicacionesMD> obtenerDepartamentos(String idPais) throws Exception {
		return getList(QUERY_OBTENER_DEPARTAMENTOS, idPais);
	}

	public List<UbicacionesMD> obtenerCiudades(String idPais, String idDepartamento) throws Exception {
		UbicacionesMD model = new UbicacionesMD();
		model.setK_pais(idPais);
		model.setK_depart(idDepartamento);
		return getList(QUERY_OBTENER_CIUDADES, model);
	}

	// public List<UbicacionesMD> obtenerCiudadesDepartamentos() throws Exception {
	// 	return getList(QUERY_OBTENER_CIUDADESDPARTAMENTOS, null);
	// }
	
	public List<SolicitudCreditoMD> obtenerCreditosRadicados(String cedula) throws Exception {
		List<SolicitudCreditoMD> result = getList(QUERY_OBTENER_CREDITOSRADICADOS, cedula);
		return result;
	}

	public List<ParentescosMD> obtenerParentescos() throws Exception {
		return getList(QUERY_OBTENER_PARENTESCOS, null);
	}

}