package com.xz.exec;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName CompareTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/9 12:50
 * @Version 1.0
 */
public class CompareTest {


    @Test
    public void test4(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovo", 35);
        arr[1] = new Goods("dell", 31);
        arr[2] = new Goods("mi", 33);
        arr[3] = new Goods("huawei", 32);

        Arrays.sort(arr, new Comparator() {
            //产品名称从低到高，价格从高到低
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(), g2.getPrice());
                    }else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("产品类别不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    /*
    Comparator接口的使用：定制排序
    1 背景
    当元素类型没有实现java.lang.Comparable接口又不方便修改代码，
    或者实现了Comparable排序规则不适合当前操作
    2 重写compare(Object o1, Object o2)方法，返回正整数表示o1>o2
     */
    public void test3(){
        String[] arr = new String[]{"aa","cc","ii","hh","ee"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovo", 35);
        arr[1] = new Goods("dell", 31);
        arr[2] = new Goods("mi", 33);
        arr[3] = new Goods("huawei", 32);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }




    //Comparable接口
    //String、包装类实现了Comparable接口，重写了compareTo方法
    //重写comparable(obj)规则
    //如果当前对象this大于形参对象obj，返回正整数
    //如果当前对象this小于形参对象obj，返回负整数
    //如果相等，返回0
    @Test
    public void test1(){
        String[] arr = new String[]{"aa","cc","ii","hh","ee"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
