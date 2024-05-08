package javastudies.stockapi.auth;

import javastudies.stockapi.model.User;
import javastudies.stockapi.repository.UserRepository;
import javastudies.stockapi.service.UserRole;
import javastudies.stockapi.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/my-stocks/auth")
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute User user) {
        System.out.println(STR."User\{user}");
        User newUser = userService.createUser(user);
        if(newUser != null) {
            return "redirect:/login";
        }
        return "redirect:/register";
    };

    @GetMapping("/login")
    public String login(Model m) {
        m.addAttribute("fullName", "LeozinDoGrau");
        return "login";
    }
}
