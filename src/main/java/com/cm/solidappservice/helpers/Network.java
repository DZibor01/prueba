package com.cm.solidappservice.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

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

}
