package com.example.booking.Repository;

import com.example.booking.Boeking;

import java.util.ArrayList;
import java.util.List;

public class BoekingRepository {
    private List<Boeking> boekingen = new ArrayList<>();

    public void voegToe(Boeking boeking) {
        boekingen.add(boeking);
    }

    public List<Boeking> getAlleBoekingen() {
        return boekingen;
    }

    public Boeking zoekBoekingOpId(int id) {
        return boekingen.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }
}
