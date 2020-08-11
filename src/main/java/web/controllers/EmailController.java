package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Email;
import web.service.EmailService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/email")
    public String getEmailPage(){
        return "email";
    }

    @PostMapping("/email")
    public String sendEmail(@RequestParam(value = "name") String name,
                            @RequestParam(value = "phoneNumber") String phone,
                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "message") String message){
        String subject = name + " registered";
        emailService.sendMail(email, subject, message);
        return "redirect:/start";
    }


}
