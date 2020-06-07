package com.xz.exec;

import org.junit.Test;

/**
 * @ClassName StringTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/7 20:33
 * @Version 1.0
 */
public class StringTest {

    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//f
        System.out.println(s3 == s6);//f
        System.out.println(s3 == s7);//f
        System.out.println(s5 == s6);//f
        System.out.println(s5 == s7);//f
        System.out.println(s6 == s7);//f

        String s8 = s5.intern();
        System.out.println(s3 == s8);//t
    }


    //String实例化两种方式
    //1 通过字面量定义
    //2 通过new+构造器的方式
    @Test
    public void test2(){
        String s1 = "java";
        String s2 = "java";

        String s3 = new String("java");
        String s4 = new String("java");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false

    }


    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);//地址值
        s1 = "hello";

        System.out.println(s1);//hello
        System.out.println(s2);//abc

        System.out.println("-----------------");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);//abc

        System.out.println("-----------------");
        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc
    }
}
