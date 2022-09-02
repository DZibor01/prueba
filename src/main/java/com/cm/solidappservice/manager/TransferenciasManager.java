package com.cm.solidappservice.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cm.solidappservice.dao.TransferenciaDAO;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.transferencias.bd.BancoMD;
import com.cm.solidappservice.model.transferencias.bd.CuentaDisponibleMD;
import com.cm.solidappservice.model.transferencias.bd.CuentaInscritaMD;
import com.cm.solidappservice.model.transferencias.bd.SolicitudInscripcionCuentaMD;
import com.cm.solidappservice.model.transferencias.bd.TransferenciaMD;
import com.cm.solidappservice.model.transferencias.request.RequestEliminacionCuenta;
import com.cm.solidappservice.model.transferencias.request.RequestRealizarTransferencia;
import com.cm.solidappservice.model.transferencias.request.RequestSolicitudInscripcionCuenta;
import com.cm.solidappservice.model.transferencias.request.RequestTransferenciaDeprecated;
import com.cm.solidappservice.model.transferencias.response.CuentaInscrita;
import com.cm.solidappservice.model.transferencias.response.ResponseBanco;
import com.cm.solidappservice.model.transferencias.response.ResponseCuentaDisponibleDeprecated;
import com.cm.solidappservice.model.transferencias.response.ResponseCuentaInscritaDeprecated;
import com.cm.solidappservice.model.transferencias.response.ResponseCuentasDisponibles;
import com.cm.solidappservice.model.transferencias.response.ResponseCuentasInscritas;
import com.cm.solidappservice.model.transferencias.response.ResponseTransferenciasIncompletas;
import com.cm.solidappservice.model.transferencias.response.ResponseTransferenciasIncompletasDeprecated;

public class TransferenciasManager {
    
    private static TransferenciasManager singleton = null;

	public static TransferenciasManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (TransferenciasManager.class) {
					if (null == singleton) {
						singleton = new TransferenciasManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	//EN DESUSO PROXIMAMENTE
	public List<ResponseCuentaInscritaDeprecated> obtenerCuentasInscritasDeprecated(String cedula) throws Exception {
		List<CuentaInscritaMD> listModel = TransferenciaDAO.getInstance().obtenerCuentasInscritas(cedula);
		List<ResponseCuentaInscritaDeprecated> response = new ArrayList<ResponseCuentaInscritaDeprecated>();
		if(listModel != null && listModel.size()>0){
			for(CuentaInscritaMD cuenta : listModel){
				response.add(new ResponseCuentaInscritaDeprecated(
					cuenta.getAanumnit(),
					cuenta.getNnasocia(),
					cuenta.getK_cuenta(),
					cuenta.getN_numcta(),
					cuenta.getF_fecape(),
					cuenta.getI_estado(),
					cuenta.getK_idterc_tit(),
					cuenta.getK_idterc(),
					cuenta.getNnasocia_o(),
					cuenta.getAanumnit_o()
				));
			}
		}
		return response;
	}
	public ResponseCuentasInscritas obtenerCuentasInscritas(String cedula) throws Exception {
		List<CuentaInscritaMD> cuentas = TransferenciaDAO.getInstance().obtenerCuentasInscritas(cedula);
		ResponseCuentasInscritas response = null;
		if(cuentas != null & cuentas.size() > 0){
			response = new ResponseCuentasInscritas();
			response.setIdAsociado(cuentas.get(0).getK_idterc());
			response.setCedulaAsociado(cuentas.get(0).getAanumnit_o());
			response.setNombreAsociado(cuentas.get(0).getNnasocia_o());
			List<CuentaInscrita> listaCuentas = new ArrayList<CuentaInscrita>();
			for(CuentaInscritaMD cu : cuentas){
				listaCuentas.add(new CuentaInscrita(
					cu.getAanumnit(),
					cu.getNnasocia(),
					cu.getK_idterc_tit(),
					cu.getK_cuenta(),
					cu.getN_numcta(),
					cu.getF_fecape(),
					cu.getI_estado()
				));
			}
			response.setCuentasInscritas(listaCuentas);
		}
		return response;
	}

	//EN DESUSO PROXIMAMENTE
	public List<ResponseCuentaDisponibleDeprecated> obtenerCuentasDisponiblesDeprecated(String cedula) throws Exception {
		List<CuentaDisponibleMD> listModel = TransferenciaDAO.getInstance().obtenerCuentasDisponibles(cedula);
		List<ResponseCuentaDisponibleDeprecated> response = new ArrayList<ResponseCuentaDisponibleDeprecated>();
		if(listModel != null && listModel.size()>0){
			for(CuentaDisponibleMD cuenta : listModel){
				response.add(new ResponseCuentaDisponibleDeprecated(
					cuenta.getA_numcta(),
					cuenta.getNnasocia(),
					cuenta.getAanumnit()
				));
			}
		}
		return response;
	}
	public List<ResponseCuentasDisponibles> obtenerCuentasDisponibles(String cedula) throws Exception {
		List<CuentaDisponibleMD> cuentas = TransferenciaDAO.getInstance().obtenerCuentasDisponibles(cedula);
		List<ResponseCuentasDisponibles> response = new ArrayList<ResponseCuentasDisponibles>();
		if(cuentas != null && cuentas.size() > 0){
			response = new ArrayList<ResponseCuentasDisponibles>();
			for(CuentaDisponibleMD cd : cuentas){
				response.add(new ResponseCuentasDisponibles(
					cd.getAanumnit(),
					cd.getNnasocia(),
					cd.getA_numcta()
				));
			}
		}
		return response;
	}

	public List<ResponseBanco> getListadoBancos() throws Exception {
		List<ResponseBanco> response = new ArrayList<ResponseBanco>();
		List<BancoMD> listModel = TransferenciaDAO.getInstance().obtenerListadoBancos();
		for (int i = 0; i < listModel.size(); i++) {
			ResponseBanco banco = new ResponseBanco();
			banco.setCodigo(listModel.get(i).getK_codban());
			banco.setNombre(listModel.get(i).getN_banco());
			response.add(banco);
		}
		return response;
	}

	public String solicitarInscribirCuenta(RequestSolicitudInscripcionCuenta request) throws Exception {
		SolicitudInscripcionCuentaMD model = new SolicitudInscripcionCuentaMD();
		model.setId_dispositivo(request.getIdDispositivo());
		model.setAanumnit_o(request.getCedula());
		model.setI_tipcta(request.getTipoCuenta());
		model.setK_codban(request.getCodigoBanco());
		model.setN_cuenta(request.getNumeroCuenta());
		model.setA_numnit_tit(request.getCedulaInscripcion());
		model.setN_tercer(request.getNombreCuenta());
		TransferenciaDAO.getInstance().solicitarInscribirCuenta(model);
		return ResponseConstantes.RESULTADO_EXITOSO;
	}

	//EN DESUSO PROXIMAMENTE
	public String realizarTransferenciaDeprecated(RequestTransferenciaDeprecated request) throws Exception {
		TransferenciaMD model = new TransferenciaMD();
		model.setA_numdoc(request.getA_numdoc());
		model.setAanumnit_o(request.getAanumnit_o());
		model.setF_solici(new Date());
		model.setId_dispositivo(request.getId_dispositivo());
		model.setK_idterc(Long.parseLong(request.getK_idterc()));
		model.setK_idterc_tit(Long.parseLong(request.getK_idterc_tit()));
		model.setN_numcta(request.getN_numcta());
		model.setV_valor(Double.parseDouble(request.getV_valor()));
		if (model.getV_valor() <= 0) {
			throw new Exception("El valor de la transferencia debe ser superior a cero.");
		}
		TransferenciaDAO.getInstance().realizarTransferencia(model);
		return "Solicitud de transferencia registrada correctamente.";
	}
	public String realizarTransferencia(RequestRealizarTransferencia request) throws Exception {
		TransferenciaMD model = new TransferenciaMD();
		model.setId_dispositivo(request.getIdDispositivo());
		model.setK_idterc(Long.parseLong(request.getIdAsociadoOrigen()));
		model.setAanumnit_o(request.getCedulaOrigen());
		model.setA_numdoc(request.getCuentaOrigen());
		model.setK_idterc_tit(Long.parseLong(request.getIdAsociadoDestino()));
		model.setN_numcta(request.getCuentaDestino());
		model.setF_solici(request.getFechaSolicitud());
		model.setV_valor(Double.parseDouble(request.getValorTransferencia()));

		if (model.getV_valor() <= 0) {
			throw new Exception("El valor de la transferencia debe ser superior a cero.");
		}
		TransferenciaDAO.getInstance().realizarTransferencia(model);
		return "Solicitud de transferencia registrada correctamente.";
	}

	//EN DESUSO PROXIMAMENTE
	public List<ResponseTransferenciasIncompletasDeprecated> consultarTransferenciasIncompletasDeprecated(RequestAutenticacion request) throws Exception {
		List<TransferenciaMD> listaModel = TransferenciaDAO.getInstance().obtenerTransferenciasIncompletas(request.getCedula());
		List<ResponseTransferenciasIncompletasDeprecated> response = new ArrayList<ResponseTransferenciasIncompletasDeprecated>();
		if(listaModel != null && listaModel.size() > 0){
			for(TransferenciaMD tr : listaModel){
				response.add(new ResponseTransferenciasIncompletasDeprecated(
					tr.getId_dispositivo(),
					tr.getAanumnit_o(),
					tr.getA_numdoc(),
					tr.getV_valor(),
					tr.getK_idterc(),
					tr.getK_idterc_tit(),
					tr.getN_numcta(),
					tr.getF_solici(),
					tr.getK_ano_mov(),
					tr.getK_sucurs_mov(),
					tr.getK_numdoc_mov(),
					tr.getK_tipdoc_mov(),
					tr.getN_observ()
				));
			}
		}
		return response;
	}
	public List<ResponseTransferenciasIncompletas> consultarTransferenciasIncompletas(RequestAutenticacion parametros) throws Exception {
		List<TransferenciaMD> listaModel = TransferenciaDAO.getInstance().obtenerTransferenciasIncompletas(
			parametros.getCedula());
		List<ResponseTransferenciasIncompletas> response = new ArrayList<ResponseTransferenciasIncompletas>();
		if(listaModel != null && listaModel.size() > 0){
			for(TransferenciaMD tr : listaModel){
				response.add(new ResponseTransferenciasIncompletas(
					tr.getId_dispositivo(),
					tr.getK_idterc(),
					tr.getAanumnit_o(),
					tr.getA_numdoc(),
					tr.getK_idterc_tit(),
					tr.getN_numcta(),
					tr.getV_valor(),
					tr.getN_observ() == null ? "" : tr.getN_observ(),
					tr.getF_solici()
				));
			}
		}
		return response;
	}

	public String eliminarCuenta(RequestEliminacionCuenta request) throws Exception {
		return TransferenciaDAO.getInstance().eliminarCuenta(request);
	}

	//EN DESUSO
	// public String inscribirCuenta(com.cm.solidappservice.model.RequestInscripcionCuenta parametro)
	// 		throws Exception {
	// 	return com.cm.solidappservice.dao.TransferenciaDAO.getInstance().inscribirCuenta(parametro);
	// }


}
