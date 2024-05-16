package javastudies.stockapi.service;

import javastudies.stockapi.DTO.GlobalQuoteDTO;
import javastudies.stockapi.DTO.StockSearchDTO;

public interface StockApiService {
    GlobalQuoteDTO getStockGlobalQuote(String stockSymbol);
}
