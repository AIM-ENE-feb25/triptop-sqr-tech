package com.example.booking.Service;

import com.example.booking.Boeking;
import com.example.booking.Repository.BoekingRepository;

import java.util.List;

public class BoekingService {
    private BoekingRepository repository;
    private List<IBoekingAdapter> adapters;

    public BoekingService(BoekingRepository repository, List<IBoekingAdapter> adapters) {
        this.repository = repository;
        this.adapters = adapters;
    }

    public boolean maakBoeking(Boeking boeking) {
        repository.voegToe(boeking);
        for (IBoekingAdapter adapter : adapters) {
            if (!adapter.maakBoeking(boeking)) {
                return false;
            }
        }
        return true;
    }

    public List<Boeking> haalAlleBoekingenOp() {
        return repository.getAlleBoekingen();
    }
}
