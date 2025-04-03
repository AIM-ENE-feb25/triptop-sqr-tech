package com.example.demo.transport;

import com.example.demo.external.TreinService;
import com.example.demo.model.TransportOptionResultaat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TreinTransport implements TransportOption {

    private final TreinService treinService;

    public TreinTransport(TreinService treinService) {
        this.treinService = treinService;
    }

    @Override
    public List<TransportOptionResultaat> searchOptions(String from, String to) {
        String now = java.time.LocalDateTime.now().toString();
        return treinService.zoekTreinOpties(from, to, now);
    }
}
