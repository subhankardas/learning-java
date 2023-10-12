package java_9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPClientJ9 {

    private static final String API_KEY = "a4ddcd75dbd6ebec8b0ed20a1247c7ff";
    private static final String UNITS = "metric";
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=%s";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String API_URL = String.format(URL, "Kolkata", API_KEY, UNITS);

        HttpRequest request = HttpRequest.newBuilder() // Build http request
                .uri(new URI(API_URL))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient() // Get http response
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response: " + response.body() + "\nCode: " + response.statusCode());
    }

}
