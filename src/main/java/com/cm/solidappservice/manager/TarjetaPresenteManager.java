package com.cm.solidappservice.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cm.solidappservice.dao.ParametrosGeneralesDAO;
import com.cm.solidappservice.dao.TarjetaPresenteDAO;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.datosasociado.bd.DatosAsociadoMD;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;
import com.cm.solidappservice.model.tarjetapresente.bd.ActualizacionTarjetaMD;
import com.cm.solidappservice.model.tarjetapresente.bd.MotivoBloqueoTarjetaMD;
import com.cm.solidappservice.model.tarjetapresente.bd.ReposicionTarjetaMD;
import com.cm.solidappservice.model.tarjetapresente.bd.TarjetaMD;
import com.cm.solidappservice.model.tarjetapresente.request.RequestActualizarEstadoTarjeta;
import com.cm.solidappservice.model.tarjetapresente.request.RequestReposicionTarjeta;
import com.cm.solidappservice.model.tarjetapresente.request.RequestReposicionTarjetaDeprecated;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseDatosAsociadoTarjeta;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseDatosAsociadoTarjetaDeprecated;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseTarjeta;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseTarjetaDeprecated;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseValorReposicionTarjeta;
import com.cm.solidappservice.model.tarjetapresente.response.ResponseValorReposicionTarjetaDeprecated;
import com.cm.solidappservice.security.Encripcion;
import com.cm.solidappservice.utils.Utilities;

public class TarjetaPresenteManager {
    
    private static TarjetaPresenteManager singleton = null;

	public static TarjetaPresenteManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (TarjetaPresenteManager.class) {
					if (null == singleton) {
						singleton = new TarjetaPresenteManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	//EN DESUSO PROXIMAMENTE
	public List<ResponseTarjetaDeprecated> getListadoTarjetasDeprecated(RequestAutenticacion request) throws Exception {
		TarjetaMD model = new TarjetaMD();
		model.setAanumnit(request.getCedula());
		List<TarjetaMD> listModel = TarjetaPresenteDAO.getInstance().getListadoTarjetas(model);
		List<ResponseTarjetaDeprecated> response = new ArrayList<ResponseTarjetaDeprecated>();
		if(listModel != null && listModel.size()>0){
			for (TarjetaMD tarjetaMD : listModel) {
				ResponseTarjetaDeprecated tarjeta = new ResponseTarjetaDeprecated();
				tarjeta.setA_numcta(Encripcion.getInstance().encriptar(tarjetaMD.getA_numcta()));
				tarjeta.setA_obliga(Encripcion.getInstance().encriptar(tarjetaMD.getA_obliga()));
				tarjeta.setA_tipodr(tarjetaMD.getA_tipodr());
				tarjeta.setF_movim(Utilities.getFechaString(tarjetaMD.getF_movim()));
				tarjeta.setI_estado(tarjetaMD.getI_estado());
				tarjeta.setK_numpla(Encripcion.getInstance().encriptar(tarjetaMD.getK_numpla()));
				tarjeta.setK_mnumpl(Encripcion.getInstance().encriptar(tarjetaMD.getK_mnumpl()));
				tarjeta.setN_percol(tarjetaMD.getN_percol());
				tarjeta.setV_cupo(tarjetaMD.getV_cupo());
				response.add(tarjeta);
			}
		}
		return response;
	}
	public List<ResponseTarjeta> getListadoTarjetas(RequestAutenticacion request) throws Exception {
		TarjetaMD model = new TarjetaMD();
		model.setAanumnit(request.getCedula());
		List<TarjetaMD> listModel = TarjetaPresenteDAO.getInstance().getListadoTarjetas(model);
		List<ResponseTarjeta> response = new ArrayList<ResponseTarjeta>();
		if(listModel != null && listModel.size()>0){
			for (TarjetaMD tarjeta : listModel) {
				response.add(new ResponseTarjeta(
					tarjeta.getN_percol(), 
					Encripcion.getInstance().encriptar(tarjeta.getK_mnumpl()), 
					Encripcion.getInstance().encriptar(tarjeta.getK_numpla()), 
					tarjeta.getI_estado(), 
					tarjeta.getV_cupo(), 
					Encripcion.getInstance().encriptar(tarjeta.getA_numcta()), 
					tarjeta.getA_tipodr(), 
					Encripcion.getInstance().encriptar(tarjeta.getA_obliga()), 
					Utilities.getFechaString(tarjeta.getF_movim())
				));
			}
		}
		return response;
	}

	public void actualizarEstadoTarjeta(RequestActualizarEstadoTarjeta request) throws Exception {
		ActualizacionTarjetaMD model = new ActualizacionTarjetaMD();
		model.setAanumnit(request.getCedula());
		model.setF_solici(new Date());
		model.setI_estado(request.getEstado());
		model.setId_dispositivo(request.getId_dispositivo());
		model.setK_numpla(request.getNumeroTarjeta());
		model.setN_motivo(request.getMotivo());
		TarjetaPresenteDAO.getInstance().actualizarEstadoTarjeta(model);
	}

	public String[] getMotivosBloqueoTarjeta() throws Exception {
		List<MotivoBloqueoTarjetaMD> listModel = TarjetaPresenteDAO.getInstance().getMotivosBloqueoTarjeta();
		if (listModel != null) {
			String[] response = new String[listModel.size()];
			for (int i = 0; i < listModel.size(); i++) {
				response[i] = listModel.get(i).getN_codblo();
			}
			return response;
		} else {
			return new String[0];
		}
	}

	//EN DESUSO PROXIMAMENTE
	public ResponseValorReposicionTarjetaDeprecated getValorReposicionTarjetaDeprecated() throws Exception {
		ParametrosGeneralesMD model = ParametrosGeneralesDAO.getInstance().obtenerValorReposicionTarjeta();
		ResponseValorReposicionTarjetaDeprecated response = null;
		if(model != null){
			response = new ResponseValorReposicionTarjetaDeprecated();
			response.setK_parame(model.getK_parametro().toString());
			response.setN_parame(model.getN_parametro());
			response.setV_numeri(Integer.parseInt(model.getN_value1()));
		}
		return response;
	}
	public ResponseValorReposicionTarjeta getValorReposicionTarjeta() throws Exception {
		ParametrosGeneralesMD model = ParametrosGeneralesDAO.getInstance().obtenerValorReposicionTarjeta();
		ResponseValorReposicionTarjeta response = null;
		if(model != null){
			response = new ResponseValorReposicionTarjeta(Integer.parseInt(model.getN_value1()));
		}
		return response;
	}

	//EN DESUSO PROXIMAMENTE
	public String registrarReposicionTarjetaDeprecated(RequestReposicionTarjetaDeprecated request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		ReposicionTarjetaMD model = new ReposicionTarjetaMD();
		model.setK_reposicion(id);
		model.setIdentificacion(request.getCedula());
		model.setN_nombr1(request.getN_nombr1());
		model.setN_nombr2(request.getN_nombr2());
		model.setN_apell1(request.getN_apell1());
		model.setN_apell2(request.getN_apell2());
		model.setN_numplastico(request.getN_numplastico());
		model.setN_ciudad(request.getN_ciudad());
		model.setK_coddependencia(request.getK_coddependencia());
		model.setN_dependencia(request.getN_dependencia());
		model.setK_ccostos(request.getK_ccostos());
		model.setI_estpla(request.getI_estpla());
		model.setK_tipotransa(request.getK_tipotransa());
		model.setD_email(request.getD_email());
		model.setT_telcel(request.getT_telcel());
		model.setF_solicitud(request.getF_solicitud());
		model.setI_depmodificada(request.getI_depmodificada());
		TarjetaPresenteDAO.getInstance().registrarReposicionTarjeta(model);
		return ResponseConstantes.RESULTADO_EXITOSO;
	}
	public String registrarReposicionTarjeta(RequestReposicionTarjeta request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		ReposicionTarjetaMD model = new ReposicionTarjetaMD();
		model.setK_reposicion(id);
		model.setIdentificacion(request.getCedula());
		model.setN_nombr1(request.getPrimerNombre());
		model.setN_nombr2(request.getSegundoNombre());
		model.setN_apell1(request.getPrimerApellido());
		model.setN_apell2(request.getSegundoApellido());
		model.setN_numplastico(request.getNumeroPlastico());
		model.setN_ciudad(request.getNombreCiudad());
		model.setK_coddependencia(request.getCodigoDependencia());
		model.setN_dependencia(request.getNombreDependencia());
		model.setK_ccostos(request.getIdCentralCostos());
		model.setI_estpla(request.getEncargado());
		model.setK_tipotransa(request.getTipoTransaccion());
		model.setD_email(request.getEmail());
		model.setT_telcel(request.getTelefonoCelular());
		model.setF_solicitud(request.getFechaSolicitud());
		model.setI_depmodificada(request.getDependenciaModificada());
		TarjetaPresenteDAO.getInstance().registrarReposicionTarjeta(model);
		return ResponseConstantes.RESULTADO_EXITOSO;
	}

	public ResponseDatosAsociadoTarjetaDeprecated obtenerDatosAsosiadoTarjetaDeprecated(RequestAutenticacion request) throws Exception {
		DatosAsociadoMD model = TarjetaPresenteDAO.getInstance().obtenerDatosAsosiadoTarjeta(request.getCedula());
		return new ResponseDatosAsociadoTarjetaDeprecated(
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
	public ResponseDatosAsociadoTarjeta obtenerDatosAsosiadoTarjeta(RequestAutenticacion request) throws Exception {
		DatosAsociadoMD model = TarjetaPresenteDAO.getInstance().obtenerDatosAsosiadoTarjeta(request.getCedula());
		return new ResponseDatosAsociadoTarjeta(
			model.getCEDULA(),
			model.getN_APELL1(),
			model.getN_APELL2(),
			model.getN_NOMBR1(),
			model.getN_NOMBR2(),
			model.getN_CIUDAD().trim(),
			model.getCODIGODEPENDENCIA(),
			model.getN_DEPENDENCIA()
		);
	}

}
