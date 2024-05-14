package javastudies.stockapi.api;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Builder
public class FetchAlphaApi {

    private static final String apiBaseUrl = "https://www.alphavantage.co/query?";
    private String apiKey;
    private String apiFunction;
    private String symbol;

    public String getRequest() {
        try{
            String url = STR."\{apiBaseUrl}&function=\{apiFunction}&symbol=\{symbol}&apikey=\{apiKey}";
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

            return response.body();

        }catch (Exception e){
            System.out.println(STR."Error while making the Fetch. Error: \{e.getMessage()}");
        }
        return "Error";
    }
}
