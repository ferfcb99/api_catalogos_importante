package com.catalogo.proveedores.mappers;

import com.catalogo.proveedores.entities.ApiErrors;
import com.catalogo.proveedores.exceptions.CatalogException;

import java.sql.Timestamp;

public class MapperApiErrors {

    public static ApiErrors armarValidacionesException(CatalogException e){
        ApiErrors error = new ApiErrors();
        error.setId(null);
        error.setCode(String.valueOf(e.getHttpStatus()));
        error.setBody("---");
        error.setMessage(e.getMessage());
        error.setCreateAt(new Timestamp(System.currentTimeMillis()));
        return error;
    }

}
