package com.catalogo.proveedores.controllers.impl;

import com.catalogo.proveedores.constants.ConstantsRoutes;
import com.catalogo.proveedores.controllers.ProveedorController;
import com.catalogo.proveedores.models.ProveedorDTO;
import com.catalogo.proveedores.models.ProveedorShortData;
import com.catalogo.proveedores.publics.ResponseAPI;
import com.catalogo.proveedores.services.ProveedorService;
import com.catalogo.proveedores.services.ValidaHeaders;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.mail.Session;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(path = "/proveedores")
public class ProveedorControllerImpl implements ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private ValidaHeaders validaHeaders;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    @GetMapping(value = ConstantsRoutes.GET_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseAPI<List<ProveedorDTO>>> getAll() {

            // meter aqui la logica del JWT

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseAPI<>(String.valueOf(HttpStatus.OK), this.proveedorService.getAll(), "Valor"));
    }

    @Override
    @PostMapping(value = ConstantsRoutes.CREATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseAPI<ProveedorDTO>> create(@RequestBody ProveedorDTO proveedorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseAPI<>(String.valueOf(HttpStatus.CREATED), this.proveedorService.create(proveedorDTO), "Valor"));
    }

    @Override
    @GetMapping(value = "/getAllShort", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseAPI<List<ProveedorShortData>>> getAllShort() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseAPI<>(String.valueOf(HttpStatus.OK), this.proveedorService.getShortData(), ""));
    }

    @Override
    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseAPI<ProveedorDTO>> getById(@PathVariable Long id) {

        //this.validaHeaders.validaHeaderAuthorization(authorization);
        //this.validaHeaders.validaHeaderAuthorization(clientId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseAPI<>(String.valueOf(HttpStatus.OK), this.proveedorService.getById(id), "VALOR DE ID"));
    }

    @GetMapping(value = "/secured")
    public ResponseEntity<ResponseAPI<String>> index() {
        return ResponseEntity.status(HttpStatus.OK).
                body(new ResponseAPI<>(String.valueOf(HttpStatus.OK), "Secured Endpoint", "done"));
    }


    @GetMapping(value = "/nonsecured")
    public ResponseEntity<ResponseAPI<String>> index2() {
        return ResponseEntity.status(HttpStatus.OK).
                body(new ResponseAPI<>(String.valueOf(HttpStatus.OK), "NonSecured Endpoint", "done"));
    }

    @GetMapping(value = "/session")
    public ResponseEntity<ResponseAPI<?>> getDetailSession(){

        String sessionId = "";
        User userObject = null;

        List<Object> sessions = sessionRegistry.getAllPrincipals();

        for (Object session : sessions) {
            if(session instanceof User){
                userObject = (User)session;
            }
            List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(session, false);
            for (SessionInformation sessionInformation : sessionInformations) {
                sessionId = sessionInformation.getSessionId();
            }

        }
        Map<String, Object> response = new HashMap<>();
        response.put("response", "Hello world");
        response.put("sessionId", sessionId);
        response.put("sessionUser", userObject);
        return ResponseEntity.ok(new ResponseAPI<>(String.valueOf(HttpStatus.OK), response,"test"));
    }


}
