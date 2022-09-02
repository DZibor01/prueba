package com.cm.solidappservice.security;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.cm.solidappservice.manager.TokenManager;
import com.cm.solidappservice.utils.Utilities;

public class Encripcion {
	static Encripcion singleton;

	public static Encripcion getInstance() {
		if (singleton == null) {
			try {
				synchronized (TokenManager.class) {
					if (null == singleton) {
						singleton = new Encripcion();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return singleton;
	}
	
	public String encriptar(String palabra) {
		int seed = generateSeed();
		StringBuffer sb = new StringBuffer();
		//System.out.println("SEED: " + seed);

		char letraInicial = (char) (seed + 50);
		char letrraFinal = (char) generateSeed2();

		sb.append(letraInicial);
		//System.out.println("C�digos: ");
		for (int i = palabra.length() - 1; i >= 0; i--) {
			char letra = palabra.charAt(i);
			int codigoLetra = (int) letra;
			//System.out.print(codigoLetra + ", ");
			int nuevoCodigo = codigoLetra + seed;
			if (nuevoCodigo == 92) {// BACK SLASH \
				nuevoCodigo = 123;// {
				//System.out.println("Caracter especial");
			}
			sb.append((char) (nuevoCodigo));
		}
		
		sb.append(letrraFinal);
		return sb.toString();
	}

	public String desencriptar(String encripcion) {
		if (Utilities.isNumeric(encripcion)) { //No está encriptado
			return encripcion;
		}
		
		char seedChar = encripcion.charAt(0);

		int seed = (int) seedChar - 50;

		encripcion = encripcion.substring(1, encripcion.length() - 1);
		StringBuffer sb = new StringBuffer();
		for (int i = encripcion.length() - 1; i >= 0; i--) {
			char letra = encripcion.charAt(i);
			int codigoLetra = (int) letra;
			if (codigoLetra == 123) {
				codigoLetra = 92;
			}
			int nuevoCodigoLetra = codigoLetra - seed;
			sb.append((char) (nuevoCodigoLetra));
		}
		return sb.toString();
	}

	// Genera un número aleatorio en el rango [10, 34]
	int generateSeed() {
		int min = 10;
		int max = 34;
		int s = min + (int) (Math.random() * ((max - min) + 1));
		return s;
	}

	// Genera un número aleatorio en el rango [48, 91]
	int generateSeed2() {
		int min = 48;
		int max = 91;
		int s = min + (int) (Math.random() * ((max - min) + 1));
		return s;
	}



	//private static final long serialVersionUID = 1L;
    private static final String secretKeyAES = "phoP@uwr0-*bafiNOx7STeSP!Fonote&omE4=Y=crU*RAdiCHIcEz_yiku#HLChu"; //secretKeyAES
    private static final String saltAES = "s?lc43ThUhus1I0lgobrinl1wlbltlc!e00biyebaDUspiTrukitiwr1hapRejU9"; //saltAES
    private static final String IV = "pr?Klri*e*ub9xon"; //IV
    
    public String encryptAES(String data) {
        byte[] iv = IV.getBytes();
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec keySpec = new PBEKeySpec(secretKeyAES.toCharArray(), saltAES.getBytes(), 65536, 256);
            SecretKey secretKeyTemp = secretKeyFactory.generateSecret(keySpec);
            SecretKeySpec secretKey = new SecretKeySpec(secretKeyTemp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            return Base64.getUrlEncoder().withoutPadding().encodeToString(cipher.doFinal(data.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String decryptAES(String data) {
        byte[] iv = IV.getBytes();
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec keySpec = new PBEKeySpec(secretKeyAES.toCharArray(), saltAES.getBytes(), 65536, 256);
            SecretKey secretKeyTemp = secretKeyFactory.generateSecret(keySpec);
            SecretKeySpec secretKey = new SecretKeySpec(secretKeyTemp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            return new String(cipher.doFinal(Base64.getUrlDecoder().decode(data)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
