package com.catalogo.proveedores.controllers;

import com.catalogo.proveedores.exceptions.NotContentException;
import com.catalogo.proveedores.exceptions.ValidacionesException;
import com.catalogo.proveedores.publics.ResponseAPIException;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.TimeoutException;

public interface ExceptionGlobalHandler {

    ResponseEntity<ResponseAPIException> handleException(Exception e);

    ResponseEntity<ResponseAPIException> handleValidacionesException(ValidacionesException e);

    ResponseEntity<ResponseAPIException> handleNotContentException(NotContentException e);

    ResponseEntity<ResponseAPIException> handleTimeoutException(TimeoutException e);

}
