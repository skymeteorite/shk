package com.xz.inet;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPTest3
 * @Description 客户端法文件给服务端，服务端保存，服务端发送收到回去
 * @Author xz
 * @Date 2020/5/15 11:56
 * @Version 1.0
 */
public class TCPTest3 {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 10002);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("image01.png");
        byte[] buf = new byte[1024];
        int len;
        while ((len = fis.read(buf)) != -1){
            os.write(buf, 0, len);
        }
        //关闭数据输出
        socket.shutdownOutput();
        //客户端接收
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf1 = new byte[20];
        int len1;
        while ((len1 = is.read(buf1)) != -1){
            baos.write(buf1, 0, len1);
        }
        System.out.println(baos.toString());

        baos.close();
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(10002);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("image05.png");
        byte[] buf = new byte[1024];
        int len;
        while ((len = is.read(buf)) != -1){
            fos.write(buf, 0, len);
        }
        //服务端反馈
        OutputStream os = socket.getOutputStream();
        os.write("文件已收到".getBytes());

        os.close();
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
