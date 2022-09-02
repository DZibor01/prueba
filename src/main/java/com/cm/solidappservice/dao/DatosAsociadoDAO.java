package com.cm.solidappservice.dao;

import java.sql.Timestamp;
import java.util.List;

import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.datosasociado.bd.ActualizaDatosAsociadoMD;
import com.cm.solidappservice.model.datosasociado.bd.ConsultaDatosAsociadoMD;
import com.cm.solidappservice.model.datosasociado.bd.DatosBasicosAsociadoMD;
import com.cm.solidappservice.model.datosasociado.bd.FormatoDireccionesMD;
import com.cm.solidappservice.model.datosasociado.bd.RegistraDatosActualizadosMD;
import com.cm.solidappservice.model.datosasociado.request.RequestActualizarDatos;

import org.apache.ibatis.session.SqlSession;

public class DatosAsociadoDAO extends DAO2 {

	private static DatosAsociadoDAO singleton = null;
	
	private static final String QUERY_CONSULTAR_DATOS_ASOCIADO = "DatosAsociadoMapper.consultarDatosAsociado";
	private static final String QUERY_ACTUALIZAR_DATOS_ASOCIADO = "DatosAsociadoMapper.actualizarDatosAsociado";
	private static final String QUERY_OBTENER_REGISTRO_DATOS_ACTUALIZADOS = "DatosAsociadoMapper.obtenerRegistroDatosActualizados";
  
	private static final String QUERY_OBTENER_TIPOS_VIA = "DatosAsociadoMapper.obtenerTiposVia";
	private static final String QUERY_OBTENER_LETRAS_VIA = "DatosAsociadoMapper.obtenerLetraVia";
	private static final String QUERY_OBTENER_COMPLEMENTO_VIA = "DatosAsociadoMapper.obtenerComplementoVia";

	private static final String QUERY_CONSULTAR_DATOS_BASICOS_ASOCIADO = "DatosAsociadoMapper.consultarDatosBasicosAsociado";

	public static DatosAsociadoDAO getInstance() {
		if (singleton == null)
		try {
			synchronized (DatosAsociadoDAO.class) {
			if (singleton == null)
				singleton = new DatosAsociadoDAO(); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return singleton;
	}
	
	public ConsultaDatosAsociadoMD consultarDatosAsociado(String cedula) throws Exception {
		ConsultaDatosAsociadoMD datos = new ConsultaDatosAsociadoMD();
		datos.setVa_anumnit(cedula);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_CONSULTAR_DATOS_ASOCIADO, datos);
		} finally {
			session.close();
		} 
		return datos;
	}

	public String actualizarDatosAsociado(RequestActualizarDatos request) throws Exception {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());

		ActualizaDatosAsociadoMD model = new ActualizaDatosAsociadoMD(
			id, 
			request.getIdRegistroDispositivo(),
			request.getCedula(),
			request.getNombreCompleto(),
			request.getDireccion().replace("#", ""),
			request.getCelular(),
			request.getEmail(),
			request.getBarrio(),
			request.getIdCiudad(),
			request.getIdDepartamento(),
			request.getIdPais(),
			request.getIp(),
			request.getCanal()
		);

		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ACTUALIZAR_DATOS_ASOCIADO, model);
		} finally {
			session.close();
		} 
		return ResponseConstantes.RESULTADO_EXITOSO;
	}

	public List<RegistraDatosActualizadosMD> obtenerRegistroDatosActualizados(String cedula) throws Exception {
		return getList(QUERY_OBTENER_REGISTRO_DATOS_ACTUALIZADOS, cedula);
	}


	public List<FormatoDireccionesMD> obtenerTiposVia() throws Exception {
		return getList(QUERY_OBTENER_TIPOS_VIA, null);
	}

	public List<FormatoDireccionesMD> obtenerLetrasVia() throws Exception {
		return getList(QUERY_OBTENER_LETRAS_VIA, null);
	}

	public List<FormatoDireccionesMD> obtenerComplementosVia() throws Exception {
		return getList(QUERY_OBTENER_COMPLEMENTO_VIA, null);
	}

	public DatosBasicosAsociadoMD obtenerDatosBasicosAsociado(String cedula) throws Exception {
		DatosBasicosAsociadoMD model = new DatosBasicosAsociadoMD();
		model.setV_AANUMNIT(cedula);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_CONSULTAR_DATOS_BASICOS_ASOCIADO, model);			
		} finally {
			session.close();
		} 
		return model;
	}

	
}