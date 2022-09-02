package com.cm.solidappservice.manager;

import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.cm.solidappservice.dao.AdelantoNominaDAO;
import com.cm.solidappservice.model.adelantonomina.bd.*;
import com.cm.solidappservice.model.adelantonomina.request.*;
import com.cm.solidappservice.model.adelantonomina.response.*;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.mensajesinbox.request.RequestEnvioMensajeInbox;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;
import com.cm.solidappservice.utils.Utilities;

public class AdelantoNominaManager {
    
    private static AdelantoNominaManager singleton = null;

	public static AdelantoNominaManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (AdelantoNominaManager.class) {
					if (null == singleton) {
						singleton = new AdelantoNominaManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	//EN DESUSO PROXIMAMENTE
	public ResponseValidarRequisitosDeprecated validarRequisitosDeprecated(RequestAutenticacion autenticacion) throws Exception {
		ValidarRequisitosMD requisitios = AdelantoNominaDAO.getInstance().validarRequisitos(autenticacion.getCedula());
		return new ResponseValidarRequisitosDeprecated(
			requisitios.getK_supreq(),
			requisitios.getN_aanumnit(),
			requisitios.getK_modali(),
			requisitios.getF_corte(),
			requisitios.getK_identificador(),
			requisitios.getCumple()
		);
	}
	public ResponseValidarRequisitos validarRequisitos(RequestAutenticacion request) throws Exception {
		ValidarRequisitosMD model = AdelantoNominaDAO.getInstance().validarRequisitos(request.getCedula());
		ResponseValidarRequisitos response = new ResponseValidarRequisitos(
			model.getK_identificador(),
			model.getK_supreq(),
			model.getK_modali(),
			model.getF_corte(),
			model.getCumple(),
			null
		);
		
		if(model.getCumple().equals("NO_CUMPLE")){
			List<MotivosNoCumpleMD> motivosmd = obtenerMotivosNoCumple(response.getIdValidacion(), response.getCumpleRequisitos());
			System.out.print("Cantidad motivos"+motivosmd.size());
			List<NoCumple> motivos = new ArrayList<NoCumple>();
			String observacion = "";

			if(motivosmd != null && motivosmd.size()>0){
				for(MotivosNoCumpleMD mn : motivosmd){
					motivos.add(new NoCumple(
						mn.getF_evaluacion(),
						mn.getN_observacion()
					));
					observacion += ", "+mn.getN_observacion();
				}
				response.setMotivos(motivos);
			}

			registroLogsAdelantoNomina(
                new RequestRegistroLogs(
                    "ASOCIADO NO CUMPLE REQUISITOS",
                    "Asociado no cumple los requititos " + observacion
                )
            );
		}
		return response;
	}
	

	//EN DESUSO PROXIMAMENTE
	public List<ResponseMotivosNoCumple> obtenerMotivosNoCumpleDeprecated(RequestMotivosNoCumple nocumple) throws Exception {
		List<MotivosNoCumpleMD> listModel = AdelantoNominaDAO.getInstance().obtenerMotivosNoCumpleDeprecated(nocumple);
		List<ResponseMotivosNoCumple> response = new ArrayList<ResponseMotivosNoCumple>();
		for(MotivosNoCumpleMD item : listModel){
			response.add(
				new ResponseMotivosNoCumple(
					item.getK_aannumnit(),
					item.getN_requisito(),
					item.getN_cumple(),
					item.getN_observacion(),
					item.getK_identificador(),
					item.getF_evaluacion()
				)
			);
		}
		return response;
	}
	public List<MotivosNoCumpleMD> obtenerMotivosNoCumple(String idValidacion, String nombreRequisito) throws Exception {
		List<MotivosNoCumpleMD> obtenernocumple = AdelantoNominaDAO.getInstance().obtenerMotivosNoCumple(idValidacion, nombreRequisito);
		return obtenernocumple;
	}


	//EN DESUSO PROXIMAMENTE
	public ResponseValorComisionDeprecated obtenerValorComisionDeprecatend() throws Exception {
		ValorComisionMD model = AdelantoNominaDAO.getInstance().obtenerValorComision();
		return new ResponseValorComisionDeprecated(model.getValor());
	}
	public ResponseValorComision obtenerValorComision() throws Exception {
		ValorComisionMD response = AdelantoNominaDAO.getInstance().obtenerValorComision();
		return new ResponseValorComision(response.getValor());
	}


	//EN DESUSO PROXIMAMENTE
	public ResponseTopesDeprecated obtenerTopesDeprecated(RequestAutenticacion request) throws Exception {
		TopesMD model = AdelantoNominaDAO.getInstance().obtenerTopes(request.getCedula());
		return new ResponseTopesDeprecated(
			model.getF_corte(),
			model.getN_aanumnit(),
			model.getV_cupo(),
			model.getV_minimo(),
			model.getV_maximo()
		);
	}
	public ResponseTopes obtenerTopes(RequestAutenticacion request) throws Exception {
		TopesMD model = AdelantoNominaDAO.getInstance().obtenerTopes(request.getCedula());
		ResponseTopes response = new ResponseTopes(
			model.getF_corte(),
			model.getV_cupo(),
			model.getV_minimo(),
			model.getV_maximo()
		);
		return response;
	}


	//EN DESUSO PROXIMAMENTE
	public ResponseSolicitarAdelantoDeprecated solicitarAdelantoNominaDeprecated(RequestSolicitarAdelantoDeprecated request) throws Exception {
		SolicitarAdelantoNominaMD model = AdelantoNominaDAO.getInstance().solicitarAdelantoDeprecated(request);
		return new ResponseSolicitarAdelantoDeprecated(
			model.getN_aanumnit(),
			model.getV_monto(),
			model.getF_solici(),
			model.getK_nroSolici(),
			model.getN_resultado(),
			model.getN_error(),
			model.getV_k_flujo()
		);
	}
	public ResponseSolicitarAdelanto solicitarAdelanto(RequestSolicitarAdelanto request) throws Exception {	
		String idRegistro = obtenerIdRegistro(request);
		SolicitarAdelantoNominaMD model = AdelantoNominaDAO.getInstance().solicitarAdelanto(request, idRegistro);
		ResponseSolicitarAdelanto response = new ResponseSolicitarAdelanto(
			model.getV_monto(),
			model.getF_solici(),
			model.getV_k_flujo(),
			model.getN_resultado(),
			model.getN_error()
		);

		if(model.getN_resultado() != null && model.getN_resultado().equals("OK")){
			registroLogsAdelantoNomina(
                new RequestRegistroLogs(
                    "ADELANTO DE NOMINA EXITOSA",
                    "Número de flujo: " + model.getV_k_flujo()
                )
            );
		}
		return response;		
	}

	//EN DESUSO PROXIMAMENTE
	public String registrarAdelantoNomina(RequestAdelantoNomina request) throws Exception {
		String response = AdelantoNominaDAO.getInstance().registrarAdelantoNominaDeprecated(request);
		return response;
	}
	public String obtenerIdRegistro(RequestSolicitarAdelanto request) throws Exception {
		String idRegistro = AdelantoNominaDAO.getInstance().registrarAdelantoNomina(request);
		return idRegistro;
	}


	//EN DESUS PROXIMAMENTE
	public ResponseProcesarSolicitudAdelantoDeprecated procesarSolicitudAdelantoDeprecated(RequestProcesarSolicitudAdelantoDeprecated request) throws Exception {
		ConsultaSolicitudAdelantoMD model = AdelantoNominaDAO.getInstance().procesarSolicitudAdelantoDeprecated(request);
		return new ResponseProcesarSolicitudAdelantoDeprecated(
			model.getV_k_flujo(),
			model.getA_numnit(),
			model.getF_solici(),
			model.getV_solici(),
			model.getK_ano(),
			model.getK_sucurs(),
			model.getK_tipdoc(),
			model.getF_primera(),
			model.getK_numdoc(),
			model.getA_tipodr(),
			model.getA_obliga(),
			model.getN_resultado(),
			model.getN_error()
		);
	}
	public ResponseProcesarSolicitudAdelanto procesarSolicitudAdelanto(RequestProcesarSolicitudAdelanto request) throws Exception {
		ConsultaSolicitudAdelantoMD model = AdelantoNominaDAO.getInstance().procesarSolicitudAdelanto(request);
		ResponseProcesarSolicitudAdelanto response = new ResponseProcesarSolicitudAdelanto();
		if(model.getN_resultado() != null && !model.getN_resultado().equals("ERROR")){

			String actualizar = actualizarAdelantoNomina(
				new AdelantoNominaMD(
					request.getCedula(),
					"C",
					model.getN_error(),
					model.getA_tipodr(),
					model.getK_numdoc(),
					Utilities.getFechaString(model.getF_primera()),
					model.getV_k_flujo()
				)
			);
			if(actualizar.equals(ResponseConstantes.RESULTADO_EXITOSO)){
				
				Date fechaInicio = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fechaInicio);
				calendar.add(Calendar.DATE, 2);
				Date fechaFin  = calendar.getTime();

				MensajesInboxManager.getInstance().enviarMensajeInbox(
					new RequestEnvioMensajeInbox(
                            Utilities.getFechaString(fechaInicio),
                            Utilities.getFechaString(fechaFin),
                            "Solicitud de adelanto de nómina",
                            "El adelanto de nómina por el valor de $"+model.getV_solici()+" ha sido exitoso,"+
                            "válida la transacción en los movimientos de tu cuenta de nómina."
					)
				);
			}

		} 

		if(model.getN_resultado() != null && model.getN_resultado().equals("ERROR")){
			registroLogsAdelantoNomina(
                new RequestRegistroLogs(
                    "PROCESAR SOLICITUD DE ADELANTO DE NOMINA FALLIDO",
                    "Número de flujo: " + model.getV_k_flujo()+" "+model.getN_resultado()+": "+model.getN_error()
                )
            );
		}

		response = new ResponseProcesarSolicitudAdelanto(
			model.getV_k_flujo(),
			model.getF_solici(),
			model.getV_solici(),
			model.getK_ano(),
			model.getK_sucurs(),
			model.getK_numdoc(),
			model.getK_tipdoc(),
			model.getF_primera(),
			model.getA_tipodr(),
			model.getA_obliga(),
			model.getN_resultado(),
			model.getN_error()
		);
		return response;
	}
	

	//EN DESUSO PROXIMAMENTE
	public String actualizarAdelantoNominaDeprecated(RequestActualizarAdelantoNomina request) throws Exception {
		String response = AdelantoNominaDAO.getInstance().actualizarAdelantoDeprecated(request);
		return response;
	}
	public String actualizarAdelantoNomina(AdelantoNominaMD model) throws Exception {
		String response = AdelantoNominaDAO.getInstance().actualizarAdelanto(model);
		return response;
	}

	
	//EN DESUSO PROXIMAMENTE
	public List<ResponseMovimientosAdelantoDeprecated> obtenerMovimientosAdelantoDeprecated(RequestAutenticacion request) throws Exception {
		List<AdelantoNominaMD> listModel = AdelantoNominaDAO.getInstance().obtenerMovimientosAdelantoNomina(request.getCedula());
		List<ResponseMovimientosAdelantoDeprecated> response = new ArrayList<ResponseMovimientosAdelantoDeprecated>();
		SimpleDateFormat formatOrigen = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat formatDestino = new SimpleDateFormat("yyyy-MM-dd");
		if(listModel != null && listModel.size()>0){
			for(AdelantoNominaMD md : listModel){
				response.add(new ResponseMovimientosAdelantoDeprecated(
					md.getK_transa(),
					md.getAanumnit(),
					formatDestino.format(formatOrigen.parse(md.getF_solictud())),
					md.getV_solicitado(),
					md.getV_cupo(),
					md.getI_estado(),
					md.getN_error(),
					md.getK_tipodr(),
					md.getK_numdoc(),
					md.getV_valorcre(),
					md.getF_primcuota(),
					md.getK_flujo(),
					md.getI_aceptacion(),
					md.getF_aceptacion(),
					md.getIp()
				));
			}
		}
		return response;
	}
	public List<ResponseMovimientosAdelanto> obtenerMovimientosAdelanto(RequestAutenticacion request) throws Exception {
		List<AdelantoNominaMD> listModel = AdelantoNominaDAO.getInstance().obtenerMovimientosAdelantoNomina(request.getCedula());
		List<ResponseMovimientosAdelanto> response = new ArrayList<ResponseMovimientosAdelanto>();
		if(listModel != null && listModel.size() > 0){
			for(AdelantoNominaMD an : listModel){
				response.add(new ResponseMovimientosAdelanto(
					an.getK_transa(),
					an.getF_solictud(),
					an.getV_solicitado(),
					an.getV_valorcre(),
					an.getI_estado(),
					an.getV_cupo(),
					an.getK_flujo(),
					an.getK_numdoc(),
					an.getK_tipodr(),
					an.getF_primcuota(),
					an.getI_aceptacion(),
					an.getF_aceptacion(),
					an.getIp(),
					an.getN_error()
				));
			}
		}
		return response;
	}


	//EN DESUSO PROXIMAMENTE
	public List<ResponseTipsDeprecated> obtenerTipsFinancierosDeprecated() throws Exception {
		List<TipsMD> listModel = AdelantoNominaDAO.getInstance().obtenerTipsFinancieros();
		List<ResponseTipsDeprecated> response = new ArrayList<ResponseTipsDeprecated>();
		if(listModel != null && listModel.size()>0){
			for(TipsMD md : listModel){
				response.add(new ResponseTipsDeprecated(
					md.getK_TIP(),
					md.getN_TIP()
				));
			}
		}
		return response;
	}
	public List<ResponseTips> obtenerTipsFinancieros() throws Exception {
		List<TipsMD> tips = AdelantoNominaDAO.getInstance().obtenerTipsFinancieros();
		List<ResponseTips> response = new ArrayList<ResponseTips>();
		if(tips != null && tips.size() > 0){
			for(TipsMD tip : tips){
				response.add(new ResponseTips(
					tip.getK_TIP(),
					tip.getN_TIP()
				));
			}
		}
		return response;
	}
	
	//EN DESUSO PROXIMAMENTE
	public ResponseEstadoAdelantoDeprecated getEstadoAdelantoNominaDeprecated() throws Exception {
		ParametrosGeneralesMD model = AdelantoNominaDAO.getInstance().obtenerEstadoAdelantoNomina();
		ResponseEstadoAdelantoDeprecated response = null;
		if(model != null){
			response = new ResponseEstadoAdelantoDeprecated(
				model.getK_parametro().toString(),
				model.getI_estado()
			);
		}
		return response;
	}
	public ResponseDependenciasAdelantoNomina getDependenciasActivasDeprecated() throws Exception {
		ParametrosGeneralesMD model = AdelantoNominaDAO.getInstance().obtenerDependenciasActivasAN();
		ResponseDependenciasAdelantoNomina response = null;
		if(model != null){
			response = new ResponseDependenciasAdelantoNomina(
				model.getK_parametro().toString(),
				model.getN_value1()
			);
		}
		return response;
	}
	public ResponseEstadoAdelanto getEstadoAdelantoNomina() throws Exception {
		ParametrosGeneralesMD model = AdelantoNominaDAO.getInstance().obtenerEstadoAdelantoNomina();
		ResponseEstadoAdelanto response = new ResponseEstadoAdelanto(		
			model.getI_estado(),
			getDependenciasActivasAdelanto()
		);
		return response;
	}
	public String[] getDependenciasActivasAdelanto() throws Exception {
		ParametrosGeneralesMD model = AdelantoNominaDAO.getInstance().obtenerDependenciasActivasAN();
		String[] dependencias = null;
		if(model.getN_value1() != null && !model.getN_value1().isEmpty()){
			dependencias = model.getN_value1().split(";");
		}
		return dependencias;
	}


	//EN DESUSO PROXIMAMENTE
	public String registroLogsAdelantoNominaDeprecated(RequestRegistroLogsDeprecated request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		LogErrorAdelantoNominaMD model = new LogErrorAdelantoNominaMD();
		model.setK_log(id);
		model.setAanumnit(request.getCedula());
		model.setF_registro(request.getF_registro());
		model.setN_accion(request.getN_accion());
		model.setN_descr(request.getN_descr());
		String resp = AdelantoNominaDAO.getInstance().registrarLogsAdelantoNomina(model);
		return resp;
	}
	public String registroLogsAdelantoNomina(RequestRegistroLogs request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		LogErrorAdelantoNominaMD model = new LogErrorAdelantoNominaMD();
		model.setK_log(id);
		model.setAanumnit(request.getCedula());
		model.setF_registro(Utilities.getFechaString(new Date()));
		model.setN_accion(request.getTitulo());
		model.setN_descr(request.getDescripcion());
		String resp = AdelantoNominaDAO.getInstance().registrarLogsAdelantoNomina(model);
		return resp;
	}
}
