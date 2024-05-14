package javastudies.stockapi.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javastudies.stockapi.DTO.GlobalQuoteDTO;
import javastudies.stockapi.DTO.StockSearchDTO;
import javastudies.stockapi.api.AlphaVantageConfig;
import javastudies.stockapi.api.AlphaVantageFunctionType;
import javastudies.stockapi.api.CustomFieldNamingStrategy;
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
