package com.example.SpringBootLes3.Controller;

import com.example.SpringBootLes3.Services.APIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
    private final APIService apiService;

    public APIController(APIService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/bookings")
    public ResponseEntity<String> getBookings() {
        String response = apiService.fetchData(
                "https://weatherapi.p.rapidapi.com",
                "/current",
                "weatherapi.p.rapidapi.com"
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/route")
    public ResponseEntity<String> getRoute() {
        String response = apiService.fetchData(
                "https://cryptoapi.p.rapidapi.com",
                "/prices",
                "cryptoapi.p.rapidapi.com"
        );
        return ResponseEntity.ok(response);
    }
}
