package com.cm.solidappservice.dao;

import org.apache.ibatis.session.SqlSession;

import com.cm.solidappservice.model.login.bd.LoginMD;
import com.cm.solidappservice.model.login.bd.RecordarClaveMD;
import com.cm.solidappservice.model.login.request.RequestLogin;
import com.cm.solidappservice.utils.Utilities;

public class LoginDAO extends DAO2 {

	private static LoginDAO singleton = null;

	private static final String QUERY_LOGIN_USUARIO = "LoginMapper.loginFunction";
	private static final String QUERY_RECORDAR_CLAVE = "LoginMapper.recordarClave";
	private static final String CONSULTAR_FECHA_ULTIMO_INGRESO = "LoginMapper.consultarFechaUltimoIngreso";
	
	
	public static LoginDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (LoginDAO.class) {
					if (null == singleton) {
						singleton = new LoginDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public String autenticarUsuario(RequestLogin request) throws Exception {
		LoginMD model = new LoginMD();
		model.setV_clave(request.getClave());
		model.setV_numnit(request.getCedula());
		model.setV_origaplic(request.getOrigen());
		model.setV_result("");
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_LOGIN_USUARIO, model);
			if (Utilities.IsNullOrEmpty(model.getV_result())) {
				throw new Exception("El resultado quedó vacío.");
			}
		} finally {
			session.close();
		}
		return model.getV_result();
	}

	public String fechaUltimoIngreso(String cedula) throws Exception {
		return getObject(CONSULTAR_FECHA_ULTIMO_INGRESO, cedula);
	}
	
	public RecordarClaveMD recordarClave(RequestLogin request) throws Exception {
		RecordarClaveMD model = new RecordarClaveMD();
		model.setV_aanumnit(request.getCedula());
		model.setV_email("");
		model.setV_vclave("");
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_RECORDAR_CLAVE, model);
		} finally {
			session.close();
		}
		return model;
	}
	
}