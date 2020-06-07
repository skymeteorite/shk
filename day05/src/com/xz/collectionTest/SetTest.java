package com.xz.collectionTest;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName SetTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/11 20:42
 * @Version 1.0
 */
public class SetTest {
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 22));//没重写hashcode方法前，调用的是Object的hashcode，两对象的hash值不同，所以都存了
        set.add(new Person("Tom", 22));//重写后对于相同属性的对象产生的hash值相同，就算重复不存，这是我们的目的
        set.add("12");
        set.add("12");
        set.add(12);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj + " " + obj.hashCode());
        }

    }

}
