package com.cm.solidappservice.manager;

import java.util.Date;
import java.util.Random;

import com.cm.solidappservice.dao.CajaMenorPteDAO;
import com.cm.solidappservice.model.cajamenorpte.request.RequestCajaMenorPteMD;

public class CajaMenorPteManager {
    
    private static CajaMenorPteManager singleton = null;

	public static CajaMenorPteManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (CajaMenorPteManager.class) {
					if (null == singleton) {
						singleton = new CajaMenorPteManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public void crearCajaMenorPte(RequestCajaMenorPteMD request) throws Exception {
		String complemento = String.valueOf(new Random().nextInt(100));
		request.setId_registro(String.valueOf(new Date().getTime()) + "-" + request.getA_numnit() + "-" + complemento);
		CajaMenorPteDAO.getInstance().crearSolicitud(request);
	}	


}
