package javastudies.stockapi.api;

import lombok.Builder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Builder
public class FetchAlphaApi {

    private final String apiBaseUrl = "https://www.alphavantage.co/query?";
    private String apiKey;
    private AlphaVantageFunctionType apiFunction;
    private String symbol;

    public String getRequest() {
        try{
            String url = STR."\{apiBaseUrl}&function=\{apiFunction.toString()}&symbol=\{symbol}&apikey=\{apiKey}";

            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            return response.body();

        }catch (Exception e){
            System.out.println(STR."Error while trying to Fetch. Error: \{e.getMessage()}");
        }
        return "Error";
    }
}
