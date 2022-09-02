package com.cm.solidappservice.manager;

import com.cm.solidappservice.dao.LogsDAO;
import com.cm.solidappservice.model.logs.bd.LogErrorMD;

public class LogsManager {

	private static LogsManager singleton = null;

	public static LogsManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (LogsManager.class) {
					if (null == singleton) {
						singleton = new LogsManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public void logError(LogErrorMD log)	{
		try {
			LogsDAO.getInstance().insert(log);
		} catch (Exception e) {
		}
	}
	
}