package com.xz.test;

/**
 * @ClassName CommunitationTest
 * @Description 两个线程交替打印1-100
 * @Author xz
 * @Date 2020/5/6 20:40
 * @Version 1.0
 */

class Number implements Runnable{

    private int num = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();
                if (num <= 100){
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}
public class CommunitationTest {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
