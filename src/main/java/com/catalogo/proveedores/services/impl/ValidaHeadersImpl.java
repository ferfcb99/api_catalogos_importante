package com.catalogo.proveedores.services.impl;

import com.catalogo.proveedores.exceptions.CatalogException;
import com.catalogo.proveedores.services.ValidaHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ValidaHeadersImpl implements ValidaHeaders {
    @Override
    public void validaHeaderAuthorization(String authorization) {
        if(authorization == null || authorization.isEmpty()){
            throw new CatalogException(HttpStatus.BAD_REQUEST, "El token no puede estar vacio");
        }
    }

    @Override
    public void validaHeaderCliendId(String clientId) {
        if(clientId == null || clientId.isEmpty()){
            throw new CatalogException(HttpStatus.BAD_REQUEST, "El token no puede estar vacio");
        }
    }
}
