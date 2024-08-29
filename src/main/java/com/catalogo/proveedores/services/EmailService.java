package com.catalogo.proveedores.services;

import java.io.File;

public interface EmailService {

    void sendEmail(String[] to, String subject, String body);

    void senEmailWithFile(String[] to, String subject, String body, File file);

}
