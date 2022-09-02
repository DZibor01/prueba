package com.cm.solidappservice.manager;

import java.util.ArrayList;
import java.util.List;

import com.cm.solidappservice.dao.AgenciasDAO;
import com.cm.solidappservice.model.agencias.bd.AgenciaMD;
import com.cm.solidappservice.model.agencias.bd.ContactoAgenciaMD;
import com.cm.solidappservice.model.agencias.response.*;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.utils.Utilities;

public class AgenciasManager {
    
    private static AgenciasManager singleton = null;

	public static AgenciasManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (AgenciasManager.class) {
					if (null == singleton) {
						singleton = new AgenciasManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	//EN DESUSO PROXIMAMENTE
	public List<ResponseAgenciasDeprecated> obtenerAgenciasDeprecated() throws Exception {
		List<AgenciaMD> agencias = AgenciasDAO.getInstance().obtenerAgencias();
		List<ResponseAgenciasDeprecated> response = new ArrayList<ResponseAgenciasDeprecated>();
		if (agencias != null) {			
			List<ContactoAgenciaMD> listContactos = AgenciasDAO.getInstance().obtenerContactos();
			for (AgenciaMD agencia : agencias) {
				if (!Utilities.isNumeric(agencia.getN_latitu()) || !Utilities.isNumeric(agencia.getN_longit())) {
					continue;
				}
				if (listContactos != null && listContactos.size() > 0) {
					ArrayList<ContactoAgenciaMD> contactosAgencia = new ArrayList<ContactoAgenciaMD>();
					for (int i = 0; i < listContactos.size(); i++) {
						ContactoAgenciaMD contacto = listContactos.get(i);
						if (contacto.getK_sucurs().equals(agencia.getK_sucurs())&& contacto.getI_tipage().equals(agencia.getI_tipage())) {
							if (Utilities.IsNullOrEmpty(contacto.getN_telefo())) {
								contacto.setN_telefo(ResponseConstantes.CADENA_VACIA);
							}
							contactosAgencia.add(contacto);
							// agencia.getContactos().add(contacto);
						}
					}
					agencia.setContactos(contactosAgencia);
				}
				response.add(new ResponseAgenciasDeprecated(
					agencia.getN_latitu(),
					agencia.getN_longit(),
					agencia.getN_sucurs(),
					agencia.getI_tipage(),
					agencia.getK_sucurs(),
					agencia.getD_sucurs(),
					agencia.getN_depart(),
					agencia.getN_ciudad(),
					agencia.getT_sucurs(),
					agencia.getContactos()
				));
			}
		}
		return response;
	}
	public List<ResponseObtenerAgencias> obtenerAgencias() throws Exception {
		List<AgenciaMD> listAagencias = AgenciasDAO.getInstance().obtenerAgencias();
		List<ResponseObtenerAgencias> response = new ArrayList<ResponseObtenerAgencias>();

		if (listAagencias != null) {
			List<ContactoAgenciaMD> listContactos = AgenciasDAO.getInstance().obtenerContactos();
			for (AgenciaMD agencia : listAagencias) {					
				if (!Utilities.isNumeric(agencia.getN_latitu()) || !Utilities.isNumeric(agencia.getN_longit())) {
					continue;
				}

				List<ContactoAgencia> contactosResponse = new ArrayList<ContactoAgencia>();
				if(listContactos != null && listContactos.size()>0){
					for (int i = 0; i < listContactos.size(); i++) {
						ContactoAgenciaMD contacto = listContactos.get(i);
						if (contacto.getK_sucurs().equals(agencia.getK_sucurs()) && contacto.getI_tipage().equals(agencia.getI_tipage())) {
							if (Utilities.IsNullOrEmpty(contacto.getN_telefo())) {
								contacto.setN_telefo(ResponseConstantes.CADENA_VACIA);
							}									
							contactosResponse.add(new ContactoAgencia(
								contacto.getN_cargo(),
								contacto.getN_nombre(),
								contacto.getN_telefo()
							));
						}
					}

				}
				response.add(new ResponseObtenerAgencias(
					agencia.getN_latitu(),
					agencia.getN_longit(),
					agencia.getN_sucurs(),
					agencia.getI_tipage(),
					agencia.getK_sucurs(),
					agencia.getD_sucurs(),
					agencia.getN_depart() == null ? "" : agencia.getN_depart(),
					agencia.getN_ciudad(),
					agencia.getT_sucurs(),
					contactosResponse
				));
			}
		}
		return response;
	}


	// public List<AgenciaMD> getAgencias() throws Exception {
	// 	List<AgenciaMD> agencias = AgenciasDAO.getInstance().obtenerAgencias();
	// 	List<AgenciaMD> retorno = new ArrayList<AgenciaMD>();
	// 	if (agencias != null) {
	// 		List<ContactoAgenciaMD> contactos = AgenciasDAO.getInstance().obtenerContactos();
	// 		for (AgenciaMD agencia : agencias) {
	// 			if (!Utilities.isNumeric(agencia.getN_latitu()) || !Utilities.isNumeric(agencia.getN_longit())) {
	// 				continue;
	// 			}
	// 			if (contactos != null && contactos.size() > 0) {
	// 				List<ContactoAgenciaMD> contactosAgencia = new ArrayList<ContactoAgenciaMD>();
	// 				for (int i = 0; i < contactos.size(); i++) {
	// 					ContactoAgenciaMD contacto = contactos.get(i);
	// 					if (contacto.getK_sucurs().equals(agencia.getK_sucurs()) && contacto.getI_tipage().equals(agencia.getI_tipage())) {
	// 						if (Utilities.IsNullOrEmpty(contacto.getN_telefo())) {
	// 							contacto.setN_telefo(ResponseConstantes.CADENA_VACIA);
	// 						}
	// 						contactosAgencia.add(contacto);
	// 					}
	// 				}
	// 				agencia.setContactos(contactosAgencia);
	// 			}
	// 			retorno.add(agencia);
	// 		}
	// 	}
	// 	return retorno;
	// }

}
