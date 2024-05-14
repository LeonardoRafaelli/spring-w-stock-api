package javastudies.stockapi.api;

import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties("alpha")
public record AlphaVantageConfig(String apiKey) {
}
