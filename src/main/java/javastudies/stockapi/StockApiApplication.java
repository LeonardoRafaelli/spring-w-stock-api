package javastudies.stockapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
@EnableConfigurationProperties(AlphaVantageConfig.class)
public class StockApiApplication {
//	private static final String BASE_URL = "https://www.alphavantage.co/query?";
//	private static final String FUNCTION = "TIME_SERIES_MONTHLY";
//	private static final String SYMBOL = "AAPL";
//	private static final String API_KEY = "UV0T6HSE3GZFLN42";
	public static void main(String[] args) {
		SpringApplication.run(StockApiApplication.class, args);

//		// Builds the Request
//		HttpRequest getRequest = HttpRequest.newBuilder()
//				.uri(new URI(STR."\{BASE_URL}function=\{FUNCTION}&symbol=\{SYMBOL}&apikey=\{API_KEY}"))
//				.build();
//
//
//		// Creates the HttpClient to send the request
//		HttpClient httpClient = HttpClient.newHttpClient();
//		HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
//
//		System.out.println(getResponse.body());
	}
}
