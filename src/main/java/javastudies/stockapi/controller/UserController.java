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
        //		// Builds the Request
        //		HttpRequest getRequest = HttpRequest.newBuilder()
        //				.uri(new URI(STR."\{BASE_URL}function=\{FUNCTION}&symbol=\{SYMBOL}&apikey=\{API_KEY}"))
        //				.build();
        //
        //
        //		// Creates the HttpClient to send the request
        //		HttpClient httpClient = HttpClient.newHttpClient();
        //		HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        //
        //		System.out.println(getResponse.body());
        return "home";
    }

}
