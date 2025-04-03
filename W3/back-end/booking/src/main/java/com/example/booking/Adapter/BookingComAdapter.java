package com.example.booking.Adapter;

import com.example.booking.API.BookingComService;

import com.example.booking.Domain.Boeking;
import org.springframework.stereotype.Component;

@Component
public class BookingComAdapter implements IBoekingAdapter {
    private final BookingComService bookingComService;

    public BookingComAdapter(BookingComService bookingComService) {
        this.bookingComService = bookingComService;
    }

    @Override
    public String maakBoeking(Boeking boeking) {
        String response = bookingComService.boek(
                boeking.getLocatie(),
                boeking.getAankomstDatum(),
                boeking.getVertrekDatum()
        );
        return response;
    }

    @Override
    public String getNaam() {
        return "BookingCom";
    }
}