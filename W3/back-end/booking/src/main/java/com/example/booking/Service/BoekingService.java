package com.example.booking.Service;


import com.example.booking.Boeking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoekingService {
    private final List<IBoekingAdapter> adapters;

    public BoekingService(List<IBoekingAdapter> adapters) {
        this.adapters = adapters;
    }

    public String maakBoeking(String locatie, String aankomst, String vertrek, String adapterKeuze) {
        for (IBoekingAdapter adapter : adapters) {
            if (adapter.getNaam().equalsIgnoreCase(adapterKeuze)) {
                return adapter.maakBoeking(new Boeking(locatie, aankomst, vertrek));
            }
        }
        return "Adapter niet gevonden";
    }
}
