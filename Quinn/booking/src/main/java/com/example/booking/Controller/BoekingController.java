package com.example.booking.Controller;

import com.example.booking.Service.BoekingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BoekingController {
    private final BoekingService service;

    public BoekingController(BoekingService service) {
        this.service = service;
    }

    @GetMapping("/booking")
    public String nieuweBoeking(@RequestParam String locatie, @RequestParam String aankomst, @RequestParam String vertrek, @RequestParam String adapterKeuze) {
        if ("BookingCom".equalsIgnoreCase(adapterKeuze)) {
            return service.maakBoeking(locatie, aankomst, vertrek, "BookingCom");
        } else if ("Tripadvisor".equalsIgnoreCase(adapterKeuze)) {
            return service.maakBoeking(locatie, aankomst, vertrek, "Tripadvisor");
        } else {
            return "Ongeldige keuze voor adapter.";
        }
    }
}
