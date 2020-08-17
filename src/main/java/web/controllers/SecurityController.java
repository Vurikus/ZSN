package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/index")
    public String index() {
        return "security/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "security/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "security/user";
    }

    @GetMapping("/login")
    public String login() {
        return "security/login";
    }

}
