package com.cm.solidappservice.manager;

import java.util.ArrayList;
import java.util.List;

import com.cm.solidappservice.dao.EstadoCuentaDAO;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.base.ResponseConstantes;
import com.cm.solidappservice.model.estadocuenta.bd.EstadoCuentaMD;
import com.cm.solidappservice.model.estadocuenta.bd.MovimientoMD;
import com.cm.solidappservice.model.estadocuenta.request.RequestMovimientosCuenta;
import com.cm.solidappservice.model.estadocuenta.request.RequestMovimientosCuentasDeprecated;
import com.cm.solidappservice.model.estadocuenta.response.MovimientosProducto;
import com.cm.solidappservice.model.estadocuenta.response.Producto;
import com.cm.solidappservice.model.estadocuenta.response.ResponseConsultarCuentas;
import com.cm.solidappservice.model.estadocuenta.response.ResponseConsultarCuentasDeprecated;
import com.cm.solidappservice.model.estadocuenta.response.ResponseEstadoMisAportes;
import com.cm.solidappservice.model.estadocuenta.response.ResponseEstadoMisAportesDeprecated;
import com.cm.solidappservice.model.estadocuenta.response.ResponseMovimientoCuentaDeprecated;
import com.cm.solidappservice.model.estadocuenta.response.ResponseMovimientosCuenta;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosGeneralesMD;
import com.cm.solidappservice.security.Encripcion;
import com.cm.solidappservice.utils.Utilities;

public class EstadoCuentaManager {
    
    private static EstadoCuentaManager singleton = null;

	public static EstadoCuentaManager getInstance() {
		if (singleton == null) {
			try {
				synchronized (EstadoCuentaManager.class) {
					if (null == singleton) {
						singleton = new EstadoCuentaManager();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return singleton;
	}

	//EN DESUSO PROXIMAMENTE
	public List<ResponseConsultarCuentasDeprecated> getCuentasDeprecated(RequestAutenticacion request) throws Exception {
		List<ResponseConsultarCuentasDeprecated> response = new ArrayList<ResponseConsultarCuentasDeprecated>();
		EstadoCuentaDAO.getInstance().procesarSaldosCuentas(new EstadoCuentaMD(request.getCedula()));
		List<EstadoCuentaMD> listModel = EstadoCuentaDAO.getInstance().obtenerCuentasDeprecated(new EstadoCuentaMD(request.getCedula()));
		if (listModel != null) {
			for (EstadoCuentaMD ec : listModel) {				
				ResponseConsultarCuentasDeprecated estado = new ResponseConsultarCuentasDeprecated();
				estado.setAanumnit(Encripcion.getInstance().encriptar(ec.getAanumnit()));
				estado.setN_tipodr(ec.getN_tipodr());
				estado.setA_tipodr(ec.getA_tipodr());
				estado.setA_numdoc(Encripcion.getInstance().encriptar(ec.getA_numdoc()));
				estado.setV_saldo(ec.getV_saldo());
				estado.setV_vencid(ec.getV_vencid());
				if (ec.getF_vencim() != null) {
					estado.setF_vencim(Utilities.getFechaString(ec.getF_vencim()));
				} else {
					estado.setF_vencim(ResponseConstantes.CADENA_VACIA);
				}
				estado.setN_produc(ec.getN_produc());
				if (ec.getF_actual() != null) {
					estado.setF_actual(Utilities.getFechaString(ec.getF_actual()));
				} else {
					estado.setF_actual(ResponseConstantes.CADENA_VACIA);
				}
				estado.setQ_diaven(ec.getQ_diaven());
				estado.setV_cuota(ec.getV_cuota());
				estado.setI_debito(ec.getI_debito());
				estado.setI_pagsup(ec.getI_pagsup());
				estado.setK_tipodr(ec.getK_tipodr());				
				estado.setV_transf(ec.getV_transf());
				if(ec.getK_tipodr() == null || ec.getK_tipodr().equals("")){
					estado.setK_tipcuent(1);
				} else if(ec.getK_tipodr().equals("OS")){
					estado.setK_tipcuent(2);
				} else if(ec.getK_tipodr().equals("OB")){
					estado.setK_tipcuent(3);
				} else if(ec.getK_tipodr().equals("CD")){
					estado.setK_tipcuent(4);
				} else{
					estado.setK_tipcuent(0);
				} 				
				response.add(estado);
			}
		}
		return response;
	}
	public List<ResponseConsultarCuentas> getCuentas(String cedula) throws Exception {		
		List<ResponseConsultarCuentas> estadoCuentas = null;
		List<EstadoCuentaMD> estados = EstadoCuentaDAO.getInstance().obtenerCuentas(new EstadoCuentaMD(cedula));
		if (estados != null) {
			estadoCuentas = new ArrayList<ResponseConsultarCuentas>();
			List<String> cuentas = new ArrayList<String>();
			for (EstadoCuentaMD ec : estados) {
				if(!cuentas.contains(ec.getN_tipodr())){
					cuentas.add(ec.getN_tipodr());
				}
			}

			for (String cuenta : cuentas) {				
				ResponseConsultarCuentas roc = new ResponseConsultarCuentas();
				roc.setNombreCuenta(cuenta);
				List<Producto> productos = new ArrayList<Producto>();
				for (EstadoCuentaMD ec : estados) {
					if(ec.getN_tipodr().equals(cuenta)){
						productos.add(new Producto(
							ec.getN_produc(),
							ec.getK_tipodr() == null ? "" : ec.getK_tipodr(),
							ec.getK_tipodr() == null || ec.getK_tipodr().equals("") ? 1 :
							ec.getK_tipodr().equals("OS") ? 2 : 
							ec.getK_tipodr().equals("OB") ? 3 :
							ec.getK_tipodr().equals("CD") ? 4 : 0,
							ec.getA_tipodr(),
							Encripcion.getInstance().encriptar(ec.getA_numdoc()),
							ec.getV_saldo(),
							ec.getV_vencid(),
							ec.getF_vencim(),
							ec.getF_actual(),
							ec.getQ_diaven(),
							ec.getV_transf(),
							ec.getV_cuota(),
							ec.getI_pagsup() == null ? "" : ec.getI_pagsup(),
							ec.getI_debito() == null ? "" : ec.getI_debito()
						));
					}
				}
				roc.setProductos(productos);
				estadoCuentas.add(roc);
			}
		}
		return estadoCuentas;
	}


	//EN DESSO PROXIMAMENTE
	public List<ResponseMovimientoCuentaDeprecated> getMovimientosCuentaDeprecated(RequestMovimientosCuentasDeprecated request) throws Exception {
		EstadoCuentaMD registro = new EstadoCuentaMD(request.getCedula());
		if(request.getK_tipcuent() != 4){
			EstadoCuentaDAO.getInstance().procesarMovimientosCuentasDeprecated(request);
		}
		List<MovimientoMD> listModel = EstadoCuentaDAO.getInstance().obtenerMovimientosCuentaDeprecated(registro);
		List<ResponseMovimientoCuentaDeprecated> response = new ArrayList<ResponseMovimientoCuentaDeprecated>();
		if(listModel != null && listModel.size()>0){
			for(MovimientoMD movimiento : listModel){
				response.add(new ResponseMovimientoCuentaDeprecated(
					movimiento.getA_tipodr(),
					movimiento.getA_numdoc(),
					movimiento.getF_movimi(),
					movimiento.getK_numdoc(),
					movimiento.getN_tipdoc(),
					movimiento.getV_valor()
				));
			}
		}
		return response;
	}
	public ResponseMovimientosCuenta getMovimientosCuenta(RequestMovimientosCuenta request) throws Exception {
		
		List<MovimientoMD> movimientos = EstadoCuentaDAO.getInstance().obtenerMovimientosCuenta(new MovimientoMD(
			request.getCedula(),
			request.getTipoCuenta(),
			request.getCodigoProducto(),
			request.getNumeroProducto()
		));
		ResponseMovimientosCuenta response = new ResponseMovimientosCuenta();
		List<MovimientosProducto> listaMovimientos = new ArrayList<MovimientosProducto>();
		response.setTipoCuenta(request.getTipoCuenta());
		response.setCodigoProducto(request.getCodigoProducto());
		response.setNumeroProducto(request.getNumeroProducto());
		for(MovimientoMD md : movimientos){
			listaMovimientos.add(new MovimientosProducto(
				md.getK_numdoc(),
				md.getN_tipdoc(),
				md.getV_valor(),
				md.getF_movimi()
			));
		}
		response.setMovimientos(listaMovimientos);
		return response;
	}


	//EN DESUSO PROXIMAMENTE
	public ResponseEstadoMisAportesDeprecated getEstadoMensajeMisAportesDeprecated() throws Exception {
		ParametrosGeneralesMD model = EstadoCuentaDAO.getInstance().obtenerEstadoMensajeMisAportes();
		ResponseEstadoMisAportesDeprecated response = null;
		if(model != null){
			response = new ResponseEstadoMisAportesDeprecated(
				model.getK_parametro().toString(),
				model.getI_estado()
			);
		}
		return response;
	}
	public ResponseEstadoMisAportes getEstadoMensajeMisAportes() throws Exception {
		ParametrosGeneralesMD model = EstadoCuentaDAO.getInstance().obtenerEstadoMensajeMisAportes();
		ResponseEstadoMisAportes response = null;
		if(model != null){
			response = new ResponseEstadoMisAportes(
				model.getI_estado(),
				model.getN_value1() == null ? "" : model.getN_value1()  
			);
		}
		return response;
	}

	// public ArrayList<ResponseConsultarCuentas> getEstadoCuenta(String cedula) throws Exception {
	// 	EstadoCuentaMD registro = new com.cm.solidappservice.model.estadocuenta.bd.EstadoCuentaMD(cedula);
	// 	List<EstadoCuentaMD> estados = null;
	// 	estados = EstadoCuentaDAO.getInstance().obtenerEstadoCuenta(registro);

	// 	if (estados != null) {
	// 		// Voy a cargar todos los movimientos del asociado.
	// 		List<MovimientoMD> movimientosAsociado = EstadoCuentaDAO.getInstance().obtenerMovimientosCedula(registro);
	// 		for (com.cm.solidappservice.model.estadocuenta.bd.EstadoCuentaMD ec : estados) {
	// 			ArrayList<MovimientoMD> movimientos = new ArrayList<MovimientoMD>();
	// 			for (int i = 0; i < movimientosAsociado.size(); i++) {
	// 				MovimientoMD movimiento = movimientosAsociado.get(i);
	// 				// M.A_TIPODR = #{a_tipodr} AND M.A_NUMDOC = #{a_numdoc}
	// 				if (ec.getA_tipodr().equals(movimiento.getA_tipodr())
	// 						&& ec.getA_numdoc().equals(movimiento.getA_numdoc())) {
	// 					movimientos.add(movimiento);
	// 				}
	// 			}
	// 			ec.setMovimientos(movimientos);
	// 		}
	// 	}

	// 	ArrayList<ResponseConsultarCuentas> l = new ArrayList<ResponseConsultarCuentas>();
	// 	if (estados != null && estados.size() > 0) {
	// 		for (EstadoCuentaMD e : estados) {
	// 			ResponseConsultarCuentas n = new ResponseConsultarCuentas();
	// 			n.setA_numdoc(Encripcion.getInstance().encriptar(e.getA_numdoc()));
	// 			n.setA_tipodr(e.getA_tipodr());
	// 			n.setAanumnit(Encripcion.getInstance().encriptar(e.getAanumnit()));
	// 			n.setK_tipodr(e.getK_tipodr() == null ? "" : e.getK_tipodr());
	// 			// n.setK_tipodr(e.ge);
	// 			if (e.getF_actual() != null) {
	// 				n.setF_actual(Utilities.getFechaString(e.getF_actual()));
	// 			} else {
	// 				n.setF_actual(ResponseConstantes.CADENA_VACIA);
	// 			}

	// 			if (e.getF_vencim() != null) {
	// 				n.setF_vencim(Utilities.getFechaString(e.getF_vencim()));
	// 			} else {
	// 				n.setF_vencim(ResponseConstantes.CADENA_VACIA);
	// 			}
	// 			n.setI_debito(e.getI_debito());
	// 			n.setI_pagsup(e.getI_pagsup());
	// 			n.setN_produc(e.getN_produc());
	// 			n.setN_tipodr(e.getN_tipodr());
	// 			n.setQ_diaven(e.getQ_diaven());
	// 			n.setV_cuota(e.getV_cuota());
	// 			n.setV_saldo(e.getV_saldo());
	// 			n.setV_vencid(e.getV_vencid());
	// 			n.setV_transf(e.getV_transf());
	// 			if (e.getMovimientos() != null && e.getMovimientos().size() > 0) {
	// 				for (com.cm.solidappservice.model.estadocuenta.bd.MovimientoMD mBD : e.getMovimientos()) {
	// 					com.cm.solidappservice.api.response.ResponseMovimiento nmBD = new ResponseMovimiento();
	// 					nmBD.setA_numdoc(Encripcion.getInstance().encriptar(mBD.getA_numdoc()));
	// 					nmBD.setA_tipodr(mBD.getA_tipodr());
	// 					nmBD.setF_movimi(Utilities.getFechaString(mBD.getF_movimi()));
	// 					nmBD.setK_numdoc(Encripcion.getInstance().encriptar(mBD.getK_numdoc()));
	// 					nmBD.setN_tipdoc(mBD.getN_tipdoc());
	// 					nmBD.setV_valor(mBD.getV_valor());
	// 					n.getMovimientos().add(nmBD);
	// 				}
	// 			}
	// 			l.add(n);
	// 		}
	// 	}

	// 	return l;
	// }


}
