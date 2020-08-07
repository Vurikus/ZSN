package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Passport;
import web.model.Person;
import web.service.RegisterService;

import java.util.List;

@Controller
public class RegisterController {
    //Field
    @Autowired
    private RegisterService registerService;

    //Function
    @GetMapping("/start")
    public String startPage(Model model){
        model.addAttribute("listAllPerson", registerService.getAllPerson());
        return "startPage";
    }

    @GetMapping("/registration")
    public String registration(){

        return "register";
    }

    @PostMapping("/registration")
    public String registrationUnemployed(@RequestParam(value = "name") String name,
                                         @RequestParam(value = "surname") String surname,
                                         Model model){
        registerService.addPerson(new Person(name, surname, "as", 12));
        return "regSuccess";
    }

    @GetMapping("/registration/pdf")
    public ModelAndView pdf() {
        System.out.println("ExcelPDFController pdf is called");
        List<Person> list = registerService.getAllPerson();
        return new ModelAndView("pdfDocument", "model", list);
    }


    //Getter and Setter
}
