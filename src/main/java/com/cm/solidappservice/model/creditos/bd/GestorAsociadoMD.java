package com.cm.solidappservice.model.creditos.bd;

/*
**PK_APP_GESTORDELASOCIADO.PR_DATOSPERSONALESGESTOR
*/
public class GestorAsociadoMD{

    private String IDENTIFICACION;
	private String CEDGESTOR;
	private String NOMBGESTOR;
	private String IDTERCERO;

	public GestorAsociadoMD() {
	}

	public GestorAsociadoMD(String iDENTIFICACION, String cEDGESTOR, String nOMBGESTOR, String iDTERCERO) {
		IDENTIFICACION = iDENTIFICACION;
		CEDGESTOR = cEDGESTOR;
		NOMBGESTOR = nOMBGESTOR;
		IDTERCERO = iDTERCERO;
	}

	public String getIDENTIFICACION() {
		return IDENTIFICACION;
	}

	public void setIDENTIFICACION(String iDENTIFICACION) {
		IDENTIFICACION = iDENTIFICACION;
	}

	public String getCEDGESTOR() {
		return CEDGESTOR;
	}

	public void setCEDGESTOR(String cEDGESTOR) {
		CEDGESTOR = cEDGESTOR;
	}

	public String getNOMBGESTOR() {
		return NOMBGESTOR;
	}

	public void setNOMBGESTOR(String nOMBGESTOR) {
		NOMBGESTOR = nOMBGESTOR;
	}

	public String getIDTERCERO() {
		return IDTERCERO;
	}

	public void setIDTERCERO(String iDTERCERO) {
		IDTERCERO = iDTERCERO;
	}
	
}