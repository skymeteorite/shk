package com.xz.io;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName OtherStream
 * @Description TODO
 * @Author xz
 * @Date 2020/5/14 14:40
 * @Version 1.0
 */
public class OtherStream {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while (true){
                System.out.println("请输入字符串");
                line = br.readLine();
                if ("end".equalsIgnoreCase(line)) {
                    System.out.println("程序结束");
                    break;
                }
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //键盘输入的字符转换为大写
    @Test
    public void test1(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while (true){
                System.out.println("请输入字符串");
                line = br.readLine();
                if ("end".equalsIgnoreCase(line)) {
                    System.out.println("程序结束");
                    break;
                }
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("ps.txt"));
        PrintStream ps = new PrintStream(fos, true);
        if (ps != null){
            System.setOut(ps);
        }
        for (int i = 0; i < 255; i++) {
            System.out.print((char)i);
            if (i % 50 == 0){
                System.out.println();
            }
        }
        ps.close();
    }
}
