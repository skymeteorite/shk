package com.xz.Lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @ClassName LambdaTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/18 19:38
 * @Version 1.0
 */
public class LambdaTest {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("hello lambda    ");
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare = com1.compare(12, 21);
        System.out.println(compare);

        //Lambda表达式
        Comparator<Integer> com2 = ((o1, o2) -> Integer.compare(o1, o2));
        int compare2 = com2.compare(12, 21);
        System.out.println(compare2);

        //方法引用
        Comparator<Integer> com3 = Integer :: compare;
        int compare3 = com3.compare(12, 21);
        System.out.println(compare3);

    }

}
