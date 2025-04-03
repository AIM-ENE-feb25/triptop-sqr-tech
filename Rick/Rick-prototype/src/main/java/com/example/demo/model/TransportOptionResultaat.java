package com.example.demo.model;

public class TransportOptionResultaat {
    private String provider;
    private String departureTime;
    private String arrivalTime;
    private boolean available;

    public TransportOptionResultaat(String provider, String departureTime, String arrivalTime, boolean available) {
        this.provider = provider;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.available = available;
    }

    public String getProvider() {
        return provider;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public boolean isAvailable() {
        return available;
    }
}
