package com.xz.reflection;

import org.junit.Test;

import java.util.Random;

/**
 * @ClassName InstanceTest
 * @Description 通过反射创建运行时类对象
 * @Author xz
 * @Date 2020/5/15 17:30
 * @Version 1.0
 */
public class InstanceTest {

    @Test
    public void test1() throws Exception{
        Class<Person> clazz = Person.class;
        Person p1 = clazz.newInstance();
        System.out.println(p1);
    }

    //反射的动态性
    @Test
    public void test2() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        int i = new Random().nextInt(3);
        String classpath = "";
        switch (i){
            case 0:
                classpath = "java.util.Date";
                break;
            case 1:
//                classpath = "java.io.BufferedInputStream";//没有空参构造器，newInstance时出错
                classpath = "java.lang.Object";
                break;
            case 2:
                classpath = "com.xz.reflection.Person";
                break;
        }

        Object instance = getInstance(classpath);
        System.out.println(instance);

    }

    //创建一个指定类的对象
    //classpath：指定类的全类名
    public Object getInstance(String classpath) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class clazz = Class.forName(classpath);
        return clazz.newInstance();

    }
}
