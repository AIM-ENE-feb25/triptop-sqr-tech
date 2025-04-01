package com.example.booking.Adapter;

import com.example.booking.API.TripadvisorService;
import com.example.booking.Boeking;
import com.example.booking.Service.IBoekingAdapter;

public class TripadvisorAdapter implements IBoekingAdapter {
    private TripadvisorService tripadvisor;

    public TripadvisorAdapter(TripadvisorService tripadvisor) {
        this.tripadvisor = tripadvisor;
    }

    @Override
    public boolean maakBoeking(Boeking boeking) {
        return tripadvisor.boek(boeking);
    }

    @Override
    public String getNaam() {
        return "TripAdvisor";
    }
}
