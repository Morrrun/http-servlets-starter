package com.alexsandrov.http.socket.udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServerRunner {
    public static void main(String[] args) throws IOException {
        try (var datagramSocket = new DatagramSocket(7777)) {
            //Create a Receive Buffer
            byte[] buffer = new byte[32] ;
            //Create a DatagramPacket by Buffer
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            //Buffer reception
            datagramSocket.receive(packet);

            System.out.println(new String(packet.getData()));
        }
    }
}
