package com.cm.solidappservice.dao;

import java.util.List;

import com.cm.solidappservice.model.datosasociado.bd.DatosAsociadoMD;
import com.cm.solidappservice.model.tarjetapresente.bd.ActualizacionTarjetaMD;
import com.cm.solidappservice.model.tarjetapresente.bd.MotivoBloqueoTarjetaMD;
import com.cm.solidappservice.model.tarjetapresente.bd.ReposicionTarjetaMD;
import com.cm.solidappservice.model.tarjetapresente.bd.TarjetaMD;

import org.apache.ibatis.session.SqlSession;

public class TarjetaPresenteDAO extends DAO2 {
	
	private static TarjetaPresenteDAO singleton = null;
	private static final String QUERY_LISTAR_TARJETAS = "TarjetaPresenteMapper.cargarListado";
	private static final String QUERY_REGISTRAR_CAMBIO_TARJETA = "TarjetaPresenteMapper.crearCambioTarjeta";
	private static final String QUERY_CARGAR_MOTIVOS_BLOQUEO = "TarjetaPresenteMapper.cargarListadoMotivosBloqueo";

	private static final String QUERY_INSERTAR_REPOSICION_TARJETA = "TarjetaPresenteMapper.reponerTarjeta";
	private static final String QUERY_OBTENER_DATOS_ASOCIADO = "TarjetaPresenteMapper.obtenerDatosAsociadoTarjeta";  

	public static TarjetaPresenteDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (TarjetaPresenteDAO.class) {
					if (null == singleton) {
						singleton = new TarjetaPresenteDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public List<TarjetaMD> getListadoTarjetas(TarjetaMD parameter) throws Exception {
		return getList(QUERY_LISTAR_TARJETAS, parameter);	
	}
	
	public void actualizarEstadoTarjeta(ActualizacionTarjetaMD parameter) throws Exception {
		insertObject(QUERY_REGISTRAR_CAMBIO_TARJETA, parameter);
	}
	
	public List<MotivoBloqueoTarjetaMD> getMotivosBloqueoTarjeta() throws Exception {
		return getList(QUERY_CARGAR_MOTIVOS_BLOQUEO, null);
	}

	public void registrarReposicionTarjeta(ReposicionTarjetaMD model) throws Exception {
		insertObject(QUERY_INSERTAR_REPOSICION_TARJETA, model);
	}

	public DatosAsociadoMD obtenerDatosAsosiadoTarjeta(String cedula) throws Exception {
		DatosAsociadoMD datos = new DatosAsociadoMD();
		datos.setV_AANUMNIT(cedula);
		SqlSession session = getFactory().openSession();
		try {
			session.selectOne(QUERY_OBTENER_DATOS_ASOCIADO, datos);
		} finally {
			session.close();
		} 
		return datos;
	}


}