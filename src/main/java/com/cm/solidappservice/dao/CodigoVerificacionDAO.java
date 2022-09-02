package com.cm.solidappservice.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.cm.solidappservice.model.codigoverificacion.bd.CodigoVerificacionMD;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;

import org.apache.ibatis.session.SqlSession;

public class CodigoVerificacionDAO extends DAO2 {
    
    private static CodigoVerificacionDAO singleton = null;
	
	private static final String QUERY_CREAR_CODIGO_VERIFICACION = "CodigoVerificacionMapper.crearCodigoVerificacion";
	private static final String QUERY_OBTENER_CODIGO_VERIFICACION = "CodigoVerificacionMapper.obtenerCodigoVerificacion";
	private static final String QUERY_OBTENER_CODIGO_VERIFICACION_CEDULA = "CodigoVerificacionMapper.obtenerCodigosVerificacionCedula";	
    private static final String QUERY_ACTUALIZAR_CODIGO_VERIFICACION = "CodigoVerificacionMapper.actualizarCodigoVerificacion";
	private static final String QUERY_ACTUALIZAR_RESULTADO_ENVIO_CODIGO = "CodigoVerificacionMapper.actualizarCodigoVerificacionResultado";

	private static final String QUERY_CREDENCIALLES_BASIC_INALAMBRIA = "ParametrosGeneralesMapper.cargarParametrosGenerales";

    public static CodigoVerificacionDAO getInstance() {
		if (singleton == null)
		try {
			synchronized (CodigoVerificacionDAO.class) {
			if (singleton == null)
				singleton = new CodigoVerificacionDAO(); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return singleton;
	}


	public CodigoVerificacionMD crearCodigo(String cedula, String tipoEnvio, String envio) throws Exception {
		long timeoutMinutos = 3L;
  		long timeoutMilisegundos = timeoutMinutos * 60L * 1000L;
		int codigo = new Random().nextInt(8999) + 1000;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());

		CodigoVerificacionMD model = new CodigoVerificacionMD();
		model.setK_codigo(id);
		model.setA_anumnit(cedula);
		model.setN_codigo(codigo+"");
		model.setF_generacion(new Date());
		model.setF_expiracion(new Date(model.getF_generacion().getTime() + timeoutMilisegundos));
		model.setI_expirado("N"); 
		model.setN_tipoenvio(tipoEnvio);
		model.setN_envio(envio);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_CREAR_CODIGO_VERIFICACION, model);
		} finally {
			session.close();
		}
		return model;
	}

	public CodigoVerificacionMD obtenerCodigo(CodigoVerificacionMD model) throws Exception {
		List<CodigoVerificacionMD> l = getList(QUERY_OBTENER_CODIGO_VERIFICACION, model);
		if(l.size() > 0){
			return l.get(0);	
		}else{
			return null;
		}
	}

	public List<CodigoVerificacionMD> obtenerCodigosCedula(String cedula) throws Exception {
		return getList(QUERY_OBTENER_CODIGO_VERIFICACION_CEDULA, cedula);
	}

	public void actualizarCodigo(CodigoVerificacionMD model) throws Exception {
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ACTUALIZAR_CODIGO_VERIFICACION, model);
		} finally {
			session.close();
		} 
	}

	public void actualizarResultadoEnvioCodigo(CodigoVerificacionMD model) throws Exception {
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ACTUALIZAR_RESULTADO_ENVIO_CODIGO, model);
		} finally {
			session.close();
		} 
	}

	public ParametrosGeneralesMD obtenerCredencialesBasicApiSms() throws Exception {
		return getObject(QUERY_CREDENCIALLES_BASIC_INALAMBRIA, 9);
	}

	public ParametrosGeneralesMD obtenerUrlApiSms() throws Exception {
		return getObject(QUERY_CREDENCIALLES_BASIC_INALAMBRIA, 11);
	}


}
