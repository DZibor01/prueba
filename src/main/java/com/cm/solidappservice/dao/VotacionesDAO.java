package com.cm.solidappservice.dao;

import java.io.IOException;
import java.util.List;

import com.cm.solidappservice.model.votaciones.bd.CandidatosMD;
import com.cm.solidappservice.model.votaciones.bd.VotantesMD;

import org.apache.ibatis.session.SqlSession;

public class VotacionesDAO extends DAO2 {

	private static VotacionesDAO singleton = null;	

	private static final String QUERY_VALIDAR_ESTADO_VOTACIONES = "VotacionesMapper.validarEstadoVotaciones";
	private static final String QUERY_CONSULTAR_ESTADO_VOTANTE = "VotacionesMapper.consultarEstadoVotante";
	private static final String QUERY_CONSULTAR_ZONA_ELECTORAL = "VotacionesMapper.consultarZonaElectoral";
	private static final String QUERY_CONSULTAR_CANDIDATOS = "VotacionesMapper.getCandidatos";

	private static final String QUERY_CAMBIAR_ESTADO_VOTANTE = "VotacionesMapper.cambiarEstadoVotante";
	private static final String QUERY_REGISTRAR_VOTO = "VotacionesMapper.registrarVoto";
	private static final String QUERY_CONSULTAR_CANDIDATO = "VotacionesMapper.consultarCandidato";


	public static VotacionesDAO getInstance() {
		if (singleton == null)
		try {
			synchronized (VotacionesDAO.class) {
			if (singleton == null)
				singleton = new VotacionesDAO(); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return singleton;
	}
	
	public int validarEstadoVotaciones() {
		int estadoVotacion = 0;
		SqlSession session = null;
		try {
			session = getFactoryMySQL().openSession();
			estadoVotacion = session.selectOne(QUERY_VALIDAR_ESTADO_VOTACIONES);
		} catch (Exception error) {
			System.out.println(error);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return estadoVotacion;
	}

	public String consultarEstadoVotante(String cedula) {
		String estadoVotante = null;
		SqlSession session = null;
		try {
			session = getFactoryMySQL().openSession();
			estadoVotante = session.selectOne(QUERY_CONSULTAR_ESTADO_VOTANTE, cedula);
		} catch (Exception error) {
			System.out.println(error);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return estadoVotante;
	}

	public Integer obtenerZonaElectoral(String cedula) throws IOException {
		Integer zonaElectoral = null;
		SqlSession session = getFactoryMySQL().openSession();
		try {
			zonaElectoral = session.selectOne(QUERY_CONSULTAR_ZONA_ELECTORAL, cedula);
		}catch(Exception ex){
			System.out.println(ex);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return zonaElectoral;
	}

	public List<CandidatosMD> getCandidatos(Integer idDependencia) throws IOException {
		List<CandidatosMD> lista = null;
		SqlSession session = getFactoryMySQL().openSession();
		try {
			lista = session.selectList(QUERY_CONSULTAR_CANDIDATOS, idDependencia);
		} catch(Exception e){
			session.close();
		}finally {
			if (session != null) {
				session.close();
			}
		}
		return lista;
	}

	public boolean cambiarEstadoVotante(String cedula) {
		boolean seCambioEstado = false;
		SqlSession session = null;
		try {
			session = getFactoryMySQL().openSession();
			session.update(QUERY_CAMBIAR_ESTADO_VOTANTE, cedula);
			seCambioEstado = true;
		} catch (Exception error) {
			System.out.println(error);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return seCambioEstado;		
	}

	public boolean registrarVoto(CandidatosMD model) {
		boolean seRegistroVoto = false;
		SqlSession session = null;
		try {
			session = getFactoryMySQL().openSession();
			session.update(QUERY_REGISTRAR_VOTO, model);
			seRegistroVoto = true;
		} catch (Exception error) {
			System.out.println(error);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return seRegistroVoto;
	}

	public CandidatosMD consultarCandidato(CandidatosMD model) {
		CandidatosMD candidado = null;
		SqlSession session = null;
		try {
			session = getFactoryMySQL().openSession();
			candidado = session.selectOne(QUERY_CONSULTAR_CANDIDATO, model);
		} catch (Exception error) {
			System.out.println(error);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return candidado;
	}
	
}