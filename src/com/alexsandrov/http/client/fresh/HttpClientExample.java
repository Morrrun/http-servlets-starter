package com.alexsandrov.http.client.fresh;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Create HTTP-Client
        var httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        //GET Request
        HttpRequest getRequest = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .GET()
                .build();
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(getResponse.body());
        System.out.println(getResponse.headers());

        //POST Request
        HttpRequest postRequest = HttpRequest.newBuilder(URI.create("https://www.google.com"))
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("path", "to", "file")))
                .build();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(postResponse.body());
        System.out.println(postResponse.headers());
    }
}
