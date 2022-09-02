package com.cm.solidappservice.model.datosasociado.bd;

/**
 * PK_APP_DATOSCEM.PR_DatosPersonalesMDASOCIADO
 */
public class DatosBasicosAsociadoMD {

  private String V_AANUMNIT;
  private String AANUMNIT;
  private String IIDETER;
  private String NAPELL1;
  private String NAPELL2;
  private String NNOMBR1;
  private String NNOMBR2;
  
  public DatosBasicosAsociadoMD() {}
  
  public DatosBasicosAsociadoMD(String V_AANUMNIT, String AANUMNIT, String IIDETER, String NAPELL1, String NAPELL2, String NNOMBR1, String NNOMBR2) {
    this.V_AANUMNIT = V_AANUMNIT;
    this.AANUMNIT = AANUMNIT;
    this.IIDETER = IIDETER;
    this.NAPELL1 = NAPELL1;
    this.NAPELL2 = NAPELL2;
    this.NNOMBR1 = NNOMBR1;
    this.NNOMBR2 = NNOMBR2;
  }
  
  public String getV_AANUMNIT() {
    return this.V_AANUMNIT;
  }
  public void setV_AANUMNIT(String V_AANUMNIT) {
    this.V_AANUMNIT = V_AANUMNIT;
  }

  public String getAANUMNIT() {
    return this.AANUMNIT;
  }
  public void setAANUMNIT(String AANUMNIT) {
    this.AANUMNIT = AANUMNIT;
  }

  public String getIIDETER() {
    return this.IIDETER;
  }  
  public void setIIDETER(String IIDETER) {
    this.IIDETER = IIDETER;
  }
    
  public String getNAPELL1() {
    return this.NAPELL1;
  }
  public void setNAPELL1(String NAPELL1) {
    this.NAPELL1 = NAPELL1;
  }
  
  public String getNAPELL2() {
    return this.NAPELL2;
  }  
  public void setNAPELL2(String NAPELL2) {
    this.NAPELL2 = NAPELL2;
  }
  
  public String getNNOMBR1() {
    return this.NNOMBR1;
  }  
  public void setNNOMBR1(String NNOMBR1) {
    this.NNOMBR1 = NNOMBR1;
  }
  
  public String getNNOMBR2() {
    return this.NNOMBR2;
  }
  public void setNNOMBR2(String NNOMBR2) {
    this.NNOMBR2 = NNOMBR2;
  }
}