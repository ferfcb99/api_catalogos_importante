package com.catalogo.proveedores.services.impl;

import com.catalogo.proveedores.entities.ApiErrors;
import com.catalogo.proveedores.exceptions.CatalogException;
import com.catalogo.proveedores.repositories.ApiErrorsRepository;
import com.catalogo.proveedores.services.ApiErrorsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApiErrorsServiceImpl implements ApiErrorsService {

    private ApiErrorsRepository apiErrorsRepository;

    @Autowired
    public ApiErrorsServiceImpl(ApiErrorsRepository apiErrorsRepository) {
        this.apiErrorsRepository = apiErrorsRepository;
    }

    @Override
    public ApiErrors saveError(ApiErrors apiErrors) {
            try{
                ApiErrors saved = this.apiErrorsRepository.save(apiErrors);
                log.info("Se guardo el error: {}", saved);
                return saved;
            }catch(Exception e){
                throw new CatalogException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al guardar el error");
            }


    }
}
