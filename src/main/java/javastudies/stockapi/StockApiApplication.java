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

	public static void main(String[] args) {
		SpringApplication.run(StockApiApplication.class, args);
	}
}
