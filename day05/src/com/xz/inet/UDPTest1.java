package com.xz.inet;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName UDPTest1
 * @Description TODO
 * @Author xz
 * @Date 2020/5/15 12:14
 * @Version 1.0
 */
public class UDPTest1 {
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "UDP test";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");

        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 10003);
        socket.send(packet);
        socket.close();
    }

    @Test
    public void receiver() throws IOException{
        DatagramSocket socket = new DatagramSocket(10003);
        byte[] buf = new byte[100];
        DatagramPacket packet = new DatagramPacket(buf, 0, buf.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }
}
