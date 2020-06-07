package com.xz.exer;

/**
 * @ClassName WindowTest3
 * @Description 使用同步方法解决
 * @Author xz
 * @Date 2020/5/6 18:21
 * @Version 1.0
 */

class Window3 implements Runnable {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private synchronized void show(){//锁：this
        if (ticket > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("window 1");
        t2.setName("window 2");
        t3.setName("window 3");

        t1.start();
        t2.start();
        t3.start();
    }
}

