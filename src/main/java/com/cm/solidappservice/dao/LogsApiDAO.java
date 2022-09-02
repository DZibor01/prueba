package com.cm.solidappservice.dao;

import com.cm.solidappservice.model.logsapi.bd.LogsApiMD;

import org.apache.ibatis.session.SqlSession;

public class LogsApiDAO extends DAO2 {
    
    private static LogsApiDAO singleton = null;
	
	private static final String QUERY_INSETAR_LOGSAPI = "LogsApiMapper.createLogsApi";
	private static final String QUERY_ACTUALIZAR_LOGSAPI = "LogsApiMapper.updateLogsApi";

    public static LogsApiDAO getInstance() {
		if (singleton == null)
		try {
			synchronized (LogsApiDAO.class) {
			if (singleton == null)
				singleton = new LogsApiDAO(); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return singleton;
	}

    public void crearRegistroLogsApi(LogsApiMD model) throws Exception {;
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_INSETAR_LOGSAPI, model);
		} finally {
			session.close();
		}
	}

    public void actualizarRegistroLogsApi(LogsApiMD model) throws Exception {
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ACTUALIZAR_LOGSAPI, model);
		} finally {
			session.close();
		} 
	}

}
