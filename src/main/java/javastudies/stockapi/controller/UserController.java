package javastudies.stockapi.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javastudies.stockapi.DTO.GlobalQuoteDTO;
import javastudies.stockapi.DTO.StockSearchDTO;
import javastudies.stockapi.api.AlphaVantageConfig;
import javastudies.stockapi.api.AlphaVantageFunctionType;
import javastudies.stockapi.api.CustomFieldNamingStrategy;
import javastudies.stockapi.api.FetchAlphaApi;
import javastudies.stockapi.auth.CustomUserDetails;
import javastudies.stockapi.model.Account;
import javastudies.stockapi.model.User;
import javastudies.stockapi.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/my-stocks")
@RequiredArgsConstructor
public class UserController {

    private final AlphaVantageConfig alphaVantageConfig;
    private final UserServiceImpl userService;
    private final Authentication authentication;

    @RequestMapping("/home")
    public String getGreetings(Model m){
        CustomUserDetails userDtls = (CustomUserDetails) authentication.getPrincipal();
        m.addAttribute("user", userDtls.getUser());
        m.addAttribute("userAccount", userDtls.getUser().getAccount());
        return "home";
    }

    @PostMapping("/get-stock-info")
    public String getStockInfo(Model m, @ModelAttribute StockSearchDTO stockSearch) {

        Gson gson = new GsonBuilder()
                .setFieldNamingStrategy(new CustomFieldNamingStrategy())
                .create();

        String apiResponse = FetchAlphaApi.builder()
        .apiFunction(AlphaVantageFunctionType.GLOBAL_QUOTE)
        .symbol(stockSearch.getSymbol())
        .build()
        .getRequest();

        System.out.println(STR."Response: \{apiResponse}");

        GlobalQuoteDTO globalQuoteDTO = gson.fromJson(apiResponse, GlobalQuoteDTO.class);
        System.out.println(STR."Global Quote DTO = \{globalQuoteDTO}");

        m.addAttribute("stock", globalQuoteDTO.getGlobalQuote());

        return "home";
    };
}
