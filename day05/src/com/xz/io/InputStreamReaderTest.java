package com.xz.io;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName InputStreamReaderTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/14 13:00
 * @Version 1.0
 */
public class InputStreamReaderTest {
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream("hello.txt");
        InputStreamReader isr = new InputStreamReader(fis);//使用默认字符集
        char[] buf = new char[20];
        int len;
        while ((len = isr.read(buf)) != -1){
            String str = new String(buf, 0, len);
            System.out.println(str);
        }
        isr.close();
    }

    @Test
    public void test2() throws IOException{
        File file1 = new File("hello1.txt");
        File file2 = new File("hello1_gbk.txt");
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        char[] buf = new char[20];
        int len;
        while ((len = isr.read(buf)) != -1){
            osw.write(buf, 0, len);
        }
        isr.close();
        osw.close();
    }
}
