package com.cm.solidappservice.model.creditos.response;

public class ResponseGestorAsociadoDeprecated {
    
	private String AANUMNIT;
	private String CEDGESTOR;
	private String NOMBGESTOR;
	private String K_IDTERC;
    
    public ResponseGestorAsociadoDeprecated() {
    }
    
    public ResponseGestorAsociadoDeprecated(String aANUMNIT, String cEDGESTOR, String nOMBGESTOR, String k_IDTERC) {
        AANUMNIT = aANUMNIT;
        CEDGESTOR = cEDGESTOR;
        NOMBGESTOR = nOMBGESTOR;
        K_IDTERC = k_IDTERC;
    }

    public String getAANUMNIT() {
		return AANUMNIT;
	}
	public void setAANUMNIT(String AANUMNIT) {
		this.AANUMNIT = AANUMNIT;
	}
    
    public String getCEDGESTOR() {
		return CEDGESTOR;
	}
	public void setCEDGESTOR(String CEDGESTOR) {
		this.CEDGESTOR = CEDGESTOR;
    }
    
    public String getNOMBGESTOR() {
		return NOMBGESTOR;
	}
	public void setNOMBGESTOR(String NOMBGESTOR) {
		this.NOMBGESTOR = NOMBGESTOR;
	}
    
    public String getK_IDTERC() {
		return K_IDTERC;
	}
	public void setK_IDTERC(String K_IDTERC) {
		this.K_IDTERC = K_IDTERC;
	}
}


