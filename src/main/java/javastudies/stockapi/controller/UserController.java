package javastudies.stockapi.controller;

import javastudies.stockapi.DTO.StockSearchDTO;
import javastudies.stockapi.api.AlphaVantageConfig;
import javastudies.stockapi.api.FetchAlphaApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/my-stocks")
@RequiredArgsConstructor
public class UserController {

    private final AlphaVantageConfig alphaVantageConfig;

    @RequestMapping("/home")
    public String getGreetings(Model m){
        return "home";
    }

    @PostMapping("/get-stock-info")
    public String getStockInfo(Model m, @ModelAttribute StockSearchDTO stockSearch) {
        System.out.println(STR."StockSymbol: \{stockSearch.getSymbol()}");
        System.out.println(STR."REQUEST\{
                FetchAlphaApi.builder()
                .apiFunction("GLOBAL_QUOTE")
                .symbol(stockSearch.getSymbol())
                .apiKey(alphaVantageConfig.apiKey())
                .build()
                .getRequest()}"
        );
        return "home";
    };
}
