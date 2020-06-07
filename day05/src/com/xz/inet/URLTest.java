package com.xz.inet;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName URLTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/15 12:33
 * @Version 1.0
 */


public class URLTest {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8080/examples/image01.png");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());

        System.out.println(url.getQuery());



    }
}
