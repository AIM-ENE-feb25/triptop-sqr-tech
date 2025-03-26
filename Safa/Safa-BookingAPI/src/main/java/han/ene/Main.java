package han.ene;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class Main {

  public static void main(String[] args) {
    String host = " X-RapidAPI-Host";
    String key = " X-RapidAPI-Key";

    HttpResponse<String> response = Unirest.get(
            "https://booking-com15.p.rapidapi.com/api/v1/hotels/searchDestination?query=man")
        .header(host, "booking-com15.p.rapidapi.com")
        .header(key, "cdce59bb45msh63300f130fa230cp1e5fcejsn83361f598203")
        .asString();

    int status = response.getStatus();
    System.out.println("Status code: " + status);

    String responseBody = response.getBody();
    System.out.println("Response body: " + responseBody);
  }
}