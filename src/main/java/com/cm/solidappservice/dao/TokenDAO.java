package com.cm.solidappservice.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import com.cm.solidappservice.model.token.bd.TokenMD;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TokenDAO {
	private static TokenDAO singleton = null;
	private static String QUERY_CONSULTAR_TOKEN = "com.cm.solidappservice.dao.sqlmap.TokenMapper.selectToken";
	private static String QUERY_ACTUALIZACION_TOKEN = "com.cm.solidappservice.dao.sqlmap.TokenMapper.updateToken";
	private static String QUERY_INSERCION_TOKEN = "com.cm.solidappservice.dao.sqlmap.TokenMapper.insertToken";
	private static String QUERY_DESACTIVAR_TOKEN = "com.cm.solidappservice.dao.sqlmap.TokenMapper.updateOtherToken";
	private static String QUERY_UPDATE_NUEVO_TOKEN = "com.cm.solidappservice.dao.sqlmap.TokenMapper.updateNewToken";


	public static TokenDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (TokenDAO.class) {
					if (null == singleton) {
						singleton = new TokenDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}
	
	SqlSessionFactory getFactory() throws IOException{
		String resource = "com/cm/solidappservice/mapper/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	public TokenMD getToken(String token) throws Exception {
		TokenMD tokenUnit = null;
		SqlSession session = getFactory().openSession();
		try {
			tokenUnit = (TokenMD) session
					.selectOne(QUERY_CONSULTAR_TOKEN, token);
		} finally {
			session.close();
		}
		return tokenUnit;
	}

	public void createToken(TokenMD token) throws Exception {
		int registrosAfectados = 0;
		SqlSession session = getFactory().openSession();
		try {
			registrosAfectados = session.insert(QUERY_INSERCION_TOKEN, token);
			token.setFechaExpiracion(new Date());
			session.update(QUERY_DESACTIVAR_TOKEN, token);
			session.commit();
		} finally {
			session.close();
		}
		if (registrosAfectados==0) {
			throw new Exception("No se pudo crear el registro.");
		}
	}
	
	public void updateToken(TokenMD token) throws Exception {
		int registrosAfectados = 0;
		SqlSession session = getFactory().openSession();
		try {
			registrosAfectados = session.update(QUERY_ACTUALIZACION_TOKEN, token);
			session.commit();
		} finally {
			session.close();
		}
		if (registrosAfectados==0) {
			throw new Exception("No se pudo crear el registro.");
		}
	}

	public void updateNewToken(TokenMD token) throws Exception {
		SqlSession session = getFactory().openSession();
		try {
			session.update(QUERY_UPDATE_NUEVO_TOKEN, token);
			session.commit();
		} finally {
			session.close();
		}
	}	
}