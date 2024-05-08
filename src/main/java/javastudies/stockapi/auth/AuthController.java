package javastudies.stockapi.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my-stocks/auth")
public class AuthController {

    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
