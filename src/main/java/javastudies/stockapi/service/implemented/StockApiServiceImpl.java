package javastudies.stockapi.service.implemented;

import com.google.gson.Gson;
import javastudies.stockapi.DTO.GlobalQuoteDTO;
import javastudies.stockapi.DTO.StockSearchDTO;
import javastudies.stockapi.api.AlphaVantageFunctionType;
import javastudies.stockapi.api.FetchAlphaApi;
import javastudies.stockapi.service.StockApiService;
import org.springframework.stereotype.Service;

@Service
public class StockApiServiceImpl implements StockApiService {

    @Override
    public GlobalQuoteDTO getStockGlobalQuote(String stockSymbol) {

        Gson gson = new Gson();

        String apiResponse = FetchAlphaApi.builder()
                .apiFunction(AlphaVantageFunctionType.GLOBAL_QUOTE)
                .symbol(stockSymbol)
                .build()
                .getRequest();

        return gson.fromJson(apiResponse, GlobalQuoteDTO.class);
    }
}
