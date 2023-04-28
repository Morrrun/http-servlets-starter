package com.alexsandrov.http.thred_pooled_server;

import com.alexsandrov.http.thred_pooled_server.server.HttpServer;

public class HttpServerRunner {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(9000, 100);
        httpServer.run();
    }
}
