package com.cm.solidappservice.dao;

import java.util.List;

import com.cm.solidappservice.model.tyc.bd.TyCAceptadosMD;
import com.cm.solidappservice.model.tyc.bd.TyCMD;


public class TyCDAO extends DAO2 {

    private static TyCDAO singleton = null;
    
    private static final String OBTENER_TODOS_TYC = "TyCMapper.obtenerTodosTyC";
    private static final String INSERTAR_TYC_ACEPTADOS = "TyCMapper.registrarTyCAceptados";
    private static final String OBTENER_TODOS_TYC_ACEPTADOS_CEDULA = "TyCMapper.obtenerTodosTyCAceptadosCedula";

    private static final String OBTENER_TYC_ACTIVOS = "TyCMapper.obtenerActivosTyC"; 
    private static final String QUERY_OBTENER_TYC_ACEPTADOS_CEDULA = "TyCMapper.obtenerTyCAceptadosCedula";
    
    public static TyCDAO getInstance() {
        if (singleton == null)
        try {
            synchronized (TyCDAO.class) {
            if (singleton == null)
                singleton = new TyCDAO(); 
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return singleton;
    }
    
    public List<TyCMD> obtenerTerminosyCondiciones() throws Exception {
        return getList(OBTENER_TODOS_TYC, null);
    }

    public void registrarTyCAceptados(TyCAceptadosMD model) throws Exception {
        insertObject(INSERTAR_TYC_ACEPTADOS, model);
    }

    public List<TyCAceptadosMD> obtenerTerminosAceptados(String cedula) throws Exception {
        return getList(OBTENER_TODOS_TYC_ACEPTADOS_CEDULA, cedula);   
    }

    public TyCMD obtenerTyC() throws Exception {
        List<TyCMD> listModel = getList(OBTENER_TYC_ACTIVOS, null);
        if(listModel.size() > 0){
			return listModel.get(0);	
		}else{
			return null;
		}
    }
    public TyCAceptadosMD obtenerTyCCedula(String cedula) throws Exception {          
        TyCAceptadosMD model = new TyCAceptadosMD();
        model.setAanumnit(cedula);
        model.setK_termycond(obtenerTyC().getK_termycond());
        List<TyCAceptadosMD> listModel =  getList(QUERY_OBTENER_TYC_ACEPTADOS_CEDULA, model);  
        if(listModel.size() > 0){
			return listModel.get(0);	
		}else{
			return null;
		} 
    }    
    
}