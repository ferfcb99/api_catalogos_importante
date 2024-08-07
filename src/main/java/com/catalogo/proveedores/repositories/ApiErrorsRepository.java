package com.catalogo.proveedores.repositories;

import com.catalogo.proveedores.entities.ApiErrors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiErrorsRepository extends JpaRepository<ApiErrors, Integer> {
}
