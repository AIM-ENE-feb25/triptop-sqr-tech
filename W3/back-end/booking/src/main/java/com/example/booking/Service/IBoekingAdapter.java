package com.example.booking.Service;

import com.example.booking.Boeking;

public interface IBoekingAdapter {
    boolean maakBoeking(Boeking boeking);
    String getNaam();
}
