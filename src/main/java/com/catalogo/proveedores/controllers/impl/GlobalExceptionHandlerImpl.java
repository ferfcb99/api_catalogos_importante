package com.catalogo.proveedores.controllers.impl;

import com.catalogo.proveedores.controllers.GlobalExceptionHandler;
import com.catalogo.proveedores.entities.ApiErrors;
import com.catalogo.proveedores.exceptions.NotContentException;
import com.catalogo.proveedores.exceptions.ValidacionesException;
import com.catalogo.proveedores.mappers.MapperApiErrors;
import com.catalogo.proveedores.publics.ResponseAPI;
import com.catalogo.proveedores.services.ApiErrorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerImpl implements GlobalExceptionHandler {

    @Autowired
    private ApiErrorsService apiErrorsService;

    @Override
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseAPI<String>> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseAPI<>("500", "Exception desconocida", e.getMessage()));
    }

    @Override
    @ExceptionHandler(ValidacionesException.class)
    public ResponseEntity<ResponseAPI<String>> handleValidacionesException(ValidacionesException e) {

        log.error("Entro al las excepciones globales");
        log.error(e.getCodigo());
        log.error(e.getDescripcion());
        log.error(e.getMensaje());

        //  ApiErrors errorSaved = this.apiErrorsService.saveError(MapperApiErrors.armarValidacionesException(e, "test", "test", "Get"));
        // log.info("se guardo: {}", errorSaved);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseAPI<>(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), "Resource not found", e.getMessage()));
    }

    @Override
    @ExceptionHandler(NotContentException.class)
    public ResponseEntity<ResponseAPI<String>> handleNotContentException(NotContentException e) {
        log.error("Entro al las excepciones globales no content");
        log.error(e.getCodigo());
        log.error(e.getDescripcion());
        log.error(e.getMensaje());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseAPI<>(String.valueOf(HttpStatus.OK), null, e.getMessage()));
    }


}
