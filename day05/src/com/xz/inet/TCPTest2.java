package com.xz.inet;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPTest2
 * @Description 客户端发文件给服务端，服务端保存在本地
 * @Author xz
 * @Date 2020/5/15 11:44
 * @Version 1.0
 */
public class TCPTest2 {
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
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException{
        ServerSocket ss = new ServerSocket(10002);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("image04.png");
        byte[] buf = new byte[1024];
        int len;
        while ((len = is.read(buf)) != -1){
            fos.write(buf, 0, len);
        }
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
