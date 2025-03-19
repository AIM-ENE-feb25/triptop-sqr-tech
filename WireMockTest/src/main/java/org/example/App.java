package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class App 
{
    public static void main(String[] args) {
//        String apiUrl = "https://triptop-identity.wiremockapi.cloud/login";
//
//
//        String requestBody = "{\"username\": \"edevries\", \"password\": \"3g2Rw9sT1x\"}";

        String apiUrl = "https://triptop-identity.wiremockapi.cloud/checkAppAccess?token=TOKEN_UIT_HET_VORIGE_REQUEST";


        String requestBody = "{\"username\": \"edevries\", \"application\": \"triptop\"}";


        HttpResponse<JsonNode> response = Unirest.post(apiUrl)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .asJson();

        // Response tonen
        System.out.println("Status code: " + response.getStatus());
        System.out.println("Response body: " + response.getBody());
    }
}
