package com.example.SpringBootLes3.Services;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class APIService {
    private final WebClient webClient;
    @Value("${rapidapi.key}")
    private String APIKey;

    public APIService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String fetchData(String baseUrl, String endpoint, String apiHost) {
        return webClient.get()
                .uri(baseUrl + endpoint)
                .header("X-RapidAPI-Key", APIKey)
                .header("X-RapidAPI-Host", apiHost)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
