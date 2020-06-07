package com.xz.reflection.exec;

import java.io.Serializable;

/**
 * @ClassName Creature
 * @Description TODO
 * @Author xz
 * @Date 2020/5/15 18:02
 * @Version 1.0
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("creature breath");
    }
    public void eat(){
        System.out.println("creature eat");
    }

}
