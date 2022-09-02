package com.cm.solidappservice.manager;

import com.cm.solidappservice.dao.LogsApiDAO;
import com.cm.solidappservice.model.logsapi.bd.LogsApiMD;

public class LogsApiManager {
 
    private static LogsApiManager singleton = null;

	public static LogsApiManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (LogsApiManager.class) {
					if (null == singleton) {
						singleton = new LogsApiManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

    public void createLogsApi(LogsApiMD model) throws Exception {
		LogsApiDAO.getInstance().crearRegistroLogsApi(model);
	}

    public void updateLogsApi(LogsApiMD model) throws Exception {
		LogsApiDAO.getInstance().actualizarRegistroLogsApi(model);
	}

}
