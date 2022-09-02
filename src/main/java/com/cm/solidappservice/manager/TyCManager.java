package com.cm.solidappservice.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cm.solidappservice.dao.TyCDAO;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.tyc.bd.TyCAceptadosMD;
import com.cm.solidappservice.model.tyc.bd.TyCMD;
import com.cm.solidappservice.model.tyc.request.RequestTyC;
import com.cm.solidappservice.model.tyc.request.RequestTyCDeprecated;
import com.cm.solidappservice.model.tyc.response.ResponseTyC;
import com.cm.solidappservice.model.tyc.response.ResponseTyCAceptadosDeprecated;
import com.cm.solidappservice.model.tyc.response.ResponseTyCDeprecated;

public class TyCManager {
    
    private static TyCManager singleton = null;

	public static TyCManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (TyCManager.class) {
					if (null == singleton) {
						singleton = new TyCManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	//EN DESUSO PROXIMAMENTE
	public String registrarTyCAceptadosDeprecated(RequestTyCDeprecated request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());            
		TyCAceptadosMD model = new TyCAceptadosMD();
		model.setK_aceptacion(id);
		model.setAanumnit(request.getCedula());
		model.setK_termycond(request.getK_termycond());
		model.setF_aceptacion(request.getF_aceptacion());
		model.setI_aceptacion(request.getI_aceptacion());
		model.setIp(request.getIp());
		TyCDAO.getInstance().registrarTyCAceptados(model);		          
		return ResponseConstantes.RESULTADO_EXITOSO;
	}
	public String registrarTyCAceptados(RequestTyC request) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String id = String.valueOf(timestamp.getTime());            
		TyCAceptadosMD model = new TyCAceptadosMD();
		model.setK_aceptacion(id);
		model.setAanumnit(request.getCedula());
		model.setK_termycond(request.getIdTyc());
		model.setF_aceptacion(request.getFechaAceptacion());
		model.setI_aceptacion(request.getAceptaTyC());
		model.setIp(request.getIp());
		TyCDAO.getInstance().registrarTyCAceptados(model);	
		return ResponseConstantes.RESULTADO_EXITOSO;
	}

	//EN DESUSO PROXIMAMENTE
	public List<ResponseTyCAceptadosDeprecated> obtenerTerminosAceptadosDeprecated(RequestAutenticacion request) throws Exception {
		List<TyCAceptadosMD> listModel = TyCDAO.getInstance().obtenerTerminosAceptados(request.getCedula());
		List<ResponseTyCAceptadosDeprecated> response = new ArrayList<ResponseTyCAceptadosDeprecated>();
		if(listModel != null && listModel.size()>0){
			for(TyCAceptadosMD tyc : listModel){
				response.add(new ResponseTyCAceptadosDeprecated(
					tyc.getK_aceptacion(),
					tyc.getAanumnit(),
					tyc.getK_termycond(),
					tyc.getF_aceptacion(),
					tyc.getI_aceptacion(),
					tyc.getIp()
				));
			}
		}
		return response;
	}
	
	//EN DESUSO PROXIMAMENTE
	public List<ResponseTyCDeprecated> obtenerTerminosDeprecated() throws Exception {
		List<TyCMD> listModel = TyCDAO.getInstance().obtenerTerminosyCondiciones();
		List<ResponseTyCDeprecated> response = new ArrayList<ResponseTyCDeprecated>();
		if(listModel != null && listModel.size()>0){
			for(TyCMD tyc : listModel){
				response.add(new ResponseTyCDeprecated(
					tyc.getK_termycond(),
					tyc.getN_termycond(),
					tyc.getF_modificacion(),
					tyc.getI_estado()
				));
			}
		}
		return response;
	}
	public List<ResponseTyC> obtenerTerminos() throws Exception {
		List<TyCMD> listModel = TyCDAO.getInstance().obtenerTerminosyCondiciones();
		List<ResponseTyC> response = new ArrayList<ResponseTyC>();
		if(listModel != null && listModel.size()>0){
			for(TyCMD tyc : listModel){
				response.add(new ResponseTyC(
					tyc.getK_termycond(),
					tyc.getN_termycond(),
					tyc.getF_modificacion(),
					tyc.getI_estado()
				));
			}
		}
		return response;
	}

	public String getValidarTerminosAceptados(String cedula) throws Exception {
		TyCAceptadosMD model = TyCDAO.getInstance().obtenerTyCCedula(cedula);
		String aceptaTyC = ResponseConstantes.CAMPO_FALSE;
		if(model != null){
			aceptaTyC = 
				model.getK_termycond() == null || model.getK_termycond() == 0 ? 
						ResponseConstantes.CAMPO_FALSE : 
						ResponseConstantes.CAMPO_TRUE;
		} 
		return aceptaTyC;
	}

}
