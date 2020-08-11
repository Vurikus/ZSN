package web.config;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.view.XmlViewResolver;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

@Configuration

public class MailConfiguration {

    private String username = "centrzan23@gmail.com";
    private String password = "1234Qwer!";

    @Bean
    public JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        mailSender.setJavaMailProperties(properties);
        mailSender.setHost(properties.getProperty("mail.smtp.host"));
        mailSender.setPort(Integer.parseInt(properties.getProperty("mail.smtp.port")));
        mailSender.setProtocol(properties.getProperty("mail.transport.protocol"));
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        return mailSender;
    }

    @Bean
    public VelocityEngine velocityEngine(){
        VelocityEngine velocityEngine = new VelocityEngine();
        return velocityEngine;
    }

    @Bean
    public SimpleMailMessage simpleMailMessage (){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setText("New text");
        return mailMessage;
    }

    public static void main(String[] args) {
//        Properties properties = new Properties();
//        try {
//            properties.put("mail.transport.protocol", "smtp");
//            properties.put("mail.smtp.host", "smtp.gmail.com");
//            properties.put("mail.smtp.port", "587");
//            properties.put("mail.smtp.auth", "true");
//            properties.put("mail.smtp.starttls.enable", "true");
//
//            Session mail = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("centrzan23@gmail.com", "1234Qwer!");
//            }
//        });

        try {
        MailConfiguration mail = new MailConfiguration();
        JavaMailSenderImpl javaMailSender = mail.javaMailSender();
        SimpleMailMessage mailMessage = new SimpleMailMessage(mail.simpleMailMessage());
        mailMessage.setTo("vurikus@yandex.ru");
        mailMessage.setText("Heilla");
        javaMailSender.send(mailMessage);


//        MimeMessage message = javaMailSender.createMimeMessage();
//        message.setFrom(new InternetAddress("centrzan23@gmail.com"));
//        message.setRecipient(Message.RecipientType.TO, new InternetAddress("vurikus@yandex.ru"));
//        message.setSubject("hello");
//        message.setText("Hi, new ");
//
//        javaMailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
