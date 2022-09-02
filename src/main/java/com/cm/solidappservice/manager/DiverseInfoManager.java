package com.cm.solidappservice.manager;

import java.util.ArrayList;
import java.util.List;

import com.cm.solidappservice.dao.DiverseInfoDAO;
import com.cm.solidappservice.dao.ParametrosGeneralesDAO;
import com.cm.solidappservice.model.diverseinfo.bd.*;
import com.cm.solidappservice.model.diverseinfo.response.*;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;

public class DiverseInfoManager {
	private static DiverseInfoManager singleton = null;

	public static DiverseInfoManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (DiverseInfoManager.class) {
					if (null == singleton) {
						singleton = new DiverseInfoManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public List<ResponsePortafolio> getPortafolio() throws Exception {
		List<PortafolioMD> portafolioMD = DiverseInfoDAO.getInstance().getPortafolio();
		List<ResponsePortafolio> response = new ArrayList<ResponsePortafolio>();
		if (portafolioMD != null && !portafolioMD.isEmpty()) {			
			List<String> tiposEncontrados = new ArrayList<String>();
			List<String> categorias = new ArrayList<String>();
			List<String> categoriasPadre = new ArrayList<String>();

			for (PortafolioMD p : portafolioMD) {
				if (!tiposEncontrados.contains(p.getI_tipprod())) {
					tiposEncontrados.add(p.getI_tipprod());
					categorias.add(p.getN_produc());
					categoriasPadre.add(p.getN_categoria());
				}
			}
			for (int i = 0; i < tiposEncontrados.size(); i++) {				
				ResponsePortafolio portafolioSE = new ResponsePortafolio();
				portafolioSE.setCategoria(categorias.get(i));
				portafolioSE.setCategoriaPadre(categoriasPadre.get(i));				
				for (PortafolioMD p : portafolioMD) {					
					if (p.getI_tipprod().equals(tiposEncontrados.get(i))) {
						List<PortafolioDetalleMD> detallePortafolio = DiverseInfoDAO.getInstance().getPortafolioDetalle(p);						
						for(PortafolioDetalleMD dp : detallePortafolio){
							portafolioSE.detalle.add(new ResponsePortafolio.DetallePortafolio(
								p.getN_produc(), 
								dp.getN_descorta(), 
								dp.getN_deslarga())
							);	
						}						
					}
				}				
				response.add(portafolioSE);
			}
		}
		return response;
	}
	
	public List<ResponsePreguntaFrecuente> getPreguntasFrecuentes() throws Exception {
		List<PreguntasFrecuentesMD> preguntasDAO = DiverseInfoDAO.getInstance().getPreguntasFrecuentes();
		List<ResponsePreguntaFrecuente> resultado = new ArrayList<ResponsePreguntaFrecuente>();
		if (preguntasDAO != null && !preguntasDAO.isEmpty()) {
			List<String> tiposPreguntas = new ArrayList<String>();
			for (PreguntasFrecuentesMD pregunta : preguntasDAO) {
				String i_tippre = String.valueOf(pregunta.getI_tippre());
				if (!tiposPreguntas.contains(i_tippre)) {
					tiposPreguntas.add(i_tippre);
				}
			}
			for (String tipo : tiposPreguntas) {
				ResponsePreguntaFrecuente preguntaSE = new ResponsePreguntaFrecuente();
				preguntaSE.setGrupo(tipo);
				for (PreguntasFrecuentesMD pregunta : preguntasDAO) {
					if (String.valueOf( pregunta.getI_tippre()).equals(tipo)) {
						preguntaSE.preguntas.add(new ResponsePreguntaFrecuente.PreguntaRespuesta(
							pregunta.getV_pregun(), pregunta.getV_respue()
						));
					}
				}
				resultado.add(preguntaSE);
			}
		}
		return resultado;
	}

	public List<ResponseRedesSociales> getRedesSociales() throws Exception {
		List<RedesSocialesMD> listModel = DiverseInfoDAO.getInstance().obtenerRedesSociales();
		List<ResponseRedesSociales> response = new ArrayList<ResponseRedesSociales>();
		if(listModel != null && listModel.size() > 0){
			for(RedesSocialesMD redSocial : listModel){
				response.add(new ResponseRedesSociales(
					redSocial.getK_idred(),
					redSocial.getN_redsocial(),
					redSocial.getV_link()
				));
			}
		}
		return response;
	}
	
	//EN DESUSO PROXIMAMENTE
	public List<ResponseDirectorioDeprecated> getDirectorioDeprecated() throws Exception {
		List<DirectorioMD> listModel =  DiverseInfoDAO.getInstance().getDirectorio();
		List<ResponseDirectorioDeprecated> response = new ArrayList<ResponseDirectorioDeprecated>();
		if(listModel != null && listModel.size() > 0){
			for(DirectorioMD directorio : listModel){
				response.add(new ResponseDirectorioDeprecated(
					directorio.getN_nombre(),
					directorio.getN_telefono(),
					directorio.getN_teleusu(),
					directorio.getI_orden()
				));
			}
		}
		return response;
	}
	public List<ResponseDirectorio> getDirectorio() throws Exception {
		List<DirectorioMD> listModel =  DiverseInfoDAO.getInstance().getDirectorio();
		List<ResponseDirectorio> response = new ArrayList<ResponseDirectorio>();
		if(listModel != null && listModel.size() > 0){
			for(DirectorioMD directorio : listModel){
				response.add(new ResponseDirectorio(
					directorio.getN_nombre(),
					directorio.getN_telefono(),
					directorio.getN_teleusu(),
					directorio.getI_orden()
				));
			}
		}
		return response;
	}

	public String getVersionActual() throws Exception {
		ParametrosGeneralesMD model = ParametrosGeneralesDAO.getInstance().obtenerParametrosVersionActual();
		if (model == null) {
			throw new Exception("Los parámetros de la aplicación están nulos.");
		}
		return String.valueOf(model.getN_value2());
	}

	public String[] getImagenesBeneficios() throws Exception {
		List<ImagenBeneficioMD> listModel = DiverseInfoDAO.getInstance().getImagenesBeneficios();
		String[] response = new String[listModel.size()];
		for (int i = 0; i < listModel.size(); i++) {
			response[i] = listModel.get(i).getN_url();
		}
		return response;
	}

	public ResponseImagenLogin getImageLogin() throws Exception {
		ImageLoginMD model = DiverseInfoDAO.getInstance().getImageLogin();
		ResponseImagenLogin response = new ResponseImagenLogin();
		response.setImageUrl(model.getN_url_imagenlogin());
		return response;
	}

	//EN DESUSO CUANDO getMensajesBanner SE APLIQUE EN LOS APLICATIVOS
	public List<MensajesBannerMD> getMensajesBannerDeprecated() throws Exception {
		List<MensajesBannerMD> response = DiverseInfoDAO.getInstance().obtenerMensajesBanner();
		return response;
	}
	public List<ResponseMensajesBanner> getMensajesBanner() throws Exception {
		List<MensajesBannerMD> listModel = DiverseInfoDAO.getInstance().obtenerMensajesBanner();
		List<ResponseMensajesBanner> response = new ArrayList<ResponseMensajesBanner>();
		if(listModel != null && listModel.size() > 0){
			for(MensajesBannerMD mensaje : listModel){
				response.add(new ResponseMensajesBanner(
					mensaje.getK_idmens(),
					mensaje.getN_mensaje()
				));
			}
		}
		return response;
	}

	//EN DESUSO CUANDO SE ELIMINE POR COMPLETO SU USO SE APLIQUE EN LOS APLICATIVOS
	public ResponseMensajesVersion getMensajesBannerVersionDeprecated() throws Exception {
		ResponseMensajesVersion response = new ResponseMensajesVersion();
		List<MensajesBannerMD> listModel = DiverseInfoDAO.getInstance().obtenerMensajesBanner();
		response.setMensajes(listModel);
		response.setVersion("A-1|I-1");
		return response;
	}

	//EN DESUSO CUANDO obtenerBannerComercial SE APLIQUE EN LOS APLICATIVOS
	public List<BannerComercialMD> obtenerBannerComercialDeprecated() throws Exception {
		List<BannerComercialMD> response = DiverseInfoDAO.getInstance().obtenerBannerComercial();
		return response;
	}
	public List<ResponseBannerComercial> obtenerBannerComercial() throws Exception {
		List<BannerComercialMD> listModel = DiverseInfoDAO.getInstance().obtenerBannerComercial();
		List<ResponseBannerComercial> response = new ArrayList<ResponseBannerComercial>();
		if(listModel != null && listModel.size() > 0){
			for(BannerComercialMD banner : listModel){
				response.add(new ResponseBannerComercial(
					banner.getK_banner(),
					banner.getN_banner(),
					banner.getN_url_imagen(),
					banner.getN_url_enlace(),
					banner.getI_estado()
				));
			}
		}
		return response;
	}
	

	//EN DESUSO CUANDO obtenerBannerComercial SE APLIQUE EN LOS APLICATIVOS
	public List<MasServiciosMD> obtenerOtrosServiciosDeprecated() throws Exception {
		List<MasServiciosMD> response = DiverseInfoDAO.getInstance().obtenerMenuMasServicios();
		return response;
	}
	public List<ResponseMenuMasServicios> obtenerOtrosServicios() throws Exception {
		List<MasServiciosMD> listModel = DiverseInfoDAO.getInstance().obtenerMenuMasServicios();
		List<ResponseMenuMasServicios> response = new ArrayList<ResponseMenuMasServicios>();
		if(listModel != null && listModel.size() > 0){
			for(MasServiciosMD servicio : listModel){
				response.add(new ResponseMenuMasServicios(
					servicio.getK_servicio(),
					servicio.getN_servicio(),
					servicio.getN_url_icono(),
					servicio.getN_url_enlace(),
					servicio.getI_estado(),
					servicio.getQ_orden()
				));
			}
		}
		return response;
	}

	public List<ResponseMensajesRespuesta> obtenerMensajesRespuesta() throws Exception {
		List<ReplyMessagesMD> listModel = DiverseInfoDAO.getInstance().obtenerMensajesRespuesta();
		List<ResponseMensajesRespuesta> response = new ArrayList<ResponseMensajesRespuesta>();
		if(listModel != null && listModel.size() > 0){
			for(ReplyMessagesMD mensaje : listModel){
				response.add(new ResponseMensajesRespuesta(
					mensaje.getK_mensajeresp(),
					mensaje.getN_tipomensaje(),
					mensaje.getN_mensajeresp()
				));
			}
		}
		return response;
	}
	

}