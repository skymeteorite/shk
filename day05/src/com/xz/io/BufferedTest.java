package com.xz.io;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName BufferedTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/14 11:46
 * @Version 1.0
 */
public class BufferedTest {
    @Test
    public void BufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("image01.png");
            File destFile = new File("image03.png");
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] buf = new byte[10];
            int len;
            while ((len = bis.read(buf)) != -1){
                bos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //关闭外层会自动关闭内层流
//        fis.close();
//        fos.close();
    }

    @Test
    public void testBufferedReaderWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello1.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello3.txt")));
            //使用char[]读取
//            char[] buf = new char[1024];
//            int len = 0;
//            while ((len = br.read(buf)) != -1){
//                bw.write(buf, 0, len);
//            }
            String line;
            while ((line = br.readLine()) != null){
                bw.write(line);//line中不包含换行符
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
