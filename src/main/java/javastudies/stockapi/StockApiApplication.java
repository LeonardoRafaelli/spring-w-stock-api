package javastudies.stockapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

@SpringBootApplication
public class StockApiApplication {
	private static final String BASE_URL = "https://www.alphavantage.co/query?";
	private static final String FUNCTION = "TIME_SERIES_MONTHLY";
	private static final String SYMBOL = "AAPL";
	private static final String API_KEY = "UV0T6HSE3GZFLN42";
	public static void main(String[] args) throws Exception {
//		SpringApplication.run(StockApiApplication.class, args);

		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI(STR."\{BASE_URL}function=\{FUNCTION}&symbol=\{SYMBOL}&apikey=\{API_KEY}"))
				.GET().build();

		System.out.println(getRequest);

	}

}
