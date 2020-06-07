package com.xz.proxy;

/**
 * @ClassName ProxyClothFactory
 * @Description 静态代理
 * @Author xz
 * @Date 2020/5/18 15:37
 * @Version 1.0
 */

/*
代理类和被代理类在编译期间就确定了
 */
interface ClothFactory{
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用被代理类对象实例化
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续收尾工作");

    }
}

//被代理类
class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批衣服");
    }
}

public class StaticProxyTest{
    public static void main(String[] args) {
        //创建被代理类对象
        ClothFactory nike = new NikeClothFactory();
        //创建代理类对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();

    }
}