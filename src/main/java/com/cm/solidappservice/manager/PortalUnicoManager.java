package com.cm.solidappservice.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cm.solidappservice.dao.PortalUnicoDAO;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.diverseinfo.bd.BannerComercialMD;
import com.cm.solidappservice.model.portalunico.bd.CompraCertificadoMD;
import com.cm.solidappservice.model.portalunico.bd.PropiedadesCertLibertadMD;
import com.cm.solidappservice.model.portalunico.bd.RegistroIngresosMD;
import com.cm.solidappservice.model.portalunico.bd.RegistroVotacionesMD;
import com.cm.solidappservice.model.portalunico.request.Propiedad;
import com.cm.solidappservice.model.portalunico.request.RequestRegistroIngreso;
import com.cm.solidappservice.model.portalunico.request.RequestRegistroIngresoDeprecated;
import com.cm.solidappservice.model.portalunico.request.RequestSolicitarCertificado;
import com.cm.solidappservice.model.portalunico.request.RequestRegistroVotaciones;
import com.cm.solidappservice.model.portalunico.response.ResponseBannerLogin;
import com.cm.solidappservice.model.portalunico.response.ResponseSolicitarCeriticado;

public class PortalUnicoManager {
    
    private static PortalUnicoManager singleton = null;

	public static PortalUnicoManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (PortalUnicoManager.class) {
					if (null == singleton) {
						singleton = new PortalUnicoManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	//EN DESUSO PROXIMAMENTE
	public String registrarIngresoPortalUnicoDeprecated(RequestRegistroIngresoDeprecated request) throws Exception {
		RegistroIngresosMD model = new RegistroIngresosMD();
		model.setAanumnit(request.getCedula());
		model.setI_aceptacion(request.getI_aceptacion());
		model.setF_login(request.getF_login());
		String response = PortalUnicoDAO.getInstance().registrarIngresoPortalUnico(model);
		return response;
	}
	public String registrarIngresoPortalUnico(RequestRegistroIngreso request) throws Exception {
		RegistroIngresosMD model = new RegistroIngresosMD();
		model.setAanumnit(request.getCedula());
		model.setI_aceptacion(request.getAceptaTyc());
		model.setF_login(request.getFechaLogin());
		String response = PortalUnicoDAO.getInstance().registrarIngresoPortalUnico(model);
		return response;
	}
	
	public List<ResponseBannerLogin> obtenerBannerLogin() throws Exception {
		List<BannerComercialMD> listModel = PortalUnicoDAO.getInstance().obtenerBannerLogin();
		List<ResponseBannerLogin> response = new ArrayList<ResponseBannerLogin>();
		if(listModel != null && listModel.size()>0){
			for(BannerComercialMD baner : listModel){
				response.add(new ResponseBannerLogin(
					baner.getK_banner(),
					baner.getN_banner(),
					baner.getN_url_imagen(),
					baner.getN_url_enlace(),
					baner.getI_estadoportal()
				));
			}
		}
		return response;
	}

	public ResponseSolicitarCeriticado solicitarCertificadoLibertad(RequestSolicitarCertificado request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String idTransaccion = String.valueOf(timestamp.getTime());
		String resultTransaccion = procesarCompra(request, idTransaccion);
		if(resultTransaccion != null && !resultTransaccion.isEmpty() && resultTransaccion.equals(ResponseConstantes.RESULTADO_EXITOSO)){
			registrarPropiedadesCertificado(request.getPropiedades(), idTransaccion);
			return new ResponseSolicitarCeriticado(
				idTransaccion,
				ResponseConstantes.RESULTADO_EXITOSO,
				""
			);
		}else{
			return new ResponseSolicitarCeriticado(
				"",
				"ERROR",
				resultTransaccion
			);
		}
	}

	private String procesarCompra(RequestSolicitarCertificado request, String idTransaccion) throws Exception{
		CompraCertificadoMD model = PortalUnicoDAO.getInstance().procesarCompra(request, idTransaccion);
		if(model != null && model.getV_RESULT() != null && model.getV_RESULT().equals("1")){
			return ResponseConstantes.RESULTADO_EXITOSO;
		}else{
			return model != null && model.getV_MESSAGE_ERROR() != null && !model.getV_MESSAGE_ERROR().isEmpty() ?
			model.getV_MESSAGE_ERROR() : "Hubo un error al realizar la compra del certificado";
		}
	}

	private void registrarPropiedadesCertificado(List<Propiedad> propiedades, String idTransaccion){
		try{
			if(propiedades != null && propiedades.size()>0){
				for(Propiedad pr : propiedades){
					PortalUnicoDAO.getInstance().registrarPropiedadesCertificado(new PropiedadesCertLibertadMD(
						idTransaccion,
						pr.getNumeroMatricula(),
						pr.getDireccionPropiedad(),
						pr.getIdDepartamento(),
						pr.getNombreDepartamento(),
						pr.getIdCiudad(),
						pr.getNombreCiudad()
					));
				}
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	public String registrarHistorialVotaciones(RequestRegistroVotaciones request) throws Exception {
		String response = PortalUnicoDAO.getInstance().registrarHistorialVotacion(new RegistroVotacionesMD(
			request.getCedula(),
			request.getFechaIngreso()
		));
		return response;
	}

}
