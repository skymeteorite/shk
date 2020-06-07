package com.xz.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadPool
 * @Description 使用线程池创建线程
 * @Author xz
 * @Date 2020/5/7 16:16
 * @Version 1.0
 */

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2 执行指定的线程的操作，需要提供实现Runnable接口或Callable接口的实现类的对象
        service.execute(new NumberThread());//适合适用于Runnable
//        service.submit();//适合适用于Callable
        //3 关闭连接池
        service.shutdown();
    }
}
