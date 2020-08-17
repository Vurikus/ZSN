package web.planner;

import org.springframework.beans.factory.annotation.Autowired;
import web.service.EmailService;

import java.util.Calendar;

public class CronQuartzTask {

    @Autowired
    private EmailService emailService;
    private String email = "usolcev37@gmail.com";
    private String subject = "test";
    private String message = "new message";


    public void cronTaskMethod() {
        //emailService.sendMail(email, subject, message);
    }
}
