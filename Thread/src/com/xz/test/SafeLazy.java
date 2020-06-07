package com.xz.test;

/**
 * @ClassName SafeLazy
 * @Description TODO
 * @Author xz
 * @Date 2020/5/6 18:37
 * @Version 1.0
 */
public class SafeLazy {

}

class Bank{
    private Bank(){}
    private static Bank instance = null;
    public static Bank getInstance(){
        //效率较差，若被占用其他线程还会进来
//        synchronized (Bank.class) {
//            if (instance == null) {
//                    return new Bank();
//                return instance;
//            }
//        }
        //效率更高
        if(instance == null){
            synchronized (Bank.class){
                if (instance == null)
                    return new Bank();
            }
        }
        return instance;
    }
}
