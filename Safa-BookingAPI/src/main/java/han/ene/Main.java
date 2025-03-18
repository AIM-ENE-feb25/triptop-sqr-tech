package han.ene;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class Main {

  public static void main(String[] args) {
    HttpResponse<String> response = Unirest.get("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchDestination?query=man")
        .header("X-RapidAPI-Host", "booking-com15.p.rapidapi.com")
        .header("X-RapidAPI-Key", "cdce59bb45msh63300f130fa230cp1e5fcejsn83361f598203")
        .asString();

    System.out.println("Status code: " + response.getStatus());

    String responseBody = response.getBody();
    System.out.println("Response body: " + responseBody);
  }
}