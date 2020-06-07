package com.xz.reflection.exec2;

import com.xz.reflection.exec.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @ClassName MethodTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/15 18:33
 * @Version 1.0
 */
public class MethodTest {
    @Test
    public void test1(){
        Class clazz = Person.class;

        //getMethods()获取当前运行时类极其public的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            System.out.println(m);
        }
        System.out.println("-------------------");
        ////getDeclaredMethods()获取当前运行时类中声明的所有方法（不包含父类中的声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println(m);
        }
    }

    /*
    @Xxxx
    权限修饰符 返回值类型 方法名（参数类型1 形参名1，...）throws XxxException{}
     */
    @Test
    public void test2(){
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods){
            //1 方法声明的获取注解
            Annotation[] annotation = m.getAnnotations();
            for (Annotation a : annotation){
                System.out.println(a);
            }

            //2 权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //3 返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //4 方法名
            System.out.print(m.getName() + "\t");

            //5 形参列表
            System.out.print("(");
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)){
                for (int i = 0; i < parameterTypes.length; i++){
                    if (i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }
            System.out.print(")");

            //6 抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(!(exceptionTypes == null || exceptionTypes.length == 0)){
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();

        }
    }
}
