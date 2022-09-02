package com.cm.solidappservice.dao;

import java.util.List;

import com.cm.solidappservice.model.estadocuenta.bd.EstadoCuentaMD;
import com.cm.solidappservice.model.estadocuenta.bd.MovimientoMD;
import com.cm.solidappservice.model.estadocuenta.request.RequestMovimientosCuentasDeprecated;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;

public class EstadoCuentaDAO extends DAO2 {

	private static EstadoCuentaDAO singleton = null;
	
	private static final String QUERY_PROCESAR_SALDOS_CUENTA = "EstadoCuentaMapper.procesarSaldosCuentas";
	private static final String QUERY_OBTENER_CUENTAS= "EstadoCuentaMapper.obtenerCuentas";
	
	private static final String QUERY_PROCESAR_MOVIMIENTOS_CUENTA = "EstadoCuentaMapper.procesarMovimientosCuenta";
	private static final String QUERY_OBTENER_MOVIMIENTOS_CUENTA = "EstadoCuentaMapper.obtenerMovimientosCedula";

	
	
	private static final String QUERY_ESTADO_MENSAJE_MISAPORTES = "ParametrosGeneralesMapper.cargarParametrosGenerales";
	
	// private static final String QUERY_OBTENER_MOVIMIENTOS_ESTADO_CUENTA = "EstadoCuentaMapper.obtenerMovimientos";


	public static EstadoCuentaDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (EstadoCuentaDAO.class) {
					if (null == singleton) {
						singleton = new EstadoCuentaDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public void procesarSaldosCuentas(EstadoCuentaMD model) throws Exception {
		model.setV_aanumnit(model.getAanumnit());
		getObject(QUERY_PROCESAR_SALDOS_CUENTA, model);
	}

	//EN DESUSO PROXIMAMENTE
	public List<EstadoCuentaMD> obtenerCuentasDeprecated(EstadoCuentaMD model) throws Exception {
		return getList(QUERY_OBTENER_CUENTAS, model);
	}
	public List<EstadoCuentaMD> obtenerCuentas(EstadoCuentaMD model) throws Exception {
		procesarSaldosCuentas(model);
		return getList(QUERY_OBTENER_CUENTAS, model);
	}
	

	//EN DESUSO PROXIMAMENTE
	public void procesarMovimientosCuentasDeprecated(RequestMovimientosCuentasDeprecated request) throws Exception {
		EstadoCuentaMD model = new EstadoCuentaMD(); 
		model.setV_aanumnit(request.getCedula());
		model.setK_tipcuent(request.getK_tipcuent());
		model.setV_tipodr(request.getV_tipodr());
		model.setV_numdoc(request.getV_numdoc());
		getObject(QUERY_PROCESAR_MOVIMIENTOS_CUENTA, model);
	}
	public void procesarMovimientosCuenta(MovimientoMD parametro) throws Exception {
		getObject(QUERY_PROCESAR_MOVIMIENTOS_CUENTA, parametro);
	}


	//EN DESUSO PROXIMAMENTE
	public List<MovimientoMD> obtenerMovimientosCuentaDeprecated(EstadoCuentaMD model) throws Exception {
		return getList(QUERY_OBTENER_MOVIMIENTOS_CUENTA, model);
	}
	public List<MovimientoMD> obtenerMovimientosCuenta(MovimientoMD movimiento) throws Exception {
		procesarMovimientosCuenta(movimiento);
		return getList(QUERY_OBTENER_MOVIMIENTOS_CUENTA, movimiento);
	}
	

	public ParametrosGeneralesMD obtenerEstadoMensajeMisAportes() throws Exception {
		return getObject(QUERY_ESTADO_MENSAJE_MISAPORTES, 6);
	}

}