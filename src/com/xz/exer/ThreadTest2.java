package com.xz.exer;

/**
 * @ClassName ThreadTest2
 * @Description 实现runnable接口
 * @Author xz
 * @Date 2020/5/6 15:49
 * @Version 1.0
 */

class MThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0)
                System.out.println(i);
        }
    }
}
public class ThreadTest2 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        Thread t2 = new Thread(mThread);

        t1.start();
        t2.start();

    }
}
