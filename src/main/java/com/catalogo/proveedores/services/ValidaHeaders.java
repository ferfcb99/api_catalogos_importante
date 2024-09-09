package com.catalogo.proveedores.services;

public interface ValidaHeaders {

    void validaHeaderAuthorization(String authorization);

    void validaHeaderCliendId(String clientId);
}
