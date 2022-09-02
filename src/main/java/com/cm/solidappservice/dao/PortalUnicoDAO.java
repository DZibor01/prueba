package com.cm.solidappservice.dao;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.diverseinfo.bd.BannerComercialMD;
import com.cm.solidappservice.model.portalunico.bd.CertificadoLibertadMD;
import com.cm.solidappservice.model.portalunico.bd.CompraCertificadoMD;
import com.cm.solidappservice.model.portalunico.bd.PropiedadesCertLibertadMD;
import com.cm.solidappservice.model.portalunico.bd.RegistroIngresosMD;
import com.cm.solidappservice.model.portalunico.bd.RegistroVotacionesMD;
import com.cm.solidappservice.model.portalunico.request.RequestSolicitarCertificado;

public class PortalUnicoDAO extends DAO2 {

	private static PortalUnicoDAO singleton = null;

	private static final String QUERY_REGISTRAR_LOGINPORTAUNICO = "PortalUnicoMapper.registrarIngresos";
	private static final String QUERY_OBTENER_BANNER_LOGIN = "PortalUnicoMapper.obtenerBannerLogin";
	private static final String QUERY_REGISTRAR_TRANSACCION_CERTLIBER = "PortalUnicoMapper.registrarTransaccionCert";
	private static final String QUERY_ACTUALIZAR_TRANSACCION_CERTLIBER = "PortalUnicoMapper.actualizarTransaccionCertificado";
	private static final String QUERY_REGISTRAR_PROPIEDADES_CERTLIBER = "PortalUnicoMapper.registrarPropiedadesCertificado";
	private static final String QUERY_AGREGAR_HISTORIAL_VOTACION = "PortalUnicoMapper.agregarHistorialVotacion";

	public static PortalUnicoDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (PortalUnicoDAO.class) {
					if (null == singleton) {
						singleton = new PortalUnicoDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	
	public String registrarIngresoPortalUnico(RegistroIngresosMD model) throws Exception {
		insertObject(QUERY_REGISTRAR_LOGINPORTAUNICO, model);
		return ResponseConstantes.RESULTADO_EXITOSO;
	}

	public List<BannerComercialMD> obtenerBannerLogin() throws Exception {
		return getList(QUERY_OBTENER_BANNER_LOGIN, null);
	}

	public CompraCertificadoMD procesarCompra(RequestSolicitarCertificado request, String idTransaccion)
			throws Exception {
		CompraCertificadoMD model = new CompraCertificadoMD(idTransaccion, request.getCedula(),
				request.getNombreCompleto(), request.getCorreoElectronico(), request.getTelefonoCelular(),
				request.getValorTotal(), request.isEsPagoACredito() ? "Y" : "N", request.getNumeroProductoDebitable(),
				request.getFechaSolicitud(), "", "");
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_REGISTRAR_TRANSACCION_CERTLIBER, model);
		} finally {
			session.close();
		}
		return model;
	}

	public void registrarPropiedadesCertificado(PropiedadesCertLibertadMD model) throws Exception {
		insertObject(QUERY_REGISTRAR_PROPIEDADES_CERTLIBER, model);
		;
	}

	public void actualizarTransaccionCertificado(CertificadoLibertadMD model) throws Exception {
		updateObject(QUERY_ACTUALIZAR_TRANSACCION_CERTLIBER, model);
	}

	public String registrarHistorialVotacion(RegistroVotacionesMD model) throws Exception {
		insertObject(QUERY_AGREGAR_HISTORIAL_VOTACION, model);
		return ResponseConstantes.RESULTADO_EXITOSO;
	}
	
}
