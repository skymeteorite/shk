package com.xz.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @ClassName LambdaTest2
 * @Description TODO
 * @Author xz
 * @Date 2020/5/18 22:37
 * @Version 1.0
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(499, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，买瓶矿泉水，价格为：" + aDouble);
            }
        });
        System.out.println("***************");

        happyTime(498, money -> System.out.println("学习太累了，买瓶矿泉水，价格为：" + money));
    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京", "东京", "巴黎", "普京");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);

        List<String> filterStrs1 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrs1);
    }

    //根据给定规则 过滤集合中的字符串，此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
