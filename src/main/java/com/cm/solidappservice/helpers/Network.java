package com.cm.solidappservice.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jettison.json.JSONObject;

public class Network {
    
    private String urlWebService;

    public Network(String urlWebService) {
        this.urlWebService = urlWebService;
    }

    public String writeService(JSONObject jsonObject, String peticion, String autorizacion) throws Exception {
        URL url;
        HttpURLConnection connection = null;
        String mensajeSalida = "";
        try {
            url = new URL(urlWebService + peticion);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(40000);
            connection.setConnectTimeout(40000);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + autorizacion);
            connection.setRequestProperty("Content-Type", "Application/json");
            connection.setRequestProperty("Accept", "Application/json");

            OutputStream os = connection.getOutputStream();
            String input = jsonObject.toString();
            os.write(input.getBytes());
            os.flush();

            connection.connect();

            int statusCode = connection.getResponseCode();

            if (statusCode != HttpURLConnection.HTTP_OK) {
                mensajeSalida = "Error: " + mensajeSalida + " (HTTP " + statusCode+ ")";
            } else {
                InputStreamReader isr = new InputStreamReader(connection.getInputStream());
                BufferedReader br = new BufferedReader(isr);

                mensajeSalida = "";

                String line = br.readLine();
                while (line != null) {
                    mensajeSalida += line;
                    line = br.readLine();
                }

                isr.close();
                br.close();
            }
        } catch (SocketTimeoutException se) {
            throw new Exception("Error al enviar la solicitud");
        } catch (Exception e) {
            closeConnection(connection);
            throw new Exception("ERROR: " + e.getMessage());
        } finally {
            closeConnection(connection);
        }
        return mensajeSalida;
    }

    private static void closeConnection(HttpURLConnection conexion){
        if (conexion != null) {
            try {
                conexion.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    //NUEVAS PETICIONES PARA LA CONEXION CON LA API DE SEGURIDAD
    
    public String checkToken(String token, String scope, String basicEncode) throws Exception {
    	String response = "";
    	HttpURLConnection con = null;
    	try {
        	String peticion = "CheckToken";
        	String ruta = urlWebService + peticion;
        	URL url = new URL(ruta);
        	//invalidateCertificate();
            con = (HttpURLConnection) url.openConnection();
            con.setReadTimeout(40000);
            con.setConnectTimeout(40000);
            con.setInstanceFollowRedirects( false );
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Basic " + basicEncode);
            
            List<NameValuePair> params = new ArrayList<NameValuePair>();
        	params.add(new BasicNameValuePair("token", token));
        	params.add(new BasicNameValuePair("scopes", scope));

        	OutputStream os = con.getOutputStream();
        	BufferedWriter writer = new BufferedWriter(
        	        new OutputStreamWriter(os, "UTF-8"));
        	writer.write(getQuery(params));
        	writer.flush();
        	writer.close();
        	os.close();
            con.connect();
            
            int responseCode = con.getResponseCode();
            if(responseCode != HttpURLConnection.HTTP_OK) {
            	throw new Exception("status!=200");
            	//return "ERROR!=200";
            }else {
            	String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
                return response;
            }
        }catch(Exception ex){
        	closeConnection(con);
        	throw new Exception(ex.getMessage());
        	//return "ERROR";
        }finally {
            closeConnection(con);
        }
    }
    
    //helpers
    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params)
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
