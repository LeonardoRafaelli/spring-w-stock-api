package javastudies.stockapi;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("alpha")
public record AlphaVantageConfig(String apiUrl, String apiKey) {
}
