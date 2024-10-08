package com.catalogo.proveedores.controllers;

import com.catalogo.proveedores.models.ProveedorDTO;
import com.catalogo.proveedores.models.ProveedorShortData;
import com.catalogo.proveedores.publics.ResponseAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface ProveedorController {

    ResponseEntity<ResponseAPI<List<ProveedorDTO>>> getAll();

    ResponseEntity<ResponseAPI<ProveedorDTO>> create(ProveedorDTO proveedorDTO);

    ResponseEntity<ResponseAPI<List<ProveedorShortData>>> getAllShort();

    ResponseEntity<ResponseAPI<ProveedorDTO>> getById(Long id);

}
