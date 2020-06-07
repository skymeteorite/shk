package com.xz.collectionTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * @ClassName CollectionTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/9 23:02
 * @Version 1.0
 */
public class CollectionTest {

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(345);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry", 20));

        boolean contains = coll.contains(123);
        System.out.println(contains);

        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Jerry", 20)));

        Collection coll1 = Arrays.asList(123, 345);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add("aa");
        coll.add("bb");
        coll.add(123);
        coll.add(new Date());

        System.out.println(coll.size());

        Collection coll1 = new ArrayList();
        coll1.add(66);

        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        System.out.println(coll.isEmpty());
        coll.clear();
        System.out.println(coll.isEmpty());
    }
}
