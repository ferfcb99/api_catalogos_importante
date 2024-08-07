package com.catalogo.proveedores.controllers;

import com.catalogo.proveedores.exceptions.NotContentException;
import com.catalogo.proveedores.exceptions.ValidacionesException;
import com.catalogo.proveedores.publics.ResponseAPI;
import org.springframework.http.ResponseEntity;

public interface GlobalExceptionHandler {

    ResponseEntity<ResponseAPI<String>> handleException(Exception e);

    ResponseEntity<ResponseAPI<String>> handleValidacionesException(ValidacionesException e);

    ResponseEntity<ResponseAPI<String>> handleNotContentException(NotContentException e);

}
