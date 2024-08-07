package com.catalogo.proveedores.mappers;

import com.catalogo.proveedores.entities.Proveedor;
import com.catalogo.proveedores.models.ProveedorDTO;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MapperProveedor {

    public static ProveedorDTO mapEntityToDTO(Proveedor proveedor) {
        ProveedorDTO proveedorDTO = new ProveedorDTO();
        proveedorDTO.setId(proveedor.getId());
        proveedorDTO.setNombre(proveedor.getNombre());
        proveedorDTO.setEmail(proveedor.getEmail());
        proveedorDTO.setTelefono(proveedor.getTelefono());
        proveedorDTO.setDireccion(proveedor.getDireccion());
        proveedorDTO.setFechaRegistro(Timestamp.from(Instant.now()));
        return proveedorDTO;
    }


    public static List<ProveedorDTO> mapEntityListToDTOList(List<Proveedor> proveedores) {
        List<ProveedorDTO> proveedorDTOList = new ArrayList<>();
        for (Proveedor proveedor : proveedores) {
            proveedorDTOList.add(mapEntityToDTO(proveedor));
        }
        return proveedorDTOList;
    }


    public static Proveedor mapDTOToEntity(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(proveedorDTO.getId());
        proveedor.setNombre(proveedorDTO.getNombre());
        proveedor.setEmail(proveedorDTO.getEmail());
        proveedor.setTelefono(proveedorDTO.getTelefono());
        proveedor.setDireccion(proveedorDTO.getDireccion());
        proveedor.setFechaRegistro(Timestamp.from(Instant.now()));
        return proveedor;
    }

    public static List<Proveedor> mapDTOListToEntityList(List<ProveedorDTO> proveedorDTOList) {
        List<Proveedor> proveedores = new ArrayList<>();
        for (ProveedorDTO proveedorDTO : proveedorDTOList) {
            proveedores.add(mapDTOToEntity(proveedorDTO));
        }
        return proveedores;
    }

}
