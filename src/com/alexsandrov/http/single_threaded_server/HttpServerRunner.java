package com.alexsandrov.http.single_threaded_server;

import com.alexsandrov.http.single_threaded_server.server.HttpServer;

public class HttpServerRunner {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(9000);
        httpServer.run();
    }
}
