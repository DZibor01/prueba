package com.cm.solidappservice.dao;

import java.util.List;

import com.cm.solidappservice.model.logs.bd.LogErrorMD;

public class LogsDAO extends DAO2{
	
	private final String QUERY_CREAR_REGISTRO = "LogsMapper.registrarLogsError";
	private final String QUERY_CARGAR_LISTADO = "LogsMapper.cargarListado";
	
	private static LogsDAO singleton = null;
	
	public static LogsDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (LogsDAO.class) {
					if (null == singleton) {
						singleton = new LogsDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}
	
	public List<LogErrorMD> getList() throws Exception{
		return getList(QUERY_CARGAR_LISTADO, null);
	}
	
	public void insert(LogErrorMD error) throws Exception{
		insertObject(QUERY_CREAR_REGISTRO, error);
	}
	
}