package javastudies.stockapi.api;

import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("alpha")
public record AlphaVantageConfig(String apiKey) {
}
