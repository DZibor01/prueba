package com.cm.solidappservice.dao;

import java.util.List;

import com.cm.solidappservice.model.diverseinfo.bd.*;

public class DiverseInfoDAO extends DAO2 {
	private static DiverseInfoDAO singleton = null;

	private static final String QUERY_OBTENER_PORTAFOLIO = "DiverseInfoMapper.selectPortafolio";
	private static final String QUERY_OBTENER_PORTAFOLIO_DETALLE = "DiverseInfoMapper.selectPortafolioDetalle";
	private static final String QUERY_OBTENER_PREGUNTAS_FRECUENTES = "DiverseInfoMapper.selectPreguntasFrecuentes";
	private static final String QUERY_OBTENER_IMAGELOGIN = "DiverseInfoMapper.selectImageLogin";	
	private static final String QUERY_OBTENER_SERVER_PARAMETERS = "DiverseInfoMapper.selectServerParameters";
	private static final String QUERY_OBTENER_REPLYMESSAGES = "DiverseInfoMapper.selectReplyMessages";
	private static final String QUERY_OBTENER_DIRECTORIO = "DiverseInfoMapper.selectDirectorio";
	private static final String QUERY_OBTENER_REDESOCIALES = "DiverseInfoMapper.obtenerRedesSociales";
	private static final String QUERY_OBTENER_IMAGENES_BENEFICIOS = "DiverseInfoMapper.selectImagenesBeneficios";
	private static final String QUERY_OBTENER_MENSAJES_BANNER = "DiverseInfoMapper.obtenerMensajesBanner";
	private static final String QUERY_OBTENER_BANNER_COMERCIAL = "DiverseInfoMapper.obtenerBannerComercial";
	private static final String QUERY_OBTENER_MENU_MAS_SERVICIOS = "DiverseInfoMapper.obtenerMenuMasServicios";

	public static DiverseInfoDAO getInstance() {
		if (singleton == null) {
			try {
				synchronized (DiverseInfoDAO.class) {
					if (null == singleton) {
						singleton = new DiverseInfoDAO();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	public List<PortafolioMD> getPortafolio() throws Exception {
		return getList(QUERY_OBTENER_PORTAFOLIO, null);
	}
	// List<PortafolioMD> testPortafolio (){
	// 	List<PortafolioMD> l = new ArrayList<PortafolioMD>();
	// 	return l;
	// }
	
	public List<PortafolioDetalleMD> getPortafolioDetalle(PortafolioMD model) throws Exception {
		return getList(QUERY_OBTENER_PORTAFOLIO_DETALLE, model);
	}
	
	public List<PreguntasFrecuentesMD> getPreguntasFrecuentes() throws Exception {
		return getList(QUERY_OBTENER_PREGUNTAS_FRECUENTES, null);
	}

	public List<RedesSocialesMD> obtenerRedesSociales() throws Exception {
		return getList(QUERY_OBTENER_REDESOCIALES, null);
	}
	
	public List<DirectorioMD> getDirectorio() throws Exception {
		return getList(QUERY_OBTENER_DIRECTORIO, null);
	}
	
	public ServerParametersMD getServerParameters() throws Exception {
		List<ServerParametersMD> listModel = getList(ServerParametersMD.class, QUERY_OBTENER_SERVER_PARAMETERS, null);
		if(listModel.size() > 0){
			return listModel.get(0);	
		}else{
			return null;
		}
	}
	
	public List<ImagenBeneficioMD> getImagenesBeneficios() throws Exception{
		return getList(QUERY_OBTENER_IMAGENES_BENEFICIOS, null);
	}
	
	public ImageLoginMD getImageLogin() throws Exception {
		List<ImageLoginMD> listModel = getList(QUERY_OBTENER_IMAGELOGIN, null);
		if(listModel.size() > 0){
			return listModel.get(0);	
		}else{
			return null;
		}
	}

	public List<MensajesBannerMD> obtenerMensajesBanner() throws Exception {
		return getList(QUERY_OBTENER_MENSAJES_BANNER, null);
	}

	public List<BannerComercialMD> obtenerBannerComercial() throws Exception {
        return getList(QUERY_OBTENER_BANNER_COMERCIAL, null);
    }

	public List<MasServiciosMD> obtenerMenuMasServicios() throws Exception {
        return getList(QUERY_OBTENER_MENU_MAS_SERVICIOS, null);
    }

	public List<ReplyMessagesMD>  obtenerMensajesRespuesta() throws Exception {
		return getList(ReplyMessagesMD.class, QUERY_OBTENER_REPLYMESSAGES, null);
	}

}