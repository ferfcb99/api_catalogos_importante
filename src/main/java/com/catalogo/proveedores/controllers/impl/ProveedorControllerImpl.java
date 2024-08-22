package com.catalogo.proveedores.controllers.impl;

import com.catalogo.proveedores.constants.ConstantsRoutes;
import com.catalogo.proveedores.controllers.ProveedorController;
import com.catalogo.proveedores.models.ProveedorDTO;
import com.catalogo.proveedores.models.ProveedorShortData;
import com.catalogo.proveedores.publics.ResponseAPI;
import com.catalogo.proveedores.services.ProveedorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/proveedores")
public class ProveedorControllerImpl implements ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Override
    @GetMapping(value = ConstantsRoutes.GET_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseAPI<List<ProveedorDTO>>> getAll() {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseAPI<>(String.valueOf(HttpStatus.OK), this.proveedorService.getAll(), "Valor"));
    }

    @Override
    @PostMapping(value = ConstantsRoutes.CREATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseAPI<ProveedorDTO>> create(@RequestBody ProveedorDTO proveedorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseAPI<>(String.valueOf(HttpStatus.CREATED), this.proveedorService.create(proveedorDTO), "Valor"));
    }

    @Override
    @GetMapping(value = "/getAllShort", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseAPI<List<ProveedorShortData>>> getAllShort() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseAPI<>(String.valueOf(HttpStatus.OK), this.proveedorService.getShortData(), ""));
    }


}
