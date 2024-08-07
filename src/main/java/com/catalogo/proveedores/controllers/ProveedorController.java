package com.catalogo.proveedores.controllers;

import com.catalogo.proveedores.models.ProveedorDTO;
import com.catalogo.proveedores.publics.ResponseAPI;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProveedorController {

    ResponseEntity<ResponseAPI<List<ProveedorDTO>>> getAll();

}
