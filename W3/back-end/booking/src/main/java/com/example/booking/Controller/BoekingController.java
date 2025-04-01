package com.example.booking.Controller;

import com.example.booking.Boeking;
import com.example.booking.Service.BoekingService;

public class BoekingController {
    private BoekingService service;

    public BoekingController(BoekingService service) {
        this.service = service;
    }

    public void nieuweBoeking(Boeking boeking) {
        if (service.maakBoeking(boeking)) {
            System.out.println("Boeking succesvol!");
        } else {
            System.out.println("Boeking mislukt!");
        }
    }

    public void toonAlleBoekingen() {
        for (Boeking boeking : service.haalAlleBoekingenOp()) {
            System.out.println("Boeking ID: " + boeking.getId() + ", Klant: " + boeking.getKlantNaam());
        }
    }
}
