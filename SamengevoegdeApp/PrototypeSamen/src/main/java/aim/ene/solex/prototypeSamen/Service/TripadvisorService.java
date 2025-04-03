package aim.ene.solex.prototypeSamen.Service;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

@Service
public class TripadvisorService {
    public String boek(String locatie, String aankomst, String vertrek) {
        HttpResponse<JsonNode> response = Unirest.get("https://tripadvisor16.p.rapidapi.com/api/v1/hotels/searchHotels")
                .queryString("geoId", locatie)
                .queryString("checkIn", aankomst)
                .queryString("checkOut", vertrek)
                .queryString("adults", "1")
                .header("X-RapidAPI-Host", "tripadvisor16.p.rapidapi.com")
                .header("X-RapidAPI-Key", "a6939e346cmshd7689b631aac94bp14f91cjsnfc1a054e1d9f")
                .asJson();

        if (response.isSuccess()) {
            return response.getBody().toString();
        } else {
            return "Data ophalen mislukt";
        }
    }
}
