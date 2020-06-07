package com.xz.exer;

/**
 * @ClassName WindowTest2
 * @Description 实现runnable接口
 * @Author xz
 * @Date 2020/5/6 16:04
 * @Version 1.0
 */

class Window1 implements Runnable {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (Window1.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window1 w = new Window1();
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
