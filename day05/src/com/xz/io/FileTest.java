package com.xz.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/13 19:04
 * @Version 1.0
 */
public class FileTest {

    @Test
    public void test1(){

        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }

    @Test
    public void test2() throws IOException {
        //文件创建
        File file1 = new File("hi.txt");
        if (!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test3(){
        //文件目录创建
        File file1 = new File("d:\\io\\io1");
        boolean mkdir1 = file1.mkdir();
        if (mkdir1){
            System.out.println("创建成功");
        }
    }

    public void deleteDirectory(File file){
        //如果file是文件，直接delete
        //如果file是目录，先删除下一级，再删自己
        if(file.isDirectory()){
            File[] all = file.listFiles();
            for(File f : all){
                deleteDirectory(f);
            }
        }
        file.delete();
    }

}
