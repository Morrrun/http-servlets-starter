package com.alexsandrov.http.single_threaded_server.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpServer {
    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            var serverSocket = new ServerSocket(port);
            var socket = serverSocket.accept();

            processSocket(socket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processSocket(Socket socket) {
        try (socket;
             var inputStream = new DataInputStream(socket.getInputStream());
             var outputStream = new DataOutputStream(socket.getOutputStream())) {
            //Обрабатываем запрос в 2 шага
            //Step 1 Handle request
            System.out.println("Request: " + new String(inputStream.readNBytes(400)));

            //Step 2 Handle response(creating)
            byte[] body = Files.readAllBytes(Path.of("resources/html", "example.html"));
            //Создаем стартовую строку с заголовками
            var headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length).getBytes();

            //Передаём заголовки
            outputStream.write(headers);
            //Отделяем заголовки от тела пустой строкой
            outputStream.write(System.lineSeparator().getBytes());
            //Передаем тело
            outputStream.write(body);

        } catch (IOException e) {
            //Здесь необходимо логировать информацию,
            //и ни в коем случае не пробрасывать Exception,
            //иначе мы остановим сервер
        }
    }
}
