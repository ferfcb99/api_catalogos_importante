package com.catalogo.proveedores.controllers.impl;

import com.catalogo.proveedores.constants.ConstantsExceptions;
import com.catalogo.proveedores.controllers.ExceptionGlobalHandler;
import com.catalogo.proveedores.exceptions.CatalogException;
import com.catalogo.proveedores.publics.ResponseAPIException;
import com.catalogo.proveedores.services.ApiErrorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Global exception handler.
 */
@RestControllerAdvice
@Slf4j
public class ExceptionGlobalHandlerImpl implements ExceptionGlobalHandler {

    @Autowired
    private ApiErrorsService apiErrorsService;

    @Override
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseAPIException> handleException(Exception e) {
        log.info("{}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseAPIException(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), ConstantsExceptions.UNKNOWN_EXCEPTION));
    }

    @Override
    @ExceptionHandler(CatalogException.class)
    public ResponseEntity<ResponseAPIException> handlePeronalizedException(CatalogException e) {
        log.info("{}", e.getMessage().toString());
        return ResponseEntity.status(e.getHttpStatus())
                .body(new ResponseAPIException(String.valueOf(e.getHttpStatus()), e.getMessage()));
    }
}
