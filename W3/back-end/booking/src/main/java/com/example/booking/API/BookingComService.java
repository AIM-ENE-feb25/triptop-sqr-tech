package com.example.booking.API;

import com.example.booking.Boeking;
import kong.unirest.Unirest;

import kong.unirest.HttpResponse;

public class BookingComService {

    public boolean boek(Boeking boeking) {
        HttpResponse<String> response = Unirest.get("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels " + boeking )
                .header("X-RapidAPI-Host", "booking-com15.p.rapidapi.com")
                .header("X-RapidAPI-Key", "a6939e346cmshd7689b631aac94bp14f91cjsnfc1a054e1d9f")
                .asString();

        if (response.isSuccess()) {
            System.out.println("Response: " + response.getBody());
            return true;
        } else {
            System.out.println("Request failed with status: " + response.getStatus());
            return false;
        }

    }
//    public boolean book(Boeking data) {
//        return true;
//    }
}
