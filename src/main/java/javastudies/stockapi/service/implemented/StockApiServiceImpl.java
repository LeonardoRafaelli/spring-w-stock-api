package javastudies.stockapi.service.implemented;

import com.google.gson.Gson;
import javastudies.stockapi.DTO.GlobalQuoteDTO;
import javastudies.stockapi.DTO.StockSearchDTO;
import javastudies.stockapi.api.AlphaVantageConfig;
import javastudies.stockapi.api.AlphaVantageFunctionType;
import javastudies.stockapi.api.FetchAlphaApi;
import javastudies.stockapi.service.StockApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockApiServiceImpl implements StockApiService {

    private final AlphaVantageConfig alphaVantageConfig;

    @Override
    public GlobalQuoteDTO getStockGlobalQuote(String stockSymbol) {

        Gson gson = new Gson();

        String apiResponse = FetchAlphaApi.builder()
                .apiFunction(AlphaVantageFunctionType.GLOBAL_QUOTE)
                .symbol(stockSymbol)
                .apiKey(alphaVantageConfig.apiKey())
                .build()
                .getRequest();

        System.out.println(STR."API Response: \{apiResponse}");

        return gson.fromJson(apiResponse, GlobalQuoteDTO.class);
    }
}
