package com.example.demo.external;

import com.example.demo.model.TransportOptionResultaat;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VluchtService {

    @Value("${rapidapi.key}")
    private String apiKey;

    public List<TransportOptionResultaat> zoekVluchten(String origin, String destination, String date,
                                                       String returnDate, String adults, String children,
                                                       String infantOnLap, String infantInSeat,
                                                       String currency, String language, String countryCode) {
        List<TransportOptionResultaat> resultaten = new ArrayList<>();

        try {
            String url = "https://google-flights2.p.rapidapi.com/api/v1/searchFlights";
            String queryParams = "?departure_id=" + origin +
                    "&arrival_id=" + destination +
                    "&outbound_date=" + date +
                    (returnDate != null ? "&return_date=" + returnDate : "") +
                    "&adults=" + adults +
                    "&children=" + children +
                    "&infant_on_lap=" + infantOnLap +
                    "&infant_in_seat=" + infantInSeat +
                    "&currency=" + currency +
                    "&language_code=" + language +
                    "&country_code=" + countryCode;

            HttpResponse<JsonNode> response = Unirest.get(url + queryParams)
                    .header("X-RapidAPI-Key", apiKey)
                    .header("X-RapidAPI-Host", "google-flights2.p.rapidapi.com")
                    .asJson();

            if (response.getStatus() != 200) {
                throw new Exception("API error: " + response.getStatus());
            }

            JSONObject responseBody = new JSONObject(response.getBody().toString());
            JSONArray itineraries = responseBody.getJSONObject("data").getJSONArray("itineraries");

            for (int i = 0; i < itineraries.length(); i++) {
                JSONObject itinerary = itineraries.getJSONObject(i);
                if (!itinerary.has("flights")) continue;

                JSONArray flights = itinerary.getJSONArray("flights");
                JSONObject firstFlight = flights.getJSONObject(0);

                String provider = firstFlight.getString("airline");
                String departureTime = firstFlight.getString("departure_time");
                String arrivalTime = firstFlight.getString("arrival_time");

                resultaten.add(new TransportOptionResultaat(provider, departureTime, arrivalTime, true));
            }

        } catch (Exception e) {
            System.out.println("FOUT VluchtService: " + e.getMessage());
        }

        return resultaten;
    }

    public String getVluchtDetails(String origin, String destination, String date, String returnDate,
                                   String adults, String children, String infantOnLap, String infantInSeat,
                                   String currency, String language, String countryCode) throws Exception {

        String url = "https://google-flights2.p.rapidapi.com/api/v1/searchFlights";
        String queryParams = "?departure_id=" + origin +
                "&arrival_id=" + destination +
                "&outbound_date=" + date +
                (returnDate != null ? "&return_date=" + returnDate : "") +
                "&adults=" + adults +
                "&children=" + children +
                "&infant_on_lap=" + infantOnLap +
                "&infant_in_seat=" + infantInSeat +
                "&currency=" + currency +
                "&language_code=" + language +
                "&country_code=" + countryCode;

        HttpResponse<JsonNode> response = Unirest.get(url + queryParams)
                .header("X-RapidAPI-Key", apiKey)
                .header("X-RapidAPI-Host", "google-flights2.p.rapidapi.com")
                .asJson();

        if (response.getStatus() != 200) {
            throw new Exception("Error: " + response.getStatus() + " - " + response.getStatusText());
        }

        JSONObject responseBody = new JSONObject(response.getBody().toString());

        System.out.println("API Response: " + responseBody.toString(2));  // Log voor debug

        JSONObject filteredResponse = new JSONObject();
        filteredResponse.put("departure_id", origin);
        filteredResponse.put("arrival_id", destination);
        filteredResponse.put("outbound_date", date);
        if (returnDate != null) {
            filteredResponse.put("return_date", returnDate);
        }

        Object itineraries = responseBody.getJSONObject("data").get("itineraries");

        if (itineraries instanceof JSONArray) {
            JSONArray itinerariesArray = (JSONArray) itineraries;

            for (int i = 0; i < itinerariesArray.length(); i++) {
                JSONObject itinerary = itinerariesArray.getJSONObject(i);

                if (itinerary.has("flights")) {
                    JSONArray flights = itinerary.getJSONArray("flights");
                    JSONObject firstFlight = flights.getJSONObject(0);

                    filteredResponse.put("flight_duration", firstFlight.getJSONObject("duration").getString("text"));
                    filteredResponse.put("airline", firstFlight.getString("airline"));
                    filteredResponse.put("price", itinerary.getInt("price"));

                    if (itinerary.has("layovers") && itinerary.getJSONArray("layovers").length() > 0) {
                        filteredResponse.put("layovers", itinerary.getJSONArray("layovers"));
                    } else {
                        filteredResponse.put("layovers", "No layovers");
                    }

                    break;
                }
            }

        } else if (itineraries instanceof JSONObject) {
            JSONObject itinerary = (JSONObject) itineraries;

            if (itinerary.has("flights")) {
                JSONArray flights = itinerary.getJSONArray("flights");
                JSONObject firstFlight = flights.getJSONObject(0);

                filteredResponse.put("flight_duration", firstFlight.getJSONObject("duration").getString("text"));
                filteredResponse.put("airline", firstFlight.getString("airline"));
                filteredResponse.put("price", itinerary.getInt("price"));

                if (itinerary.has("layovers") && itinerary.getJSONArray("layovers").length() > 0) {
                    filteredResponse.put("layovers", itinerary.getJSONArray("layovers"));
                } else {
                    filteredResponse.put("layovers", "No layovers");
                }
            }

        } else {
            throw new Exception("Unexpected format for itineraries: " + itineraries);
        }

        return filteredResponse.toString();
    }
}
