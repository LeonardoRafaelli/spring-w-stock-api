package javastudies.stockapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my-stocks")
public class UserController {

    @GetMapping("/home")
    public String getGreetings(){
        return "home";
    }

}
