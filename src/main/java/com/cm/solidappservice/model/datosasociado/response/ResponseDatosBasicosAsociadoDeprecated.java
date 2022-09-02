package com.cm.solidappservice.model.datosasociado.response;

public class ResponseDatosBasicosAsociadoDeprecated {
    
    private String AANUMNIT;
    private String IIDETER;
    private String NAPELL1;
    private String NAPELL2;
    private String NNOMBR1;
    private String NNOMBR2;

    public ResponseDatosBasicosAsociadoDeprecated(){}

    public ResponseDatosBasicosAsociadoDeprecated(String aANUMNIT, String iIDETER, String nAPELL1,
            String nAPELL2, String nNOMBR1, String nNOMBR2) {
        AANUMNIT = aANUMNIT;
        IIDETER = iIDETER;
        NAPELL1 = nAPELL1;
        NAPELL2 = nAPELL2;
        NNOMBR1 = nNOMBR1;
        NNOMBR2 = nNOMBR2;
    }

    public String getAANUMNIT() {
        return AANUMNIT;
    }

    public void setAANUMNIT(String aANUMNIT) {
        AANUMNIT = aANUMNIT;
    }

    public String getIIDETER() {
        return IIDETER;
    }

    public void setIIDETER(String iIDETER) {
        IIDETER = iIDETER;
    }

    public String getNAPELL1() {
        return NAPELL1;
    }

    public void setNAPELL1(String nAPELL1) {
        NAPELL1 = nAPELL1;
    }

    public String getNAPELL2() {
        return NAPELL2;
    }

    public void setNAPELL2(String nAPELL2) {
        NAPELL2 = nAPELL2;
    }

    public String getNNOMBR1() {
        return NNOMBR1;
    }

    public void setNNOMBR1(String nNOMBR1) {
        NNOMBR1 = nNOMBR1;
    }

    public String getNNOMBR2() {
        return NNOMBR2;
    }

    public void setNNOMBR2(String nNOMBR2) {
        NNOMBR2 = nNOMBR2;
    }

    

}


