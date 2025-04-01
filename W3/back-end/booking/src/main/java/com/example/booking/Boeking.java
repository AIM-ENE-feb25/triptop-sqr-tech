package com.example.booking;

public class Boeking {
    private int id;
    private String klantNaam;

    public Boeking(int id, String klantNaam) {
        this.id = id;
        this.klantNaam = klantNaam;
    }

    public int getId() { return id; }
    public String getKlantNaam() { return klantNaam; }
}
