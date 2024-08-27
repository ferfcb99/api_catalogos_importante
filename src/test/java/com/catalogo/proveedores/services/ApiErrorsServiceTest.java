package com.catalogo.proveedores.services;

import com.catalogo.proveedores.entities.ApiErrors;
import com.catalogo.proveedores.repositories.ApiErrorsRepository;
import com.catalogo.proveedores.services.impl.ApiErrorsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;

@SpringBootTest
public class ApiErrorsServiceTest {

    @Mock
    ApiErrorsRepository apiErrorsRepository;

    @InjectMocks
    ApiErrorsService apiErrorsService = new ApiErrorsServiceImpl(apiErrorsRepository);

    ApiErrors apiErrors;

    @BeforeEach
    public void setUp(){
        apiErrors = new ApiErrors();
        apiErrors.setId(1);
        apiErrors.setCode("123");
        apiErrors.setMessage("message");
        apiErrors.setCreateAt(new Timestamp(System.currentTimeMillis()));
    }

    @Test
    public void saveErrorTest(){
        System.out.println("Test there");
        Mockito.when(this.apiErrorsRepository.save(this.apiErrors)).thenReturn(this.apiErrors);
        assertNotNull(this.apiErrorsService.saveError(apiErrors));
    }
    
    @Test
    public void saveErrorExceptionTest() {
    	Mockito.when(this.apiErrorsRepository.save(this.apiErrors)).thenThrow(new RuntimeException());
    	assertThrows(UnknownError.class, () -> this.apiErrorsService.saveError(apiErrors));
    }

}











