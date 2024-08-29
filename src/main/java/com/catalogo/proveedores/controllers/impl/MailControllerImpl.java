package com.catalogo.proveedores.controllers.impl;


import com.catalogo.proveedores.controllers.MailController;
import com.catalogo.proveedores.models.EmailDTO;
import com.catalogo.proveedores.services.EmailService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/sendemail")
public class MailControllerImpl implements MailController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/sendMessage", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> receiveEmail(@RequestBody EmailDTO emailDTO) {

        System.out.println("Mensaje recibido");

        emailService.sendEmail(emailDTO.getTo(), emailDTO.getSubject(), emailDTO.getBody());

        Map<String, String> response = new HashMap<>();
        response.put("estado", "Enviado");

        return ResponseEntity.ok(response);
    }

}
