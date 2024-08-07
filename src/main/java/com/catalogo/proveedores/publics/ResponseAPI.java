package com.catalogo.proveedores.publics;

public class ResponseAPI<T> {

    public String code;
    public T body;
    public String message;

    public ResponseAPI() {
    }

    public ResponseAPI(String code, T body, String message) {
        this.code = code;
        this.body = body;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
