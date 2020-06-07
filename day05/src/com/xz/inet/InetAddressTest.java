package com.xz.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName InetAddressTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/14 18:19
 * @Version 1.0
 */
//使用InetAddress类代表IP
public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress inet1 = null;
        InetAddress inet2 = null;
        try {
            inet1 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet1);

            inet2 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inet2);

            //获取本机ip
            InetAddress inet3 = InetAddress.getLocalHost();
            System.out.println(inet3);
            System.out.println(inet3.getHostName());
            System.out.println(inet3.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
