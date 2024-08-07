package com.catalogo.proveedores.controllers.impl;

import com.catalogo.proveedores.constants.ConstantsRoutes;
import com.catalogo.proveedores.controllers.ProveedorController;
import com.catalogo.proveedores.models.ProveedorDTO;
import com.catalogo.proveedores.publics.ResponseAPI;
import com.catalogo.proveedores.services.ProveedorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
