package com.catalogo.proveedores.models;

import java.util.Arrays;

public class EmailDTO {
    private String[] to;
    private String subject;
    private String body;

    public EmailDTO() {
    }


    public EmailDTO(String[] to, String body, String subject) {
        this.to = to;
        this.body = body;
        this.subject = subject;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EmailDTO{" +
                "to=" + Arrays.toString(to) +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
