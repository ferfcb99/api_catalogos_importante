package com.catalogo.proveedores.exceptions;

import org.springframework.http.HttpStatus;

public class CatalogException extends RuntimeException {

    private final HttpStatus httpStatus;

    private final String errorMessage;

    public CatalogException(final HttpStatus httpStatus, final String errorMessage) {
        super(errorMessage);
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    public CatalogException(final String errorMessage) {
        super(errorMessage);
        this.httpStatus = null;
        this.errorMessage = errorMessage;
    }

    public CatalogException(final String errorMessage, final Throwable throwable) {
        super(errorMessage, throwable);
        this.httpStatus = null;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public String toString() {
        return "CatalogException{" +
                "httpStatus=" + httpStatus +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
