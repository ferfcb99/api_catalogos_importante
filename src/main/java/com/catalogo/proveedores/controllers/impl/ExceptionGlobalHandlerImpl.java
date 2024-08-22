package com.catalogo.proveedores.controllers.impl;

import com.catalogo.proveedores.constants.ConstantsExceptions;
import com.catalogo.proveedores.controllers.ExceptionGlobalHandler;
import com.catalogo.proveedores.exceptions.NotContentException;
import com.catalogo.proveedores.exceptions.ValidacionesException;
import com.catalogo.proveedores.publics.ResponseAPIException;
import com.catalogo.proveedores.services.ApiErrorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;

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
    @ExceptionHandler(ValidacionesException.class)
    public ResponseEntity<ResponseAPIException> handleValidacionesException(ValidacionesException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseAPIException(e.getCode(), e.getMessage()));
    }

    @Override
    @ExceptionHandler(NotContentException.class)
    public ResponseEntity<ResponseAPIException> handleNotContentException(NotContentException e) {
        log.info("Entro a not content exception desde el manejador general de excepciones");
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseAPIException(e.getCode(), e.getMessage()));
    }

    @Override
    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<ResponseAPIException> handleTimeoutException(TimeoutException e) {
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
                .body(new ResponseAPIException(String.valueOf(HttpStatus.GATEWAY_TIMEOUT), e.getMessage()));
    }


}
