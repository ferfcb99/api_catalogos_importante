package com.catalogo.proveedores.controllers;

import com.catalogo.proveedores.models.EmailDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface MailController {

    ResponseEntity<?> receiveEmail(@RequestBody EmailDTO emailDTO);

}
