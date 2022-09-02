package com.cm.solidappservice.manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cm.solidappservice.dao.*;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.datosasociado.bd.ConsultaDatosAsociadoMD;
import com.cm.solidappservice.model.datosasociado.bd.DatosBasicosAsociadoMD;
import com.cm.solidappservice.model.datosasociado.bd.FormatoDireccionesMD;
import com.cm.solidappservice.model.datosasociado.bd.RegistraDatosActualizadosMD;
import com.cm.solidappservice.model.datosasociado.request.RequestActualizarDatos;
import com.cm.solidappservice.model.datosasociado.response.ItemsDirecciones;
import com.cm.solidappservice.model.datosasociado.response.ResponseConsultarDatosAsociado;
import com.cm.solidappservice.model.datosasociado.response.ResponseDatosBasicosAsociado;
import com.cm.solidappservice.model.datosasociado.response.ResponseDatosBasicosAsociadoDeprecated;
import com.cm.solidappservice.model.datosasociado.response.ResponseFormatoDirecciones;
import com.cm.solidappservice.model.login.response.DatosActualizados;

public class DatosAsociadoManager {

    private static DatosAsociadoManager singleton = null;

	public static DatosAsociadoManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (DatosAsociadoManager.class) {
					if (null == singleton) {
						singleton = new DatosAsociadoManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}


     //----------------------------------------------------------------------------------------
	//------------------------------Seccion Datos Asociado-------------------------------------
	public ResponseConsultarDatosAsociado consultarDatosAsociado(RequestAutenticacion autenticacion) throws Exception {
		ConsultaDatosAsociadoMD model = DatosAsociadoDAO.getInstance().consultarDatosAsociado(autenticacion.getCedula());
        ResponseConsultarDatosAsociado response = new ResponseConsultarDatosAsociado();
        if(response != null){
            response = new ResponseConsultarDatosAsociado(
                model.getVa_anumnit(),
                model.getVn_nombre(),
                model.getVd_direcc() == null ? "" : model.getVd_direcc(),
                model.getVt_celular() == null ? "" : model.getVt_celular(),
                model.getVd_email() == null ? "" : model.getVd_email(),
                model.getVn_barrio() == null ? "" : model.getVn_barrio(),
                model.getVk_ciudad(),
                model.getVn_ciudad() == null ? "" : model.getVn_ciudad().trim(),
                model.getVk_depart(),
                model.getVn_depart() == null ? "" : model.getVn_depart(),
                model.getVk_pais(),
                model.getVn_pais() == null ? "" : model.getVn_pais()
            );
        }
		return response;
	}

	public DatosActualizados validarDatosActualizados(String cedula) throws Exception {
		List<RegistraDatosActualizadosMD> model =  DatosAsociadoDAO.getInstance().obtenerRegistroDatosActualizados(cedula);
		String primeraVezActualiza = ResponseConstantes.CAMPO_TRUE;
		String tieneDatosActualizados = ResponseConstantes.CAMPO_FALSE;
		Date ultimaFechaActualizacion = new Date();
		String canal = "";
		if(model != null && model.size() > 0){
			primeraVezActualiza = ResponseConstantes.CAMPO_FALSE;
			
			String tiempoMeses = ParametrosGeneralesDAO.getInstance().obtenerParametrosMesesActualizarDatos().getN_value1();
			for(RegistraDatosActualizadosMD rd : model){
				ultimaFechaActualizacion = rd.getF_actdatos(); 
				canal = rd.getN_canal();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(rd.getF_actdatos());
				calendar.add(Calendar.MONTH, Integer.parseInt(tiempoMeses));
				Date fechaFin  = calendar.getTime();
				Integer compare = fechaFin.compareTo(new Date());
				if(compare > 0){
					tieneDatosActualizados = ResponseConstantes.CAMPO_TRUE;
				}				
			}
		}
		DatosActualizados datosActualizados = new DatosActualizados(
			primeraVezActualiza,
			tieneDatosActualizados,
			ultimaFechaActualizacion,
			canal
		);
		return datosActualizados;
	}

	public String actualizarDatosAsociado(RequestActualizarDatos request) throws Exception {
		String response = DatosAsociadoDAO.getInstance().actualizarDatosAsociado(request);
		return response;
	}


	public ResponseFormatoDirecciones obtenerFormatoDirecciones() throws Exception {
		List<FormatoDireccionesMD> listaTiposVia = DatosAsociadoDAO.getInstance().obtenerTiposVia();
		List<FormatoDireccionesMD> listaLetrasVia = DatosAsociadoDAO.getInstance().obtenerLetrasVia();
		List<FormatoDireccionesMD> listaComplVia = DatosAsociadoDAO.getInstance().obtenerComplementosVia();

		List<ItemsDirecciones> responseTiposVia = new ArrayList<ItemsDirecciones>();
		List<ItemsDirecciones> responseLetrasVia = new ArrayList<ItemsDirecciones>();
		List<ItemsDirecciones> responseComplementosVia = new ArrayList<ItemsDirecciones>();

		for(FormatoDireccionesMD rd : listaTiposVia){
			responseTiposVia.add(new ItemsDirecciones(
				rd.getRv_abbreviation(),
				rd.getRv_meaning()
			));
		}

		for(FormatoDireccionesMD rd : listaLetrasVia){
			responseLetrasVia.add(new ItemsDirecciones(
				rd.getRv_abbreviation(),
				rd.getRv_meaning()
			));
		}

		for(FormatoDireccionesMD rd : listaComplVia){
			responseComplementosVia.add(new ItemsDirecciones(
				rd.getRv_abbreviation(),
				rd.getRv_meaning()
			));
		}

		ResponseFormatoDirecciones response = new ResponseFormatoDirecciones(
			responseTiposVia,
			responseLetrasVia,
			responseComplementosVia
		);
		return response;
	}

	//EN DESUSO PROXIMAMENTE
	public ResponseDatosBasicosAsociadoDeprecated obtenerDatosBasicosAsociadoDeprecated(RequestAutenticacion autenticacion) throws Exception {
		DatosBasicosAsociadoMD model = DatosAsociadoDAO.getInstance().obtenerDatosBasicosAsociado(autenticacion.getCedula());
		return new ResponseDatosBasicosAsociadoDeprecated(
			model.getAANUMNIT() == null ? "" : model.getAANUMNIT(),
			model.getIIDETER() == null ? "" : model.getIIDETER(),
			model.getNAPELL1() == null ? "" : model.getNAPELL1(),
			model.getNAPELL2() == null ? "" : model.getNAPELL2(),
			model.getNNOMBR1() == null ? "" : model.getNNOMBR1(),
			model.getNNOMBR2() == null ? "" : model.getNNOMBR2()
		);
	}
	public ResponseDatosBasicosAsociado obtenerDatosBasicosAsociado(RequestAutenticacion autenticacion) throws Exception {
		DatosBasicosAsociadoMD model = DatosAsociadoDAO.getInstance().obtenerDatosBasicosAsociado(autenticacion.getCedula());
		return new ResponseDatosBasicosAsociado(
			model.getIIDETER(),
			model.getAANUMNIT(),
			model.getNAPELL1(),
			model.getNAPELL2(),
			model.getNNOMBR1(),
			model.getNNOMBR2()
		);
	}

}
