package com.xz.exer;

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }
}

public class ThreadTest{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(i + "...");
        }
    }
}
