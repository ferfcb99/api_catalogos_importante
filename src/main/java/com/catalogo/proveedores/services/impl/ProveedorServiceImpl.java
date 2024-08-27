package com.catalogo.proveedores.services.impl;

import com.catalogo.proveedores.constants.ConstantsExceptions;
import com.catalogo.proveedores.entities.Proveedor;
import com.catalogo.proveedores.entities.VistaProveedor;
import com.catalogo.proveedores.exceptions.NotContentException;
import com.catalogo.proveedores.exceptions.ValidacionesException;
import com.catalogo.proveedores.mappers.MapperProveedor;
import com.catalogo.proveedores.models.ProveedorDTO;
import com.catalogo.proveedores.models.ProveedorShortData;
import com.catalogo.proveedores.repositories.ProveedorRepository;
import com.catalogo.proveedores.repositories.ProveedorViewRepository;
import com.catalogo.proveedores.services.ProveedorService;
import com.catalogo.proveedores.utils.InputValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private static final Logger log = LoggerFactory.getLogger(ProveedorServiceImpl.class);

    private ProveedorRepository proveedorRepository;

    private ProveedorViewRepository proveedorViewRepository;

    @Autowired
    public ProveedorServiceImpl(ProveedorRepository proveedorRepository, ProveedorViewRepository proveedorViewRepository) {
        this.proveedorRepository = proveedorRepository;
        this.proveedorViewRepository = proveedorViewRepository;
    }

    @Override
    @Transactional
    public List<ProveedorDTO> getAll() {
        List<Proveedor> proveedores;

        try {
            proveedores = this.proveedorRepository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ValidacionesException(ConstantsExceptions.CODE_ERROR_500, ConstantsExceptions.DESCRIPTION_ERROR_500);
        }
        if (proveedores.isEmpty()) {
            log.info("entro aqui");
            throw new NotContentException(ConstantsExceptions.CODE_ERROR_204, ConstantsExceptions.DESCRIPTION_ERROR_204);
        }

        /*
        List<VistaProveedor> vistaProveedores = this.proveedorViewRepository.findAll();

        log.info("----------------vista---");
        for (VistaProveedor proveedor : vistaProveedores) {
            log.info(proveedor.toString());
        }
        log.info("----------------vista---");

        List<Proveedor> proveedoresProcedure = this.proveedorRepository.getAllActiveProveedores();

        log.info("----------------procedimiento---");
        for (Proveedor proveedor : proveedoresProcedure) {
            log.info(proveedor.toString());
        }
        log.info("----------------procedimiento---");
        */

        return MapperProveedor.mapEntityListToDTOList(proveedores);
    }

    @Override
    public ProveedorDTO create(ProveedorDTO proveedorDTO) {
        // meter validacion de campos para evitar inyectar SQL

        if (!InputValidator.validateField(proveedorDTO.getNombre(), 20)) {
            log.info("entro a la validacion");
        }

        Proveedor proveedor = MapperProveedor.mapDTOToEntity(proveedorDTO);
        proveedor.setFechaRegistro(new Timestamp(System.currentTimeMillis()));

        return MapperProveedor.mapEntityToDTO(proveedorRepository.save(proveedor));

    }

    @Override
    public List<ProveedorShortData> getShortData() {
        return this.proveedorRepository.getShortData();
    }

}
