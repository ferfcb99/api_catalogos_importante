package com.catalogo.proveedores.mappers;

import com.catalogo.proveedores.entities.ApiErrors;
import com.catalogo.proveedores.exceptions.ValidacionesException;

import java.sql.Timestamp;

public class MapperApiErrors {

    public static ApiErrors armarValidacionesException(ValidacionesException e, String url, String uri, String methodType){
        ApiErrors error = new ApiErrors();
        error.setId(null);
        error.setCode(e.getCodigo());
        error.setBody("---");
        error.setMessage(e.getMessage());
        error.setUrl(url);
        error.setUri(uri);
        error.setMethodType(methodType);
        error.setCreateAt(new Timestamp(System.currentTimeMillis()));
        return error;
    }

}
