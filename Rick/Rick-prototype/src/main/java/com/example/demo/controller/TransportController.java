package com.example.demo.controller;

import com.example.demo.model.TransportOptionResultaat;
import com.example.demo.planner.TransportPlanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class TransportController {

    private final TransportPlanner planner;

    public TransportController(TransportPlanner planner) {
        this.planner = planner;
    }

    @GetMapping
    public ResponseEntity<List<TransportOptionResultaat>> plan(
            @RequestParam String from,
            @RequestParam String to) {

        List<TransportOptionResultaat> results = planner.search(from, to);
        return ResponseEntity.ok(results);
    }
}
