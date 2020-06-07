package com.xz.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyTest
 * @Description 动态代理
 * @Author xz
 * @Date 2020/5/18 15:48
 * @Version 1.0
 */

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "i fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}


class HumanUtil{
    public void method1(){
        System.out.println("method 1");
    }
    public void method2(){
        System.out.println("method 2");
    }
}

/*
要想实现动态代理，
1：如何根据加载到内存中的被代理类，动态创建一个代理类对象
2：当通过代理类对象调用方法，如何动态的去调用被代理类中的同名方法
 */

class ProxyFactory{
    //调用此方法，返回一个代理类对象，解决问题1
    public static Object getProxyInstance(Object obj){//obj:被代理类对象

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类对象进行赋值
    public void bind(Object obj){
        this.obj = obj;
    }


    //当通过代理类对象调用方法a时，就会自动调用如下的方法
    //将被代理类要执行的方法a的功能，声明在invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        //method即为代理类对象调用的方法，此方法也就作为被代理类对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj, args);

        util.method2();

        //上述方法的返回值就作为当前类中的invoke的返回值
        return returnValue;
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance：代理类对象
        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(superMan);

        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("apple");
        System.out.println("************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();

    }
}
