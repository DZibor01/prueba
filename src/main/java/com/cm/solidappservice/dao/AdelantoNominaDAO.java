package com.cm.solidappservice.dao;

import com.cm.solidappservice.model.adelantonomina.bd.*;
import com.cm.solidappservice.model.adelantonomina.request.*;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;
import com.cm.solidappservice.utils.Utilities;

import java.sql.Timestamp;
import java.util.List;
import java.util.Date;
import org.apache.ibatis.session.SqlSession;

public class AdelantoNominaDAO extends DAO2 {

	private static com.cm.solidappservice.dao.AdelantoNominaDAO singleton = null;
	
	private static final String QUERY_VALIDAR_REQUISITOS = "AdelantoNominaMapper.validarParametrosFunction";
	private static final String QUERY_VALIDAR_NO_CUMPLE = "AdelantoNominaMapper.obtenerNoCumple";
	private static final String QUERY_OBTENER_VALORES = "AdelantoNominaMapper.obtenerValoresFunction";
	private static final String QUERY_OBTENER_VALORCOMISION = "AdelantoNominaMapper.obtenerValorComision";  
	private static final String QUERY_SOLICITAR_ADELANTAR_NOMINA = "AdelantoNominaMapper.adelantarNominaFunction";  
	private static final String QUERY_ADELANTAR_NOMINA_CONSULTA = "AdelantoNominaMapper.adelantarNominaConsultarSolicitud";  
	private static final String QUERY_ADELANTAR_NOMINA_INSERTAR = "AdelantoNominaMapper.insertarAdelantoN";  
	private static final String QUERY_ADELANTAR_NOMINA_ACTUALIZAR_DEPRECATED = "AdelantoNominaMapper.actualizarAdelantoNDeprecated";
	private static final String QUERY_ADELANTAR_NOMINA_ACTUALIZAR = "AdelantoNominaMapper.actualizarAdelantoN";
	private static final String QUERY_CONSULTAR_TIPS = "AdelantoNominaMapper.selectTips";  
	private static final String QUERY_CONSULTAR_MOVIMIENTOS = "AdelantoNominaMapper.obtenerMovimientos";  
	private final String QUERY_CREAR_REGISTRO_ADELANTO_NOMINA = "AdelantoNominaMapper.crearRegistroAdelantoNomina";  
	private static final String QUERY_ESTADO_ADELANTO = "ParametrosGeneralesMapper.cargarParametrosGenerales";
	
  
	public static com.cm.solidappservice.dao.AdelantoNominaDAO getInstance() {
		if (singleton == null)
		try {
			synchronized (com.cm.solidappservice.dao.AdelantoNominaDAO.class) {
			if (singleton == null)
				singleton = new com.cm.solidappservice.dao.AdelantoNominaDAO(); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return singleton;
	}
	
	public ValidarRequisitosMD validarRequisitos(String cedula) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		Date fecha = new Date();
		ValidarRequisitosMD model = new ValidarRequisitosMD();
		model.setK_supreq("1");
		model.setN_aanumnit(cedula);
		model.setK_modali("137");
		model.setF_corte(fecha);
		model.setK_identificador(id);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_VALIDAR_REQUISITOS, model);
		} finally {
			session.close();
		}
		return model;
	}
	
	public List<MotivosNoCumpleMD> obtenerMotivosNoCumpleDeprecated(RequestMotivosNoCumple request) throws Exception {
		MotivosNoCumpleMD model = new MotivosNoCumpleMD();
		model.setK_identificador(request.getK_identificador());
		model.setN_requisito(request.getN_requisito());
		List<MotivosNoCumpleMD> response = getList(QUERY_VALIDAR_NO_CUMPLE, model);
		return response;
	}
	public List<MotivosNoCumpleMD> obtenerMotivosNoCumple(String idValidacion, String nombreRequisito) throws Exception {
		MotivosNoCumpleMD model = new MotivosNoCumpleMD();
		model.setK_identificador(idValidacion);
		model.setN_requisito(nombreRequisito);
		List<MotivosNoCumpleMD> result = getList(QUERY_VALIDAR_NO_CUMPLE, model);
		return result;
	}

	public ValorComisionMD obtenerValorComision() throws Exception {
		return getObject(QUERY_OBTENER_VALORCOMISION, null);
	}
	
	public TopesMD obtenerTopes(String cedula) throws Exception {
		Date fecha = new Date();
		TopesMD model = new TopesMD();
		model.setN_aanumnit(cedula);
		model.setF_corte(fecha);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_OBTENER_VALORES, model);
		} finally {
			session.close();
		} 
		return model;
	}
	
	//EN DESUSO PROXIMAMENTE
	public SolicitarAdelantoNominaMD solicitarAdelantoDeprecated(RequestSolicitarAdelantoDeprecated request) throws Exception {
		SolicitarAdelantoNominaMD model = new SolicitarAdelantoNominaMD();
		model.setN_aanumnit(request.getCedula());
		model.setV_monto(request.getV_monto());
		model.setF_solici(request.getF_solici());
		model.setK_nroSolici(request.getK_nroSolici());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_SOLICITAR_ADELANTAR_NOMINA, model);
		} finally {
			session.close();
		} 
		return model;
	}
	public SolicitarAdelantoNominaMD solicitarAdelanto(RequestSolicitarAdelanto request, String idRegistro) throws Exception {
		SolicitarAdelantoNominaMD model = new SolicitarAdelantoNominaMD();
		model.setN_aanumnit(request.getCedula());
		model.setV_monto(request.getValorFinalSolicitado().toString());
		model.setF_solici(Utilities.getFechaString(new Date()));
		model.setK_nroSolici(idRegistro);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_SOLICITAR_ADELANTAR_NOMINA, model);
		} finally {
			session.close();
		} 
		return model;
	}
	

	//EN DESUSO PROXIMAMENTE
	public String registrarAdelantoNominaDeprecated(RequestAdelantoNomina request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		AdelantoNominaMD model = new AdelantoNominaMD();
		model.setK_transa(id);
		model.setAanumnit(request.getCedula());
		model.setF_solictud(!Utilities.IsNullOrEmpty(request.getF_solictud()) ? request.getF_solictud() : request.getF_solicitud());
		model.setV_solicitado(request.getV_solicitado());
		model.setV_valorcre(request.getV_valorcre());
		model.setV_cupo(request.getV_cupo());
		model.setI_estado(request.getI_estado());
		model.setN_error(request.getN_error());
		model.setK_flujo(request.getK_flujo());
		model.setI_aceptacion(request.getI_aceptacion());
		model.setF_aceptacion(request.getF_aceptacion());
		model.setIp(request.getIp());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ADELANTAR_NOMINA_INSERTAR, model);			
		} finally {
			session.close();
		}
		return id;
	}
	public String registrarAdelantoNomina(RequestSolicitarAdelanto request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		AdelantoNominaMD model = new AdelantoNominaMD();
		model.setK_transa(id);
		model.setAanumnit(request.getCedula());
		model.setF_solictud(request.getFechaSolicitud());
		model.setV_solicitado(request.getValorSolicitado());
		model.setV_valorcre(request.getValorFinalSolicitado());
		model.setV_cupo(request.getCupoTotal());
		model.setI_estado(request.getEstado());
		model.setN_error("");
		model.setK_flujo(0);
		model.setI_aceptacion(request.getAceptaTerminos());
		model.setF_aceptacion(request.getFechaAceptacion());
		model.setIp(request.getIp());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ADELANTAR_NOMINA_INSERTAR, model);
		} finally {
			session.close();
		} 
		return id;
	}
	

	//EN DESUSO PROXIMAMENTE
	public ConsultaSolicitudAdelantoMD procesarSolicitudAdelantoDeprecated(RequestProcesarSolicitudAdelantoDeprecated request) throws Exception {		
		ConsultaSolicitudAdelantoMD model = new ConsultaSolicitudAdelantoMD();
		model.setV_k_flujo(request.getV_k_flujo());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ADELANTAR_NOMINA_CONSULTA, model);
		} finally {
			session.close();
		}
		return model;
	}
	public ConsultaSolicitudAdelantoMD procesarSolicitudAdelanto(RequestProcesarSolicitudAdelanto request) throws Exception {		
		ConsultaSolicitudAdelantoMD model = new ConsultaSolicitudAdelantoMD();
		model.setV_k_flujo(request.getIdFlujo());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ADELANTAR_NOMINA_CONSULTA, model);
		} finally {
			session.close();
		}
		return model;
	}
	
	//EN DESUSO PROXIMAMENTE
	public String actualizarAdelantoDeprecated(RequestActualizarAdelantoNomina request) throws Exception {
		AdelantoNominaMD model = new AdelantoNominaMD();
		model.setAanumnit(request.getCedula());
		model.setK_flujo(request.getK_flujo());
		model.setI_estado(request.getI_estado());
		model.setN_error(request.getN_error());
		model.setK_tipodr(request.getK_tipodr());
		model.setK_numdoc(request.getK_numdoc());
		model.setF_primcuota(request.getF_primcuota());
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ADELANTAR_NOMINA_ACTUALIZAR_DEPRECATED, model);			
		} finally {
			session.close();
		}
		return ResponseConstantes.RESULTADO_EXITOSO;
	}
	public String actualizarAdelanto(AdelantoNominaMD model) throws Exception {
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ADELANTAR_NOMINA_ACTUALIZAR, model);
		} finally {
			session.close();
		} 
		return ResponseConstantes.RESULTADO_EXITOSO;
	}

	
	public List<AdelantoNominaMD> obtenerMovimientosAdelantoNomina(String cedula) throws Exception {
		List<AdelantoNominaMD> result = getList(QUERY_CONSULTAR_MOVIMIENTOS, cedula);
		return result;
	}

	public List<TipsMD> obtenerTipsFinancieros() throws Exception {
		return getList(QUERY_CONSULTAR_TIPS, null);
	}
	
	public String registrarLogsAdelantoNomina(LogErrorAdelantoNominaMD model) throws Exception {		
		SqlSession session = getFactory().openSession();
		try {						
			session.selectOne(QUERY_CREAR_REGISTRO_ADELANTO_NOMINA, model);
		} finally {
			session.close();
		} 
		return ResponseConstantes.RESULTADO_EXITOSO;
	}
	
	public ParametrosGeneralesMD obtenerEstadoAdelantoNomina() throws Exception {
		return getObject(QUERY_ESTADO_ADELANTO, 3);
	}

	public ParametrosGeneralesMD obtenerDependenciasActivasAN() throws Exception {
		return getObject(QUERY_ESTADO_ADELANTO, 5);
	}

}