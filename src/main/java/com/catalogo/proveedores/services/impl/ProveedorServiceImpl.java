package com.catalogo.proveedores.services.impl;

import com.catalogo.proveedores.constants.ConstantsExceptions;
import com.catalogo.proveedores.entities.Proveedor;
import com.catalogo.proveedores.entities.VistaProveedor;
import com.catalogo.proveedores.exceptions.CatalogException;
import com.catalogo.proveedores.mappers.MapperProveedor;
import com.catalogo.proveedores.models.ProveedorDTO;
import com.catalogo.proveedores.models.ProveedorShortData;
import com.catalogo.proveedores.repositories.ProveedorRepository;
import com.catalogo.proveedores.repositories.ProveedorViewRepository;
import com.catalogo.proveedores.services.EmailService;
import com.catalogo.proveedores.services.ProveedorService;
import com.catalogo.proveedores.utils.InputValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    private static final Logger log = LoggerFactory.getLogger(ProveedorServiceImpl.class);

    private ProveedorRepository proveedorRepository;

    private ProveedorViewRepository proveedorViewRepository;

    private EmailService emailService;

    //Importante hacer la inyección de dependencia de JavaMailSender:
    private JavaMailSender mailSender;

    @Autowired
    public ProveedorServiceImpl(ProveedorRepository proveedorRepository, ProveedorViewRepository proveedorViewRepository, EmailService emailService, JavaMailSender mailSender) {
        this.proveedorRepository = proveedorRepository;
        this.proveedorViewRepository = proveedorViewRepository;
        this.emailService = emailService;
    }

    @Override
    @Transactional
    public List<ProveedorDTO> getAll() {
        List<Proveedor> proveedores;

        try {
            proveedores = this.proveedorRepository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new CatalogException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al consultar los proveedores");
        }
        if (proveedores.isEmpty()) {
            log.info("entro aqui");
            throw new CatalogException(HttpStatus.NO_CONTENT, "No existen registros");
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

    @Override
    public ProveedorDTO getById(Long id) {
        Optional<Proveedor> proveedor = this.proveedorRepository.findById(id);
        if (proveedor.isPresent()) {
            return MapperProveedor.mapEntityToDTO(proveedor.get());
        }
        return null;
    }

}
