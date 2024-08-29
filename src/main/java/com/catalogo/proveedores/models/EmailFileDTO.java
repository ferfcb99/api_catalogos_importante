package com.catalogo.proveedores.models;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class EmailFileDTO {

    private String[] to;
    private String subject;
    private String body;
    MultipartFile file;

    public EmailFileDTO() {
    }


    public EmailFileDTO(String[] to, String body, String subject, MultipartFile file) {
        this.to = to;
        this.body = body;
        this.subject = subject;
        this.file = file;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "EmailFileDTO{" +
                "to=" + Arrays.toString(to) +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", file=" + file +
                '}';
    }
}
