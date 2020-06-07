package com.xz.reflection.exec2;

import com.xz.reflection.exec.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @ClassName FieldTest
 * @Description 获取当前运行时类的属性结构
 * @Author xz
 * @Date 2020/5/15 18:14
 * @Version 1.0
 */
public class FieldTest {
    @Test
    public void test1(){
        Class clazz = Person.class;

        //获取属性结构
        //getFields()获取当前运行时类极其父类中声明的public的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields){
            System.out.println(f);
        }
        //getDeclaredFields()获取当前运行时类中声明的所有属性（不包含父类中的声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            System.out.println(f);
        }
    }

    //权限修饰符，数据类型，变量名
    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields){
            //1 权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            //2 数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //3 变量名
            String name = f.getName();
            System.out.print(name);
            System.out.println();
        }
    }
}
