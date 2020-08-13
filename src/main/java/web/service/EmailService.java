package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    //Field
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private SimpleMailMessage mailMessage;

    //Function
    public void sendMail (String emailTo, String subject, String textMessage){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage(mailMessage);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(textMessage);
        mailSender.send(mailMessage);
    }

}
