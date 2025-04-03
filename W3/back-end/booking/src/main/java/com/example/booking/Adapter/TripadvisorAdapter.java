package com.example.booking.Adapter;

import com.example.booking.API.TripadvisorService;

import com.example.booking.Domain.Boeking;
import org.springframework.stereotype.Component;

@Component
public class TripadvisorAdapter implements IBoekingAdapter {
    private TripadvisorService tripadvisor;

    public TripadvisorAdapter(TripadvisorService tripadvisor) {
        this.tripadvisor = tripadvisor;
    }

    @Override
    public String maakBoeking(Boeking boeking) {
        String response = tripadvisor.boek(
                boeking.getLocatie(),
                boeking.getAankomstDatum(),
                boeking.getVertrekDatum()
        );
        return response;
    }

    @Override
    public String getNaam() {
        return "TripAdvisor";
    }
}
