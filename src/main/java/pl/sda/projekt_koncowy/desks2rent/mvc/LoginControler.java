package pl.sda.projekt_koncowy.desks2rent.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControler {

    @GetMapping("/login")
    String loginPage(){
        return "login.html";
    }
}
