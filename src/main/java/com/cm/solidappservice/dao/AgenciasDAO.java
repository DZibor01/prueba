package com.cm.solidappservice.dao;

import java.util.List;

import com.cm.solidappservice.model.agencias.bd.AgenciaMD;
import com.cm.solidappservice.model.agencias.bd.ContactoAgenciaMD;

public class AgenciasDAO extends DAO2 {

	private static AgenciasDAO singleton = null;

	private static final String QUERY_OBTENER_AGENCIAS = "AgenciasMapper.selectAgencias";
	private static final String QUERY_OBTENER_CONTACTOS_AGENCIAS = "AgenciasMapper.selectAllContactos";
	private static final String QUERY_OBTENER_CONTACTOS_FILTRADOS_AGENCIAS = "AgenciasMapper.selectContactos";

	public static AgenciasDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (AgenciasDAO.class) {
					if (null == singleton) {
						singleton = new AgenciasDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}
	
	public List<AgenciaMD> obtenerAgencias() throws Exception {	
		List<AgenciaMD> model = getList(QUERY_OBTENER_AGENCIAS, null);
		return model;
	}
	
	public List<ContactoAgenciaMD> obtenerContactos() throws Exception {		
		List<ContactoAgenciaMD> model = getList(ContactoAgenciaMD.class, QUERY_OBTENER_CONTACTOS_AGENCIAS, null);
		return model;
	}

	public List<ContactoAgenciaMD> obtenerContactosFiltrado(ContactoAgenciaMD agencia) throws Exception {		
		List<ContactoAgenciaMD> model = getList(QUERY_OBTENER_CONTACTOS_FILTRADOS_AGENCIAS, agencia);
		return model;
	}
}