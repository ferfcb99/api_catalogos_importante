package com.catalogo.proveedores.publics;

public class ResponseAPIException {

    public String code;
    public String message;

    public ResponseAPIException() {
    }

    public ResponseAPIException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
