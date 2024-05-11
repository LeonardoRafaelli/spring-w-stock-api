package javastudies.stockapi.service;

import org.springframework.stereotype.Service;

@Service
public class StockApiServiceImpl implements StockApiService {

    private static final String BASE_URL = "https://www.alphavantage.co/query?";
    private static final String FUNCTION = "TIME_SERIES_MONTHLY";
    private static final String SYMBOL = "AAPL";
    private static final String API_KEY = "UV0T6HSE3GZFLN42";

    @Override
    public Object getStockTimeSeriesMonthly(String symbol) {

        return null;
    }
}
