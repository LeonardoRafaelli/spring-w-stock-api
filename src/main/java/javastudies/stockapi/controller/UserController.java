package javastudies.stockapi.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.HttpServletRequest;
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
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping("/my-stocks")
@RequiredArgsConstructor
public class UserController {

    private final AlphaVantageConfig alphaVantageConfig;
    private final UserServiceImpl userService;

    @RequestMapping("/home")
    public String getGreetings(
            HttpServletRequest request,
            Model m,
            @AuthenticationPrincipal CustomUserDetails userDtls
    ){
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if(inputFlashMap != null) {
            GlobalQuoteDTO globalQuoteDTO = (GlobalQuoteDTO) inputFlashMap.get("stock");
            m.addAttribute("stock", globalQuoteDTO.getGlobalQuote());
        }
        m.addAttribute("user", userDtls.getUser());
        m.addAttribute("userAccount", userDtls.getUser().getAccount());
        return "home";
    }

    @PostMapping("/get-stock-info")
    public RedirectView getStockInfo(
            Model m,
            @ModelAttribute StockSearchDTO stockSearch,
            RedirectAttributes redirectAttributes
    ) {

        Gson gson = new Gson();

        String apiResponse = FetchAlphaApi.builder()
        .apiFunction(AlphaVantageFunctionType.GLOBAL_QUOTE)
        .symbol(stockSearch.getSymbol())
        .build()
        .getRequest();

        System.out.println(STR."Response: \{apiResponse}");

        GlobalQuoteDTO globalQuoteDTO = gson.fromJson(apiResponse, GlobalQuoteDTO.class);
        System.out.println(STR."Global Quote DTO = \{globalQuoteDTO}");

        redirectAttributes.addFlashAttribute("stock", globalQuoteDTO);

        return new RedirectView("/my-stocks/home", true);
    };

    @PostMapping("/add-money")
    public String addMoneyToAccount(){
        System.out.println("Chegou em Add Money");
        return "redirect:/home";
    }
}
