package com.xz.exec;

import org.junit.Test;

/**
 * @ClassName IDEADebug
 * @Description TODO
 * @Author xz
 * @Date 2020/5/8 15:21
 * @Version 1.0
 */
public class IDEADebug {
    @Test
    public void testStringBuilder(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);


    }
}
