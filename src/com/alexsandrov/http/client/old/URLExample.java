package com.alexsandrov.http.client.old;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLExample {
    public static void main(String[] args) throws IOException {
        var url = new URL("file:C:\\Users\\mifon\\IdeaProjects\\http-servlets-starter\\src\\com\\alexsandrov\\http\\socket\\udp\\DatagramRunner.java");
        var urlConnection = url.openConnection();

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static void checkGoogle() throws IOException {
        var url = new URL("https://www.google.com");
        var urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);

        try (var outputStream = urlConnection.getOutputStream()) {
        }

        System.out.println();
    }
}
