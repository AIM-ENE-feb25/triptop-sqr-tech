package com.example.demo.controller;

import com.example.demo.external.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train")
public class TreinController {

    private final TreinService treinService;

    @Autowired
    public TreinController(TreinService treinService) {
        this.treinService = treinService;
    }

    @GetMapping("/journey")
    public String getJourneyDetails(
            @RequestParam String fromStation,
            @RequestParam String toStation,
            @RequestParam String dateTime
    ) {
        // Aansluiting naar de NS API via de service
        return treinService.getTrainJourneyDetails(fromStation, toStation, dateTime);
    }
}
