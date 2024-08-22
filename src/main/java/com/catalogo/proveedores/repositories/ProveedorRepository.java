package com.catalogo.proveedores.repositories;

import com.catalogo.proveedores.entities.Proveedor;
import com.catalogo.proveedores.models.ProveedorShortData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    @Procedure("get_all_active_proveedores")
    List<Proveedor> getAllActiveProveedores();

    @Query("SELECT new com.catalogo.proveedores.models.ProveedorShortData(p.direccion, p.telefono, p.email) FROM Proveedor p")
    List<ProveedorShortData> getShortData();

}
