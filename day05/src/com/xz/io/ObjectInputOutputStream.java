package com.xz.io;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName ObjectInputOutputStream
 * @Description 对象流
 * @Author xz
 * @Date 2020/5/14 16:01
 * @Version 1.0
 */
public class ObjectInputOutputStream {
    //序列化过程，将内存中java对象保存到磁盘中或通过网络传输出去
    @Test
    public void testObjectOutputStream() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
        oos.writeObject(new String("i love TT"));
        oos.flush();
        oos.close();
    }

    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object o = ois.readObject();
            String str = (String)o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
