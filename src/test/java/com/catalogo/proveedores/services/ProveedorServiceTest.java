package com.catalogo.proveedores.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.proveedores.entities.Proveedor;
import com.catalogo.proveedores.exceptions.NotContentException;
import com.catalogo.proveedores.exceptions.ValidacionesException;
import com.catalogo.proveedores.repositories.ProveedorRepository;
import com.catalogo.proveedores.repositories.ProveedorViewRepository;
import com.catalogo.proveedores.services.impl.ProveedorServiceImpl;

@SpringBootTest
public class ProveedorServiceTest {

	@Mock
	private ProveedorRepository proveedorRepository;
	
	@Mock
	private ProveedorViewRepository proveedorViewRepository;
	
	@InjectMocks
	private ProveedorService proveedorService = new ProveedorServiceImpl(proveedorRepository, proveedorViewRepository);
	
	List<Proveedor> proveedores;
	
	@BeforeEach
	public void setUp() {
		this.proveedores = new ArrayList<>();
		this.proveedores.add(
				new Proveedor(1L, "ProvTest", "ProvTest", "5662561278", "test@test.com", new Timestamp(System.currentTimeMillis())));
	}
	
	@Test
	public void getAllTest() {
		Mockito.when(this.proveedorRepository.findAll()).thenReturn(proveedores);
		this.proveedorService.getAll();
	}
	
	@Test
	public void getAllExceptionTest() {
		Mockito.when(this.proveedorRepository.findAll()).thenThrow(RuntimeException.class);
		assertThrows(ValidacionesException.class, () -> this.proveedorService.getAll());
	}
	
	@Test 
	public void getAllExceptionEmptyTest() {
		this.proveedores.clear();
		Mockito.when(this.proveedorRepository.findAll()).thenReturn(proveedores);
		assertThrows(NotContentException.class, () -> this.proveedorService.getAll());
	}
	
	
}
