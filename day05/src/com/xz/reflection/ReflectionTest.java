package com.xz.reflection;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/15 15:39
 * @Version 1.0
 */
public class ReflectionTest {

    //反射之前，对于Person的操作
    @Test
    public void test1(){
        //1 创建Person类的对象
        Person p1 = new Person("Tom", 12);

        //2 通过对象，调用内部属性，方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        //在Person类外部，不能通过Person类对象调用private结构

    }

    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //1 通过反射创建person类对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person)obj;
        System.out.println(p.toString());

        //2 通过反射调用对象指定的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射调用Person类的私有结构
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person)cons1.newInstance("Jerry");
        System.out.println(p1);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Jack");
        System.out.println(p1);

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");//相当于p1.showNation("中国");
        System.out.println(nation);
    }

    //获取Class的实例方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一  通过运行时类的属性  .class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二  通过运行时类的对象  .getClass
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        //方式三  调用Class的静态方法，forName(String classPath)
        Class clazz3 = Class.forName("com.xz.reflection.Person");
        System.out.println(clazz3);
        //方式四  使用类的加载器ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.xz.reflection.Person");
        System.out.println(clazz4);

    }

    //Class可以是哪些实例
    @Test
    public void test4(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[][].class;
        Class c4 = int[].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        int[] a = new int[5];
        int[] b = new int[10];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        //只要数组维度，类型一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}
