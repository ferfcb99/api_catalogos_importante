package com.catalogo.proveedores.repositories;

import com.catalogo.proveedores.entities.Proveedor;
import com.catalogo.proveedores.entities.VistaProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorViewRepository extends JpaRepository<VistaProveedor, Long> {



}
