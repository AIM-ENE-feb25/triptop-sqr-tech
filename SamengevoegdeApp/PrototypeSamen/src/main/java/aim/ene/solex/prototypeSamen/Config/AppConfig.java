package aim.ene.solex.prototypeSamen.Config;

import aim.ene.solex.prototypeSamen.planner.TransportPlanner;
import aim.ene.solex.prototypeSamen.transport.TransportOption;
import aim.ene.solex.prototypeSamen.transport.TreinTransport;
import aim.ene.solex.prototypeSamen.transport.VluchtTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${transport.type}")
    private String transportType;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Primary
    @Bean
    public TransportOption transportOption(TreinTransport treinTransport, VluchtTransport vluchtTransport) {
        return switch (transportType.toLowerCase()) {
            case "train" -> treinTransport;
            case "flight" -> vluchtTransport;
            default -> throw new IllegalArgumentException("Onbekend transporttype: " + transportType);
        };
    }

    @Bean
    public TransportPlanner transportPlanner(TransportOption option) {
        return new TransportPlanner(option);
    }
}
