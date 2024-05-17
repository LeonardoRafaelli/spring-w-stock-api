package javastudies.stockapi.api;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("alpha")
public record AlphaVantageConfig(String apiKey) {
}
