package com.xz.annotationTest;

import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * @ClassName AnnotationTest
 * @Description TODO
 * @Author xz
 * @Date 2020/5/9 21:41
 * @Version 1.0
 */
public class AnnotationTest {
    public static void main(String[] args) {
//        @SuppressWarnings("unused")
//        int a = 1;

        String s1 = "ab";
        String s = "a";
        String s2 = s + "b";
        System.out.println(s1.equals(s2));
    }
    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}
@MyAnnotation
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void walk(){
        System.out.println("walk");
    }

    public void eat(){
        System.out.println("eat");
    }

}

interface Info{
    void show();
}

class Student extends Person implements Info{
    @Override
    public void walk() {
        System.out.println("student walk");
    }

    @Override
    public void show() {

    }
}