package com.catalogo.proveedores.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "api_errors")
public class ApiErrors implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Integer id;

    @Column(name = "code_response", nullable = false, unique = false, length = 10)
    private String code;

    @Column(name = "body", nullable = false, unique = false, length = 100)
    private String body;

    @Column(name = "message", nullable = false, unique = false, length = 255)
    private String message;

    @Column(name = "created_at", unique = false, columnDefinition="TIMESTAMP")
    private Timestamp createAt;


    public ApiErrors() {
    }

    public ApiErrors(Integer id, String code, String body, String message, Timestamp createAt) {
        this.id = id;
        this.code = code;
        this.body = body;
        this.message = message;
        this.createAt = createAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "ApiErrors{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", body='" + body + '\'' +
                ", message='" + message + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
