package com.alexsandrov.http.single_threaded_server.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HttpClientRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        //Создали запрос
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:9000"))
                .header("content-type", "application/json")
                .POST(HttpRequest
                        .BodyPublishers
                        .ofFile(Path.of("resources/json", "first.json")))
                .build();
        //Отправили запрос
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        //Обработали ответ
        System.out.println(response.headers());
        System.out.println(response.body());
    }
}
