package javastudies.stockapi.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Controller
public class ErrorController {

    @RequestMapping("/**")
    public String handleNotFound(HttpServletRequest request){
        System.out.println("Error Controller");
        String refererUrl = request.getHeader("Referer");
        if(refererUrl != null && !refererUrl.isEmpty()) {
            return STR."redirect:\{refererUrl}";
        }
        return "redirect:/my-stocks/home";
    }
}
