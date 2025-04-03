package aim.ene.solex.prototypeSamen.Service;

import aim.ene.solex.prototypeSamen.Domain.TransportOptionResultaat;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreinService {

    @Value("${ns.api.key}")
    private String apiKey;

    @Value("${ns.api.base-url}")
    private String apiBaseUrl;

    private final RestTemplate restTemplate;

    public TreinService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<TransportOptionResultaat> zoekTreinOpties(String fromStation, String toStation, String dateTime) {
        String url = apiBaseUrl + "/trips?fromStation=" + fromStation + "&toStation=" + toStation + "&dateTime=" + dateTime;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Ocp-Apim-Subscription-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        List<TransportOptionResultaat> resultaten = new ArrayList<>();

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                JSONObject jsonResponse = new JSONObject(response.getBody());
                JSONArray trips = jsonResponse.getJSONArray("trips");

                for (int i = 0; i < trips.length(); i++) {
                    JSONObject trip = trips.getJSONObject(i);
                    JSONObject legs = trip.getJSONArray("legs").getJSONObject(0);

                    String provider = "NS";
                    String departureTime = legs.getJSONObject("origin").getString("plannedDateTime");
                    String arrivalTime = legs.getJSONObject("destination").getString("plannedDateTime");

                    resultaten.add(new TransportOptionResultaat(provider, departureTime, arrivalTime, true));
                }
            }
        } catch (Exception e) {
            System.out.println("FOUT TreinService: " + e.getMessage());
        }

        return resultaten;
    }

    public String getTrainJourneyDetails(String fromStation, String toStation, String dateTime) {
        String url = apiBaseUrl + "/trips?fromStation=" + fromStation + "&toStation=" + toStation + "&dateTime=" + dateTime;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Ocp-Apim-Subscription-Key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                JSONObject jsonResponse = new JSONObject(response.getBody());
                JSONArray trips = jsonResponse.getJSONArray("trips");

                if (trips.length() > 0) {
                    StringBuilder result = new StringBuilder();

                    for (int i = 0; i < trips.length(); i++) {
                        JSONObject trip = trips.getJSONObject(i);
                        JSONObject legs = trip.getJSONArray("legs").getJSONObject(0);

                        String originStation = legs.getJSONObject("origin").getString("name");
                        String destinationStation = legs.getJSONObject("destination").getString("name");
                        String departureTime = legs.getJSONObject("origin").getString("plannedDateTime");
                        String arrivalTime = legs.getJSONObject("destination").getString("plannedDateTime");
                        int durationInMinutes = trip.getInt("plannedDurationInMinutes");

                        result.append(String.format("From: %s to: %s, Departure: %s, Arrival: %s, Duration: %d minutes\n",
                                originStation, destinationStation, departureTime, arrivalTime, durationInMinutes));
                    }

                    return result.toString();
                } else {
                    return "No trips found.";
                }
            } else {
                return "Error: " + response.getStatusCodeValue();
            }
        } catch (Exception e) {
            return "Fout: " + e.getMessage();
        }
    }
}
