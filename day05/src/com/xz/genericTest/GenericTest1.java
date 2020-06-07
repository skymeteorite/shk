package com.xz.genericTest;

import com.xz.collectionTest.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenericTest1
 * @Description TODO
 * @Author xz
 * @Date 2020/5/13 12:00
 * @Version 1.0
 */
public class GenericTest1 {
    @Test
    public void test1(){

        //如果定义了泛型类，实例化没有指定类的泛型，认为此泛型类型为Object
        //要求：如果定义了类是带泛型的，实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("abc");

        Order<String> order1 = new Order<String>("orderA", 1001, "order:A");
        order1.setOrderT("AA: hello");

    }

    @Test
    public void test2(){
        SubOrder sub1 = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型，则子类实例化对象时，不再需要指明泛型
        sub1.setOrderT(111);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("222");

    }

    @Test
    public void test3(){
        //泛型不同的引用不能相互赋值
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
//        list1 = list2;

        Person p1 = null;
        Person p2 = null;
        p1 = p2;
    }

    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}
