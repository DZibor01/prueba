package com.cm.solidappservice.manager;

import java.util.ArrayList;
import java.util.List;

import com.cm.solidappservice.dao.CentrosVacacionalesDAO;
import com.cm.solidappservice.model.centrosvacacionales.bd.CentroVacacionalMD;
import com.cm.solidappservice.model.centrosvacacionales.bd.SolicitudCentroVacacionalMD;
import com.cm.solidappservice.model.centrosvacacionales.request.RequestSolicitudCentroVacacional;
import com.cm.solidappservice.model.centrosvacacionales.response.ResponseCentroVacacional;
import com.cm.solidappservice.model.centrosvacacionales.response.ResponsePerfilCentroVacacional;
import com.cm.solidappservice.utils.Utilities;

public class CentrosVacacionalesManager {
    
    private static CentrosVacacionalesManager singleton = null;

	public static CentrosVacacionalesManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (CentrosVacacionalesManager.class) {
					if (null == singleton) {
						singleton = new CentrosVacacionalesManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public List<ResponseCentroVacacional> getListadoCentrosVacacionales() throws Exception {
		List<ResponseCentroVacacional> centrosVacacionalesRetorno = new ArrayList<ResponseCentroVacacional>();
		List<CentroVacacionalMD> listadoBD = CentrosVacacionalesDAO.getInstance().getList();

		List<String> centrosDistintos = new ArrayList<String>();
		for (CentroVacacionalMD c : listadoBD) {
			if (!centrosDistintos.contains(c.getK_cenvac())) {
				centrosDistintos.add(c.getK_cenvac());
				ArrayList<CentroVacacionalMD> tmp = new ArrayList<CentroVacacionalMD>();
				tmp.add(c);
			}
		}

		for (int i = 0; i < centrosDistintos.size(); i++) {
			List<ResponsePerfilCentroVacacional> perfiles = new ArrayList<ResponsePerfilCentroVacacional>();
			String codigoCentroActual = centrosDistintos.get(i);
			ResponseCentroVacacional nuevoCentro = new ResponseCentroVacacional();
			int controlador = 1;
			for (CentroVacacionalMD c : listadoBD) {
				if (c.getK_cenvac().equals(codigoCentroActual)) {
					perfiles.add(new ResponsePerfilCentroVacacional(c.getK_peruni(), c.getN_peruni()));
					if (controlador == 1) {
						nuevoCentro.setCodigo(c.getK_cenvac());
						nuevoCentro.setNombre(c.getN_cenvac());
						nuevoCentro.setDireccion(c.getD_cenvac());
					}
					controlador++;
				}
			}
			nuevoCentro.setPerfiles(perfiles);
			centrosVacacionalesRetorno.add(nuevoCentro);
		}
		return centrosVacacionalesRetorno;
	}

	public void createSolicitudCentroVacacional(RequestSolicitudCentroVacacional solicitud) throws Exception {
		SolicitudCentroVacacionalMD parametro = new SolicitudCentroVacacionalMD();
		parametro.setAanumnit(solicitud.getCedula());
		if (Utilities.IsNullOrEmpty(solicitud.getFecha())) {
			parametro.setF_llegad(null);
		} else {
			parametro.setF_llegad(Utilities.getFechaDate(solicitud.getFecha()));
		}
		parametro.setI_asousa(solicitud.getAsociadoViaja());
		parametro.setId_dispositivo(solicitud.getIdDispositivo());
		parametro.setK_cenvac(solicitud.getCodigo());
		parametro.setK_peruni(solicitud.getCodigoPerfil());
		parametro.setO_observ(solicitud.getObservaciones());
		parametro.setQ_perman(solicitud.getNumeroDias());
		parametro.setQ_totadu(solicitud.getNumeroAdultos());
		parametro.setQ_totnin(solicitud.getNumeroNinos());
		parametro.setD_email(solicitud.getEmailContacto());
		CentrosVacacionalesDAO.getInstance().insert(parametro);
	}

}
