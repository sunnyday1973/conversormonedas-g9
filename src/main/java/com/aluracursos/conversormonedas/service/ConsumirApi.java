package com.aluracursos.conversormonedas.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirApi {
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private String exchandeRateApiKey;

    public String consultarApi(String parteURL) {
        exchandeRateApiKey = System.getenv("EXCHANGERATE_APIKEY");
        if (exchandeRateApiKey == null || exchandeRateApiKey.trim().isEmpty()) {
            throw new IllegalStateException("EXCHANGERATE_APIKEY no está configurada");
        }

        String url = URL_BASE + exchandeRateApiKey + parteURL;
        //System.out.println(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
        } catch (Exception e) {
             throw new RuntimeException("Error al obtener la resupuesta desde el servidor: " + e.getMessage());
        }

        String json = response.body();
        return json;
    }
}
