package com.cm.solidappservice.model.codigoverificacion.request;

public class RequestEnviarCodigoSMS {
  
    private String MessageText;
    private String Type;
    private String Device;

    public RequestEnviarCodigoSMS() {}

    public RequestEnviarCodigoSMS(String messageText, String type, String device) {
        MessageText = messageText;
        Type = type;
        Device = device;
    }

    public String getMessageText() {
        return MessageText;
    }

    public void setMessageText(String messageText) {
        MessageText = messageText;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDevice() {
        return Device;
    }

    public void setDevice(String device) {
        Device = device;
    }

}
