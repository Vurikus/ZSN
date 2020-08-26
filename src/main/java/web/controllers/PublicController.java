package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Email;
import web.model.Person;
import web.service.EmailService;
import web.service.RegisterService;

@Controller
public class PublicController {
    //Field
    @Autowired
    private RegisterService registerService;
    @Autowired
    private EmailService emailService;

    //Function
    @GetMapping("/")
    public String startPage(Model model){
        return "public/index";
    }

    @GetMapping("/public/documentation")
    public String documentationPage (Model model){
        return "public/documentation";
    }

    @GetMapping("/public/contact")
    public String contactPage (Model model){
        return "public/contact";
    }

    @GetMapping("/registration/list")
    public String getRegistrationPage (Model model){
        return "public/list";
    }

    @PostMapping("/registration/list")
    public String sendRegistration (@RequestParam(value = "name") String name,
                                    @RequestParam(value = "surname") String surname,
                                    @RequestParam(value = "patronymic") String patronymic,
                                    @RequestParam(value = "age") int age,
                                    @RequestParam(value = "email") String email,
                                    Model model){
        emailService.sendMail(email, name + Email.SUBJECT, Email.MESSAGE);
        registerService.addPerson(new Person(name, surname, patronymic, age));
        return "public/regSuccess";
    }

}
