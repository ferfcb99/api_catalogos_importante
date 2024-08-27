package com.catalogo.proveedores.controllers;

import com.catalogo.proveedores.exceptions.CatalogException;
import com.catalogo.proveedores.publics.ResponseAPIException;
import org.springframework.http.ResponseEntity;

public interface ExceptionGlobalHandler {

    ResponseEntity<ResponseAPIException> handleException(Exception e);

    ResponseEntity<ResponseAPIException> handlePeronalizedException(CatalogException e);
}
