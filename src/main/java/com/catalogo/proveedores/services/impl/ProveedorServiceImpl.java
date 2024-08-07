package com.catalogo.proveedores.services.impl;

import com.catalogo.proveedores.constants.ConstantsExceptions;
import com.catalogo.proveedores.entities.Proveedor;
import com.catalogo.proveedores.exceptions.NotContentException;
import com.catalogo.proveedores.exceptions.ValidacionesException;
import com.catalogo.proveedores.mappers.MapperProveedor;
import com.catalogo.proveedores.models.ProveedorDTO;
import com.catalogo.proveedores.repositories.ProveedorRepository;
import com.catalogo.proveedores.services.ProveedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private static final Logger log = LoggerFactory.getLogger(ProveedorServiceImpl.class);

    private ProveedorRepository proveedorRepository;

    @Autowired
    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<ProveedorDTO> getAll() {
        List<Proveedor> proveedores;
        // List<ProveedorDTO> proveedorDTOs = new ArrayList<>();
        try{
            proveedores = new ArrayList<>(); // this.proveedorRepository.findAll();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ValidacionesException(ConstantsExceptions.ERROR_500,
                    ConstantsExceptions.ERROR_AL_CONSULTAR,
                    "Mensaje personalizado");
        }
        if(proveedores.isEmpty()){
            log.info("entro aqui");
            throw new NotContentException(ConstantsExceptions.ERROR_204,
                    ConstantsExceptions.SIN_DATOS,
                    "Mensaje personalizado");
        }
        return MapperProveedor.mapEntityListToDTOList(proveedores);
    }
}
