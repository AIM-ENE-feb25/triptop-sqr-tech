package com.example.booking.Adapter;

import com.example.booking.API.BookingComService;
import com.example.booking.Boeking;
import com.example.booking.Service.IBoekingAdapter;

public class BookingComAdapter implements IBoekingAdapter {
    private BookingComService bookingCom;

    public BookingComAdapter(BookingComService bookingCom) {
        this.bookingCom = bookingCom;
    }

    @Override
    public boolean maakBoeking(Boeking boeking) {
        return bookingCom.boek(boeking);
    }

    @Override
    public String getNaam() {
        return "BookingCom";
    }
}
