package com.cm.solidappservice.manager;

import com.cm.solidappservice.dao.TokenDAO;
import com.cm.solidappservice.model.base.RequestAutenticacion;
import com.cm.solidappservice.model.login.request.RequestLogin;
import com.cm.solidappservice.model.token.bd.TokenMD;
import com.cm.solidappservice.security.TokenException;

import java.util.Date;
import java.util.UUID;

public class TokenManager {
  
  static TokenManager singleton;
  
  public static TokenManager getInstance() {
    if (singleton == null)
      try {
        synchronized (TokenManager.class) {
          if (singleton == null)
            singleton = new TokenManager(); 
        } 
      } catch (Exception ex) {
        ex.printStackTrace();
      }  
    return singleton;
  }
  
  private static long timeoutMinutos = 5L;
  
  private static long timeoutMilisegundos = timeoutMinutos * 60L * 1000L;
  
  public RequestAutenticacion GenerarToken(RequestLogin credencial) throws Exception {
    TokenMD c = new TokenMD();
    c.setToken(UUID.randomUUID().toString());
    c.setAanumnit(credencial.getCedula());
    c.setFechaGeneracion(new Date());
    c.setFechaExpiracion(new Date(c.getFechaGeneracion().getTime() + timeoutMilisegundos));
    c.setI_expirado("N");
    c.setN_origaplic(credencial.getOrigen());
    TokenDAO.getInstance().createToken(c);
    RequestAutenticacion credencialAutenticacion = new RequestAutenticacion();
    credencialAutenticacion.setCedula(c.getAanumnit());
    credencialAutenticacion.setToken(c.getToken());
    return credencialAutenticacion;
  }
  
  private static long getDiferenciaMinutos(Date fechaHoraDesde) {
    Date fechaActual = new Date();
    long diferenciaMilisegundos = fechaActual.getTime() - fechaHoraDesde.getTime();
    long diferenciaMinutos = diferenciaMilisegundos / 1000L / 60L;
    return diferenciaMinutos;
  }
  
  public void ValidarToken(RequestAutenticacion credencial) throws TokenException {
    TokenMD token = null;
    try {
      token = TokenDAO.getInstance().getToken(credencial.getToken());
    } catch (Exception e1) {
      e1.printStackTrace();
      throw new TokenException("Error obtiendo el token de sesión");
    } 
    if (token != null) {
      if (!token.getAanumnit().equals(credencial.getCedula()))
        throw new TokenException(TokenException.ReasonException.SuplantacionToken); 
      if (token.getI_expirado().equals("N")) {
        long diferenciaMinutos = getDiferenciaMinutos(token.getFechaExpiracion());
        if (diferenciaMinutos >= timeoutMinutos) {
          token.setFechaExpiracion(new Date());
          token.setI_expirado("Y");
          try {
            TokenDAO.getInstance().updateToken(token);
          } catch (Exception e) {
            e.printStackTrace();
            throw new TokenException("Error actualizando el token de sesión");
          }
          throw new TokenException(TokenException.ReasonException.TimeoutExpirado);
        }
        token.setFechaExpiracion(new Date(token.getFechaExpiracion().getTime() + timeoutMilisegundos));
        try {
          TokenDAO.getInstance().updateToken(token);
        } catch (Exception e) {
          e.printStackTrace();
          throw new TokenException("Error actualizando la fecha del token de sesión");
        } 
      } else if (token.getI_expirado().equals("Y")) {
        throw new TokenException(TokenException.ReasonException.NuevoInicioSesion);
      } 
    } else {
      throw new TokenException(TokenException.ReasonException.TokenNoExiste);
    } 
  }


}