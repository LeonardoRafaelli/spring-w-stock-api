package javastudies.stockapi.DTO;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GlobalQuoteDTO {

    @SerializedName("Global Quote")
    GlobalQuote globalQuote;

    @Data
    private static class GlobalQuote {
        @SerializedName("01. symbol")
        private String symbol;
        @SerializedName("02. open")
        private double open;
        @SerializedName("03. high")
        private double high;
        @SerializedName("04. low")
        private double low;
        @SerializedName("05. price")
        private double price;
        @SerializedName("06. volume")
        private long volume;
        @SerializedName("07. latest trading day")
        private String latestTradingDay;
        @SerializedName("08. previous close")
        private double previousClose;
        @SerializedName("09. change")
        private double change;
        @SerializedName("10. change percent")
        private String changePercent;
    }


}
