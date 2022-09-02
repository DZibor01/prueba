package com.cm.solidappservice.model.diverseinfo.response;

import java.util.ArrayList;
import java.util.List;

public class ResponsePreguntaFrecuente {
	
	private String grupo;
	public List<PreguntaRespuesta> preguntas = new ArrayList<ResponsePreguntaFrecuente.PreguntaRespuesta>();
		
	public ResponsePreguntaFrecuente() {
	}

	public ResponsePreguntaFrecuente(String grupo, List<PreguntaRespuesta> preguntas) {
		this.grupo = grupo;
		this.preguntas = preguntas;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<PreguntaRespuesta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<PreguntaRespuesta> preguntas) {
		this.preguntas = preguntas;
	}

	public static class PreguntaRespuesta{

		private String pregunta;
		private String respuesta;
		
		public PreguntaRespuesta() {
		}

		public PreguntaRespuesta(String pregunta, String respuesta)
		{
			this.pregunta = pregunta;
			this.respuesta = respuesta;
		}

		public String getPregunta() {
			return pregunta;
		}

		public void setPregunta(String pregunta) {
			this.pregunta = pregunta;
		}

		public String getRespuesta() {
			return respuesta;
		}

		public void setRespuesta(String respuesta) {
			this.respuesta = respuesta;
		}		
	}
}