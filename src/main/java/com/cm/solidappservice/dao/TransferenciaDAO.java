package com.cm.solidappservice.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cm.solidappservice.model.transferencias.bd.BancoMD;
import com.cm.solidappservice.model.transferencias.bd.CuentaDisponibleMD;
import com.cm.solidappservice.model.transferencias.bd.CuentaInscritaMD;
import com.cm.solidappservice.model.transferencias.bd.EliminacionCuentaMD;
import com.cm.solidappservice.model.transferencias.bd.InscripcionCuentaMD;
import com.cm.solidappservice.model.transferencias.bd.SolicitudInscripcionCuentaMD;
import com.cm.solidappservice.model.transferencias.bd.TransferenciaMD;
import com.cm.solidappservice.model.transferencias.request.RequestEliminacionCuenta;
import com.cm.solidappservice.model.transferencias.request.RequestInscripcionCuentaDeprecated;

public class TransferenciaDAO extends DAO2{
	
	private final String QUERY_CARGAR_CUENTAS_INSCRITAS = "TransferenciaMapper.cargarListadoCuentasInscritas";
	private final String QUERY_CARGAR_CUENTAS_DISPONIBLES = "TransferenciaMapper.cargarListadoCuentasDisponibles";
	private final String QUERY_INSCRIBIR_CUENTA = "TransferenciaMapper.inscribirCuenta";
	private final String QUERY_SOLICITUD_INSCRIBIR_CUENTA = "TransferenciaMapper.solicitarInscribirCuenta";
	private final String QUERY_CREAR_TRANSFERENCIA = "TransferenciaMapper.crearTransferencia";
	private final String QUERY_OBTENER_TRANSFERENCIA = "TransferenciaMapper.selectTransferencias";
	private final String QUERY_ELIMINAR_CUENTA = "TransferenciaMapper.eliminarCuenta";
	private final String QUERY_CARGAR_BANCOS = "TransferenciaMapper.cargarListadoBancos";
		
	private static TransferenciaDAO singleton = null;
	
	public static TransferenciaDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (TransferenciaDAO.class) {
					if (null == singleton) {
						singleton = new TransferenciaDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}
	
	public List<CuentaInscritaMD> obtenerCuentasInscritas(String cedula) throws Exception {
		return getList(QUERY_CARGAR_CUENTAS_INSCRITAS, cedula);
	}
	
	public List<CuentaDisponibleMD> obtenerCuentasDisponibles(String cedula) throws Exception {
		return getList(QUERY_CARGAR_CUENTAS_DISPONIBLES, cedula);
	}
	
	public List<BancoMD> obtenerListadoBancos() throws Exception {
		return getList(QUERY_CARGAR_BANCOS, null);
	}
	
	public String inscribirCuenta(RequestInscripcionCuentaDeprecated credencial) throws Exception {
		InscripcionCuentaMD parameter = new InscripcionCuentaMD();
		parameter.setV_aanumnit(credencial.getCedula());
		parameter.setV_aanumnit_d(credencial.getCedulaInscripcion());
		parameter.setV_numcta(credencial.getCuentaInscripcion());
		parameter.setV_respue("");

		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_INSCRIBIR_CUENTA, parameter);
			return parameter.getV_respue();
		} finally {
			session.close();
		}
	}
	
	public void solicitarInscribirCuenta(SolicitudInscripcionCuentaMD credencial) throws Exception {
		insertObject(QUERY_SOLICITUD_INSCRIBIR_CUENTA, credencial);
	}
	
	public void realizarTransferencia(TransferenciaMD model) throws Exception {
		insertObject(QUERY_CREAR_TRANSFERENCIA, model);
	}

	public String eliminarCuenta(RequestEliminacionCuenta credencial) throws Exception {
		EliminacionCuentaMD parameter = new EliminacionCuentaMD();
		parameter.setV_aanumnit(credencial.getCedula());
		parameter.setV_numcta(credencial.getNumeroCuenta());
		parameter.setV_respue("");
		
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_ELIMINAR_CUENTA, parameter);
		} finally {
			session.close();
		}
		return parameter.getV_respue();
	}

	public List<TransferenciaMD> obtenerTransferenciasIncompletas(String cedula) throws Exception {
		TransferenciaMD model = new TransferenciaMD();
		model.setAanumnit_o(cedula);
		List<TransferenciaMD> result = getList(QUERY_OBTENER_TRANSFERENCIA, model);
		return result;
	}
}