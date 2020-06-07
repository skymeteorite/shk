package com.xz.io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName FileReaderWriterTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/13 22:53
 * @Version 1.0
 */
public class FileReaderWriterTest {

    //将day05下的hello.txt输出到控制台
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1 实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");//相对于当前module
            //2 提供具体的流
            fr = new FileReader(file);
            //3 数据读入
            //read() 返回读入的一个字符，如果到达文件末尾返回-1
            //方式一
//        int data = fr.read();
//        while (data != -1){
//            System.out.print((char)data);
//            data = fr.read();
//        }

            //方式二  语法上针对方式一修改
            int data;
            while ((data = fr.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4 流关闭
//            try {
//                if (fr != null)
//                    fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            //或
            if (fr != null){
                try {
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

    //对read()操作升级，使用read的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            //read(char[] buf) 返回每次读入cbuf数组中的字符个数，如果到达末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                //错误的写法，最后一此数组不满，未满位置的元素还在
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //正确写法一
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //错误写法
//                String str = new String(cbuf);
                //正确写法
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null)
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @Test
    public void testFileWriter() throws IOException {
        FileWriter fw = null;
        try {
            //1 提供File类对象，指明写出到的文件
            File file = new File("hello1.txt");
            //2 提供FileWriter对象，用于数据写出
            fw = new FileWriter(file);
            //3 写出操作
            fw.write("yyyyeeeeeesssss");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    @Test
    public void testFileReaderWriter(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //第二个try也一定执行，第一个已经把异常处理了
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
