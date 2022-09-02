package com.cm.solidappservice.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.cm.solidappservice.dao.DiverseInfoDAO;
import com.cm.solidappservice.manager.ParametrosGeneralesManager;
import com.cm.solidappservice.model.diverseinfo.bd.ReplyMessagesMD;
import com.cm.solidappservice.model.parametrosgenerales.bd.ParametrosEmailMD;

import org.jsoup.Jsoup;

public class Utilities {
	
	public static String SOLICITUD_CORRECTA = "Tu solicitud ha sido enviada con éxito.";
	public static String SOLICITUD_CORRECTA_CENTRO_VACACIONAL = "Tu solicitud ha sido enviada con éxito. Sujeto a disponibilidad.";
	public static String SOLICITUD_CONTINGENCIA_COVID19_CENTRO_VACACIONAL = "Hola, uniéndonos a las medidas que se dispusieron para mitigar la propagación del COVID-19. Nuestros Centros Vacacionales aún no están operando y se están preparando para recibirte nuevamente. Un gestor te contactará para gestionar la reserva que acabas de solicitar y programar tus días de descanso.";
	public static String CORREO_CLAVE_ENVIADO = "Tu clave fue enviada exitosamente al correo registrado.";
	public static String CORREO_INVALIDO = "Tu correo electrónico no se encuentra registrado, comunícate con las oficinas de PRESENTE.";
	public static String ERROR_SERVICIO = "Ha ocurrido un error. Intenta de nuevo y si el error persiste, contacta a PRESENTE.";

	public static final String RUTA_LOGS = "/var/logs_app/app_prueba";
	
	public void getResponseMessages(){
		try{
			List<ReplyMessagesMD> listModel = DiverseInfoDAO.getInstance().obtenerMensajesRespuesta();

			if(listModel != null && listModel.size() > 0){
				for(ReplyMessagesMD respuesta : listModel){
					if(respuesta.getK_mensajeresp() == 1){
						ERROR_SERVICIO = respuesta.getN_mensajeresp();
					}
					if(respuesta.getK_mensajeresp() == 2){
						SOLICITUD_CORRECTA = respuesta.getN_mensajeresp();
					}
					if(respuesta.getK_mensajeresp() == 3){
						CORREO_CLAVE_ENVIADO = respuesta.getN_mensajeresp();
					}
					if(respuesta.getK_mensajeresp() == 4){
						CORREO_INVALIDO = respuesta.getN_mensajeresp();
					}
					if(respuesta.getK_mensajeresp() == 5){
						SOLICITUD_CORRECTA_CENTRO_VACACIONAL = respuesta.getN_mensajeresp();
					}
				}
			}		
		}catch(Exception e){			
		}
	}
	
	public static boolean IsNullOrEmpty(String cadena){
		return ((cadena == null) || cadena.trim().isEmpty());
	}
	
	/**
	 * Convierte la fecha en un String con el formato dd/MM/yyyy
	 * @param fecha
	 * @return
	 */
	public static String getFechaString(Date fecha){
		//SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		return dt.format(fecha);
	}

	/**
	 * Convierte la fecha en un String con el formato dd/MM/yyyy hh:mm:ss a
	 * @param fecha
	 * @return
	 */
	public static String getFechaTimeString(Date fecha){
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		// SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		return dt.format(fecha);
	}
	
	/**
	 * Obtiene una fecha desde un String que debe tener el formato "dd/MM/yyyy" 
	 * @param fecha
	 * @return
	 * @throws Exception 
	 */
	public static Date getFechaDate(String fecha) throws Exception{
		if (IsNullOrEmpty(fecha)) {
			throw new Exception("Fecha nula.");
		}
		Calendar c = Calendar.getInstance();
		String[] fechaSeparada = fecha.split("/");
		if (fechaSeparada.length!=3) {
			throw new Exception("Formato de fecha inválida. Debe cumplir con dd/MM/yyyy: " + fecha);
		}
		c.set(Calendar.YEAR, Integer.parseInt(fechaSeparada[2]));
		c.set(Calendar.MONTH, Integer.parseInt(fechaSeparada[1]) - 1);
		c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fechaSeparada[0]));
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
	
	public static boolean isNumeric(String cadena){
		try {
			if (IsNullOrEmpty(cadena)) {
				return false;
			}
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	/*
	 * Retorna una fecha con la hora 00:00:00
	 */
	public static Date getFechaHoraInicial(Date fecha){
		Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
	}
	
	/*
	 * Retorna una fecha con la hora 23:59:59
	 */
	public static Date getFechaHoraFinal(Date fecha){
		Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
	}

	public static boolean sendMail(String to, String mensaje, String asunto)
			throws Exception {
		boolean sent = false;

		if (to != null && !to.equals("")) {

			final String subject = asunto;			
			final String userEmail = "fondopresente@grupo-exito.com";
			final String passwordEmail = "Felizsiempre5";
			final String servidorSMTP = "";
			final String tituloRemitente ="PRESENTE App";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.user", userEmail);
			props.put("mail.smtp.password", passwordEmail);
			props.put("mail.smtp.host", servidorSMTP);
			props.put("mail.smtp.port", "25");

			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(userEmail, passwordEmail);
						}
					});

			try {
				
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(userEmail, tituloRemitente));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to.trim()));
				message.setSubject(subject);
				message.setText(mensaje);
				sent = false;
				Transport.send(message);
				sent = true;
				
			} catch (MessagingException e) {
				
				if(!sent){
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(userEmail, tituloRemitente));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to.trim()));
					message.setSubject(subject);
					message.setText(mensaje);
					Transport t = session.getTransport("smtp");
					t.connect(userEmail, passwordEmail);
					t.sendMessage(message, message.getAllRecipients());
					sent = true;
				}
				
			}
		}
		return sent;
	}
	
	public boolean sendMail2(String to, String clave, String asunto, String tipoContenido) 
			throws Exception {
		boolean sent = false;

		if (to != null && !to.equals("")) {
			
			ParametrosEmailMD parametros = ParametrosGeneralesManager.getInstance().getParametrosEmail(tipoContenido);

			final String subject = asunto;
			final String userEmail = parametros.getUserEmail();
			final String passwordEmail = parametros.getPasswordEmail();
			final String tituloRemitente = parametros.getTituloRemitente();
			final String mensaje = parametros.getContenido_Email().replace("#clave#", clave);			
			Multipart contentHtml = getHtml(mensaje, clave, tipoContenido);	

			Properties props = new Properties();
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.user", userEmail);
			props.put("mail.smtp.password", passwordEmail);
			props.put("mail.smtp.host", parametros.getServidorSMTP());
			props.put("mail.smtp.port", parametros.getPuertoSMTP());

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userEmail, passwordEmail);
				}
			});

			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(userEmail, tituloRemitente));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to.trim()));
				message.setSubject(subject);
				message.setContent(contentHtml);			
				sent = false;
				Transport.send(message);
				sent = true;
			} catch (MessagingException e) {
				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(userEmail, tituloRemitente));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to.trim()));
					message.setSubject(subject);
					//message.setText(mensaje);
					message.setContent(contentHtml, "text/html; charset=utf-8");
					Transport t = session.getTransport("smtp");
					t.connect(userEmail, passwordEmail);
					t.sendMessage(message, message.getAllRecipients());
					sent = true;
				} catch (Exception ex) {
					throw new Exception("Primer intento: " + e.toString() + ". Error en el segundo intento: " + ex.toString());
				}
			}
		}
		return sent;
	}


	public Multipart getHtml(String mensaje, String clave, String tipoContenido) throws Exception {

		Multipart multipart = new MimeMultipart("related");
		BodyPart htmlPart = new MimeBodyPart();

		String plantilla = "PlantillaGeneral.html";
		if(tipoContenido.equals("1")){
			plantilla = "PlantillaOlvidoClave.html";
		} 

		String contentHtml = "";
		String path =  getClass().getResource("").getPath()+"/html/"+plantilla;
		System.out.print(path);
		contentHtml = Jsoup.parse(new File(path), "UTF-8").toString();
		contentHtml = contentHtml.replace("#MensajeContenido#", mensaje);
		contentHtml = contentHtml.replace("#Codigo-ClaveContenido#", clave);
		htmlPart.setContent(contentHtml, "text/html; charset=UTF-8");
		multipart.addBodyPart(htmlPart);
		multipart.addBodyPart(imgPart("LogoPresenteCorreo","LogoPresenteCorreo.png"));
		if(tipoContenido.equals("1")){			
			multipart.addBodyPart(imgPart("IconUnica", "IconUnica.png"));
			multipart.addBodyPart(imgPart("IconRegularidad", "IconRegularidad.png"));
			multipart.addBodyPart(imgPart("IconCierra", "IconCierra.png"));
			multipart.addBodyPart(imgPart("IconPunto", "IconPunto.png"));
			multipart.addBodyPart(imgPart("IconPunto2", "IconPunto.png"));
		}
		
		// String iconPuntoFinal = iconPunto.substring(1, iconPunto.length());
		// byte[] filesByte = Files.readAllBytes(new File(logoPresenteFinal).toPath());
		return multipart;
	}

	public BodyPart imgPart(String idImagen, String nombreImagen) throws Exception {
		String filePath = getClass().getResource("").getPath()+"/images/"+nombreImagen;
		BodyPart imgPart = new MimeBodyPart();
		DataSource fds = new FileDataSource(filePath);
		imgPart.setDataHandler(new DataHandler(fds));
		imgPart.setFileName(nombreImagen); 
		imgPart.setHeader("Content-ID","<"+idImagen+">");
		imgPart.setDisposition(MimeBodyPart.INLINE);
		return imgPart;
	}



}