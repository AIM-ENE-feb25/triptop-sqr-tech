package com.example.booking;

public class Boeking {
    private String locatie;
    private String aankomstDatum;
    private String vertrekDatum;

    public Boeking(String locatie, String aankomstDatum, String vertrekDatum) {
        this.locatie = locatie;
        this.aankomstDatum = aankomstDatum;
        this.vertrekDatum = vertrekDatum;
    }

    public String getLocatie() {
        return locatie;
    }

    public String getAankomstDatum() {
        return aankomstDatum;
    }

    public String getVertrekDatum() {
        return vertrekDatum;
    }
}

