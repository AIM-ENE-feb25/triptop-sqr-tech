package org.example;


import kong.unirest.HttpResponse;
import kong.unirest.Unirest;



public class App
{
    public static void main( String[] args )
    {
        HttpResponse<String> response = Unirest.post("https://google-map-places-new-v2.p.rapidapi.com/v1/places:autocomplete")
                .header("X-RapidAPI-Host", "google-map-places-new-v2.p.rapidapi.com")
                .header("X-RapidAPI-Key", "a6939e346cmshd7689b631aac94bp14f91cjsnfc1a054e1d9f")  // Replace with your actual API key
                .header("X-Goog-FieldMask", "*")
                .header("Content-Type", "application/json")
                .body("{\"input\":\"Restaurant\",\"locationBias\":{\"circle\":{\"center\":{\"latitude\":40,\"longitude\":-110},\"radius\":10000}},\"includedPrimaryTypes\":[],\"includedRegionCodes\":[],\"languageCode\":\"\",\"regionCode\":\"\",\"origin\":{\"latitude\":0,\"longitude\":0},\"inputOffset\":0,\"includeQueryPredictions\":true,\"sessionToken\":\"\"}")  // Replace with your actual input
                .asString();

        System.out.println("Status code: " + response.getStatus());
        System.out.println("Response body: " + response.getBody());
    }
}
