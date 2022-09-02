package com.cm.solidappservice.manager;

import java.util.List;
import java.util.ArrayList;

import com.cm.solidappservice.dao.VotacionesDAO;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.votaciones.bd.CandidatosMD;
import com.cm.solidappservice.model.votaciones.request.RequestRegistrarVoto;
import com.cm.solidappservice.model.votaciones.response.ResponseCandidato;

public class VotacionesManager {
    
    private static VotacionesManager singleton = null;

	public static VotacionesManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (VotacionesManager.class) {
					if (null == singleton) {
						singleton = new VotacionesManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}
	
	public List<ResponseCandidato> obtenerCandidatosZona(RequestAutenticacion request) throws Exception {
		
		List<CandidatosMD> listModel=null;
		List<ResponseCandidato> response = new ArrayList<ResponseCandidato>();

		Integer estadoVotaciones = VotacionesDAO.getInstance().validarEstadoVotaciones();

		if(estadoVotaciones ==1 ) {

			String estadoVotante = VotacionesDAO.getInstance().consultarEstadoVotante(request.getCedula());
			if(estadoVotante != null && estadoVotante.equals("N")){
	
				Integer zonaElectoral = VotacionesDAO.getInstance().obtenerZonaElectoral(request.getCedula());

				if(zonaElectoral != null){
					listModel = VotacionesDAO.getInstance().getCandidatos(zonaElectoral);
				}else{
					throw new Exception("Error consultando los candidatos");
				}


			}else if(estadoVotante != null && estadoVotante.equals("S")){
				throw new Exception("El usuario ya registro su voto");
			}else{
				throw new Exception("Error consultando el estado del votante");
			}

		}else if (estadoVotaciones == 2) {
			throw new Exception("Votaciones cerradas");
		}else{
			throw new Exception("Error consultando el estado de la votacione");
		}		
		
		
		if(listModel != null && listModel.size() > 0){
			for(CandidatosMD rc : listModel){
				response.add(new ResponseCandidato(
					rc.getConsecutivo(),
					rc.getNombre(),
					rc.getZonaElectoral()
				));
			}
		}
		return response;		
	}


	public String registrarVoto(RequestRegistrarVoto request) throws Exception{

		//0: Votaciones cerradas -> Votaciones cerradas
		//1: Usuario ya voto -> El usuario ya registro su voto
		//2: Usuario no registrado -> Actual Error consultando el estado del votante

		//Valida que las votaciones esten abiertas
		String response = ResponseConstantes.ERROR_VACIO;

		Integer estadoVotaciones = VotacionesDAO.getInstance().validarEstadoVotaciones();

		if(estadoVotaciones == 1) {

			//Valida que el usuario no haya votado
			String estadoVotante = VotacionesDAO.getInstance().consultarEstadoVotante(request.getCedula());
			if(estadoVotante != null && estadoVotante.equals("N")){
				//Cambia estado votante a una S
				boolean seCambioEstado = VotacionesDAO.getInstance().cambiarEstadoVotante(request.getCedula());
				if(seCambioEstado){

					CandidatosMD candidato = VotacionesDAO.getInstance().consultarCandidato(new CandidatosMD(
						request.getIdCandidato(),
						request.getZonaElectoral()
					));
						
					//Suma voto a candidato
					boolean seRegistroVoto = VotacionesDAO.getInstance().registrarVoto(new CandidatosMD(
						request.getIdCandidato(),
						request.getZonaElectoral()
					));

					candidato = VotacionesDAO.getInstance().consultarCandidato(new CandidatosMD(
						request.getIdCandidato(),
						request.getZonaElectoral()
					));

					if(seRegistroVoto){
						response = "Se ha registrado el voto correctamente";
					}else{
						response = "Error al registrar el voto";
					}
				}else{
					throw new Exception("Error al cambiar el estado del votante");
				}
				
			}else if(estadoVotante != null && estadoVotante.equals("S")){
				throw new Exception("El usuario ya registro su voto");
			}else{
				throw new Exception("Error consultando el estado del votante");
			}

		}else if (estadoVotaciones == 2) {
			throw new Exception("Votaciones cerradas");
		}else{
			throw new Exception("Error consultando el estado de la votaciones");
		}		
		
		return response;
		
	}


}
