package com.alexsandrov.http.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        //Returns IP-Address by host
        var inetAddress = Inet4Address.getByName("localhost");

        try (var datagramSocket = new DatagramSocket();) {
            //Creating a send buffer
            var bytes = "Hello from UDP client".getBytes();
            //Create a DatagramPacket by Buffer
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inetAddress, 7777);
            //Sending a package
            datagramSocket.send(packet);
        }
    }
}
