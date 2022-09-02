package com.cm.solidappservice.dao;

import java.sql.Timestamp;
import java.util.List;

import com.cm.solidappservice.model.dispositivo.bd.RegistroDispositivoMD;
import com.cm.solidappservice.model.dispositivo.request.RequestDispositivo;

import org.apache.ibatis.session.SqlSession;


public class DispositivoDAO extends DAO2 {

	private static com.cm.solidappservice.dao.DispositivoDAO singleton = null;
	
	private static final String QUERY_INSERTAR_NUEVO_DISPOSITIVO = "DispositivoMapper.insertarNuevoDispositivo";
	private static final String QUERY_OBTENER_DISPOSITIVOS_REGISTRADOS = "DispositivoMapper.obtenerDispositivosRegistrados";
	

	public static com.cm.solidappservice.dao.DispositivoDAO getInstance() {
		if (singleton == null)
		try {
			synchronized (com.cm.solidappservice.dao.DispositivoDAO.class) {
			if (singleton == null)
				singleton = new com.cm.solidappservice.dao.DispositivoDAO(); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return singleton;
	}
	
	public List<RegistroDispositivoMD> obtenerDispositivoRegistrado(RequestDispositivo request) throws Exception {
		RegistroDispositivoMD dispositivo = new RegistroDispositivoMD();
		dispositivo.setA_anumnit(request.getCedula());
		dispositivo.setN_fabricante(request.getFabricante());
		dispositivo.setN_modelo(request.getModelo());
		dispositivo.setId_dispositivo(request.getIdDispositivo());
		dispositivo.setK_imei(request.getImei());
		dispositivo.setT_celprincipal(request.getCelPrincipal());
		return getList(QUERY_OBTENER_DISPOSITIVOS_REGISTRADOS, dispositivo);
	}


	public String insertarNuevoDispositivo(RequestDispositivo request) throws Exception {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());
		
		RegistroDispositivoMD model = new RegistroDispositivoMD();
		model.setK_registrodispos(id);
		model.setA_anumnit(request.getCedula());
		model.setN_fabricante(request.getFabricante());
		model.setN_modelo(request.getModelo());
		model.setId_dispositivo(request.getIdDispositivo());
		model.setK_imei(request.getImei());
		model.setT_celprincipal(request.getCelPrincipal());
		model.setN_sistoperativo(request.getSistemaOperativo());
		model.setK_version(request.getVersionSistemaOperativo());
		SqlSession session = getFactory().openSession();
		try {		
			session.selectOne(QUERY_INSERTAR_NUEVO_DISPOSITIVO, model);
			return id;
		} finally {
			session.close();
		} 		
	}

	

}