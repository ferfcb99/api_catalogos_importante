package com.catalogo.proveedores.services;

import com.catalogo.proveedores.entities.Proveedor;
import com.catalogo.proveedores.models.ProveedorDTO;
import com.catalogo.proveedores.models.ProveedorShortData;

import java.util.List;

public interface ProveedorService {

    List<ProveedorDTO> getAll();

    ProveedorDTO create(ProveedorDTO proveedorDTO);

    List<ProveedorShortData> getShortData();

}
