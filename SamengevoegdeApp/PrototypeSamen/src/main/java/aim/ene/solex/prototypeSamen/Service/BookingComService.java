package aim.ene.solex.prototypeSamen.Service;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class BookingComService {
    public String boek(String locatie, String aankomst, String vertrek) {
        HttpResponse<JsonNode> response = Unirest.get("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels")
                .queryString("dest_id", locatie)
                .queryString("search_type", "CITY")
                .queryString("arrival_date", aankomst)
                .queryString("departure_date", vertrek)
                .queryString("adults", "1")
                .header("X-RapidAPI-Host", "booking-com15.p.rapidapi.com")
                .header("X-RapidAPI-Key", "a6939e346cmshd7689b631aac94bp14f91cjsnfc1a054e1d9f")
                .asJson();


       if (response.isSuccess()) {
            return response.getBody().toString();
        } else {
            return "Data ophalen niet gelukt";
        }
    }
}
