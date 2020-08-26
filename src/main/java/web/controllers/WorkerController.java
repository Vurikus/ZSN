package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.model.Email;
import web.model.Person;
import web.service.EmailService;
import web.service.RegisterService;

import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController extends PublicController{
    //Field
    @Autowired
    private RegisterService registerService;
    @Autowired
    private EmailService emailService;

    //Function
    @GetMapping("/registration/pdf")
    public ModelAndView pdf() {
        System.out.println("ExcelPDFController pdf is called");

        List<Person> list = registerService.getAllPerson();
        return new ModelAndView("pdfDocument", "model", list);
    }


}
