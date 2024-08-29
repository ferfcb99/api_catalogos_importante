package com.catalogo.proveedores.services.impl;

import com.catalogo.proveedores.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.charset.StandardCharsets;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${email.sender}")
    private String emailUser;

    private JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(String[] to, String subject, String body) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailUser);
        mailMessage.setTo(to); // se puede enviar array de strings para los correos
        mailMessage.setSubject(subject);
        mailMessage.setText(body);

        this.mailSender.send(mailMessage);
    }

    @Override
    public void senEmailWithFile(String[] to, String subject, String body, File file) {
      try{
          MimeMessage mimeMessage = mailSender.createMimeMessage();
          MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

          mimeMessageHelper.setFrom(emailUser);
          mimeMessageHelper.setTo(to);
          mimeMessageHelper.setSubject(subject);
          mimeMessageHelper.setText(body);
          mimeMessageHelper.addAttachment(file.getName(), file);

          mailSender.send(mimeMessage);

      }catch (MessagingException e){
          throw new RuntimeException(e);
      }
    }

}
