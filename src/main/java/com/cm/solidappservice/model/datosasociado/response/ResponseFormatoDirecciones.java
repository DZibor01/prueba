package com.cm.solidappservice.model.datosasociado.response;

import java.util.List;

public class ResponseFormatoDirecciones{

    private List<ItemsDirecciones> tiposVia;
    private List<ItemsDirecciones> letrasVia;
    private List<ItemsDirecciones> complementosVia;

    public ResponseFormatoDirecciones() {
    }

    public ResponseFormatoDirecciones(List<ItemsDirecciones> tiposVia, List<ItemsDirecciones> letrasVia,
            List<ItemsDirecciones> complementosVia) {
        this.tiposVia = tiposVia;
        this.letrasVia = letrasVia;
        this.complementosVia = complementosVia;
    }
    
    public List<ItemsDirecciones> getTiposVia() {
        return tiposVia;
    }
    public void setTiposVia(List<ItemsDirecciones> tiposVia) {
        this.tiposVia = tiposVia;
    }
    public List<ItemsDirecciones> getLetrasVia() {
        return letrasVia;
    }
    public void setLetrasVia(List<ItemsDirecciones> letrasVia) {
        this.letrasVia = letrasVia;
    }
    public List<ItemsDirecciones> getComplementosVia() {
        return complementosVia;
    }
    public void setComplementosVia(List<ItemsDirecciones> complementosVia) {
        this.complementosVia = complementosVia;
    }
    
    

}
