package javastudies.stockapi.controller;

import jakarta.servlet.http.HttpServletRequest;
import javastudies.stockapi.DTO.GlobalQuoteDTO;
import javastudies.stockapi.auth.CustomUserDetails;
import javastudies.stockapi.service.implemented.StockApiServiceImpl;
import javastudies.stockapi.service.implemented.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/my-stocks")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final StockApiServiceImpl stockApiService;

    @RequestMapping("/home")
    public String getGreetings(
            @RequestParam(name = "symbol", required = false) String stockSymbol,
            Model m,
            @AuthenticationPrincipal CustomUserDetails userDtls
    ){

        if(stockSymbol != null) {
            GlobalQuoteDTO globalQuoteDTO = stockApiService.getStockGlobalQuote(stockSymbol);
            m.addAttribute("stock", globalQuoteDTO.getGlobalQuote());
        }

        m.addAttribute("user", userDtls.getUser());
        m.addAttribute("userAccount", userDtls.getUser().getAccount());
        return "home";
    }

    @PostMapping("/get-stock-info")
    public String getStockInfo(
            @RequestParam(name = "symbol") String stockSymbol
    ) {
        return STR."redirect:/my-stocks/home?symbol=\{stockSymbol}";
    };

    @PostMapping("/add-money")
    public String addMoneyToAccount(){
        System.out.println("Chegou em Add Money");
        return "redirect:/my-stocks/home";
    }

    // Dedicated Error Page
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        System.out.println("Reach User Controller Handle ERror");
        return "home";
    }
}
