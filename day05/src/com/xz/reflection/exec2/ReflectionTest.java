package com.xz.reflection.exec2;

import com.xz.reflection.exec.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/18 13:21
 * @Version 1.0
 */

/*
调用运行时类中指定的结构：属性，方法，构造器
 */
public class ReflectionTest {

    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;
        Person p = (Person)clazz.newInstance();
        //获取public属性，通常不采用
        Field id = clazz.getField("age");

        //设置当前属性的值
        id.set(p, 1001);

        //获取当前属性的值
        int pID = (int)id.get(p);
        System.out.println(pID);

    }

    @Test
    public void test2() throws Exception{
        Class clazz = Person.class;

        Person p = (Person)clazz.newInstance();

        //获取运行时类中的指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "Tom");
        System.out.println(name.get(p));

    }

    @Test
    public void test3() throws Exception{
        Class clazz = Person.class;

        Person p = (Person)clazz.getDeclaredConstructor().newInstance();

        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        //参数1 方法调用者  参数2 给方法的实参
        //invoke的返回值为对应类中调用方法的返回值
        Object returnValue = show.invoke(p, "china");
        System.out.println(returnValue);

        //调用static方法
        Method show1 = clazz.getDeclaredMethod("show1");
        show1.setAccessible(true);
        //如果运行时类没有返回值，返回null
        Object returnval = show1.invoke(Person.class);
//        Object returnval = show1.invoke(null);//写null也可以
        System.out.println(returnval);


    }

    //调用运行时类指定构造器
    @Test
    public void testConstructor() throws Exception{
        Class clazz = Person.class;

        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Person p = (Person) constructor.newInstance("Tom");
        System.out.println(p);

    }

}
