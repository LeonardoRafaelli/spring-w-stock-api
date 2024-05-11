package javastudies.stockapi.controller;

import javastudies.stockapi.AlphaVantageConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping("/my-stocks")
@RequiredArgsConstructor
public class UserController {

    private final AlphaVantageConfig alphaVantageConfig;

    @RequestMapping("/home")
    public String getGreetings(Model m){
        m.addAttribute("api_key", alphaVantageConfig.apiKey());
        m.addAttribute("api_url", alphaVantageConfig.apiUrl());
        return "home";
    }

}
